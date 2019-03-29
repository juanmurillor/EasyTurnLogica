package com.easyturn.presentation.backingBeans;

import com.easyturn.exceptions.*;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.AdministrativosDTO;

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
public class AdministrativosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdministrativosView.class);
    private InputText txtIdtipousuadmin_Tipousuadmin;
    private InputText txtEmail_Usuarios;
    private InputText txtIdusuadministrativo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<AdministrativosDTO> data;
    private AdministrativosDTO selectedAdministrativos;
    private Administrativos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public AdministrativosView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedAdministrativos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedAdministrativos = null;

        if (txtIdtipousuadmin_Tipousuadmin != null) {
            txtIdtipousuadmin_Tipousuadmin.setValue(null);
            txtIdtipousuadmin_Tipousuadmin.setDisabled(true);
        }

        if (txtEmail_Usuarios != null) {
            txtEmail_Usuarios.setValue(null);
            txtEmail_Usuarios.setDisabled(true);
        }

        if (txtIdusuadministrativo != null) {
            txtIdusuadministrativo.setValue(null);
            txtIdusuadministrativo.setDisabled(false);
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
            Integer idusuadministrativo = FacesUtils.checkInteger(txtIdusuadministrativo);
            entity = (idusuadministrativo != null)
                ? businessDelegatorView.getAdministrativos(idusuadministrativo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdtipousuadmin_Tipousuadmin.setDisabled(false);
            txtEmail_Usuarios.setDisabled(false);
            txtIdusuadministrativo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtIdtipousuadmin_Tipousuadmin.setValue(entity.getTipousuadmin()
                                                          .getIdtipousuadmin());
            txtIdtipousuadmin_Tipousuadmin.setDisabled(false);
            txtEmail_Usuarios.setValue(entity.getUsuarios().getEmail());
            txtEmail_Usuarios.setDisabled(false);
            txtIdusuadministrativo.setValue(entity.getIdusuadministrativo());
            txtIdusuadministrativo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedAdministrativos = (AdministrativosDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedAdministrativos"));
        txtIdtipousuadmin_Tipousuadmin.setValue(selectedAdministrativos.getIdtipousuadmin_Tipousuadmin());
        txtIdtipousuadmin_Tipousuadmin.setDisabled(false);
        txtEmail_Usuarios.setValue(selectedAdministrativos.getEmail_Usuarios());
        txtEmail_Usuarios.setDisabled(false);
        txtIdusuadministrativo.setValue(selectedAdministrativos.getIdusuadministrativo());
        txtIdusuadministrativo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedAdministrativos == null) && (entity == null)) {
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
            entity = new Administrativos();

            Integer idusuadministrativo = FacesUtils.checkInteger(txtIdusuadministrativo);

            entity.setIdusuadministrativo(idusuadministrativo);
            entity.setTipousuadmin((FacesUtils.checkInteger(
                    txtIdtipousuadmin_Tipousuadmin) != null)
                ? businessDelegatorView.getTipousuadmin(FacesUtils.checkInteger(
                        txtIdtipousuadmin_Tipousuadmin)) : null);
            entity.setUsuarios((FacesUtils.checkString(txtEmail_Usuarios) != null)
                ? businessDelegatorView.getUsuarios(FacesUtils.checkString(
                        txtEmail_Usuarios)) : null);
            businessDelegatorView.saveAdministrativos(entity);
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
                Integer idusuadministrativo = new Integer(selectedAdministrativos.getIdusuadministrativo());
                entity = businessDelegatorView.getAdministrativos(idusuadministrativo);
            }

            entity.setTipousuadmin((FacesUtils.checkInteger(
                    txtIdtipousuadmin_Tipousuadmin) != null)
                ? businessDelegatorView.getTipousuadmin(FacesUtils.checkInteger(
                        txtIdtipousuadmin_Tipousuadmin)) : null);
            entity.setUsuarios((FacesUtils.checkString(txtEmail_Usuarios) != null)
                ? businessDelegatorView.getUsuarios(FacesUtils.checkString(
                        txtEmail_Usuarios)) : null);
            businessDelegatorView.updateAdministrativos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedAdministrativos = (AdministrativosDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedAdministrativos"));

            Integer idusuadministrativo = new Integer(selectedAdministrativos.getIdusuadministrativo());
            entity = businessDelegatorView.getAdministrativos(idusuadministrativo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idusuadministrativo = FacesUtils.checkInteger(txtIdusuadministrativo);
            entity = businessDelegatorView.getAdministrativos(idusuadministrativo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteAdministrativos(entity);
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

    public String action_modifyWitDTO(Integer idusuadministrativo,
        Integer idtipousuadmin_Tipousuadmin, String email_Usuarios)
        throws Exception {
        try {
            businessDelegatorView.updateAdministrativos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("AdministrativosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdtipousuadmin_Tipousuadmin() {
        return txtIdtipousuadmin_Tipousuadmin;
    }

    public void setTxtIdtipousuadmin_Tipousuadmin(
        InputText txtIdtipousuadmin_Tipousuadmin) {
        this.txtIdtipousuadmin_Tipousuadmin = txtIdtipousuadmin_Tipousuadmin;
    }

    public InputText getTxtEmail_Usuarios() {
        return txtEmail_Usuarios;
    }

    public void setTxtEmail_Usuarios(InputText txtEmail_Usuarios) {
        this.txtEmail_Usuarios = txtEmail_Usuarios;
    }

    public InputText getTxtIdusuadministrativo() {
        return txtIdusuadministrativo;
    }

    public void setTxtIdusuadministrativo(InputText txtIdusuadministrativo) {
        this.txtIdusuadministrativo = txtIdusuadministrativo;
    }

    public List<AdministrativosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataAdministrativos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<AdministrativosDTO> administrativosDTO) {
        this.data = administrativosDTO;
    }

    public AdministrativosDTO getSelectedAdministrativos() {
        return selectedAdministrativos;
    }

    public void setSelectedAdministrativos(AdministrativosDTO administrativos) {
        this.selectedAdministrativos = administrativos;
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
