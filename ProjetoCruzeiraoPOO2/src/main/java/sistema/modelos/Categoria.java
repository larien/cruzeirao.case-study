package sistema.modelos;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumeration.EnumSexo;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;

	private String nome;
	private int nascidosApartirDe;

	@ManyToMany
	@JoinTable(name = "CategoriaXInscricao")
	private List<Inscricao> inscricoes;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "CATEGORIACAMPEONATO_ID", referencedColumnName = "ID") })
	private Campeonato campeonato;

	@ManyToMany
	@JoinTable(name = "CategoriaXFase")
	private List<Fase> fases;

	private int minJogadores;

	private int maxJogadores;

	private int minTimes;

	private int maxTimes;

	private Enumeration<EnumSexo> sexo;

	private int attribute74;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNascidosApartirDe() {
		return nascidosApartirDe;
	}

	public void setNascidosApartirDe(int nascidosApartirDe) {
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

	public Enumeration<EnumSexo> getSexo() {
		return sexo;
	}

	public void setSexo(Enumeration<EnumSexo> sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}