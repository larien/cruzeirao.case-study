package enumeration;
/*
 * Adicionar aqui todos os tipos de usuario
 * */
public enum EnumUsuarioTipo {
	ADM("Administrador"),
	JUIZ("Juiz"), 
	JOGADOR("Jogador"), 
	TECNICO("Tecnico"), 
	TORCEDOR("Torcedor"), 
	ORGANIZADOR("Organizador");

	private String label;
	
	EnumUsuarioTipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
