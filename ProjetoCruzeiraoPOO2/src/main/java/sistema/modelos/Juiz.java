package sistema.modelos;

import java.util.Enumeration;

import enumeration.EnumJuizTipo;

public class Juiz {
	private Enumeration<EnumJuizTipo> tipo;
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Enumeration<EnumJuizTipo> getTipo() {
		return tipo;
	}

	public void setTipo(Enumeration<EnumJuizTipo> tipo) {
		this.tipo = tipo;
	}
}
