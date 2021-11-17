package com.monnaie.monnaieDemo.enumeration;

public enum EMonnaie {
	
	DIX(10,"pieces10"),CINQ(5,"pieces5"),DEUX(2,"pieces2");
	
	private Integer valeur;
	private String nomChampsMonnaie;
	
	EMonnaie(Integer valeur,String nomChampsMonnaie) {
		this.valeur = valeur;
		this.nomChampsMonnaie = nomChampsMonnaie;
	}

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	public String getNomChampsMonnaie() {
		return nomChampsMonnaie;
	}

	public void setNomChampsMonnaie(String nomChampsMonnaie) {
		this.nomChampsMonnaie = nomChampsMonnaie;
	}
	
	
	
}
