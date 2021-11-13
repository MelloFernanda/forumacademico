package com.example.forum.controller;

import com.example.forum.controller.dto.TopicoDto;
import com.example.forum.controller.form.TopicoForm;
import com.example.forum.modelo.Topico;
import com.example.forum.repository.CursoRepository;
import com.example.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso){
        if (nomeCurso == null) {

            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadatrar (@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}