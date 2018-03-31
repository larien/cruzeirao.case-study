package sistema.modelos;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import enumeration.EnumFaseFormato;

public class Fase {
	private Date dataInicio;
	private Date dataFim;
	private Enumeration<EnumFaseFormato> formato;
	private Categoria categoria;
	private List<Grupo> grupos;
	private int numero;
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Enumeration<EnumFaseFormato> getFormato() {
		return formato;
	}
	public void setFormato(Enumeration<EnumFaseFormato> formato) {
		this.formato = formato;
	}
	
}
