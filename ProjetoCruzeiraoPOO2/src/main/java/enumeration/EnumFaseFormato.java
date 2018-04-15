package enumeration;

public enum EnumFaseFormato {
	Formato1("Azul"), 
	Formato2("Vermelho"), 
	Formato3("Amarelo");
	
	private String label;
	
	EnumFaseFormato(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}

}
