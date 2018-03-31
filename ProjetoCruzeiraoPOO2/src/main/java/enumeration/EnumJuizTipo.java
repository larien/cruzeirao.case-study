package enumeration;

public enum EnumJuizTipo {

	JUIZ("Juiz"), 
	JUIZ2("Jogador"), 
	JUIZ3("Vendedor");
	
	private String label;
	
	EnumJuizTipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
