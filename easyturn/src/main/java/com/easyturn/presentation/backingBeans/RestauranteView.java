package com.easyturn.presentation.backingBeans;

import com.easyturn.exceptions.*;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.RestauranteDTO;

import com.easyturn.presentation.businessDelegate.*;

import com.easyturn.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RestauranteView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RestauranteView.class);
    private InputText txtDescripcionrestaurante;
    private InputText txtImagenrestaurante;
    private InputText txtNombrerestaurante;
    private InputText txtTelefonorestaurante;
    private InputText txtEmail_Usuarios;
    private InputText txtIdrestaurante;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RestauranteDTO> data;
    private RestauranteDTO selectedRestaurante;
    private Restaurante entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RestauranteView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedRestaurante = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRestaurante = null;

        if (txtDescripcionrestaurante != null) {
            txtDescripcionrestaurante.setValue(null);
            txtDescripcionrestaurante.setDisabled(true);
        }

        if (txtImagenrestaurante != null) {
            txtImagenrestaurante.setValue(null);
            txtImagenrestaurante.setDisabled(true);
        }

        if (txtNombrerestaurante != null) {
            txtNombrerestaurante.setValue(null);
            txtNombrerestaurante.setDisabled(true);
        }

        if (txtTelefonorestaurante != null) {
            txtTelefonorestaurante.setValue(null);
            txtTelefonorestaurante.setDisabled(true);
        }

        if (txtEmail_Usuarios != null) {
            txtEmail_Usuarios.setValue(null);
            txtEmail_Usuarios.setDisabled(true);
        }

        if (txtIdrestaurante != null) {
            txtIdrestaurante.setValue(null);
            txtIdrestaurante.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer idrestaurante = FacesUtils.checkInteger(txtIdrestaurante);
            entity = (idrestaurante != null)
                ? businessDelegatorView.getRestaurante(idrestaurante) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcionrestaurante.setDisabled(false);
            txtImagenrestaurante.setDisabled(false);
            txtNombrerestaurante.setDisabled(false);
            txtTelefonorestaurante.setDisabled(false);
            txtEmail_Usuarios.setDisabled(false);
            txtIdrestaurante.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDescripcionrestaurante.setValue(entity.getDescripcionrestaurante());
            txtDescripcionrestaurante.setDisabled(false);
            txtImagenrestaurante.setValue(entity.getImagenrestaurante());
            txtImagenrestaurante.setDisabled(false);
            txtNombrerestaurante.setValue(entity.getNombrerestaurante());
            txtNombrerestaurante.setDisabled(false);
            txtTelefonorestaurante.setValue(entity.getTelefonorestaurante());
            txtTelefonorestaurante.setDisabled(false);
            txtEmail_Usuarios.setValue(entity.getUsuarios().getEmail());
            txtEmail_Usuarios.setDisabled(false);
            txtIdrestaurante.setValue(entity.getIdrestaurante());
            txtIdrestaurante.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRestaurante = (RestauranteDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedRestaurante"));
        txtDescripcionrestaurante.setValue(selectedRestaurante.getDescripcionrestaurante());
        txtDescripcionrestaurante.setDisabled(false);
        txtImagenrestaurante.setValue(selectedRestaurante.getImagenrestaurante());
        txtImagenrestaurante.setDisabled(false);
        txtNombrerestaurante.setValue(selectedRestaurante.getNombrerestaurante());
        txtNombrerestaurante.setDisabled(false);
        txtTelefonorestaurante.setValue(selectedRestaurante.getTelefonorestaurante());
        txtTelefonorestaurante.setDisabled(false);
        txtEmail_Usuarios.setValue(selectedRestaurante.getEmail_Usuarios());
        txtEmail_Usuarios.setDisabled(false);
        txtIdrestaurante.setValue(selectedRestaurante.getIdrestaurante());
        txtIdrestaurante.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRestaurante == null) && (entity == null)) {
                action_create();
            } else {
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
            entity = new Restaurante();

            Integer idrestaurante = FacesUtils.checkInteger(txtIdrestaurante);

            entity.setDescripcionrestaurante(FacesUtils.checkString(
                    txtDescripcionrestaurante));
            entity.setIdrestaurante(idrestaurante);
            entity.setImagenrestaurante(FacesUtils.checkString(
                    txtImagenrestaurante));
            entity.setNombrerestaurante(FacesUtils.checkString(
                    txtNombrerestaurante));
            entity.setTelefonorestaurante(FacesUtils.checkLong(
                    txtTelefonorestaurante));
            entity.setUsuarios((FacesUtils.checkString(txtEmail_Usuarios) != null)
                ? businessDelegatorView.getUsuarios(FacesUtils.checkString(
                        txtEmail_Usuarios)) : null);
            businessDelegatorView.saveRestaurante(entity);
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
            if (entity == null) {
                Integer idrestaurante = new Integer(selectedRestaurante.getIdrestaurante());
                entity = businessDelegatorView.getRestaurante(idrestaurante);
            }

            entity.setDescripcionrestaurante(FacesUtils.checkString(
                    txtDescripcionrestaurante));
            entity.setImagenrestaurante(FacesUtils.checkString(
                    txtImagenrestaurante));
            entity.setNombrerestaurante(FacesUtils.checkString(
                    txtNombrerestaurante));
            entity.setTelefonorestaurante(FacesUtils.checkLong(
                    txtTelefonorestaurante));
            entity.setUsuarios((FacesUtils.checkString(txtEmail_Usuarios) != null)
                ? businessDelegatorView.getUsuarios(FacesUtils.checkString(
                        txtEmail_Usuarios)) : null);
            businessDelegatorView.updateRestaurante(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRestaurante = (RestauranteDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedRestaurante"));

            Integer idrestaurante = new Integer(selectedRestaurante.getIdrestaurante());
            entity = businessDelegatorView.getRestaurante(idrestaurante);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idrestaurante = FacesUtils.checkInteger(txtIdrestaurante);
            entity = businessDelegatorView.getRestaurante(idrestaurante);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRestaurante(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String descripcionrestaurante,
        Integer idrestaurante, String imagenrestaurante,
        String nombrerestaurante, Integer telefonorestaurante,
        String email_Usuarios) throws Exception {
        try {
            entity.setDescripcionrestaurante(FacesUtils.checkString(
                    descripcionrestaurante));
            entity.setImagenrestaurante(FacesUtils.checkString(
                    imagenrestaurante));
            entity.setNombrerestaurante(FacesUtils.checkString(
                    nombrerestaurante));
            entity.setTelefonorestaurante(FacesUtils.checkLong(
                    telefonorestaurante));
            businessDelegatorView.updateRestaurante(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RestauranteView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcionrestaurante() {
        return txtDescripcionrestaurante;
    }

    public void setTxtDescripcionrestaurante(
        InputText txtDescripcionrestaurante) {
        this.txtDescripcionrestaurante = txtDescripcionrestaurante;
    }

    public InputText getTxtImagenrestaurante() {
        return txtImagenrestaurante;
    }

    public void setTxtImagenrestaurante(InputText txtImagenrestaurante) {
        this.txtImagenrestaurante = txtImagenrestaurante;
    }

    public InputText getTxtNombrerestaurante() {
        return txtNombrerestaurante;
    }

    public void setTxtNombrerestaurante(InputText txtNombrerestaurante) {
        this.txtNombrerestaurante = txtNombrerestaurante;
    }

    public InputText getTxtTelefonorestaurante() {
        return txtTelefonorestaurante;
    }

    public void setTxtTelefonorestaurante(InputText txtTelefonorestaurante) {
        this.txtTelefonorestaurante = txtTelefonorestaurante;
    }

    public InputText getTxtEmail_Usuarios() {
        return txtEmail_Usuarios;
    }

    public void setTxtEmail_Usuarios(InputText txtEmail_Usuarios) {
        this.txtEmail_Usuarios = txtEmail_Usuarios;
    }

    public InputText getTxtIdrestaurante() {
        return txtIdrestaurante;
    }

    public void setTxtIdrestaurante(InputText txtIdrestaurante) {
        this.txtIdrestaurante = txtIdrestaurante;
    }

    public List<RestauranteDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRestaurante();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RestauranteDTO> restauranteDTO) {
        this.data = restauranteDTO;
    }

    public RestauranteDTO getSelectedRestaurante() {
        return selectedRestaurante;
    }

    public void setSelectedRestaurante(RestauranteDTO restaurante) {
        this.selectedRestaurante = restaurante;
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

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
