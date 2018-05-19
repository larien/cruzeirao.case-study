package sistema.modelos;

import java.io.Serializable;
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

@Entity
@Table(name = "Inscricao")
public class Inscricao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;

	private long numero;
	private boolean pagamento;
	private boolean validada;

	@ManyToMany
	@JoinTable(name = "InscricaoXInscrito")
	private List<Inscrito> inscritos;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "INSCRICAOCATEGORIA_ID", referencedColumnName = "ID") })
	private Categoria categoria;

	@ManyToMany
	@JoinTable(name = "Partida")
	private List<Partida> partidas;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "INSCRICAOEQUIPE_ID", referencedColumnName = "ID") })
	private Equipe equipe;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}

	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}

	public List<Inscrito> getInscritos() {
		return inscritos;
	}

	public void setInscritos(List<Inscrito> inscritos) {
		this.inscritos = inscritos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return numero + "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
