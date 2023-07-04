package com.usuario.servicio.service;

import java.util.List;
import java.util.Map;

import com.usuario.servicio.entities.Usuario;
import com.usuario.servicio.models.Carro;
import com.usuario.servicio.models.Moto;

public interface UsuarioService {

	public List<Usuario> getA11();
	
	public Usuario getUsuarioById(int id);
	
	public Usuario save(Usuario usuario);
	
	public Carro saveCarro(int usuarioId,Carro carro);
	
	public Moto saveMoto(int usuarioId,Moto moto);
	
	public Map<String,Object> getUsuarioAndVehiculos(int usuarioId);
}
