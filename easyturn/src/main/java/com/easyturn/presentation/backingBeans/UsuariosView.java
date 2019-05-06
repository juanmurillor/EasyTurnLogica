package  com.easyturn.presentation.backingBeans;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.io.Serializable;
import java.sql.*;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.RowEditEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  com.easyturn.exceptions.*;
import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.UsuariosDTO;
import com.easyturn.presentation.businessDelegate.*;
import com.easyturn.utilities.*;
/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */
 

@ManagedBean
@ViewScoped
public class UsuariosView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(UsuariosView.class);
	
public UsuariosView() {
super();
}
    private InputText txtApellido;
    private InputText txtContraseña;
    private InputText txtNombre;
    private InputText txtTelefono;
    private InputText txtIdtipousuario_Tipousuario;
    private InputText txtEmail;
private CommandButton btnSave;
private CommandButton btnModify;
private CommandButton btnDelete;
private CommandButton btnClear;
private List<UsuariosDTO> data;
private UsuariosDTO selectedUsuarios;
private Usuarios entity;
private boolean showDialog;
    
@ManagedProperty(value="#{BusinessDelegatorView}")
private IBusinessDelegatorView businessDelegatorView;


		
	public String action_new(){
		action_clear();
		selectedUsuarios = null;
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		
		entity = null;
		selectedUsuarios = null;
		
                    if(txtApellido != null){
			 txtApellido.setValue(null);
             txtApellido.setDisabled(true);
			}
                    if(txtContraseña != null){
			 txtContraseña.setValue(null);
             txtContraseña.setDisabled(true);
			}
                    if(txtNombre != null){
			 txtNombre.setValue(null);
             txtNombre.setDisabled(true);
			}
                    if(txtTelefono != null){
			 txtTelefono.setValue(null);
             txtTelefono.setDisabled(true);
			}
                    if(txtIdtipousuario_Tipousuario != null){
			 txtIdtipousuario_Tipousuario.setValue(null);
             txtIdtipousuario_Tipousuario.setDisabled(true);
			}
                        			    if(txtEmail != null){
				   txtEmail.setValue(null);
				   txtEmail.setDisabled(false);	
				}
                        if(btnSave != null){
		  btnSave.setDisabled(true);
		}
		if (btnDelete != null) {
        	btnDelete.setDisabled(true);
        }
        return "";
        }

										
	public void listener_txtId(){
    
	    try {
	    	        String email = FacesUtils.checkString(txtEmail);
	    	    	entity = email != null ? businessDelegatorView.getUsuarios(email) : null;
	    } catch (Exception e) {
	    	entity = null;
	    }
	    
		if(entity==null){
	    	        txtApellido.setDisabled(false);
	    	        txtContraseña.setDisabled(false);
	    	        txtNombre.setDisabled(false);
	    	        txtTelefono.setDisabled(false);
	    	        txtIdtipousuario_Tipousuario.setDisabled(false);
	    	    	    	        txtEmail.setDisabled(false);
	    	    		    btnSave.setDisabled(false);
		    }else{
		    		        txtApellido.setValue(entity.getApellido());txtApellido.setDisabled(false);
		    		        txtContraseña.setValue(entity.getContraseña());txtContraseña.setDisabled(false);
		    		        txtNombre.setValue(entity.getNombre());txtNombre.setDisabled(false);
		    		        txtTelefono.setValue(entity.getTelefono());txtTelefono.setDisabled(false);
		    		        txtIdtipousuario_Tipousuario.setValue(entity.getTipousuario().getIdtipousuario());txtIdtipousuario_Tipousuario.setDisabled(false);
		    		    		        txtEmail.setValue(entity.getEmail());txtEmail.setDisabled(true);
		    		    btnSave.setDisabled(false);
		    if(btnDelete!=null){
		    	btnDelete.setDisabled(false);
		    }
	    }
    }
        
	public String action_edit(ActionEvent evt){
    	
    	selectedUsuarios = (UsuariosDTO)(evt.getComponent().getAttributes().get("selectedUsuarios"));		
            txtApellido.setValue(selectedUsuarios.getApellido());txtApellido.setDisabled(false);
            txtContraseña.setValue(selectedUsuarios.getContraseña());txtContraseña.setDisabled(false);
            txtNombre.setValue(selectedUsuarios.getNombre());txtNombre.setDisabled(false);
            txtTelefono.setValue(selectedUsuarios.getTelefono());txtTelefono.setDisabled(false);
            txtIdtipousuario_Tipousuario.setValue(selectedUsuarios.getIdtipousuario_Tipousuario());txtIdtipousuario_Tipousuario.setDisabled(false);
                txtEmail.setValue(selectedUsuarios.getEmail());txtEmail.setDisabled(true);
            btnSave.setDisabled(false);
    	setShowDialog(true);

    	return "";
    }
    
    public String action_save(){    	
        try {        	
        	if(selectedUsuarios == null && entity==null){
        		action_create();
        	}else{
        		action_modify();
        	}
        	data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    	
    }
    
    public String action_create() {
        try {
        	entity = new Usuarios();

	    	        String email = FacesUtils.checkString(txtEmail);
	    
                                    	            		entity.setApellido(FacesUtils.checkString(txtApellido));
            	                                                        	            		entity.setContraseña(FacesUtils.checkString(txtContraseña));
            	                                                        	            		entity.setEmail(email);
            	                                                        	            		entity.setNombre(FacesUtils.checkString(txtNombre));
            	                                            entity.setTelefono(FacesUtils.checkLong(txtTelefono));
                            entity.setTipousuario(FacesUtils.checkInteger(txtIdtipousuario_Tipousuario) != null ? businessDelegatorView.getTipousuario(FacesUtils.checkInteger(txtIdtipousuario_Tipousuario)) : null );
        	        businessDelegatorView.saveUsuarios(entity);
	        FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
        } catch (Exception e) {
        	entity = null;
        	FacesUtils.addErrorMessage(e.getMessage());
        }
        return "";
    }
		
	public String action_modify() {
        try {
        	if(entity==null){
		    		        String email = new String(selectedUsuarios.getEmail());
		    	    		entity = businessDelegatorView.getUsuarios(email);
    		}
    		
        	    		entity.setApellido(FacesUtils.checkString(txtApellido));
    	        	    		entity.setContraseña(FacesUtils.checkString(txtContraseña));
    	        	        	    		entity.setNombre(FacesUtils.checkString(txtNombre));
    	        	    		entity.setTelefono(FacesUtils.checkLong(txtTelefono));
    	    	    	        entity.setTipousuario(FacesUtils.checkInteger(txtIdtipousuario_Tipousuario) != null ? businessDelegatorView.getTipousuario(FacesUtils.checkInteger(txtIdtipousuario_Tipousuario)) : null );
	        	        businessDelegatorView.updateUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
		   data=null;
           FacesUtils.addErrorMessage(e.getMessage());
        }
        return "";
	}
	
	public String action_delete_datatable(ActionEvent evt){
		try{
        	selectedUsuarios = (UsuariosDTO)(evt.getComponent().getAttributes().get("selectedUsuarios"));
    						String email = new String(selectedUsuarios.getEmail());
						entity = businessDelegatorView.getUsuarios(email);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
	
	public String action_delete_master(){
		try{
					        String email = FacesUtils.checkString(txtEmail);
		    		    entity = businessDelegatorView.getUsuarios(email);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
    
	public void action_delete() throws Exception{
		try{
			businessDelegatorView.deleteUsuarios(entity);
    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
            data= null;
		}catch(Exception e ){
			throw e;
		}  
	}	
	
    public String action_closeDialog(){
    	setShowDialog(false);
    	action_clear();    	
    	return "";
    }	
		
        public String action_modifyWitDTO(String apellido, String contraseña, String email, String nombre, Integer telefono, Integer idtipousuario_Tipousuario) throws Exception {
        try {
        
        	    		entity.setApellido(FacesUtils.checkString(apellido));
    	        	    		entity.setContraseña(FacesUtils.checkString(contraseña));
    	        	        	    		entity.setNombre(FacesUtils.checkString(nombre));
    	        	    		entity.setTelefono(FacesUtils.checkLong(telefono));
    	            businessDelegatorView.updateUsuarios(entity);
		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
        //renderManager.getOnDemandRenderer("UsuariosView").requestRender();
        FacesUtils.addErrorMessage(e.getMessage());
        throw e;
        }
        return "";
        }
								
									
                                          
                                                                                            public InputText getTxtApellido() {
                                                return txtApellido;
                                                }
                                                public void setTxtApellido(InputText txtApellido) {
                                                this.txtApellido = txtApellido;
                                                }
                                                                                            public InputText getTxtContraseña() {
                                                return txtContraseña;
                                                }
                                                public void setTxtContraseña(InputText txtContraseña) {
                                                this.txtContraseña = txtContraseña;
                                                }
                                                                                            public InputText getTxtNombre() {
                                                return txtNombre;
                                                }
                                                public void setTxtNombre(InputText txtNombre) {
                                                this.txtNombre = txtNombre;
                                                }
                                                                                            public InputText getTxtTelefono() {
                                                return txtTelefono;
                                                }
                                                public void setTxtTelefono(InputText txtTelefono) {
                                                this.txtTelefono = txtTelefono;
                                                }
                                                                                            public InputText getTxtIdtipousuario_Tipousuario() {
                                                return txtIdtipousuario_Tipousuario;
                                                }
                                                public void setTxtIdtipousuario_Tipousuario(InputText txtIdtipousuario_Tipousuario) {
                                                this.txtIdtipousuario_Tipousuario = txtIdtipousuario_Tipousuario;
                                                }
                                                                                                                                                                                    public InputText getTxtEmail() {
                                                return txtEmail;
                                                }
                                                public void setTxtEmail(InputText txtEmail) {
                                                this.txtEmail = txtEmail;
                                                }
                                                                                        											
																						public List<UsuariosDTO> getData() {
												try{
													if(data==null){
													data = businessDelegatorView.getDataUsuarios();
													}	
												
												}catch(Exception e){
												 e.printStackTrace();
												}
												return data;
											}
																						public void setData(List<UsuariosDTO> usuariosDTO){
												this.data=usuariosDTO;
											}
											
																						
											public UsuariosDTO getSelectedUsuarios(){
												return selectedUsuarios;
											}
											
											public void setSelectedUsuarios (UsuariosDTO usuarios ){
												this.selectedUsuarios = usuarios;
											}
											
											
                                            public CommandButton getBtnSave() {
                                            return btnSave;
                                            }
                                            public void setBtnSave(CommandButton btnSave) {
                                            this.btnSave = btnSave;
                                            }
                                            public CommandButton getBtnModify() {
                                            return btnModify;
                                            }
                                            public void setBtnModify(CommandButton btnModify) {
                                            this.btnModify = btnModify;
                                            }
                                            public CommandButton getBtnDelete() {
                                            return btnDelete;
                                            }
                                            public void setBtnDelete(CommandButton btnDelete) {
                                            this.btnDelete = btnDelete;
                                            }
                                            public CommandButton getBtnClear() {
                                            return btnClear;
                                            }
                                            public void setBtnClear(CommandButton btnClear) {
                                            this.btnClear = btnClear;
                                            }
                                            
                                            public TimeZone getTimeZone() {
                                             return java.util.TimeZone.getDefault();
                                             }
																							
											 public IBusinessDelegatorView getBusinessDelegatorView() {
											 return businessDelegatorView;
											 }

											public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
											this.businessDelegatorView = businessDelegatorView;
											}
											
											public boolean isShowDialog() {
												return showDialog;
											}
										
											public void setShowDialog(boolean showDialog) {
												this.showDialog = showDialog;
											}											
                                             
									}
