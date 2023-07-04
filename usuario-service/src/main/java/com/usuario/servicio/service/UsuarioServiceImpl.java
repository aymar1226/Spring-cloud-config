package com.usuario.servicio.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.servicio.dao.UsuarioDao;
import com.usuario.servicio.entities.Usuario;
import com.usuario.servicio.feignclients.CarroFeignClient;
import com.usuario.servicio.feignclients.MotoFeignClient;
import com.usuario.servicio.models.Carro;
import com.usuario.servicio.models.Moto;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	
	@Autowired
	private UsuarioDao usuariodao;
	
	@Autowired
	private CarroFeignClient carroFeignClient;
	
	@Autowired
	private MotoFeignClient motoFeignClient;
	
	
	@Override
	public List<Usuario> getA11() {
		// TODO Auto-generated method stub
		return usuariodao.findAll();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		// TODO Auto-generated method stub
		return usuariodao.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario nuevoUsuario = usuariodao.save(usuario);
		return nuevoUsuario;
	}

	//FEIGN
	
	@Override
	public Carro saveCarro(int usuarioId, Carro carro) {
		// TODO Auto-generated method stub
		carro.setUsuarioId(usuarioId);
		Carro nuevoCarro = carroFeignClient.save(carro);
		return nuevoCarro;
	}

	@Override
	public Moto saveMoto(int usuarioId, Moto moto) {
		// TODO Auto-generated method stub
		moto.setUsuarioId(usuarioId);
		Moto nuevoMoto = motoFeignClient.save(moto);
		return nuevoMoto;
	}
	
	@Override
	public Map<String,Object> getUsuarioAndVehiculos(int usuarioId){
		Map<String,Object> resultado = new HashMap<>();
		Usuario usuario = usuariodao.findById(usuarioId).orElse(null);
		
		if(usuario == null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		}
		resultado.put("Usuario", usuario);
		List<Carro> carros = carroFeignClient.getCarros(usuarioId);
		if(carros.isEmpty()) {
			resultado.put("Carros", "El usuario no tiene carros");
		}else {
			resultado.put("Carros", carros);
		}
		
		List<Moto> motos = motoFeignClient.getMotos(usuarioId);
		if(motos.isEmpty()) {
			resultado.put("Motos", "El usuario no tiene motos");
		}else {
			resultado.put("Motos", motos);
		}
		return resultado;
	}

}
