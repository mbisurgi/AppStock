package com.designfreed.appstock.entities;

public class ItemMovimiento {
    private Long id;
    private Integer envaseId;
    private Integer cantidad;

    public ItemMovimiento() {

    }

    public ItemMovimiento(Long id, Integer envaseId, Integer cantidad) {
        this.id = id;
        this.envaseId = envaseId;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnvaseId() {
        return envaseId;
    }

    public void setEnvaseId(Integer envaseId) {
        this.envaseId = envaseId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
