package com.designfreed.appstock.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.designfreed.appstock.entities.HojaRuta;
import com.designfreed.appstock.repository.HojaRutaRepository;

import java.util.List;

public class HojaRutaLoader extends AsyncTaskLoader<List<HojaRuta>> {
    private String url;

    public HojaRutaLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public List<HojaRuta> loadInBackground() {
        if (url == null) {
            return null;
        }

        return HojaRutaRepository.getHojasRuta(url);
    }
}
