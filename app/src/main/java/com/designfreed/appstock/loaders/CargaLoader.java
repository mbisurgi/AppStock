package com.designfreed.appstock.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.designfreed.appstock.entities.Carga;
import com.designfreed.appstock.repository.CargaRepository;

import java.util.List;

public class CargaLoader extends AsyncTaskLoader<List<Carga>> {
    private String url;
    private Long hojaRutaId;

    public CargaLoader(Context context, String url, Long hojaRutaId) {
        super(context);
        this.url = url;
        this.hojaRutaId = hojaRutaId;
    }

    @Override
    public List<Carga> loadInBackground() {
        if (url == null) {
            return null;
        }

        return CargaRepository.getCargas(url, hojaRutaId);
    }
}
