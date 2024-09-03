package com.poloit.grupo12.inscripciones.service.interfaces;

import com.poloit.grupo12.inscripciones.dto.MentorDTO;

import java.util.List;

public interface IMentorService {
    public List<MentorDTO> findAll();
    public MentorDTO findById(Long id);
    public MentorDTO save(MentorDTO mentorDTO);
    public MentorDTO update(Long id, MentorDTO mentorDTO);
    public void delete(Long id);

}
