package com.dangky.hanngu.web.rest;

import com.dangky.hanngu.DangkythitienghanApp;
import com.dangky.hanngu.domain.Sinhvien;
import com.dangky.hanngu.repository.SinhvienRepository;
import com.dangky.hanngu.service.SinhvienService;
import com.dangky.hanngu.service.dto.SinhvienDTO;
import com.dangky.hanngu.service.mapper.SinhvienMapper;
import com.dangky.hanngu.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dangky.hanngu.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link SinhvienResource} REST controller.
 */
@SpringBootTest(classes = DangkythitienghanApp.class)
public class SinhvienResourceIT {

    private static final Integer DEFAULT_ALEVEL = 7;
    private static final Integer UPDATED_ALEVEL = 8;

    private static final Long DEFAULT_IMGIDX = 1L;
    private static final Long UPDATED_IMGIDX = 2L;

    private static final String DEFAULT_UADD = "AAAAAAAAAA";
    private static final String UPDATED_UADD = "BBBBBBBBBB";

    private static final Integer DEFAULT_UBIRTH_0 = 1900;
    private static final Integer UPDATED_UBIRTH_0 = 1901;

    private static final Integer DEFAULT_UBIRTH_1 = 1;
    private static final Integer UPDATED_UBIRTH_1 = 2;

    private static final Integer DEFAULT_UBIRTH_2 = 1;
    private static final Integer UPDATED_UBIRTH_2 = 2;

    private static final String DEFAULT_UEMAIL_0 = "AAAAAAAAAA";
    private static final String UPDATED_UEMAIL_0 = "BBBBBBBBBB";

    private static final String DEFAULT_UEMAIL_1 = "AAAAAAAAAA";
    private static final String UPDATED_UEMAIL_1 = "BBBBBBBBBB";

    private static final String DEFAULT_UHP = "AAAAAAAAAA";
    private static final String UPDATED_UHP = "BBBBBBBBBB";

    private static final String DEFAULT_UJOB = "AAAAAAAAAA";
    private static final String UPDATED_UJOB = "BBBBBBBBBB";

    private static final String DEFAULT_UKNAME = "AAAAAAAAAA";
    private static final String UPDATED_UKNAME = "BBBBBBBBBB";

    @Autowired
    private SinhvienRepository sinhvienRepository;

    @Autowired
    private SinhvienMapper sinhvienMapper;

    @Autowired
    private SinhvienService sinhvienService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restSinhvienMockMvc;

