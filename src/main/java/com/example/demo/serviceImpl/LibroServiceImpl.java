package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LibroEntity;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public LibroEntity create(LibroEntity libro) {
		return libroRepository.save(libro);
	}

	@Override
	public LibroEntity update(LibroEntity libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

	@Override
	public void delete(Long ID_LIBRO) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(ID_LIBRO);
		
	}

	@Override
	public LibroEntity read(Long ID_LIBRO) {
		// TODO Auto-generated method stub
		return libroRepository.findById(ID_LIBRO).get();
	}

	@Override
	public List<LibroEntity> readAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}
	
}
