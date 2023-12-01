package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.config.security.TokenService;
import com.piazzariap1.pizzaria.dto.LoginDTO;
import com.piazzariap1.pizzaria.dto.UserEntityDTO;
import com.piazzariap1.pizzaria.entity.UserEntity;
import com.piazzariap1.pizzaria.repository.UserEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements UserDetailsService {

    @Autowired
    UserEntityRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserEntityDTO logar(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.username(),
                        loginDTO.password()
                )
        );

        UserEntity user = repository.findByUsername(loginDTO.username()).orElseThrow();

        //B.O TÁ AQUI
        var jwtToken = tokenService.generateToken(user);

        UserEntityDTO userLogado = new UserEntityDTO(user.getId(),user.getUsername(),user.getRole(),jwtToken);

        return userLogado;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails =  repository.findByUsername(username).orElseThrow();

        return new User(userDetails.getUsername(), userDetails.getPassword(), true,true,true,true,userDetails.getAuthorities());
    }

    @Transactional
    public UserEntity cadastrar(UserEntityDTO userEntityDTO){
        UserEntity user = new UserEntity();

        BeanUtils.copyProperties(userEntityDTO,user);

        return repository.save(user);
    }

    public UserEntity buscarPorId(Long id){
        Optional<UserEntity> user = repository.findById(id);

        if(user.isEmpty()){
            throw new NotFoundException("não foi possivel localizar o user informado!");
        }
        return user.get();
    }

    public List<UserEntity> listar(){
        List<UserEntity> userEntities = repository.findAll();

        if(userEntities.isEmpty()){
            throw new NotFoundException("não foi possivel localizar nenhum user cadastrado!");
        }

        return userEntities;
    }

    @Transactional
    public UserEntity editar(Long id, UserEntityDTO userEntityNovo){
        UserEntity user = this.buscarPorId(id);

        if(userEntityNovo.id() == 0 || userEntityNovo.id().equals(null)){
            throw new NotFoundException("não foi possivel localizar o user informado!");
        }

        //user.setPasswaord(userEntityNovo.password());

        return repository.save(user);
    }
}
