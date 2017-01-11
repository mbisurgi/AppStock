package com.designfreed.appstock.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.designfreed.appstock.entities.Movimiento;
import com.designfreed.appstock.repository.MovimientoRepository;

import java.util.List;

public class MovimientoLoader extends AsyncTaskLoader<List<Movimiento>> {
    private String url;
    private Long hojaRutaId;

    public MovimientoLoader(Context context, String url, Long hojaRutaId) {
        super(context);
        this.url = url;
        this.hojaRutaId = hojaRutaId;
    }

    @Override
    public List<Movimiento> loadInBackground() {
        if (url == null) {
            return null;
        }

        return MovimientoRepository.getMovimientos(url, hojaRutaId);
    }
}
