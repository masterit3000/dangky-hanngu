package com.dangky.hanngu.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Sinhvien.
 */
@Entity
@Table(name = "sinhvien")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(value = 7)
    @Max(value = 8)
    @Column(name = "alevel", nullable = false)
    private Integer alevel;

    @Column(name = "imgidx")
    private Long imgidx;

    @NotNull
    @Column(name = "uadd", nullable = false)
    private String uadd;

    @NotNull
    @Min(value = 1900)
    @Max(value = 2020)
    @Column(name = "ubirth_0", nullable = false)
    private Integer ubirth0;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    @Column(name = "ubirth_1", nullable = false)
    private Integer ubirth1;

    @NotNull
    @Min(value = 1)
    @Max(value = 31)
    @Column(name = "ubirth_2", nullable = false)
    private Integer ubirth2;

    @NotNull
    @Column(name = "uemail_0", nullable = false)
    private String uemail0;

    @NotNull
    @Column(name = "uemail_1", nullable = false)
    private String uemail1;

    @NotNull
    @Column(name = "uhp", nullable = false)
    private String uhp;

    @NotNull
    @Column(name = "ujob", nullable = false)
    private String ujob;

    @NotNull
    @Column(name = "ukname", nullable = false)
    private String ukname;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlevel() {
        return alevel;
    }

    public Sinhvien alevel(Integer alevel) {
        this.alevel = alevel;
        return this;
    }

    public void setAlevel(Integer alevel) {
        this.alevel = alevel;
    }

    public Long getImgidx() {
        return imgidx;
    }

    public Sinhvien imgidx(Long imgidx) {
        this.imgidx = imgidx;
        return this;
    }

    public void setImgidx(Long imgidx) {
        this.imgidx = imgidx;
    }

    public String getUadd() {
        return uadd;
    }

    public Sinhvien uadd(String uadd) {
        this.uadd = uadd;
        return this;
    }

    public void setUadd(String uadd) {
        this.uadd = uadd;
    }

    public Integer getUbirth0() {
        return ubirth0;
    }

    public Sinhvien ubirth0(Integer ubirth0) {
        this.ubirth0 = ubirth0;
        return this;
    }

    public void setUbirth0(Integer ubirth0) {
        this.ubirth0 = ubirth0;
    }

    public Integer getUbirth1() {
        return ubirth1;
    }

    public Sinhvien ubirth1(Integer ubirth1) {
        this.ubirth1 = ubirth1;
        return this;
    }

    public void setUbirth1(Integer ubirth1) {
        this.ubirth1 = ubirth1;
    }

    public Integer getUbirth2() {
        return ubirth2;
    }

    public Sinhvien ubirth2(Integer ubirth2) {
        this.ubirth2 = ubirth2;
        return this;
    }

    public void setUbirth2(Integer ubirth2) {
        this.ubirth2 = ubirth2;
    }

    public String getUemail0() {
        return uemail0;
    }

    public Sinhvien uemail0(String uemail0) {
        this.uemail0 = uemail0;
        return this;
    }

    public void setUemail0(String uemail0) {
        this.uemail0 = uemail0;
    }

    public String getUemail1() {
        return uemail1;
    }

    public Sinhvien uemail1(String uemail1) {
        this.uemail1 = uemail1;
        return this;
    }

    public void setUemail1(String uemail1) {
        this.uemail1 = uemail1;
    }

    public String getUhp() {
        return uhp;
    }

    public Sinhvien uhp(String uhp) {
        this.uhp = uhp;
        return this;
    }

    public void setUhp(String uhp) {
        this.uhp = uhp;
    }

    public String getUjob() {
        return ujob;
    }

    public Sinhvien ujob(String ujob) {
        this.ujob = ujob;
        return this;
    }

    public void setUjob(String ujob) {
        this.ujob = ujob;
    }

    public String getUkname() {
        return ukname;
    }

    public Sinhvien ukname(String ukname) {
        this.ukname = ukname;
        return this;
    }

    public void setUkname(String ukname) {
        this.ukname = ukname;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sinhvien)) {
            return false;
        }
        return id != null && id.equals(((Sinhvien) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
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
