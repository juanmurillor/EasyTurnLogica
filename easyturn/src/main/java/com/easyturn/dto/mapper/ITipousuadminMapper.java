package com.easyturn.dto.mapper;

import com.easyturn.modelo.Tipousuadmin;
import com.easyturn.modelo.dto.TipousuadminDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipousuadminMapper {
    public TipousuadminDTO tipousuadminToTipousuadminDTO(
        Tipousuadmin tipousuadmin) throws Exception;

    public Tipousuadmin tipousuadminDTOToTipousuadmin(
        TipousuadminDTO tipousuadminDTO) throws Exception;

    public List<TipousuadminDTO> listTipousuadminToListTipousuadminDTO(
        List<Tipousuadmin> tipousuadmins) throws Exception;

    public List<Tipousuadmin> listTipousuadminDTOToListTipousuadmin(
        List<TipousuadminDTO> tipousuadminDTOs) throws Exception;
}
