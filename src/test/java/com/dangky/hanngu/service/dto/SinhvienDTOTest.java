package com.dangky.hanngu.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dangky.hanngu.web.rest.TestUtil;

public class SinhvienDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SinhvienDTO.class);
        SinhvienDTO sinhvienDTO1 = new SinhvienDTO();
        sinhvienDTO1.setId(1L);
        SinhvienDTO sinhvienDTO2 = new SinhvienDTO();
        assertThat(sinhvienDTO1).isNotEqualTo(sinhvienDTO2);
        sinhvienDTO2.setId(sinhvienDTO1.getId());
        assertThat(sinhvienDTO1).isEqualTo(sinhvienDTO2);
        sinhvienDTO2.setId(2L);
        assertThat(sinhvienDTO1).isNotEqualTo(sinhvienDTO2);
        sinhvienDTO1.setId(null);
        assertThat(sinhvienDTO1).isNotEqualTo(sinhvienDTO2);
    }
}
