package com.example.forum.controller.dto;

import com.example.forum.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
//Data Transfer Object (usado para o transporte de dados entre diferentes componentes de um sistema)

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> converter(List<Topico> topicos) {
    //Converter de Topico para TopicoDto para retornar no TopicoController

        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
}
