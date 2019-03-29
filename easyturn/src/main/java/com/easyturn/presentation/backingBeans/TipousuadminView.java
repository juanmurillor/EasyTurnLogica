package com.easyturn.presentation.backingBeans;

import com.easyturn.exceptions.*;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.TipousuadminDTO;

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
public class TipousuadminView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipousuadminView.class);
    private InputText txtNombretipousuadmin;
    private InputText txtIdtipousuadmin;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipousuadminDTO> data;
    private TipousuadminDTO selectedTipousuadmin;
    private Tipousuadmin entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipousuadminView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipousuadmin = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipousuadmin = null;

        if (txtNombretipousuadmin != null) {
            txtNombretipousuadmin.setValue(null);
            txtNombretipousuadmin.setDisabled(true);
        }

        if (txtIdtipousuadmin != null) {
            txtIdtipousuadmin.setValue(null);
            txtIdtipousuadmin.setDisabled(false);
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
            Integer idtipousuadmin = FacesUtils.checkInteger(txtIdtipousuadmin);
            entity = (idtipousuadmin != null)
                ? businessDelegatorView.getTipousuadmin(idtipousuadmin) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombretipousuadmin.setDisabled(false);
            txtIdtipousuadmin.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombretipousuadmin.setValue(entity.getNombretipousuadmin());
            txtNombretipousuadmin.setDisabled(false);
            txtIdtipousuadmin.setValue(entity.getIdtipousuadmin());
            txtIdtipousuadmin.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipousuadmin = (TipousuadminDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedTipousuadmin"));
        txtNombretipousuadmin.setValue(selectedTipousuadmin.getNombretipousuadmin());
        txtNombretipousuadmin.setDisabled(false);
        txtIdtipousuadmin.setValue(selectedTipousuadmin.getIdtipousuadmin());
        txtIdtipousuadmin.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipousuadmin == null) && (entity == null)) {
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
            entity = new Tipousuadmin();

            Integer idtipousuadmin = FacesUtils.checkInteger(txtIdtipousuadmin);

            entity.setIdtipousuadmin(idtipousuadmin);
            entity.setNombretipousuadmin(FacesUtils.checkString(
                    txtNombretipousuadmin));
            businessDelegatorView.saveTipousuadmin(entity);
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
                Integer idtipousuadmin = new Integer(selectedTipousuadmin.getIdtipousuadmin());
                entity = businessDelegatorView.getTipousuadmin(idtipousuadmin);
            }

            entity.setNombretipousuadmin(FacesUtils.checkString(
                    txtNombretipousuadmin));
            businessDelegatorView.updateTipousuadmin(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipousuadmin = (TipousuadminDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedTipousuadmin"));

            Integer idtipousuadmin = new Integer(selectedTipousuadmin.getIdtipousuadmin());
            entity = businessDelegatorView.getTipousuadmin(idtipousuadmin);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idtipousuadmin = FacesUtils.checkInteger(txtIdtipousuadmin);
            entity = businessDelegatorView.getTipousuadmin(idtipousuadmin);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipousuadmin(entity);
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

    public String action_modifyWitDTO(Integer idtipousuadmin,
        String nombretipousuadmin) throws Exception {
        try {
            entity.setNombretipousuadmin(FacesUtils.checkString(
                    nombretipousuadmin));
            businessDelegatorView.updateTipousuadmin(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipousuadminView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombretipousuadmin() {
        return txtNombretipousuadmin;
    }

    public void setTxtNombretipousuadmin(InputText txtNombretipousuadmin) {
        this.txtNombretipousuadmin = txtNombretipousuadmin;
    }

    public InputText getTxtIdtipousuadmin() {
        return txtIdtipousuadmin;
    }

    public void setTxtIdtipousuadmin(InputText txtIdtipousuadmin) {
        this.txtIdtipousuadmin = txtIdtipousuadmin;
    }

    public List<TipousuadminDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipousuadmin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipousuadminDTO> tipousuadminDTO) {
        this.data = tipousuadminDTO;
    }

    public TipousuadminDTO getSelectedTipousuadmin() {
        return selectedTipousuadmin;
    }

    public void setSelectedTipousuadmin(TipousuadminDTO tipousuadmin) {
        this.selectedTipousuadmin = tipousuadmin;
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
