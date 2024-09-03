package com.poloit.grupo12.inscripciones.service.interfaces;

import com.poloit.grupo12.inscripciones.dto.OngDTO;

import java.util.List;

public interface IOngService {

    public List<OngDTO> findAll();
    public OngDTO findById(Long id);
    public OngDTO save(OngDTO ongDTO);
    public OngDTO update(Long id, OngDTO ongDTO);
    public void delete(Long id);

}
