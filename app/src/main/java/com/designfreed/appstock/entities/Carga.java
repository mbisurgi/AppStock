package com.designfreed.appstock.entities;

import java.io.Serializable;
import java.util.List;

public class Carga implements Serializable {
    private Long id;
    private Long tipoId;
    private List<ItemCarga> items;

    public Carga() {

    }

    public Carga(Long id, Long tipoId, List<ItemCarga> items) {
        this.id = id;
        this.tipoId = tipoId;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public List<ItemCarga> getItems() {
        return items;
    }

    public void setItems(List<ItemCarga> items) {
        this.items = items;
    }
}
