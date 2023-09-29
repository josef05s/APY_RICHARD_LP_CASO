package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LectorEntity;
import com.example.demo.repository.LectorRepository;
import com.example.demo.service.LectorService;

@Service
public class LectorServiceImpl implements LectorService{

	@Autowired
	private LectorRepository lectorRepository;
	
	@Override
	public LectorEntity create(LectorEntity lector) {
		// TODO Auto-generated method stub
		return lectorRepository.save(lector);
	}

	@Override
	public LectorEntity update(LectorEntity lector) {
		// TODO Auto-generated method stub
		return lectorRepository.save(lector);
	}

	@Override
	public void delete(Long ID_LECTOR) {
		// TODO Auto-generated method stub
		lectorRepository.deleteById(ID_LECTOR);
	}

	@Override
	public LectorEntity read(Long ID_LECTOR) {
		// TODO Auto-generated method stub
		return lectorRepository.findById(ID_LECTOR).get();
	}

	@Override
	public List<LectorEntity> readAll() {
		// TODO Auto-generated method stub
		return lectorRepository.findAll();
	}

	
}
