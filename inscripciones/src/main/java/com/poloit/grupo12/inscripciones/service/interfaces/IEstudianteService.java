package com.poloit.grupo12.inscripciones.service.interfaces;

import com.poloit.grupo12.inscripciones.dto.EstudianteDTO;

import java.util.List;

public interface IEstudianteService {

    public List<EstudianteDTO> findAll();
    public EstudianteDTO findById(Long id);
    public EstudianteDTO save(EstudianteDTO estudianteDTO);
    public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO);
    public void delete(Long id);
}
