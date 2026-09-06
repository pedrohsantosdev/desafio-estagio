package com.example.estagio.resource;

import com.example.estagio.entity.Tarefa;
import com.example.estagio.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<Tarefa> cadastrar(@RequestBody Tarefa tarefa) {
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listar(@RequestParam(required = false) String responsavel) {

        if(responsavel != null) {
            return ResponseEntity.ok(tarefaRepository.findByResponsavelContainingIgnoreCase(responsavel));
        }

        return ResponseEntity.ok(tarefaRepository.findAll());
    }

    @GetMapping("/data")
    public ResponseEntity<List<Tarefa>> buscarPorData(@RequestParam LocalDate data) {

        return ResponseEntity.ok(tarefaRepository.findByDataEntrega(data));
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Tarefa>> listarPendetes(@RequestParam(required = false) String responsavel) {

        if(responsavel != null) {
            return ResponseEntity.ok(tarefaRepository.findByConcluidaFalseAndResponsavelContainingIgnoreCase(responsavel));
        }

        return ResponseEntity.ok(tarefaRepository.findByConcluidaFalse());
    }


}
