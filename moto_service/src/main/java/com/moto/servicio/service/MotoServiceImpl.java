package com.moto.servicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.servicio.dao.MotoDao;
import com.moto.servicio.entities.Moto;

@Service
public class MotoServiceImpl implements MotoService {
	
	@Autowired
	private MotoDao motodao;

	@Override
	public List<Moto> getA11() {
		// TODO Auto-generated method stub
		return motodao.findAll();
	}

	@Override
	public Moto getMotoById(int id) {
		// TODO Auto-generated method stub
		return motodao.findById(null).orElse(null);
	}

	@Override
	public Moto save(Moto moto) {
		// TODO Auto-generated method stub
		Moto nuevamoto = motodao.save(moto);
		return nuevamoto;
	}

	@Override
	public List<Moto> byUsuarioId(int usuarioId) {
		// TODO Auto-generated method stub
		return motodao.findByUsuarioId(usuarioId);
	}

}
