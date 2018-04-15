package enumeration;

public enum EnumInscritoTipo {
	Inscricao1("Azul"), 
	Inscricao2("Vermelho"), 
	Inscricao3("Amarelo");
	
	private String label;
	
	EnumInscritoTipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}

}
