package enumeration;

public enum EnumCartaoTipo {
	AZUL("Azul"), 
	VERMELHO("Vermelho"), 
	AMARELO("Amarelo");
	
	private String label;
	
	EnumCartaoTipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
