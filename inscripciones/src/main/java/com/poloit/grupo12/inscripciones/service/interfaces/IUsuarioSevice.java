package com.poloit.grupo12.inscripciones.service.interfaces;

import com.poloit.grupo12.inscripciones.dto.UsuarioDTO;
import com.poloit.grupo12.inscripciones.model.Usuario;

import java.util.List;

public interface IUsuarioSevice {

    public List<UsuarioDTO> findAll();
    public UsuarioDTO findById(Long id);
    public UsuarioDTO save(UsuarioDTO usuarioDTO);
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO);
    public void delete(Long id);

    public Usuario save(Usuario usuario);
    public Usuario findByEmail(String email);


}
