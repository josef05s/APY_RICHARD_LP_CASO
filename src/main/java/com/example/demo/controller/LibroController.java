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

import com.example.demo.serviceImpl.LibroServiceImpl;
import com.example.demo.entity.LibroEntity;



import java.util.List;;

@RestController
@RequestMapping("api/libro")
public class LibroController {

	@Autowired
	private LibroServiceImpl LibroService;

	@GetMapping("/all")
	public List<LibroEntity> listar() {
		return LibroService.readAll();
	}

	@GetMapping("/{ID_LIBRO}")
	public ResponseEntity<LibroEntity> listar2(@PathVariable("ID_LIBRO") long ID_LIBRO) {
		LibroEntity libro = LibroService.read(ID_LIBRO);
		if (libro != null) {
			return new ResponseEntity<>(libro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/libro")
	public ResponseEntity<LibroEntity> crearLibro(@RequestBody LibroEntity libro) {
		try {
			LibroEntity nuevoLibro = LibroService.create(new LibroEntity(libro.getID_LIBRO(),libro.getTitulo(),libro.getFecha_lanzamiento(),libro.getIdioma(),libro.getPaginas(),libro.getDescripcion(),libro.getPortada(),null, libro.getAutor(),libro.getCategoria(),libro.getEditorial()));
			return new ResponseEntity<LibroEntity>(nuevoLibro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/libro/{ID_LIBRO}")
	public ResponseEntity<LibroEntity> updateTutorial(@PathVariable("ID_LIBRO") long ID_LIBRO, @RequestBody LibroEntity l) {
		LibroEntity Libro = LibroService.read(ID_LIBRO);

		if (Libro != null) {
			Libro.setID_LIBRO(l.getID_LIBRO());
			Libro.setTitulo(l.getTitulo());
			Libro.setFecha_lanzamiento(l.getFecha_lanzamiento());
			Libro.setIdioma(l.getIdioma());
			Libro.setPaginas(l.getPaginas());
			Libro.setDescripcion(l.getDescripcion());
			Libro.setPortada(l.getPortada());
			return new ResponseEntity<>(LibroService.create(Libro), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/libro/{ID_LIBRO}")
	public ResponseEntity<HttpStatus> deleteLibro(@PathVariable("ID_LIBRO") long ID_LIBRO) {
		try {
			LibroService.delete(ID_LIBRO);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
