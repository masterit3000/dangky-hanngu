package com.dangky.hanngu.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SinhvienMapperTest {

    private SinhvienMapper sinhvienMapper;

    @BeforeEach
    public void setUp() {
        sinhvienMapper = new SinhvienMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sinhvienMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sinhvienMapper.fromId(null)).isNull();
    }
}
