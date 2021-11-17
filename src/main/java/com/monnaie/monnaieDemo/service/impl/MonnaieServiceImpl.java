package com.monnaie.monnaieDemo.service.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.monnaie.monnaieDemo.entity.Monnaie;
import com.monnaie.monnaieDemo.enumeration.EMonnaie;
import com.monnaie.monnaieDemo.service.MonnaieService;


@Service
public class MonnaieServiceImpl implements MonnaieService{
	
	private Logger logger = LoggerFactory.getLogger(MonnaieServiceImpl.class);
	
	/**
	 * Renvoie un objet Monnaie rendant la monnaie de façon optimale
	 * @param somme valeur representant la somme a rendre en monnaie
	 * @return Objet Monnaie representant monnaie à rendre
	 */
	@Override
	public Monnaie monnaieOptimale(long somme) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		//Pour rendre efficacement la monnaie on rend la plus grande valeur de monnaie qu'on puisse rendre d'abord
		// On trie donc la liste de de monnaie qu'on peut rendre par ordre décroissant.
		List<EMonnaie> monnaieList = Arrays.asList(EMonnaie.values()).stream().sorted((m1,m2) -> m1.getValeur().compareTo(m2.getValeur())).collect(Collectors.toList());
		Collections.reverse(monnaieList);
		
		int plusGrandeValeur = monnaieList.get(0).getValeur(); //10
		int plusPetiteValeur = monnaieList.get(monnaieList.size()-1).getValeur();//2
		
		long sommeASoustraire = somme;
		
		Monnaie monnaieARendre = new Monnaie();
		
		for (EMonnaie monnaie : monnaieList) {
			
			int valeurASoustraire = monnaie.getValeur();
			logger.info("Monnaie a soustraire : "+valeurASoustraire);
			
			if (valeurASoustraire == plusGrandeValeur && sommeASoustraire >= plusGrandeValeur) {
				//TODO a ameliorer en utilisant directement la méthode de modification dynamique du champs en question de la classe monnaie
				monnaieARendre.setPieces10(sommeASoustraire - (sommeASoustraire%plusGrandeValeur));
				sommeASoustraire -= (sommeASoustraire - (sommeASoustraire%plusGrandeValeur));
			}
			else {
				while (sommeASoustraire >= valeurASoustraire && sommeASoustraire - valeurASoustraire >= plusPetiteValeur) {
					sommeASoustraire -= valeurASoustraire;
					monnaieARendre = this.modifierChampsMonnaie(monnaieARendre, monnaie.getNomChampsMonnaie());
				}
			}
			
			
		}
		
		if (sommeASoustraire == plusPetiteValeur) {
			sommeASoustraire -= plusPetiteValeur;
			monnaieARendre = this.modifierChampsMonnaie(monnaieARendre, EMonnaie.DEUX.getNomChampsMonnaie());
		}
		return monnaieARendre;
	}
	
	private Monnaie modifierChampsMonnaie(Monnaie m,String nomChamp) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Field field = m.getClass().getDeclaredField(nomChamp);
		field.setAccessible(true);
		Long valeur = (Long) field.get(m);
		field.set(m,valeur+1);
		return m;
	}

}
