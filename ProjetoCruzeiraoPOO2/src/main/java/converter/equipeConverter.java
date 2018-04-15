package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.beans.EquipeMB;
import sistema.modelos.Equipe;
@FacesConverter("equipeConverter")
public class equipeConverter implements Converter {
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
	        try {
	            EquipeMB EquipeMB = (EquipeMB) fc.getExternalContext().getApplicationMap().get("equipeMB");
	            for(Equipe equipe : EquipeMB.getEquipes())
	            {
	            	if(equipe.getNome().equals(value))
	            	{
	            		System.out.println(equipe);
	            		return equipe;
	            	}
	            }
	            
	          
	        } catch(NumberFormatException e) {
	          //  throw new ExcrConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
	        }
	    }
	    
    return null;
	}
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {

		if (object != null) {
			if (object instanceof Equipe)
				return ((Equipe) object).getNome();
		}

		return null;
	}
}
