package com.monnaie.monnaieDemo.entity;

public class Monnaie {
	
	private long pieces10;
	
	private long pieces5;
	
	private long pieces2;

	public long getPieces10() {
		return pieces10;
	}

	public void setPieces10(long pieces10) {
		this.pieces10 = pieces10;
	}

	public long getPieces5() {
		return pieces5;
	}

	public void setPieces5(long pieces5) {
		this.pieces5 = pieces5;
	}

	public long getPieces2() {
		return pieces2;
	}

	public void setPieces2(long pieces2) {
		this.pieces2 = pieces2;
	}

	@Override
	public String toString() {
		if (pieces10 == 0 && pieces5 == 0 && pieces2 == 0) {
			return  null;
		}
		else {
			return "Monnaie [pieces10=" + pieces10 + ", pieces5=" + pieces5 + ", pieces2=" + pieces2 + "]";
		}
	}
	
	
	

}
