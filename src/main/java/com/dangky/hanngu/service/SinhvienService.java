package com.dangky.hanngu.service;

import com.dangky.hanngu.service.dto.SinhvienDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.dangky.hanngu.domain.Sinhvien}.
 */
public interface SinhvienService {

    /**
     * Save a sinhvien.
     *
     * @param sinhvienDTO the entity to save.
     * @return the persisted entity.
     */
    SinhvienDTO save(SinhvienDTO sinhvienDTO);

    /**
     * Get all the sinhviens.
     *
     * @return the list of entities.
     */
    List<SinhvienDTO> findAll();

    /**
     * Get the "id" sinhvien.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SinhvienDTO> findOne(Long id);

    /**
     * Delete the "id" sinhvien.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
