package com.poloit.grupo12.inscripciones.controller;

import com.poloit.grupo12.inscripciones.dto.OngDTO;
import com.poloit.grupo12.inscripciones.service.IOngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ong")
public class OngController {

    @Autowired
    private IOngService service;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll() {
        List<OngDTO> lista = service.findAll();
        if (!lista.isEmpty()) {
            return ResponseEntity.ok(lista);
        } else {
            String mensajeError = "La tabla no contiene datos para mostrar";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @GetMapping("obtener/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<OngDTO> opt = Optional.ofNullable(service.findById(id));
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        } else {
            String mensajeError = "No se encontro la ONG con ID " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody OngDTO ongDTO) {
        try {
            OngDTO nuevaOng = service.save(ongDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOng);
        } catch (Exception e) {
            String mensajeError = "Ocurrió un error al crear la ONG " + ongDTO.getNombre();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<?> edit(@RequestBody OngDTO ongDTO) {
        if (service.findById(ongDTO.getId()) != null) {
            OngDTO OngEditada = service.update(ongDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(OngEditada);
        } else {
            String mensajeError = "No se encontro la ONG con ID " + ongDTO.getId();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (service.findById(id) != null) {
            service.delete(id);
            String mensajeOk = "Se elimino la ONG con ID " + id;
            return ResponseEntity.ok(mensajeOk);

        } else {
            String mensajeError = "No se encontro la ONG con ID " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

}
