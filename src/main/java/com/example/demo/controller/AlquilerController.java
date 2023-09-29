package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AlquilerEntity;

import com.example.demo.serviceImpl.AlquilerServiceImpl;

@RestController
@RequestMapping("api/alquiler")
public class AlquilerController {

	@Autowired
	private AlquilerServiceImpl AlquilerService;
	
	@GetMapping("/all")
	public List<AlquilerEntity> listar() {
		return AlquilerService.readAll();
	}
	
	@GetMapping("/{ID_ALQUILERES}")
	public ResponseEntity<AlquilerEntity> listar2(@PathVariable("ID_ALQUILERES") long ID_ALQUILERES) {
		AlquilerEntity alquiler = AlquilerService.read(ID_ALQUILERES);
		if (alquiler != null) {
			return new ResponseEntity<>(alquiler, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	}
	@PostMapping("/alquiler")
	public ResponseEntity<AlquilerEntity> crearAlquiler(@RequestBody AlquilerEntity alquiler) {
		try {
			AlquilerEntity nuevoAlquiler = AlquilerService.create(new AlquilerEntity(alquiler.getID_ALQUILERES(),alquiler.getFechasalida(),alquiler.getFechaentrada(), null, null));
			return new ResponseEntity<>(nuevoAlquiler, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	@PutMapping("/alquiler/{ID_ALQUILERES}")
	public ResponseEntity<AlquilerEntity> updateTutorial(@PathVariable("ID_ALQUILERES") long ID_ALQUILERES, @RequestBody AlquilerEntity l) {
		AlquilerEntity Alquiler = AlquilerService.read(ID_ALQUILERES);

		if (Alquiler != null) {
			Alquiler.setID_ALQUILERES(l.getID_ALQUILERES());
			Alquiler.setFechasalida(l.getFechasalida());
			Alquiler.setFechaentrada(l.getFechaentrada());
			
			return new ResponseEntity<>(AlquilerService.create(Alquiler), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
	
	@DeleteMapping("/alquileres/{ID_ALQUILERES}")
	public ResponseEntity<HttpStatus> deleteAlquiler(@PathVariable("ID_ALQUILERES") long ID_ALQUILERES) {
		try {
			AlquilerService.delete(ID_ALQUILERES);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}