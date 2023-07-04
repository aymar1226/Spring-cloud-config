package com.usuario.servicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuario.servicio.entities.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Integer>{

}
