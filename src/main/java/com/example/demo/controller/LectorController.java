package com.example.demo.controller;

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

import com.example.demo.entity.LectorEntity;

import com.example.demo.serviceImpl.LectorServiceImpl;



import java.util.List;

@RestController
@RequestMapping("api/lector")
public class LectorController {

	@Autowired
	private LectorServiceImpl LectorService;
	   
	@GetMapping("/all")
	public List<LectorEntity> listar() { 
		return LectorService.readAll();
	}
	
	@GetMapping("/{ID_LECTOR}")
	public ResponseEntity<LectorEntity> listar2(@PathVariable("ID_LECTOR") long ID_LECTOR) {
		LectorEntity lector = LectorService.read(ID_LECTOR);
		if (lector != null) {
			return new ResponseEntity<>(lector, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/lector")
	public ResponseEntity<LectorEntity> crearLector(@RequestBody LectorEntity lector) {
		try {
			LectorEntity nuevoLector = LectorService.create(new LectorEntity(lector.getID_LECTOR(),lector.getNombre(),lector.getTelefono(),lector.getDireccion(),lector.getCodigo_postal(),lector.getObservaciones(), null));
			return new ResponseEntity<>(nuevoLector, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/lector/{ID_LECTOR}")
	public ResponseEntity<LectorEntity> updateTutorial(@PathVariable("ID_LECTOR") long ID_LECTOR, @RequestBody LectorEntity l) {
		LectorEntity Lector = LectorService.read(ID_LECTOR);

		if (Lector != null) {
			Lector.setID_LECTOR(l.getID_LECTOR());
			Lector.setNombre(l.getNombre());
			Lector.setTelefono(l.getTelefono());
			Lector.setDireccion(l.getDireccion());
			Lector.setCodigo_postal(l.getCodigo_postal());
			Lector.setObservaciones(l.getObservaciones());
			
			return new ResponseEntity<>(LectorService.create(Lector), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/lector/{ID_LECTOR}")
	public ResponseEntity<HttpStatus> deleteLector(@PathVariable("ID_LECTOR") long ID_LECTOR) {
		try {
			LectorService.delete(ID_LECTOR);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

