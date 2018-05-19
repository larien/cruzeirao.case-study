package sistema.modelos;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Partida")
public class Partida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;

	private int numero;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PARTIDAINSCRICAOMANDANTE_ID", referencedColumnName = "ID") })
	private Inscricao equipeMandante;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PARTIDAINSCRICAOVISITANTE_ID", referencedColumnName = "ID") })
	private Inscricao equipeVisitante;
	private Date data;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "LOCAL_ID", referencedColumnName = "ID") })
	private Local local;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PARTIDA_ID", referencedColumnName = "ID") })
	private Partida proxPartida;

	@ManyToMany
	@JoinTable(name = "Juiz")
	private List<Juiz> juizes;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PARTIDAGRUPO_ID", referencedColumnName = "ID") })
	private Grupo grupo;
	private String relatoJuiz;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PARTIDARODADA_ID", referencedColumnName = "ID") })
	private Rodada rodada;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Inscricao getEquipeMandante() {
		return equipeMandante;
	}

	public void setEquipeMandante(Inscricao equipeMandante) {
		this.equipeMandante = equipeMandante;
	}

	public Inscricao getEquipeVisitante() {
		return equipeVisitante;
	}

	public void setEquipeVisitante(Inscricao equipeVisitante) {
		this.equipeVisitante = equipeVisitante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Partida getProxPartida() {
		return proxPartida;
	}

	public void setProxPartida(Partida proxPartida) {
		this.proxPartida = proxPartida;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getRelatoJuiz() {
		return relatoJuiz;
	}

	public void setRelatoJuiz(String relatoJuiz) {
		this.relatoJuiz = relatoJuiz;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
