package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LibroEntity;

public interface LibroService {

	LibroEntity create (LibroEntity libro);
	LibroEntity update (LibroEntity libro);
	void delete (Long ID_LIBRO);
	LibroEntity read (Long ID_LIBRO);
	List<LibroEntity> readAll();
}
