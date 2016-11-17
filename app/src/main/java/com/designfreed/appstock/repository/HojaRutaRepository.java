package com.designfreed.appstock.repository;

import com.designfreed.appstock.entities.HojaRuta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HojaRutaRepository {
    private HojaRutaRepository() {

    }

    public static List<HojaRuta> getHojasRuta(String urlString) {
        String json = "";

        //urlString = urlString.concat(formatDate(Calendar.getInstance().getTime()));

        List<HojaRuta> hojas = new ArrayList<>();

        URL url;

        HttpURLConnection httpURLConnection = null;

        try {
            url = new URL(urlString);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                json = readFromStream(inputStream);

                hojas = extractHojasRuta(json);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

        return hojas;
    }

    private static List<HojaRuta> extractHojasRuta(String json) {
        List<HojaRuta> hojas = new ArrayList<>();

        try {
            JSONArray jsonHojas = new JSONArray(json);

            for (int i = 0; i < jsonHojas.length(); i++) {
                JSONObject jsonHoja = jsonHojas.getJSONObject(i);

                JSONObject jsonChofer = jsonHoja.getJSONObject("chofer");

                String nombre = jsonChofer.getString("nombre");
                String apellido = jsonChofer.getString("apellido");

                Long id = jsonHoja.getLong("id");
                String chofer = apellido + ", " + nombre;
                Boolean estado = jsonHoja.getBoolean("estado");

                HojaRuta hoja = new HojaRuta(id, chofer, estado);

                hojas.add(hoja);
            }
        } catch (JSONException e) {

        }

        return hojas;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();

        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();

            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    private static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(date);
    }
}
