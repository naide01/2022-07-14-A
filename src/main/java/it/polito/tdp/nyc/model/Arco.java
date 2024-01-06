package it.polito.tdp.nyc.model;

public class Arco implements Comparable <Arco> {
	//contiene le informazioni dell'arco
	private String v1;
	private String v2;
	private int peso;
	
	public Arco(String v1, String v2, int peso) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;
	}
	public String getV1() {
		return v1;
	}
	public void setV1(String v1) {
		this.v1 = v1;
	}
	public String getV2() {
		return v2;
	}
	public void setV2(String v2) {
		this.v2 = v2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public int compareTo(Arco a) {
		return a.peso - this.peso; 
	}
	@Override
	public String toString() {
		return "Arco da: " + v1 + " a " + v2 + ", peso: " + peso + "\n";
	}
	
	
}
