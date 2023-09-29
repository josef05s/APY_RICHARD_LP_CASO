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

import com.example.demo.entity.AutorEntity;
import com.example.demo.serviceImpl.AutorServiceImpl;



import java.util.List;

@RestController
@RequestMapping("api/autor")
public class AutorController {

	@Autowired
	private AutorServiceImpl AutorService;
	
	@GetMapping("/all")
	public List<AutorEntity> listar() {
		return AutorService.readAll();
	}
	
	@GetMapping("/{ID_AUTOR}")
	public ResponseEntity<AutorEntity> listar2(@PathVariable("ID_AUTOR") long ID_AUTOR) {
		AutorEntity autor = AutorService.read(ID_AUTOR);
		if (autor != null) {
			return new ResponseEntity<>(autor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/autor")
	public ResponseEntity<AutorEntity> crearAutor(@RequestBody AutorEntity autor) {
		try {
		AutorEntity nuevoAutor = AutorService.create(new AutorEntity(autor.getID_AUTOR(),autor.getAutor(), null));
			return new ResponseEntity<AutorEntity>(nuevoAutor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/autor/{ID_AUTOR}")
	public ResponseEntity<AutorEntity> updateTutorial(@PathVariable("ID_AUTOR") long ID_AUTOR, @RequestBody AutorEntity au) {
		AutorEntity Autor = AutorService.read(ID_AUTOR);

		if (Autor != null) {
			Autor.setID_AUTOR(au.getID_AUTOR());
			Autor.setAutor(au.getAutor());
						return new ResponseEntity<>(AutorService.create(Autor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/autor/{ID_AUTOR}")
	public ResponseEntity<HttpStatus> deleteAutor(@PathVariable("ID_AUTOR") long ID_AUTOR) {
		try {
			AutorService.delete(ID_AUTOR);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
