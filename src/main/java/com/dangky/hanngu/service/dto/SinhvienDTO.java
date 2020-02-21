package com.dangky.hanngu.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.dangky.hanngu.domain.Sinhvien} entity.
 */
public class SinhvienDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 7)
    @Max(value = 8)
    private Integer alevel;

    private Long imgidx;

    @NotNull
    private String uadd;

    @NotNull
    @Min(value = 1900)
    @Max(value = 2020)
    private Integer ubirth0;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    private Integer ubirth1;

    @NotNull
    @Min(value = 1)
    @Max(value = 31)
    private Integer ubirth2;

    @NotNull
    private String uemail0;

    @NotNull
    private String uemail1;

    @NotNull
    private String uhp;

    @NotNull
    private String ujob;

    @NotNull
    private String ukname;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlevel() {
        return alevel;
    }

    public void setAlevel(Integer alevel) {
        this.alevel = alevel;
    }

    public Long getImgidx() {
        return imgidx;
    }

    public void setImgidx(Long imgidx) {
        this.imgidx = imgidx;
    }

    public String getUadd() {
        return uadd;
    }

    public void setUadd(String uadd) {
        this.uadd = uadd;
    }

    public Integer getUbirth0() {
        return ubirth0;
    }

    public void setUbirth0(Integer ubirth0) {
        this.ubirth0 = ubirth0;
    }

    public Integer getUbirth1() {
        return ubirth1;
    }

    public void setUbirth1(Integer ubirth1) {
        this.ubirth1 = ubirth1;
    }

    public Integer getUbirth2() {
        return ubirth2;
    }

    public void setUbirth2(Integer ubirth2) {
        this.ubirth2 = ubirth2;
    }

    public String getUemail0() {
        return uemail0;
    }

    public void setUemail0(String uemail0) {
        this.uemail0 = uemail0;
    }

    public String getUemail1() {
        return uemail1;
    }

    public void setUemail1(String uemail1) {
        this.uemail1 = uemail1;
    }

    public String getUhp() {
        return uhp;
    }

    public void setUhp(String uhp) {
        this.uhp = uhp;
    }

    public String getUjob() {
        return ujob;
    }

    public void setUjob(String ujob) {
        this.ujob = ujob;
    }

    public String getUkname() {
        return ukname;
    }

    public void setUkname(String ukname) {
        this.ukname = ukname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SinhvienDTO sinhvienDTO = (SinhvienDTO) o;
        if (sinhvienDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sinhvienDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SinhvienDTO{" +
            "id=" + getId() +
            ", alevel=" + getAlevel() +
            ", imgidx=" + getImgidx() +
            ", uadd='" + getUadd() + "'" +
            ", ubirth0=" + getUbirth0() +
            ", ubirth1=" + getUbirth1() +
            ", ubirth2=" + getUbirth2() +
            ", uemail0='" + getUemail0() + "'" +
            ", uemail1='" + getUemail1() + "'" +
            ", uhp='" + getUhp() + "'" +
            ", ujob='" + getUjob() + "'" +
            ", ukname='" + getUkname() + "'" +
            "}";
    }
}
