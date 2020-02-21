package com.dangky.hanngu.service.mapper;


import com.dangky.hanngu.domain.*;
import com.dangky.hanngu.service.dto.SinhvienDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Sinhvien} and its DTO {@link SinhvienDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SinhvienMapper extends EntityMapper<SinhvienDTO, Sinhvien> {



    default Sinhvien fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sinhvien sinhvien = new Sinhvien();
        sinhvien.setId(id);
        return sinhvien;
    }
}
