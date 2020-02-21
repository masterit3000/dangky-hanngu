package com.dangky.hanngu.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dangky.hanngu.web.rest.TestUtil;

public class SinhvienTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Sinhvien.class);
        Sinhvien sinhvien1 = new Sinhvien();
        sinhvien1.setId(1L);
        Sinhvien sinhvien2 = new Sinhvien();
        sinhvien2.setId(sinhvien1.getId());
        assertThat(sinhvien1).isEqualTo(sinhvien2);
        sinhvien2.setId(2L);
        assertThat(sinhvien1).isNotEqualTo(sinhvien2);
        sinhvien1.setId(null);
        assertThat(sinhvien1).isNotEqualTo(sinhvien2);
    }
}
