package com.carro.servicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.servicio.dao.CarroDao;
import com.carro.servicio.entities.Carro;

@Service
public class CarroServiceImpl implements CarroService{

	@Autowired
	private CarroDao carrodao;
	
	@Override
	public List<Carro> getA11() {
		// TODO Auto-generated method stub
		return carrodao.findAll();
	}

	@Override
	public Carro getCarroById(int id) {
		// TODO Auto-generated method stub
		return carrodao.findById(id).orElse(null);
	}

	@Override
	public Carro save(Carro carro) {
		// TODO Auto-generated method stub
		Carro nuevocarro = carrodao.save(carro);
		return nuevocarro;
	}

	@Override
	public List<Carro> byUsuarioId(int usuarioId) {
		// TODO Auto-generated method stub
		return carrodao.findByUsuarioId(usuarioId);
	}

}
