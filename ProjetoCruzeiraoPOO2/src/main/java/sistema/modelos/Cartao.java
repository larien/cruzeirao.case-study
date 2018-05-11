
package sistema.modelos;

import java.io.Serializable;
import java.util.Enumeration;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import enumeration.EnumCartaoTipo;

@Entity
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ID", referencedColumnName = "ID") })
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}