package com.poloit.grupo12.inscripciones.service.interfaces;

import com.poloit.grupo12.inscripciones.dto.CursoDTO;

import java.util.List;

public interface ICursoService {
    public List<CursoDTO> findAll();
    public CursoDTO findById(Long id);
    public CursoDTO save(CursoDTO cursoDTO);
    public CursoDTO update(Long id, CursoDTO cursoDTO);
    public void delete(Long id);
}
