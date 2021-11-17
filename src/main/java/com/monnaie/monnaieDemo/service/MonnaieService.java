package com.monnaie.monnaieDemo.service;

import org.springframework.stereotype.Service;

import com.monnaie.monnaieDemo.entity.Monnaie;

public interface MonnaieService {
	
	public Monnaie monnaieOptimale(long somme) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;

}
