package converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.beans.UsuarioMB;
import sistema.modelos.Usuario;


@FacesConverter("juizConverter")
public class juizConverter implements Converter{
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
	        try {
	            UsuarioMB UsuarioMB = (UsuarioMB) fc.getExternalContext().getApplicationMap().get("usuarioMB");
	            for(Usuario usuario : UsuarioMB.getCadastros())
	            {
	            	if(usuario.getNome().equals(value))
	            		return usuario;
	            }
	            
	          
	        } catch(NumberFormatException e) {
	          //  throw new ExcrConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
	        }
	    }
	    
    return null;
}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			if (object instanceof Usuario)
				return ((Usuario) object).getNome();
		}

		return null;

	}

}
