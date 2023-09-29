package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AlquilerEntity;

public interface AlquilerService {
     
	
	  AlquilerEntity create (AlquilerEntity alquiler);
	  AlquilerEntity update  (AlquilerEntity alquiler);
	  void delete (Long ID_ALQUILER);
	  AlquilerEntity read (Long ID_ALQUILER);
	  List<AlquilerEntity> readAll();
}
