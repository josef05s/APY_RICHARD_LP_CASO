package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EditorialEntity;

public interface EditorialService {

	EditorialEntity create (EditorialEntity editorial);
	EditorialEntity update (EditorialEntity editorial);
	void delete (Long ID_EDITORIAL);
	EditorialEntity read (Long ID_EDITORIAL);
	List<EditorialEntity> readAll();
}
