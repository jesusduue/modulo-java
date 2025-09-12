package com.seguridad.seguridad.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tipo_privacidad", schema = "seguridad")
public class tipoPrivacidad {
    @Id
    @Column (name = "cod_tip")
    private int cod_tip;

    @Column (name = "nom_tip")
    private String des_tip;

    @Column (name = "est_tip")
    private String est_tip;

    public tipoPrivacidad() {
    }

    public tipoPrivacidad(int cod_tip) {
        this.cod_tip = cod_tip;
    }

    public tipoPrivacidad(int cod_tip, String des_tip, String est_tip) {
        this.cod_tip = cod_tip;
        this.des_tip = des_tip;
        this.est_tip = est_tip;
    }

    public tipoPrivacidad(String des_tip, String est_tip) {
        this.des_tip = des_tip;
        this.est_tip = est_tip;
    }

    public int getCod_tip() {
        return cod_tip;
    }

    public void setCod_tip(int cod_tip) {
        this.cod_tip = cod_tip;
    }

    public String getDes_tip() {
        return des_tip;
    }

    public void setDes_tip(String des_tip) {
        this.des_tip = des_tip;
    }

    public String getEst_tip() {
        return est_tip;
    }

    public void setEst_tip(String est_tip) {
        this.est_tip = est_tip;
    }



}
