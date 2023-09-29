package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EditorialEntity;
import com.example.demo.repository.EditorialRepository;
import com.example.demo.service.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialRepository editorialRepository;
	
	@Override
	public EditorialEntity create(EditorialEntity editorial) {
		// TODO Auto-generated method stub
		return editorialRepository.save(editorial);
	}

	@Override
	public EditorialEntity update(EditorialEntity editorial) {
		// TODO Auto-generated method stub
		return editorialRepository.save(editorial);
	}

	@Override
	public void delete(Long ID_EDITORIAL) {
		// TODO Auto-generated method stub
		editorialRepository.deleteById(ID_EDITORIAL);
	}

	@Override
	public EditorialEntity read(Long ID_EDITORIAL) {
		// TODO Auto-generated method stub
		return editorialRepository.findById(ID_EDITORIAL).get();
	}

	@Override
	public List<EditorialEntity> readAll() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}

}
