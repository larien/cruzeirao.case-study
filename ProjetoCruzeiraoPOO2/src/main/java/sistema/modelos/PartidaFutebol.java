package sistema.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PartidaFutebol")
public class PartidaFutebol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;

	@ManyToMany
	@JoinTable(name = "PartidaFutebolXGolMandates")
	private List<Gol> golsMandantes;

	@ManyToMany
	@JoinTable(name = "PartidaFutebolXGolVisitantes")
	private List<Gol> golsVisitantes;

	@ManyToMany
	@JoinTable(name = "PartidaFutebolXGolPenalteMandantes")
	private List<Gol> golsPenaltesMandantes;

	@ManyToMany
	@JoinTable(name = "PartidaFutebolXGolPenalteVisitantes")
	private List<Gol> golsPenaltesVisitantes;

	@ManyToMany
	@JoinTable(name = "PartidaFutebolXCartaoMandantes")
	private List<Cartao> cartoesMandante;

	@ManyToMany
	@JoinTable(name = "PartidaFutebolXCartaoVisititantes")
	private List<Cartao> cartoesVisitante;

	public List<Gol> getGolsMandantes() {
		return golsMandantes;
	}

	public void setGolsMandantes(List<Gol> golsMandantes) {
		this.golsMandantes = golsMandantes;
	}

	public List<Gol> getGolsVisitantes() {
		return golsVisitantes;
	}

	public void setGolsVisitantes(List<Gol> golsVisitantes) {
		this.golsVisitantes = golsVisitantes;
	}

	public List<Gol> getGolsPenaltesMandantes() {
		return golsPenaltesMandantes;
	}

	public void setGolsPenaltesMandantes(List<Gol> golsPenaltesMandantes) {
		this.golsPenaltesMandantes = golsPenaltesMandantes;
	}

	public List<Gol> getGolsPenaltesVisitantes() {
		return golsPenaltesVisitantes;
	}

	public void setGolsPenaltesVisitantes(List<Gol> golsPenaltesVisitantes) {
		this.golsPenaltesVisitantes = golsPenaltesVisitantes;
	}

	public List<Cartao> getCartoesMandante() {
		return cartoesMandante;
	}

	public void setCartoesMandante(List<Cartao> cartoesMandante) {
		this.cartoesMandante = cartoesMandante;
	}

	public List<Cartao> getCartoesVisitante() {
		return cartoesVisitante;
	}

	public void setCartoesVisitante(List<Cartao> cartoesVisitante) {
		this.cartoesVisitante = cartoesVisitante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
