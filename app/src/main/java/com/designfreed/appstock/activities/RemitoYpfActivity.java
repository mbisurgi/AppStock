package com.designfreed.appstock.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.designfreed.appstock.R;
import com.designfreed.appstock.entities.ItemMovimientoStock;
import com.designfreed.appstock.entities.MovimientoStock;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RemitoYpfActivity extends AppCompatActivity {
    private EditText fecha;
    private EditText comprobante;
    private EditText garrafa10cant;
    private EditText garrafa10pcio;
    private EditText garrafa15cant;
    private EditText garrafa15pcio;
    private EditText garrafa15mecant;
    private EditText garrafa15mepcio;
    private EditText garrafa30cant;
    private EditText garrafa30pcio;
    private EditText garrafa45cant;
    private EditText garrafa45pcio;
    private Button procesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remito_ypf);

        fecha = (EditText) findViewById(R.id.fecha);
        comprobante = (EditText) findViewById(R.id.nro_remito);
        garrafa10cant = (EditText) findViewById(R.id.garrafa10cant);
        garrafa10pcio = (EditText) findViewById(R.id.garrafa10pcio);
        garrafa15cant = (EditText) findViewById(R.id.garrafa15cant);
        garrafa15pcio = (EditText) findViewById(R.id.garrafa15pcio);
        garrafa15mecant = (EditText) findViewById(R.id.garrafa15mecant);
        garrafa15mepcio = (EditText) findViewById(R.id.garrafa15mepcio);
        garrafa30cant = (EditText) findViewById(R.id.garrafa30cant);
        garrafa30pcio = (EditText) findViewById(R.id.garrafa30pcio);
        garrafa45cant = (EditText) findViewById(R.id.garrafa45cant);
        garrafa45pcio = (EditText) findViewById(R.id.garrafa45pcio);
        procesar = (Button) findViewById(R.id.procesar);

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new HttpAsyncTask().execute();
            }
        });
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String urlService = "http://bybgas.dyndns.org:8080/StockService/services/stockService/saveOrUpdateMovimientoStock";

            String json = generarJsonObject().toString();

            String response = "";

            try {
                URL url = new URL(urlService);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
                writer.write(json);
                writer.close();

                int res = connection.getResponseCode();

                if (res == HttpURLConnection.HTTP_OK) {
                    response = connection.getResponseMessage();
                }

                if (res == 201) {
                    response = connection.getResponseMessage();
                }

                if (res == 400) {
                    response = connection.getResponseMessage();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();


            if (s.equals("OK")) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }

    private JSONObject generarJsonObject() {
        MovimientoStock movimientoStock = new MovimientoStock();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        JSONObject jsonMovimiento = new JSONObject();

        try {
            movimientoStock.setFecha(formatter.parse(fecha.getText().toString()));
            movimientoStock.setNroComprobante(comprobante.getText().toString());
            movimientoStock.setHojaRutaId(null);
            movimientoStock.setTipoMovimiento("Compra producto");
            movimientoStock.setModulo("Stock");

            List<ItemMovimientoStock> items = new ArrayList<>();

            if (!garrafa10cant.getText().toString().isEmpty() && Integer.parseInt(garrafa10cant.getText().toString()) != 0 ) {
                ItemMovimientoStock lleno = new ItemMovimientoStock();
                ItemMovimientoStock vacio = new ItemMovimientoStock();

                lleno.setEnvaseId(1L);
                lleno.setEstadoId(1L);
                lleno.setCantidad(Integer.parseInt(garrafa10cant.getText().toString()));
                lleno.setPrecio(Float.parseFloat(garrafa10pcio.getText().toString()));
                lleno.setComodatoGenerado(false);

                vacio.setEnvaseId(1L);
                vacio.setEstadoId(2L);
                vacio.setCantidad(lleno.getCantidad() * -1);
                vacio.setPrecio(lleno.getPrecio());
                vacio.setComodatoGenerado(false);

                items.add(lleno);
                items.add(vacio);
            }

            if (!garrafa15cant.getText().toString().isEmpty() && Integer.parseInt(garrafa15cant.getText().toString()) != 0 ) {
                ItemMovimientoStock lleno = new ItemMovimientoStock();
                ItemMovimientoStock vacio = new ItemMovimientoStock();

                lleno.setEnvaseId(3L);
                lleno.setEstadoId(1L);
                lleno.setCantidad(Integer.parseInt(garrafa15cant.getText().toString()));
                lleno.setPrecio(Float.parseFloat(garrafa15pcio.getText().toString()));
                lleno.setComodatoGenerado(false);

                vacio.setEnvaseId(3L);
                vacio.setEstadoId(2L);
                vacio.setCantidad(lleno.getCantidad() * -1);
                vacio.setPrecio(lleno.getPrecio());
                vacio.setComodatoGenerado(false);

                items.add(lleno);
                items.add(vacio);
            }

            if (!garrafa15mecant.getText().toString().isEmpty() && Integer.parseInt(garrafa15mecant.getText().toString()) != 0 ) {
                ItemMovimientoStock lleno = new ItemMovimientoStock();
                ItemMovimientoStock vacio = new ItemMovimientoStock();

                lleno.setEnvaseId(4L);
                lleno.setEstadoId(1L);
                lleno.setCantidad(Integer.parseInt(garrafa15mecant.getText().toString()));
                lleno.setPrecio(Float.parseFloat(garrafa15mepcio.getText().toString()));
                lleno.setComodatoGenerado(false);

                vacio.setEnvaseId(4L);
                vacio.setEstadoId(2L);
                vacio.setCantidad(lleno.getCantidad() * -1);
                vacio.setPrecio(lleno.getPrecio());
                vacio.setComodatoGenerado(false);

                items.add(lleno);
                items.add(vacio);
            }

            if (!garrafa30cant.getText().toString().isEmpty() && Integer.parseInt(garrafa30cant.getText().toString()) != 0) {
                ItemMovimientoStock lleno = new ItemMovimientoStock();
                ItemMovimientoStock vacio = new ItemMovimientoStock();

                lleno.setEnvaseId(5L);
                lleno.setEstadoId(1L);
                lleno.setCantidad(Integer.parseInt(garrafa30cant.getText().toString()));
                lleno.setPrecio(Float.parseFloat(garrafa30pcio.getText().toString()));
                lleno.setComodatoGenerado(false);

                vacio.setEnvaseId(5L);
                vacio.setEstadoId(2L);
                vacio.setCantidad(lleno.getCantidad() * -1);
                vacio.setPrecio(lleno.getPrecio());
                vacio.setComodatoGenerado(false);

                items.add(lleno);
                items.add(vacio);
            }

            if (!garrafa45cant.getText().toString().isEmpty() && Integer.parseInt(garrafa45cant.getText().toString()) != 0) {
                ItemMovimientoStock lleno = new ItemMovimientoStock();
                ItemMovimientoStock vacio = new ItemMovimientoStock();

                lleno.setEnvaseId(6L);
                lleno.setEstadoId(1L);
                lleno.setCantidad(Integer.parseInt(garrafa45cant.getText().toString()));
                lleno.setPrecio(Float.parseFloat(garrafa45pcio.getText().toString()));
                lleno.setComodatoGenerado(false);

                vacio.setEnvaseId(6L);
                vacio.setEstadoId(2L);
                vacio.setCantidad(lleno.getCantidad() * -1);
                vacio.setPrecio(lleno.getPrecio());
                vacio.setComodatoGenerado(false);

                items.add(lleno);
                items.add(vacio);
            }

            movimientoStock.setItems(items);

            jsonMovimiento.put("id", movimientoStock.getId());
            jsonMovimiento.put("fecha", movimientoStock.getFecha().getTime());
            jsonMovimiento.put("hojaRutaId", movimientoStock.getHojaRutaId());
            jsonMovimiento.put("tipoMovimiento", movimientoStock.getTipoMovimiento());
            jsonMovimiento.put("modulo", movimientoStock.getModulo());
            jsonMovimiento.put("nroComprobante", movimientoStock.getNroComprobante());

            JSONArray jsonArrayItems = new JSONArray();

            for (ItemMovimientoStock item: movimientoStock.getItems()) {
                JSONObject jsonItem = new JSONObject();

                jsonItem.put("id", item.getId());
                jsonItem.put("envaseId", item.getEnvaseId());
                jsonItem.put("estadoId", item.getEstadoId());
                jsonItem.put("cantidad", item.getCantidad());
                jsonItem.put("comodatoGenerado", item.getComodatoGenerado());
                jsonItem.put("precio", item.getPrecio());

                jsonArrayItems.put(jsonItem);
            }

            jsonMovimiento.put("items", jsonArrayItems);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonMovimiento;
    }
}
