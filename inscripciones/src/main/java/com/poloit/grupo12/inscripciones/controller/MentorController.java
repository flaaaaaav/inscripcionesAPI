package com.poloit.grupo12.inscripciones.controller;

import com.poloit.grupo12.inscripciones.dto.MentorDTO;
import com.poloit.grupo12.inscripciones.service.implementacion.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    @Autowired
    private MentorService service;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll() {
        List<MentorDTO> lista = service.findAll();
        if (!lista.isEmpty()) {
            return ResponseEntity.ok(lista);
        } else {
            String mensajeError = "La tabla no contiene datos para mostrar";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @GetMapping("obtener/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<MentorDTO> optDTO = Optional.ofNullable(service.findById(id));
        if (optDTO.isPresent()) {
            return ResponseEntity.ok(optDTO);
        } else {
            String mensajeError = "No se encontro el mentor con ID " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody MentorDTO mentorDTO) {
        try {
            MentorDTO nuevoMentor = service.save(mentorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMentor);
        } catch (Exception e) {
            String mensajeError = "Ocurrió un error al crear el mentor";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@RequestBody MentorDTO mentorDTO,
                                  @PathVariable Long id) {
        if (service.findById(id) != null) {
            MentorDTO mentorEditado = service.update(id, mentorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(mentorEditado);
        } else {
            String mensajeError = "No se encontro el mentor con ID " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (service.findById(id) != null) {
            service.delete(id);
            String mensajeOk = "Se elimino el mentor con el ID " + id;
            return ResponseEntity.ok(mensajeOk);

        } else {
            String mensajeError = "No se encontro el mentor con el ID " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

}
