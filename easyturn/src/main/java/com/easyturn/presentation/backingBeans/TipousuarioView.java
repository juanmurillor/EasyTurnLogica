package com.easyturn.presentation.backingBeans;

import com.easyturn.exceptions.*;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.TipousuarioDTO;

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
public class TipousuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipousuarioView.class);
    private InputText txtNombretipousuario;
    private InputText txtIdtipousuario;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipousuarioDTO> data;
    private TipousuarioDTO selectedTipousuario;
    private Tipousuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipousuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipousuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipousuario = null;

        if (txtNombretipousuario != null) {
            txtNombretipousuario.setValue(null);
            txtNombretipousuario.setDisabled(true);
        }

        if (txtIdtipousuario != null) {
            txtIdtipousuario.setValue(null);
            txtIdtipousuario.setDisabled(false);
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
            Integer idtipousuario = FacesUtils.checkInteger(txtIdtipousuario);
            entity = (idtipousuario != null)
                ? businessDelegatorView.getTipousuario(idtipousuario) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombretipousuario.setDisabled(false);
            txtIdtipousuario.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombretipousuario.setValue(entity.getNombretipousuario());
            txtNombretipousuario.setDisabled(false);
            txtIdtipousuario.setValue(entity.getIdtipousuario());
            txtIdtipousuario.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipousuario = (TipousuarioDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTipousuario"));
        txtNombretipousuario.setValue(selectedTipousuario.getNombretipousuario());
        txtNombretipousuario.setDisabled(false);
        txtIdtipousuario.setValue(selectedTipousuario.getIdtipousuario());
        txtIdtipousuario.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipousuario == null) && (entity == null)) {
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
            entity = new Tipousuario();

            Integer idtipousuario = FacesUtils.checkInteger(txtIdtipousuario);

            entity.setIdtipousuario(idtipousuario);
            entity.setNombretipousuario(FacesUtils.checkString(
                    txtNombretipousuario));
            businessDelegatorView.saveTipousuario(entity);
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
                Integer idtipousuario = new Integer(selectedTipousuario.getIdtipousuario());
                entity = businessDelegatorView.getTipousuario(idtipousuario);
            }

            entity.setNombretipousuario(FacesUtils.checkString(
                    txtNombretipousuario));
            businessDelegatorView.updateTipousuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipousuario = (TipousuarioDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipousuario"));

            Integer idtipousuario = new Integer(selectedTipousuario.getIdtipousuario());
            entity = businessDelegatorView.getTipousuario(idtipousuario);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idtipousuario = FacesUtils.checkInteger(txtIdtipousuario);
            entity = businessDelegatorView.getTipousuario(idtipousuario);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipousuario(entity);
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

    public String action_modifyWitDTO(Integer idtipousuario,
        String nombretipousuario) throws Exception {
        try {
            entity.setNombretipousuario(FacesUtils.checkString(
                    nombretipousuario));
            businessDelegatorView.updateTipousuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipousuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombretipousuario() {
        return txtNombretipousuario;
    }

    public void setTxtNombretipousuario(InputText txtNombretipousuario) {
        this.txtNombretipousuario = txtNombretipousuario;
    }

    public InputText getTxtIdtipousuario() {
        return txtIdtipousuario;
    }

    public void setTxtIdtipousuario(InputText txtIdtipousuario) {
        this.txtIdtipousuario = txtIdtipousuario;
    }

    public List<TipousuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipousuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipousuarioDTO> tipousuarioDTO) {
        this.data = tipousuarioDTO;
    }

    public TipousuarioDTO getSelectedTipousuario() {
        return selectedTipousuario;
    }

    public void setSelectedTipousuario(TipousuarioDTO tipousuario) {
        this.selectedTipousuario = tipousuario;
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
