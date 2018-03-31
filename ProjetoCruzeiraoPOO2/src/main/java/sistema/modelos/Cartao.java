
package sistema.modelos;

import java.util.Enumeration;

import enumeration.EnumCartaoTipo;

public class Cartao {
	private Inscrito inscrito;
	private Enumeration<EnumCartaoTipo> tipo;
	private int tempo;
	
	
	public Inscrito getInscrito() {
		return inscrito;
	}
	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public Enumeration<EnumCartaoTipo> getTipo() {
		return tipo;
	}
	public void setTipo(Enumeration<EnumCartaoTipo> tipo) {
		this.tipo = tipo;
	}
	
}