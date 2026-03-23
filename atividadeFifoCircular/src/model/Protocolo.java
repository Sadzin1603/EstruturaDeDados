package model;

public class Protocolo {
	private String type;
	private String dados;
	
	public Protocolo(String type,String dados) {
		this.type = type;
		this.dados = dados;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDados() {
		return dados;
	}
	public void setDados(String dados) {
		this.dados = dados;
	}
	
	@Override
	public String toString() {
		
		return this.type.toString() + " : " + this.dados;
	}
}
