package sistema.modelos;

import java.util.Enumeration;

import enumeration.EnumInscritoTipo;

public class Inscrito {
	private Enumeration<EnumInscritoTipo> tipo;
	private Usuario usuario;
	private Inscricao inscricao;
	private boolean aceiteUsuario;
	private boolean suspensoJogos;
	private boolean inscricaoValidada;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Inscricao getInscricao() {
		return inscricao;
	}
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	public boolean isAceiteUsuario() {
		return aceiteUsuario;
	}
	public void setAceiteUsuario(boolean aceiteUsuario) {
		this.aceiteUsuario = aceiteUsuario;
	}
	public boolean isSuspensoJogos() {
		return suspensoJogos;
	}
	public void setSuspensoJogos(boolean suspensoJogos) {
		this.suspensoJogos = suspensoJogos;
	}
	public boolean isInscricaoValidada() {
		return inscricaoValidada;
	}
	public void setInscricaoValidada(boolean inscricaoValidada) {
		this.inscricaoValidada = inscricaoValidada;
	}
	public Enumeration<EnumInscritoTipo> getTipo() {
		return tipo;
	}
	public void setTipo(Enumeration<EnumInscritoTipo> tipo) {
		this.tipo = tipo;
	}
	
}
