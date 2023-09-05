package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Categoria;
import com.empresa.entity.Cliente;
import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.repository.CategoriaRepository;
import com.empresa.repository.ClienteRepository;
import com.empresa.service.CategoriaService;
import com.empresa.service.ClienteService;

@Controller
public class RegistraClienteController {

	private final ClienteService cliService;
	private final CategoriaService catService;
	
	public RegistraClienteController(ClienteService clienteService,
									 CategoriaService categoriaService) {
		this.cliService = clienteService;
		this.catService = categoriaService;
	}
	
	@GetMapping(value = "/verRegistraCliente" )
	public String verCliente() {return "registraCliente";}
	
	@GetMapping(value = "/listaCategoria")
	@ResponseBody
	public List<Categoria> cargaCategoria(){
		return catService.listarTodo();
	}
	
	@PostMapping("/registraCliente")
	@ResponseBody
	public Map<?, ?> registra(Cliente obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		Cliente objSalida = cliService.insertaCliente(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorDni")
	@ResponseBody
	public String validaDni(String dni) {
		List<Cliente> lstCliente = cliService.listaPorDni(dni);
		if(CollectionUtils.isEmpty(lstCliente)) {
			return "{\"valid\":true}";
		}else {
			return "{\"valid\":false}";
		}
	}
}
