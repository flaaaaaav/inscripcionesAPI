package com.poloit.grupo12.inscripciones.service.implementacion;

import com.poloit.grupo12.inscripciones.dto.CursoDTO;
import com.poloit.grupo12.inscripciones.model.*;
import com.poloit.grupo12.inscripciones.repository.ICursoRepository;
import com.poloit.grupo12.inscripciones.repository.IMentorRepository;
import com.poloit.grupo12.inscripciones.repository.IOngRepository;
import com.poloit.grupo12.inscripciones.service.interfaces.ICursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepository;
    @Autowired
    private IOngRepository ongRepository;
    @Autowired
    private IMentorRepository mentorRepository;

    @Override
    public List<CursoDTO> findAll() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream()
                .map(curso -> convertToDto((curso)))
                .collect(Collectors.toList());
    }

    @Override
    public CursoDTO findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Curso> optCurso = cursoRepository.findById(id);
        return optCurso.map(this::convertToDto).orElse(null);
    }

    @Override
    public CursoDTO save(CursoDTO cursoDTO) {
        ModelMapper mapper = new ModelMapper();
        Curso curso = mapper.map(cursoDTO, Curso.class);
        Ong ong = ongRepository.findById(cursoDTO.getOngId()).orElse(null);
        Mentor mentor = mentorRepository.findById(cursoDTO.getMentorId()).orElse(null);
        if (ong != null && mentor != null) {
            curso.setOng(ong);
            curso.setMentor(mentor);
            Curso nuevoCurso = cursoRepository.save(curso);
            return convertToDto(nuevoCurso);
        }
        return null;
    }

    @Override
    public CursoDTO update(Long id, CursoDTO cursoDTO) {
        ModelMapper mapper = new ModelMapper();
        Curso curso = mapper.map(cursoDTO, Curso.class);
        curso.setId(id);
        Ong ong = ongRepository.findById(cursoDTO.getOngId()).orElse(null);
        Mentor mentor = mentorRepository.findById(cursoDTO.getMentorId()).orElse(null);
        if (ong != null && mentor != null) {
            curso.setOng(ong);
            curso.setMentor(mentor);
            Curso nuevoCurso = cursoRepository.save(curso);
            return convertToDto(nuevoCurso);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

    private CursoDTO convertToDto(Curso curso) {
        ModelMapper mapper = new ModelMapper();
        CursoDTO cursoDTO = mapper.map(curso, CursoDTO.class);
        cursoDTO.setOngId(curso.getOng().getId());
        cursoDTO.setOngNombre(curso.getOng().getNombre());
        cursoDTO.setMentorId(curso.getMentor().getId());
        return cursoDTO;
    }
}
