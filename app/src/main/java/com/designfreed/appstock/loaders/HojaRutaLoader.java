package com.designfreed.appstock.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.designfreed.appstock.entities.HojaRuta;
import com.designfreed.appstock.repository.HojaRutaRepository;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
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

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HojaRuta[] hojas = restTemplate.getForObject(url, HojaRuta[].class);

        return Arrays.asList(hojas);
        //return HojaRutaRepository.getHojasRuta(url);
    }
}
