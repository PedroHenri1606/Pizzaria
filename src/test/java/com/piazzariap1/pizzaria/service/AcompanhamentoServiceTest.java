package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.repository.AcompanhamentoRepository;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import com.piazzariap1.pizzaria.service.implementada.AcompanhamentoServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AcompanhamentoServiceTest {

    @InjectMocks
    AcompanhamentoServiceImpl service;

    @Mock
    AcompanhamentoRepository repository;

    Acompanhamento acompanhamento;

    @BeforeEach
    public void setup(){
        acompanhamento = new Acompanhamento("COCA COLLA 1L", 12L);
    }


    @Test
    void buscarPorIdTeste(){
        when(repository.findById(acompanhamento.getId())).thenReturn(Optional.ofNullable(acompanhamento));

        Acompanhamento acompanhamentoBanco = service.buscarPorId(acompanhamento.getId());

        Assertions.assertEquals(acompanhamento, acompanhamentoBanco);
        verify(repository).findById(acompanhamentoBanco.getId());
        verifyNoMoreInteractions(repository);

        System.out.println(acompanhamentoBanco.getId());
        System.out.println(acompanhamento.getId());
    }

    @Test
    void buscarPorIdExceptionTeste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado}");

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado}");
    }



    @Test
    void buscarPorDescricaoTeste(){
        when(repository.findByDescricao(acompanhamento.getDescricao().toUpperCase())).thenReturn(Collections.singletonList(acompanhamento));

        List<Acompanhamento> acompanhamentos = service.buscarPorDescricao(acompanhamento.getDescricao());

        Assertions.assertEquals(Collections.singletonList(acompanhamento), acompanhamentos);
        verify(repository).findByDescricao(acompanhamento.getDescricao().toUpperCase());
        verifyNoMoreInteractions(repository);

        System.out.println(Collections.singletonList(acompanhamento));
        System.out.println(acompanhamentos);
    }

    @Test
    void buscarPorDescricaoNaoLocalizaoExceptionTeste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorDescricao(""));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado}");
        verifyNoMoreInteractions(repository);

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado}");
    }

    @Test
    void buscarPorDescricaoNaoLocalizaoException2Teste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorDescricao("null"));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado2}");

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado2}");
    }


    @Test
    void buscarPorValorTeste(){
        when(repository.findByValor(acompanhamento.getValor())).thenReturn(Collections.singletonList(acompanhamento));

        List<Acompanhamento> acompanhamentos = service.buscarPorValor(acompanhamento.getValor());

        Assertions.assertEquals(Collections.singletonList(acompanhamento), acompanhamentos);
        verify(repository).findByValor(acompanhamento.getValor());
        verifyNoMoreInteractions(repository);

        System.out.println(Collections.singletonList(acompanhamento));
        System.out.println(acompanhamentos);
    }

    @Test
    void buscarPorValorNaoLocalizaoExceptionTeste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorValor(null));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado}");
        verifyNoMoreInteractions(repository);

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado}");
    }

    @Test
    void buscarPorValorNaoLocalizaoException2Teste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorValor(20L));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado2}");

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado2}");
    }


    @Test
    void buscarAcompanhamentoComecandoComTeste(){
        when(repository.findByDescricaoStartingWith(acompanhamento.getDescricao().toUpperCase())).thenReturn(Collections.singletonList(acompanhamento));

        List<Acompanhamento> acompanhamentos = service.buscarAcompanhamentoComecandoCom(acompanhamento.getDescricao().toUpperCase());

        Assertions.assertEquals(Collections.singletonList(acompanhamento), acompanhamentos);
        verify(repository).findByDescricaoStartingWith(acompanhamento.getDescricao().toUpperCase());
        verifyNoMoreInteractions(repository);

        System.out.println(Collections.singletonList(acompanhamento));
        System.out.println(acompanhamentos);
    }

    @Test
    void buscarAcompanhamentoComecandoComNaoLocalizaoExceptionTeste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoComecandoCom(""));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado}");
        verifyNoMoreInteractions(repository);

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado}");
    }

    @Test
    void buscarAcompanhamentoComecandocOMNaoLocalizaoException2Teste(){
        final NaoLocalizadoException e = Assert.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoComecandoCom("null"));

        Assertions.assertEquals(e.getMessage(), "{acompanhamento.exception.nao-localizado2}");

        System.out.println(e.getMessage());
        System.out.println("{acompanhamento.exception.nao-localizado2}");
    }
}
