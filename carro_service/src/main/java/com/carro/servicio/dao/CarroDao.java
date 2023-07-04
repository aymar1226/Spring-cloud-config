package com.carro.servicio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carro.servicio.entities.Carro;

@Repository
public interface CarroDao extends JpaRepository<Carro,Integer> {
	List<Carro> findByUsuarioId(int usuarioId);

}
