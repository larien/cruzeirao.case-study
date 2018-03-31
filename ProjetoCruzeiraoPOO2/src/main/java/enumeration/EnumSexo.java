package enumeration;

public enum EnumSexo {
	FEMININO("Feminino"), 
	MASCULINO("Masculino"), 
	TRANSGENERO("Transgenero"), 
	INTERSEX("InterSex");
	
	private String label;
	
	EnumSexo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
