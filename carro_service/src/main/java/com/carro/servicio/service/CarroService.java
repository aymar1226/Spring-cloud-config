package com.carro.servicio.service;

import java.util.List;

import com.carro.servicio.entities.Carro;

public interface CarroService {
	
	public List<Carro> getA11();
	public Carro getCarroById(int id);
	public Carro save(Carro carro);
	public List<Carro> byUsuarioId(int usuarioId);
}