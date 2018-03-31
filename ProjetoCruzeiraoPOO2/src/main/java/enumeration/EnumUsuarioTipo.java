package enumeration;
/*
 * Adicionar aqui todos os tipos de usuario
 * */
public enum EnumUsuarioTipo {
	JUIZ("Juiz"), 
	JOGADOR("Jogador"), 
	VENDEDOR("Vendedor");
	
	private String label;
	
	EnumUsuarioTipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
