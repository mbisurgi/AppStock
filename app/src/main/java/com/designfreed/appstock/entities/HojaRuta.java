package com.designfreed.appstock.entities;

public class HojaRuta {
    private Long id;
    private String chofer;
    private Boolean estado;
    private Boolean controlStock;

    public HojaRuta() {

    }

    public HojaRuta(Long id, String chofer, Boolean estado, Boolean controlStock) {
        this.id = id;
        this.chofer = chofer;
        this.estado = estado;
        this.controlStock = controlStock;
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

    public Boolean getControlStock() {
        return controlStock;
    }

    public void setControlStock(Boolean controlStock) {
        this.controlStock = controlStock;
    }
}
