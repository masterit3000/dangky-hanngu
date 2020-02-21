package com.dangky.hanngu.service.impl;

import com.dangky.hanngu.service.SinhvienService;
import com.dangky.hanngu.domain.Sinhvien;
import com.dangky.hanngu.repository.SinhvienRepository;
import com.dangky.hanngu.service.dto.SinhvienDTO;
import com.dangky.hanngu.service.mapper.SinhvienMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Sinhvien}.
 */
@Service
@Transactional
public class SinhvienServiceImpl implements SinhvienService {

    private final Logger log = LoggerFactory.getLogger(SinhvienServiceImpl.class);

    private final SinhvienRepository sinhvienRepository;

    private final SinhvienMapper sinhvienMapper;

    public SinhvienServiceImpl(SinhvienRepository sinhvienRepository, SinhvienMapper sinhvienMapper) {
        this.sinhvienRepository = sinhvienRepository;
        this.sinhvienMapper = sinhvienMapper;
    }

    /**
     * Save a sinhvien.
     *
     * @param sinhvienDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SinhvienDTO save(SinhvienDTO sinhvienDTO) {
        log.debug("Request to save Sinhvien : {}", sinhvienDTO);
        Sinhvien sinhvien = sinhvienMapper.toEntity(sinhvienDTO);
        sinhvien = sinhvienRepository.save(sinhvien);
        return sinhvienMapper.toDto(sinhvien);
    }

    /**
     * Get all the sinhviens.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<SinhvienDTO> findAll() {
        log.debug("Request to get all Sinhviens");
        return sinhvienRepository.findAll().stream()
            .map(sinhvienMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one sinhvien by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SinhvienDTO> findOne(Long id) {
        log.debug("Request to get Sinhvien : {}", id);
        return sinhvienRepository.findById(id)
            .map(sinhvienMapper::toDto);
    }

    /**
     * Delete the sinhvien by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sinhvien : {}", id);
        sinhvienRepository.deleteById(id);
    }
}
