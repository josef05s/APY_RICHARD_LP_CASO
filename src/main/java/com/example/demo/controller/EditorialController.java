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

import com.example.demo.entity.EditorialEntity;
import com.example.demo.serviceImpl.EditorialServiceImpl;



import java.util.List;

@RestController
@RequestMapping("api/editorial")
public class EditorialController {

	@Autowired
	private EditorialServiceImpl EditorialService;

	@GetMapping("/all")
	public List<EditorialEntity> listar() {
		return EditorialService.readAll();
	}

	@GetMapping("/{ID_EDITORIAL}")
	public ResponseEntity<EditorialEntity> listar2(@PathVariable("ID_EDITORIAL") long ID_EDITORIAL) {
		EditorialEntity editorial = EditorialService.read(ID_EDITORIAL);
		if (editorial != null) {
			return new ResponseEntity<>(editorial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/editorial")
	public ResponseEntity<EditorialEntity> crearEditorial(@RequestBody EditorialEntity editorial) {
		try {
			EditorialEntity nuevoEditorial = EditorialService.create(new EditorialEntity(editorial.getID_EDITORIAL(),editorial.getEditorial(), null));
			return new ResponseEntity<EditorialEntity>(nuevoEditorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/editorial/{ID_EDITORIAL}")
	public ResponseEntity<EditorialEntity> updateTutorial(@PathVariable("ID_EDITORIAL") long ID_EDITORIAL,
			@RequestBody EditorialEntity e) {
		EditorialEntity Editorial = EditorialService.read(ID_EDITORIAL);

		if (Editorial != null) {
			Editorial.setID_EDITORIAL(e.getID_EDITORIAL());
			Editorial.setEditorial(e.getEditorial());

			return new ResponseEntity<>(EditorialService.create(Editorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/editorial/{id}")
	public ResponseEntity<HttpStatus> deleteEditorial(@PathVariable("ID_EDITORIAL") long ID_EDITORIAL) {
		try {
			EditorialService.delete(ID_EDITORIAL);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
