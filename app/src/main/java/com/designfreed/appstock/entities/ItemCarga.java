package com.designfreed.appstock.entities;

import java.io.Serializable;

public class ItemCarga implements Serializable {
    private Long id;
    private Integer envaseId;
    private Integer lleno;
    private Integer vacio;
    private Integer averiado;
    private Integer retiro;
    private Integer entrega;
    private Integer cambio;

    public ItemCarga() {

    }

    public ItemCarga(Long id, Integer envaseId, Integer lleno, Integer vacio, Integer averiado, Integer retiro, Integer entrega, Integer cambio) {
        this.id = id;
        this.envaseId = envaseId;
        this.lleno = lleno;
        this.vacio = vacio;
        this.averiado = averiado;
        this.retiro = retiro;
        this.entrega = entrega;
        this.cambio = cambio;
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

    public Integer getLleno() {
        return lleno;
    }

    public void setLleno(Integer lleno) {
        this.lleno = lleno;
    }

    public Integer getVacio() {
        return vacio;
    }

    public void setVacio(Integer vacio) {
        this.vacio = vacio;
    }

    public Integer getAveriado() {
        return averiado;
    }

    public void setAveriado(Integer averiado) {
        this.averiado = averiado;
    }

    public Integer getRetiro() {
        return retiro;
    }

    public void setRetiro(Integer retiro) {
        this.retiro = retiro;
    }

    public Integer getEntrega() {
        return entrega;
    }

    public void setEntrega(Integer entrega) {
        this.entrega = entrega;
    }

    public Integer getCambio() {
        return cambio;
    }

    public void setCambio(Integer cambio) {
        this.cambio = cambio;
    }
}
