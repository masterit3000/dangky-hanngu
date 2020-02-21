package com.dangky.hanngu.repository;

import com.dangky.hanngu.domain.Sinhvien;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Sinhvien entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SinhvienRepository extends JpaRepository<Sinhvien, Long> {

}
