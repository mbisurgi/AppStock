package com.designfreed.appstock.entities;

public class HojaRuta {
    private Long id;
    private String chofer;
    private Boolean estado;

    public HojaRuta() {

    }

    public HojaRuta(Long id, String chofer, Boolean estado) {
        this.id = id;
        this.chofer = chofer;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
