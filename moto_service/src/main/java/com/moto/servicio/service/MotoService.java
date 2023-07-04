package com.moto.servicio.service;

import java.util.List;

import com.moto.servicio.entities.Moto;

public interface MotoService {

	public List<Moto> getA11();
	public Moto getMotoById(int id);
	public Moto save(Moto moto);
	public List<Moto> byUsuarioId(int usuarioId);
}
