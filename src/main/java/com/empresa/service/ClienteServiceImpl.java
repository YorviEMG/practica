package com.empresa.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Cliente;
import com.empresa.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente insertaCliente(Cliente obj) {
		// TODO Auto-generated method stub
		obj.setEstado(0);
		obj.setFechaRegistro(new java.util.Date(System.currentTimeMillis()));

		return repository.save(obj);
	}

	@Override
	public List<Cliente> listaPorDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDniIgnoreCase(dni);
	}
}
