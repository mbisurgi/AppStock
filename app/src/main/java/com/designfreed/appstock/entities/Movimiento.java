package com.designfreed.appstock.entities;

import java.util.List;

public class Movimiento {
    private Long id;
    private List<ItemMovimiento> items;

    public Movimiento() {

    }

    public Movimiento(Long id, List<ItemMovimiento> items) {
        this.id = id;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemMovimiento> getItems() {
        return items;
    }

    public void setItems(List<ItemMovimiento> items) {
        this.items = items;
    }
}
