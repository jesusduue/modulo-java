package com.seguridad.seguridad.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tipo_privacidad", schema = "seguridad")
public class TipoPrivacidad {
    @Id
    @Column (name = "cod_tip")
    private int cod_tip;

    @Column (name = "nom_tip")
    private String nom_tip;

    @Column (name = "est_tip")
    private String est_tip;

    public TipoPrivacidad() {
    }

    public TipoPrivacidad(int cod_tip) {
        this.cod_tip = cod_tip;
    }

    public TipoPrivacidad(int cod_tip, String nom_tip, String est_tip) {
        this.cod_tip = cod_tip;
        this.nom_tip = nom_tip;
        this.est_tip = est_tip;
    }

    public TipoPrivacidad(String nom_tip, String est_tip) {
        this.nom_tip = nom_tip;
        this.est_tip = est_tip;
    }

    public int getCod_tip() {
        return cod_tip;
    }

    public void setCod_tip(int cod_tip) {
        this.cod_tip = cod_tip;
    }

    public String getNom_tip() {
        return nom_tip;
    }

    public void setNom_tip(String nom_tip) {
        this.nom_tip = nom_tip;
    }

    public String getEst_tip() {
        return est_tip;
    }

    public void setEst_tip(String est_tip) {
        this.est_tip = est_tip;
    }



}
