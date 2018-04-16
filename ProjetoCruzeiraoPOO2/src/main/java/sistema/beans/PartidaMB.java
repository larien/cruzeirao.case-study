package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DragDropEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Grupo;
import sistema.modelos.Inscricao;
import sistema.modelos.Juiz;
import sistema.modelos.Local;
import sistema.modelos.Partida;
import sistema.modelos.Rodada;
import sistema.service.PartidaService;

@ManagedBean(eager=true)
@ApplicationScoped
public class PartidaMB {
	private PartidaService service = new PartidaService();
	private Partida Partida = new Partida();
	private static Rodada rodada;

	public void salvar()
	{
		service.salvar(Partida);
		Partida = new Partida();
	}
	
	public Partida getPartida() {
		return Partida;
	}
	public void setPartida(Partida Partida) {
		this.Partida = Partida;
	}
	public void remover (Partida Partida)
	{
		service.remove(Partida);
	}

	public List<Partida> getPartidas() {
		return service.getPartidas();
	}

	@SuppressWarnings("unchecked")
	public void editarPartida(ActionEvent event)
	{
		rodada = (Rodada)event.getComponent().getAttributes().get("rodada");
		
		if (rodada.getPartidas()==null)
			rodada.setPartidas(new ArrayList<Partida>());
		service.setPartidas(rodada.getPartidas());
		Partida.setRodada(rodada);
	}

	public void onJuizDrop(DragDropEvent ddEvent) {
        Juiz juiz = ((Juiz) ddEvent.getData());		
        Partida teste= (Partida) ddEvent.getComponent().getAttributes().get("partida");

        if(teste.getJuizes() == null)
        	teste.setJuizes(new ArrayList<Juiz>());
        for (Juiz j : teste.getJuizes())
        	if(juiz == j)
        		return;
        teste.getJuizes().add(juiz);
    }
}
	