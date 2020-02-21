package com.dangky.hanngu.web.rest;

import com.dangky.hanngu.service.SinhvienService;
import com.dangky.hanngu.web.rest.errors.BadRequestAlertException;
import com.dangky.hanngu.service.dto.SinhvienDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.dangky.hanngu.domain.Sinhvien}.
 */
@RestController
@RequestMapping("/api")
public class SinhvienResource {

    private final Logger log = LoggerFactory.getLogger(SinhvienResource.class);

    private static final String ENTITY_NAME = "sinhvien";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SinhvienService sinhvienService;

    public SinhvienResource(SinhvienService sinhvienService) {
        this.sinhvienService = sinhvienService;
    }

    /**
     * {@code POST  /sinhviens} : Create a new sinhvien.
     *
     * @param sinhvienDTO the sinhvienDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sinhvienDTO, or with status {@code 400 (Bad Request)} if the sinhvien has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sinhviens")
    public ResponseEntity<SinhvienDTO> createSinhvien(@Valid @RequestBody SinhvienDTO sinhvienDTO) throws URISyntaxException {
        log.debug("REST request to save Sinhvien : {}", sinhvienDTO);
        if (sinhvienDTO.getId() != null) {
            throw new BadRequestAlertException("A new sinhvien cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SinhvienDTO result = sinhvienService.save(sinhvienDTO);
        return ResponseEntity.created(new URI("/api/sinhviens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sinhviens} : Updates an existing sinhvien.
     *
     * @param sinhvienDTO the sinhvienDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sinhvienDTO,
     * or with status {@code 400 (Bad Request)} if the sinhvienDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sinhvienDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sinhviens")
    public ResponseEntity<SinhvienDTO> updateSinhvien(@Valid @RequestBody SinhvienDTO sinhvienDTO) throws URISyntaxException {
        log.debug("REST request to update Sinhvien : {}", sinhvienDTO);
        if (sinhvienDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SinhvienDTO result = sinhvienService.save(sinhvienDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sinhvienDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sinhviens} : get all the sinhviens.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sinhviens in body.
     */
    @GetMapping("/sinhviens")
    public List<SinhvienDTO> getAllSinhviens() {
        log.debug("REST request to get all Sinhviens");
        return sinhvienService.findAll();
    }

    /**
     * {@code GET  /sinhviens/:id} : get the "id" sinhvien.
     *
     * @param id the id of the sinhvienDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sinhvienDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sinhviens/{id}")
    public ResponseEntity<SinhvienDTO> getSinhvien(@PathVariable Long id) {
        log.debug("REST request to get Sinhvien : {}", id);
        Optional<SinhvienDTO> sinhvienDTO = sinhvienService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sinhvienDTO);
    }

    /**
     * {@code DELETE  /sinhviens/:id} : delete the "id" sinhvien.
     *
     * @param id the id of the sinhvienDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sinhviens/{id}")
    public ResponseEntity<Void> deleteSinhvien(@PathVariable Long id) {
        log.debug("REST request to delete Sinhvien : {}", id);
        sinhvienService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
