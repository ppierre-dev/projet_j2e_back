package com.univlittoral.projetback.dto;

public class GenresDTO {
	private String label;
	private int value;
	private String color;
	
	private int MANGA;
	private int ROMAN;
	private int BD;
	private int POESIE;
	private int NOUVELLE;
	
	public int getMANGA() {
		return MANGA;
	}
	public void addMANGA() {
		this.MANGA++;
	}
	public int getROMAN() {
		return ROMAN;
	}
	public void addROMAN() {
		this.ROMAN++;
	}
	public int getBD() {
		return BD;
	}
	public void addBD() {
		this.BD++;
	}
	public int getPOESIE() {
		return POESIE;
	}
	public void addPOESIE() {
		this.POESIE++;
	}
	public int getNOUVELLE() {
		return NOUVELLE;
	}
	public void addNOUVELLE() {
		this.NOUVELLE++;
	}
}
