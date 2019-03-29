package com.easyturn.presentation.backingBeans;

import com.easyturn.exceptions.*;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.ProductrestaurantesDTO;

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
public class ProductrestaurantesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProductrestaurantesView.class);
    private InputText txtCantidadproducto;
    private InputText txtDescripcionproducto;
    private InputText txtImagenproducto;
    private InputText txtNombreproducto;
    private InputText txtPrecioproducto;
    private InputText txtIdrestaurante_Restaurante;
    private InputText txtIdproductos;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProductrestaurantesDTO> data;
    private ProductrestaurantesDTO selectedProductrestaurantes;
    private Productrestaurantes entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProductrestaurantesView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedProductrestaurantes = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedProductrestaurantes = null;

        if (txtCantidadproducto != null) {
            txtCantidadproducto.setValue(null);
            txtCantidadproducto.setDisabled(true);
        }

        if (txtDescripcionproducto != null) {
            txtDescripcionproducto.setValue(null);
            txtDescripcionproducto.setDisabled(true);
        }

        if (txtImagenproducto != null) {
            txtImagenproducto.setValue(null);
            txtImagenproducto.setDisabled(true);
        }

        if (txtNombreproducto != null) {
            txtNombreproducto.setValue(null);
            txtNombreproducto.setDisabled(true);
        }

        if (txtPrecioproducto != null) {
            txtPrecioproducto.setValue(null);
            txtPrecioproducto.setDisabled(true);
        }

        if (txtIdrestaurante_Restaurante != null) {
            txtIdrestaurante_Restaurante.setValue(null);
            txtIdrestaurante_Restaurante.setDisabled(true);
        }

        if (txtIdproductos != null) {
            txtIdproductos.setValue(null);
            txtIdproductos.setDisabled(false);
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
            Integer idproductos = FacesUtils.checkInteger(txtIdproductos);
            entity = (idproductos != null)
                ? businessDelegatorView.getProductrestaurantes(idproductos) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCantidadproducto.setDisabled(false);
            txtDescripcionproducto.setDisabled(false);
            txtImagenproducto.setDisabled(false);
            txtNombreproducto.setDisabled(false);
            txtPrecioproducto.setDisabled(false);
            txtIdrestaurante_Restaurante.setDisabled(false);
            txtIdproductos.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCantidadproducto.setValue(entity.getCantidadproducto());
            txtCantidadproducto.setDisabled(false);
            txtDescripcionproducto.setValue(entity.getDescripcionproducto());
            txtDescripcionproducto.setDisabled(false);
            txtImagenproducto.setValue(entity.getImagenproducto());
            txtImagenproducto.setDisabled(false);
            txtNombreproducto.setValue(entity.getNombreproducto());
            txtNombreproducto.setDisabled(false);
            txtPrecioproducto.setValue(entity.getPrecioproducto());
            txtPrecioproducto.setDisabled(false);
            txtIdrestaurante_Restaurante.setValue(entity.getRestaurante()
                                                        .getIdrestaurante());
            txtIdrestaurante_Restaurante.setDisabled(false);
            txtIdproductos.setValue(entity.getIdproductos());
            txtIdproductos.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedProductrestaurantes = (ProductrestaurantesDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedProductrestaurantes"));
        txtCantidadproducto.setValue(selectedProductrestaurantes.getCantidadproducto());
        txtCantidadproducto.setDisabled(false);
        txtDescripcionproducto.setValue(selectedProductrestaurantes.getDescripcionproducto());
        txtDescripcionproducto.setDisabled(false);
        txtImagenproducto.setValue(selectedProductrestaurantes.getImagenproducto());
        txtImagenproducto.setDisabled(false);
        txtNombreproducto.setValue(selectedProductrestaurantes.getNombreproducto());
        txtNombreproducto.setDisabled(false);
        txtPrecioproducto.setValue(selectedProductrestaurantes.getPrecioproducto());
        txtPrecioproducto.setDisabled(false);
        txtIdrestaurante_Restaurante.setValue(selectedProductrestaurantes.getIdrestaurante_Restaurante());
        txtIdrestaurante_Restaurante.setDisabled(false);
        txtIdproductos.setValue(selectedProductrestaurantes.getIdproductos());
        txtIdproductos.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedProductrestaurantes == null) && (entity == null)) {
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
            entity = new Productrestaurantes();

            Integer idproductos = FacesUtils.checkInteger(txtIdproductos);

            entity.setCantidadproducto(FacesUtils.checkInteger(
                    txtCantidadproducto));
            entity.setDescripcionproducto(FacesUtils.checkString(
                    txtDescripcionproducto));
            entity.setIdproductos(idproductos);
            entity.setImagenproducto(FacesUtils.checkString(txtImagenproducto));
            entity.setNombreproducto(FacesUtils.checkString(txtNombreproducto));
            entity.setPrecioproducto(FacesUtils.checkInteger(txtPrecioproducto));
            entity.setRestaurante((FacesUtils.checkInteger(
                    txtIdrestaurante_Restaurante) != null)
                ? businessDelegatorView.getRestaurante(FacesUtils.checkInteger(
                        txtIdrestaurante_Restaurante)) : null);
            businessDelegatorView.saveProductrestaurantes(entity);
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
                Integer idproductos = new Integer(selectedProductrestaurantes.getIdproductos());
                entity = businessDelegatorView.getProductrestaurantes(idproductos);
            }

            entity.setCantidadproducto(FacesUtils.checkInteger(
                    txtCantidadproducto));
            entity.setDescripcionproducto(FacesUtils.checkString(
                    txtDescripcionproducto));
            entity.setImagenproducto(FacesUtils.checkString(txtImagenproducto));
            entity.setNombreproducto(FacesUtils.checkString(txtNombreproducto));
            entity.setPrecioproducto(FacesUtils.checkInteger(txtPrecioproducto));
            entity.setRestaurante((FacesUtils.checkInteger(
                    txtIdrestaurante_Restaurante) != null)
                ? businessDelegatorView.getRestaurante(FacesUtils.checkInteger(
                        txtIdrestaurante_Restaurante)) : null);
            businessDelegatorView.updateProductrestaurantes(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedProductrestaurantes = (ProductrestaurantesDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedProductrestaurantes"));

            Integer idproductos = new Integer(selectedProductrestaurantes.getIdproductos());
            entity = businessDelegatorView.getProductrestaurantes(idproductos);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idproductos = FacesUtils.checkInteger(txtIdproductos);
            entity = businessDelegatorView.getProductrestaurantes(idproductos);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteProductrestaurantes(entity);
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

    public String action_modifyWitDTO(Integer cantidadproducto,
        String descripcionproducto, Integer idproductos, String imagenproducto,
        String nombreproducto, Integer precioproducto,
        Integer idrestaurante_Restaurante) throws Exception {
        try {
            entity.setCantidadproducto(FacesUtils.checkInteger(cantidadproducto));
            entity.setDescripcionproducto(FacesUtils.checkString(
                    descripcionproducto));
            entity.setImagenproducto(FacesUtils.checkString(imagenproducto));
            entity.setNombreproducto(FacesUtils.checkString(nombreproducto));
            entity.setPrecioproducto(FacesUtils.checkInteger(precioproducto));
            businessDelegatorView.updateProductrestaurantes(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProductrestaurantesView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCantidadproducto() {
        return txtCantidadproducto;
    }

    public void setTxtCantidadproducto(InputText txtCantidadproducto) {
        this.txtCantidadproducto = txtCantidadproducto;
    }

    public InputText getTxtDescripcionproducto() {
        return txtDescripcionproducto;
    }

    public void setTxtDescripcionproducto(InputText txtDescripcionproducto) {
        this.txtDescripcionproducto = txtDescripcionproducto;
    }

    public InputText getTxtImagenproducto() {
        return txtImagenproducto;
    }

    public void setTxtImagenproducto(InputText txtImagenproducto) {
        this.txtImagenproducto = txtImagenproducto;
    }

    public InputText getTxtNombreproducto() {
        return txtNombreproducto;
    }

    public void setTxtNombreproducto(InputText txtNombreproducto) {
        this.txtNombreproducto = txtNombreproducto;
    }

    public InputText getTxtPrecioproducto() {
        return txtPrecioproducto;
    }

    public void setTxtPrecioproducto(InputText txtPrecioproducto) {
        this.txtPrecioproducto = txtPrecioproducto;
    }

    public InputText getTxtIdrestaurante_Restaurante() {
        return txtIdrestaurante_Restaurante;
    }

    public void setTxtIdrestaurante_Restaurante(
        InputText txtIdrestaurante_Restaurante) {
        this.txtIdrestaurante_Restaurante = txtIdrestaurante_Restaurante;
    }

    public InputText getTxtIdproductos() {
        return txtIdproductos;
    }

    public void setTxtIdproductos(InputText txtIdproductos) {
        this.txtIdproductos = txtIdproductos;
    }

    public List<ProductrestaurantesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProductrestaurantes();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProductrestaurantesDTO> productrestaurantesDTO) {
        this.data = productrestaurantesDTO;
    }

    public ProductrestaurantesDTO getSelectedProductrestaurantes() {
        return selectedProductrestaurantes;
    }

    public void setSelectedProductrestaurantes(
        ProductrestaurantesDTO productrestaurantes) {
        this.selectedProductrestaurantes = productrestaurantes;
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
