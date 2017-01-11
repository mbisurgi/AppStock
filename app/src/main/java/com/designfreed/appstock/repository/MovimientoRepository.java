package com.designfreed.appstock.repository;

import com.designfreed.appstock.entities.Carga;
import com.designfreed.appstock.entities.ItemCarga;
import com.designfreed.appstock.entities.ItemMovimiento;
import com.designfreed.appstock.entities.Movimiento;

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
import java.util.ArrayList;
import java.util.List;

public class MovimientoRepository {
    private MovimientoRepository() {

    }

    public static List<Movimiento> getMovimientos(String urlString, Long hojaRutaId) {
        String json = "";

        urlString = urlString.concat("hojaRutaId=").concat(hojaRutaId.toString());

        List<Movimiento> movimientos = new ArrayList<>();

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

                movimientos = extractMovimientos(json);
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

        return movimientos;
    }

    private static List<Movimiento> extractMovimientos(String json) {
        List<Movimiento> movimientos = new ArrayList<>();

        try {
            JSONArray jsonMovimientos = new JSONArray(json);

            for (int i = 0; i < jsonMovimientos.length(); i++) {
                JSONObject jsonMovimiento = jsonMovimientos.getJSONObject(i);

                Long id = jsonMovimiento.getLong("id");

                JSONArray jsonItems = jsonMovimiento.getJSONArray("items");

                List<ItemMovimiento> items = new ArrayList<>();

                for (int j = 0; j < jsonItems.length(); j++) {
                    JSONObject jsonItem = jsonItems.getJSONObject(j);

                    Long itemId = jsonItem.getLong("id");
                    Integer envaseId = jsonItem.getInt("envaseId");
                    Integer cantidad = jsonItem.getInt("cantidad");

                    ItemMovimiento item = new ItemMovimiento(itemId, envaseId, cantidad);

                    items.add(item);
                }

                Movimiento movimiento = new Movimiento(id, items);

                movimientos.add(movimiento);
            }
        } catch (JSONException e) {

        }

        return movimientos;
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
}
