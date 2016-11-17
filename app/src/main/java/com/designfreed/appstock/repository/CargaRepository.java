package com.designfreed.appstock.repository;

import com.designfreed.appstock.entities.Carga;
import com.designfreed.appstock.entities.ItemCarga;

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

public class CargaRepository {
    private CargaRepository() {

    }

    public static List<Carga> getCargas(String urlString, Long hojaRutaId) {
        String json = "";

        urlString = urlString.concat("hojaRutaId=").concat(hojaRutaId.toString());

        List<Carga> cargas = new ArrayList<>();

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

                cargas = extractCargas(json);
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

        return cargas;
    }

    private static List<Carga> extractCargas(String json) {
        List<Carga> cargas = new ArrayList<>();

        try {
            JSONArray jsonCargas = new JSONArray(json);

            for (int i = 0; i < jsonCargas.length(); i++) {
                JSONObject jsonCarga = jsonCargas.getJSONObject(i);

                Long id = jsonCarga.getLong("id");

                JSONObject jsonTipo = jsonCarga.getJSONObject("tipo");

                Long tipoId = jsonTipo.getLong("id");

                JSONArray jsonItems = jsonCarga.getJSONArray("items");

                List<ItemCarga> items = new ArrayList<>();

                for (int j = 0; j < jsonItems.length(); j++) {
                    JSONObject jsonItem = jsonItems.getJSONObject(j);

                    Long itemId = jsonItem.getLong("id");
                    Integer envaseId = jsonItem.getInt("envaseId");
                    Integer lleno = jsonItem.getInt("lleno");
                    Integer vacio = jsonItem.getInt("vacio");
                    Integer averiado = jsonItem.getInt("averiado");
                    Integer retiro = jsonItem.getInt("retiro");
                    Integer entrega = jsonItem.getInt("entrega");
                    Integer cambio = jsonItem.getInt("cambio");

                    ItemCarga item = new ItemCarga(itemId, envaseId, lleno, vacio, averiado, retiro, entrega, cambio);

                    items.add(item);
                }

                Carga carga = new Carga(id, tipoId, items);

                cargas.add(carga);
            }
        } catch (JSONException e) {

        }

        return cargas;
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
