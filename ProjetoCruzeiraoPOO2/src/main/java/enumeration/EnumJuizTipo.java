package enumeration;
/*
 * Adicionar aqui todos os tipos de usuario
 * */
public enum EnumJuizTipo {

	AbritroPrincipal("Arbitro principal"), 
	ArbitroLateral("Arbitro lateral"), 
	Gandula("Gandula");
	
	private String label;
	
	EnumJuizTipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