    private Sinhvien sinhvien;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SinhvienResource sinhvienResource = new SinhvienResource(sinhvienService);
        this.restSinhvienMockMvc = MockMvcBuilders.standaloneSetup(sinhvienResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Sinhvien createEntity(EntityManager em) {
        Sinhvien sinhvien = new Sinhvien()
            .alevel(DEFAULT_ALEVEL)
            .imgidx(DEFAULT_IMGIDX)
            .uadd(DEFAULT_UADD)
            .ubirth0(DEFAULT_UBIRTH_0)
            .ubirth1(DEFAULT_UBIRTH_1)
            .ubirth2(DEFAULT_UBIRTH_2)
            .uemail0(DEFAULT_UEMAIL_0)
            .uemail1(DEFAULT_UEMAIL_1)
            .uhp(DEFAULT_UHP)
            .ujob(DEFAULT_UJOB)
            .ukname(DEFAULT_UKNAME);
        return sinhvien;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Sinhvien createUpdatedEntity(EntityManager em) {
        Sinhvien sinhvien = new Sinhvien()
            .alevel(UPDATED_ALEVEL)
            .imgidx(UPDATED_IMGIDX)
            .uadd(UPDATED_UADD)
            .ubirth0(UPDATED_UBIRTH_0)
            .ubirth1(UPDATED_UBIRTH_1)
            .ubirth2(UPDATED_UBIRTH_2)
            .uemail0(UPDATED_UEMAIL_0)
            .uemail1(UPDATED_UEMAIL_1)
            .uhp(UPDATED_UHP)
            .ujob(UPDATED_UJOB)
            .ukname(UPDATED_UKNAME);
        return sinhvien;
    }

    @BeforeEach
    public void initTest() {
        sinhvien = createEntity(em);
    }

    @Test
    @Transactional
    public void createSinhvien() throws Exception {
        int databaseSizeBeforeCreate = sinhvienRepository.findAll().size();

        // Create the Sinhvien
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);
        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isCreated());

        // Validate the Sinhvien in the database
        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeCreate + 1);
        Sinhvien testSinhvien = sinhvienList.get(sinhvienList.size() - 1);
        assertThat(testSinhvien.getAlevel()).isEqualTo(DEFAULT_ALEVEL);
        assertThat(testSinhvien.getImgidx()).isEqualTo(DEFAULT_IMGIDX);
        assertThat(testSinhvien.getUadd()).isEqualTo(DEFAULT_UADD);
        assertThat(testSinhvien.getUbirth0()).isEqualTo(DEFAULT_UBIRTH_0);
        assertThat(testSinhvien.getUbirth1()).isEqualTo(DEFAULT_UBIRTH_1);
        assertThat(testSinhvien.getUbirth2()).isEqualTo(DEFAULT_UBIRTH_2);
        assertThat(testSinhvien.getUemail0()).isEqualTo(DEFAULT_UEMAIL_0);
        assertThat(testSinhvien.getUemail1()).isEqualTo(DEFAULT_UEMAIL_1);
        assertThat(testSinhvien.getUhp()).isEqualTo(DEFAULT_UHP);
        assertThat(testSinhvien.getUjob()).isEqualTo(DEFAULT_UJOB);
        assertThat(testSinhvien.getUkname()).isEqualTo(DEFAULT_UKNAME);
    }

    @Test
    @Transactional
    public void createSinhvienWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sinhvienRepository.findAll().size();

        // Create the Sinhvien with an existing ID
        sinhvien.setId(1L);
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sinhvien in the database
        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkAlevelIsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setAlevel(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUaddIsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUadd(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUbirth0IsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUbirth0(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUbirth1IsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUbirth1(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUbirth2IsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUbirth2(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUemail0IsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUemail0(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUemail1IsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUemail1(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUhpIsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUhp(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUjobIsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUjob(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUknameIsRequired() throws Exception {
        int databaseSizeBeforeTest = sinhvienRepository.findAll().size();
        // set the field null
        sinhvien.setUkname(null);

        // Create the Sinhvien, which fails.
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        restSinhvienMockMvc.perform(post("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSinhviens() throws Exception {
        // Initialize the database
        sinhvienRepository.saveAndFlush(sinhvien);

        // Get all the sinhvienList
        restSinhvienMockMvc.perform(get("/api/sinhviens?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sinhvien.getId().intValue())))
            .andExpect(jsonPath("$.[*].alevel").value(hasItem(DEFAULT_ALEVEL)))
            .andExpect(jsonPath("$.[*].imgidx").value(hasItem(DEFAULT_IMGIDX.intValue())))
            .andExpect(jsonPath("$.[*].uadd").value(hasItem(DEFAULT_UADD)))
            .andExpect(jsonPath("$.[*].ubirth0").value(hasItem(DEFAULT_UBIRTH_0)))
            .andExpect(jsonPath("$.[*].ubirth1").value(hasItem(DEFAULT_UBIRTH_1)))
            .andExpect(jsonPath("$.[*].ubirth2").value(hasItem(DEFAULT_UBIRTH_2)))
            .andExpect(jsonPath("$.[*].uemail0").value(hasItem(DEFAULT_UEMAIL_0)))
            .andExpect(jsonPath("$.[*].uemail1").value(hasItem(DEFAULT_UEMAIL_1)))
            .andExpect(jsonPath("$.[*].uhp").value(hasItem(DEFAULT_UHP)))
            .andExpect(jsonPath("$.[*].ujob").value(hasItem(DEFAULT_UJOB)))
            .andExpect(jsonPath("$.[*].ukname").value(hasItem(DEFAULT_UKNAME)));
    }
    
    @Test
    @Transactional
    public void getSinhvien() throws Exception {
        // Initialize the database
        sinhvienRepository.saveAndFlush(sinhvien);

        // Get the sinhvien
        restSinhvienMockMvc.perform(get("/api/sinhviens/{id}", sinhvien.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sinhvien.getId().intValue()))
            .andExpect(jsonPath("$.alevel").value(DEFAULT_ALEVEL))
            .andExpect(jsonPath("$.imgidx").value(DEFAULT_IMGIDX.intValue()))
            .andExpect(jsonPath("$.uadd").value(DEFAULT_UADD))
            .andExpect(jsonPath("$.ubirth0").value(DEFAULT_UBIRTH_0))
            .andExpect(jsonPath("$.ubirth1").value(DEFAULT_UBIRTH_1))
            .andExpect(jsonPath("$.ubirth2").value(DEFAULT_UBIRTH_2))
            .andExpect(jsonPath("$.uemail0").value(DEFAULT_UEMAIL_0))
            .andExpect(jsonPath("$.uemail1").value(DEFAULT_UEMAIL_1))
            .andExpect(jsonPath("$.uhp").value(DEFAULT_UHP))
            .andExpect(jsonPath("$.ujob").value(DEFAULT_UJOB))
            .andExpect(jsonPath("$.ukname").value(DEFAULT_UKNAME));
    }

    @Test
    @Transactional
    public void getNonExistingSinhvien() throws Exception {
        // Get the sinhvien
        restSinhvienMockMvc.perform(get("/api/sinhviens/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSinhvien() throws Exception {
        // Initialize the database
        sinhvienRepository.saveAndFlush(sinhvien);

        int databaseSizeBeforeUpdate = sinhvienRepository.findAll().size();

        // Update the sinhvien
        Sinhvien updatedSinhvien = sinhvienRepository.findById(sinhvien.getId()).get();
        // Disconnect from session so that the updates on updatedSinhvien are not directly saved in db
        em.detach(updatedSinhvien);
        updatedSinhvien
            .alevel(UPDATED_ALEVEL)
            .imgidx(UPDATED_IMGIDX)
            .uadd(UPDATED_UADD)
            .ubirth0(UPDATED_UBIRTH_0)
            .ubirth1(UPDATED_UBIRTH_1)
            .ubirth2(UPDATED_UBIRTH_2)
            .uemail0(UPDATED_UEMAIL_0)
            .uemail1(UPDATED_UEMAIL_1)
            .uhp(UPDATED_UHP)
            .ujob(UPDATED_UJOB)
            .ukname(UPDATED_UKNAME);
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(updatedSinhvien);

        restSinhvienMockMvc.perform(put("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isOk());

        // Validate the Sinhvien in the database
        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeUpdate);
        Sinhvien testSinhvien = sinhvienList.get(sinhvienList.size() - 1);
        assertThat(testSinhvien.getAlevel()).isEqualTo(UPDATED_ALEVEL);
        assertThat(testSinhvien.getImgidx()).isEqualTo(UPDATED_IMGIDX);
        assertThat(testSinhvien.getUadd()).isEqualTo(UPDATED_UADD);
        assertThat(testSinhvien.getUbirth0()).isEqualTo(UPDATED_UBIRTH_0);
        assertThat(testSinhvien.getUbirth1()).isEqualTo(UPDATED_UBIRTH_1);
        assertThat(testSinhvien.getUbirth2()).isEqualTo(UPDATED_UBIRTH_2);
        assertThat(testSinhvien.getUemail0()).isEqualTo(UPDATED_UEMAIL_0);
        assertThat(testSinhvien.getUemail1()).isEqualTo(UPDATED_UEMAIL_1);
        assertThat(testSinhvien.getUhp()).isEqualTo(UPDATED_UHP);
        assertThat(testSinhvien.getUjob()).isEqualTo(UPDATED_UJOB);
        assertThat(testSinhvien.getUkname()).isEqualTo(UPDATED_UKNAME);
    }

    @Test
    @Transactional
    public void updateNonExistingSinhvien() throws Exception {
        int databaseSizeBeforeUpdate = sinhvienRepository.findAll().size();

        // Create the Sinhvien
        SinhvienDTO sinhvienDTO = sinhvienMapper.toDto(sinhvien);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSinhvienMockMvc.perform(put("/api/sinhviens")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sinhvienDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sinhvien in the database
        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSinhvien() throws Exception {
        // Initialize the database
        sinhvienRepository.saveAndFlush(sinhvien);

        int databaseSizeBeforeDelete = sinhvienRepository.findAll().size();

        // Delete the sinhvien
        restSinhvienMockMvc.perform(delete("/api/sinhviens/{id}", sinhvien.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Sinhvien> sinhvienList = sinhvienRepository.findAll();
        assertThat(sinhvienList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
