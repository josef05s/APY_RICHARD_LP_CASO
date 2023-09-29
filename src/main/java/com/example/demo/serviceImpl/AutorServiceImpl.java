package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AutorEntity;
import com.example.demo.repository.AutorRepository;
import com.example.demo.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	public AutorRepository autorRepository;
		
	
	
	@Override
	public AutorEntity create(AutorEntity autor) {
		// TODO Auto-generated method stub
		return autorRepository.save(autor);
	}

	@Override
	public AutorEntity update(AutorEntity autor) {
		// TODO Auto-generated method stub
		return autorRepository.save(autor);
	}

	@Override
	public void delete(Long ID_AUTOR) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(ID_AUTOR);
	}

	@Override
	public AutorEntity read(Long ID_AUTOR) {
		// TODO Auto-generated method stub
		return autorRepository.findById(ID_AUTOR).get();
	}

	@Override
	public List<AutorEntity> readAll() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

}
