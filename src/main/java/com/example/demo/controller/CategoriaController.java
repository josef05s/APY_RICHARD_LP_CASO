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

import com.example.demo.serviceImpl.CategoriaServiceImpl;
import com.example.demo.entity.CategoriaEntity;



import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaServiceImpl CategoriaService;

	@GetMapping("/all")
	public List<CategoriaEntity> listar() {
		return CategoriaService.readAll();
	}

	@GetMapping("/{ID_CATEGORIA}")
	public ResponseEntity<CategoriaEntity> listar2(@PathVariable("ID_CATEGORIA") long ID_CATEGORIA) {
		CategoriaEntity categoria = CategoriaService.read(ID_CATEGORIA);
		if (categoria != null) {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/categoria")
	public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaEntity categoria) {
		try {
			CategoriaEntity nuevoCategoria = CategoriaService.create(new CategoriaEntity(categoria.getID_CATEGORIA(),categoria.getCategoria(), null));
			return new ResponseEntity<CategoriaEntity>(nuevoCategoria, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/categoria/{ID_CATEGORIA}")
	public ResponseEntity<CategoriaEntity> updateTutorial(@PathVariable("ID_CATEGORIA") long ID_CATEGORIA,
			@RequestBody CategoriaEntity c) {
		CategoriaEntity Categoria = CategoriaService.read(ID_CATEGORIA);

		if (Categoria != null) {
			Categoria.setID_CATEGORIA(c.getID_CATEGORIA());
			Categoria.setCategoria(c.getCategoria());
			return new ResponseEntity<>(CategoriaService.create(Categoria), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/categoria/{ID_CATEGORIA}")
	public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("ID_CATEGORIA") long ID_CATEGORIA) {
		try {
			CategoriaService.delete(ID_CATEGORIA);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
