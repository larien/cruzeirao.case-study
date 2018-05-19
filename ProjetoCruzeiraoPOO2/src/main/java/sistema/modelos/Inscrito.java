package sistema.modelos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Inscrito")
public class Inscrito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;

	private String tipo;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "INSCRITOUSUARIO_ID", referencedColumnName = "ID") })
	private Usuario usuario;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "INSCRITOINSCRICAO_ID", referencedColumnName = "ID") })
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return tipo + " " + usuario.getNome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
