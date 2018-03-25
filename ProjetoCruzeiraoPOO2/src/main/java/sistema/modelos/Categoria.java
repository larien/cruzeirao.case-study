package sistema.modelos;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import enumeration.EnumSexoTipo;

public class Categoria {
	private String nome;
	private Date nascidosApartirDe;
	private List<Inscricao> inscricoes;
	private Campeonato campeonato;
	private List<Fase> fases;
	private int minJogadores;
	private int maxJogadores;
	private int minTimes;
	private int maxTimes;
	private Enumeration<EnumSexoTipo> sexo;
	private int attribute74;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascidosApartirDe() {
		return nascidosApartirDe;
	}
	public void setNascidosApartirDe(Date nascidosApartirDe) {
		this.nascidosApartirDe = nascidosApartirDe;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public int getMinJogadores() {
		return minJogadores;
	}
	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}
	public int getMaxTimes() {
		return maxTimes;
	}
	public void setMaxTimes(int maxTimes) {
		this.maxTimes = maxTimes;
	}
	public int getMinTimes() {
		return minTimes;
	}
	public void setMinTimes(int minTimes) {
		this.minTimes = minTimes;
	}
	public int getMaxJogadores() {
		return maxJogadores;
	}
	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}
	public int getAttribute74() {
		return attribute74;
	}
	public void setAttribute74(int attribute74) {
		this.attribute74 = attribute74;
	}
	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}
	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	public List<Fase> getFases() {
		return fases;
	}
	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}
	public Enumeration<EnumSexoTipo> getSexo() {
		return sexo;
	}
	public void setSexo(Enumeration<EnumSexoTipo> sexo) {
		this.sexo = sexo;
	}
	
}
