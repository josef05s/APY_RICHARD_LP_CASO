package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlquilerEntity;
import com.example.demo.repository.AlquilerRepository;
import com.example.demo.service.AlquilerService;



@Service
public class AlquilerServiceImpl implements AlquilerService{

	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Override
	public AlquilerEntity create(AlquilerEntity alquiler) {
		// TODO Auto-generated method stub
		return alquilerRepository.save(alquiler);
	}

	@Override
	public AlquilerEntity update(AlquilerEntity alquiler) {
		// TODO Auto-generated method stub
		return alquilerRepository.save(alquiler);
	}

	@Override
	public void delete(Long ID_ALQUILER) {
		// TODO Auto-generated method stub
		alquilerRepository.deleteById(ID_ALQUILER);
	}

	@Override
	public AlquilerEntity read(Long ID_ALQUILER) {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(ID_ALQUILER).get();
	}

	@Override
	public List<AlquilerEntity> readAll() {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

	
}

