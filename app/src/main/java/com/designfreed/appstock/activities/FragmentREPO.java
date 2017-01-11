package com.designfreed.appstock.activities;

import android.app.LoaderManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.designfreed.appstock.R;
import com.designfreed.appstock.entities.Carga;
import com.designfreed.appstock.entities.ItemCarga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FragmentREPO extends Fragment {
    private static final String SERVICE_URL = "http://bybgas.dyndns.org:8080/StockService/services/stockService/getCargaByHojaRuta?";
    private static final Long REPO = 2L;
    private EditText lleno10;
    private EditText lleno12;
    private EditText lleno15;
    private EditText lleno15me;
    private EditText lleno30;
    private EditText lleno45;
    private EditText vacio10;
    private EditText vacio12;
    private EditText vacio15;
    private EditText vacio15me;
    private EditText vacio30;
    private EditText vacio45;
    private EditText averiado10;
    private EditText averiado12;
    private EditText averiado15;
    private EditText averiado15me;
    private EditText averiado30;
    private EditText averiado45;
    private EditText retiro10;
    private EditText retiro12;
    private EditText retiro15;
    private EditText retiro15me;
    private EditText retiro30;
    private EditText retiro45;
    private EditText entrega10;
    private EditText entrega12;
    private EditText entrega15;
    private EditText entrega15me;
    private EditText entrega30;
    private EditText entrega45;
    private EditText cambio10;
    private EditText cambio12;
    private EditText cambio15;
    private EditText cambio15me;
    private EditText cambio30;
    private EditText cambio45;
    private Button procesar;
    private TextView choferNombre;
    private String chofer;
    private Long hojaRutaId;
    Carga carga;

    public FragmentREPO() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tipos_carga_repo, container, false);

        hojaRutaId = getArguments().getLong("id");

        carga = (Carga) getArguments().getSerializable("cargaREPO");
        chofer = getArguments().getString("chofer");

        choferNombre = (TextView) rootView.findViewById(R.id.nombrechofer);
        choferNombre.setText(chofer);

        procesar = (Button) rootView.findViewById(R.id.procesar);

        lleno10 = (EditText) rootView.findViewById(R.id.lleno10);
        lleno10.setText(String.valueOf(0));

        lleno12 = (EditText) rootView.findViewById(R.id.lleno12);
        lleno12.setText(String.valueOf(0));

        lleno15 = (EditText) rootView.findViewById(R.id.lleno15);
        lleno15.setText(String.valueOf(0));

        lleno15me = (EditText) rootView.findViewById(R.id.lleno15me);
        lleno15me.setText(String.valueOf(0));

        lleno30 = (EditText) rootView.findViewById(R.id.lleno30);
        lleno30.setText(String.valueOf(0));

        lleno45 = (EditText) rootView.findViewById(R.id.lleno45);
        lleno45.setText(String.valueOf(0));

        vacio10 = (EditText) rootView.findViewById(R.id.vacio10);
        vacio10.setText(String.valueOf(0));

        vacio12 = (EditText) rootView.findViewById(R.id.vacio12);
        vacio12.setText(String.valueOf(0));

        vacio15 = (EditText) rootView.findViewById(R.id.vacio15);
        vacio15.setText(String.valueOf(0));

        vacio15me = (EditText) rootView.findViewById(R.id.vacio15me);
        vacio15me.setText(String.valueOf(0));

        vacio30 = (EditText) rootView.findViewById(R.id.vacio30);
        vacio30.setText(String.valueOf(0));

        vacio45 = (EditText) rootView.findViewById(R.id.vacio45);
        vacio45.setText(String.valueOf(0));

        averiado10 = (EditText) rootView.findViewById(R.id.averiado10);
        averiado10.setText(String.valueOf(0));

        averiado12 = (EditText) rootView.findViewById(R.id.averiado12);
        averiado12.setText(String.valueOf(0));

        averiado15 = (EditText) rootView.findViewById(R.id.averiado15);
        averiado15.setText(String.valueOf(0));

        averiado15me = (EditText) rootView.findViewById(R.id.averiado15me);
        averiado15me.setText(String.valueOf(0));

        averiado30 = (EditText) rootView.findViewById(R.id.averiado30);
        averiado30.setText(String.valueOf(0));

        averiado45 = (EditText) rootView.findViewById(R.id.averiado45);
        averiado45.setText(String.valueOf(0));

        retiro10 = (EditText) rootView.findViewById(R.id.retiro10);
        retiro10.setText(String.valueOf(0));

        retiro12 = (EditText) rootView.findViewById(R.id.retiro12);
        retiro12.setText(String.valueOf(0));

        retiro15 = (EditText) rootView.findViewById(R.id.retiro15);
        retiro15.setText(String.valueOf(0));

        retiro15me = (EditText) rootView.findViewById(R.id.retiro15me);
        retiro15me.setText(String.valueOf(0));

        retiro30 = (EditText) rootView.findViewById(R.id.retiro30);
        retiro30.setText(String.valueOf(0));

        retiro45 = (EditText) rootView.findViewById(R.id.retiro45);
        retiro45.setText(String.valueOf(0));

        entrega10 = (EditText) rootView.findViewById(R.id.entrega10);
        entrega10.setText(String.valueOf(0));

        entrega12 = (EditText) rootView.findViewById(R.id.entrega12);
        entrega12.setText(String.valueOf(0));

        entrega15 = (EditText) rootView.findViewById(R.id.entrega15);
        entrega15.setText(String.valueOf(0));

        entrega15me = (EditText) rootView.findViewById(R.id.entrega15me);
        entrega15me.setText(String.valueOf(0));

        entrega30 = (EditText) rootView.findViewById(R.id.entrega30);
        entrega30.setText(String.valueOf(0));

        entrega45 = (EditText) rootView.findViewById(R.id.entrega45);
        entrega45.setText(String.valueOf(0));

        cambio10 = (EditText) rootView.findViewById(R.id.cambio10);
        cambio10.setText(String.valueOf(0));

        cambio12 = (EditText) rootView.findViewById(R.id.cambio12);
        cambio12.setText(String.valueOf(0));

        cambio15 = (EditText) rootView.findViewById(R.id.cambio15);
        cambio15.setText(String.valueOf(0));

        cambio15me = (EditText) rootView.findViewById(R.id.cambio15me);
        cambio15me.setText(String.valueOf(0));

        cambio30 = (EditText) rootView.findViewById(R.id.cambio30);
        cambio30.setText(String.valueOf(0));

        cambio45 = (EditText) rootView.findViewById(R.id.cambio45);
        cambio45.setText(String.valueOf(0));

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new HttpAsyncTask().execute();
            }
        });

        cargarCarga(carga);

        return rootView;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String urlService = "http://bybgas.dyndns.org:8080/StockService/services/stockService/saveOrUpdateCarga";

            String json = generarJsonObject(carga).toString();

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

            Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();

            //LoaderManager loader = getActivity().getLoaderManager();

            //loader.getLoader(0).forceLoad();

            Intent intent = new Intent(getContext(), CargaActivity.class);
            intent.putExtra("id", hojaRutaId);
            intent.putExtra("chofer", chofer);
            startActivity(intent);
        }
    }

    private JSONObject generarJsonObject(Carga carga) {
        List<ItemCarga> items = new ArrayList<>();

        ItemCarga garrafa10 = new ItemCarga();
        garrafa10.setEnvaseId(1);
        garrafa10.setLleno(Integer.parseInt(lleno10.getText().toString()));
        garrafa10.setVacio(Integer.parseInt(vacio10.getText().toString()));
        garrafa10.setAveriado(Integer.parseInt(averiado10.getText().toString()));
        garrafa10.setRetiro(Integer.parseInt(retiro10.getText().toString()));
        garrafa10.setEntrega(Integer.parseInt(entrega10.getText().toString()));
        garrafa10.setCambio(Integer.parseInt(cambio10.getText().toString()));

        ItemCarga garrafa12 = new ItemCarga();
        garrafa12.setEnvaseId(2);
        garrafa12.setLleno(Integer.parseInt(lleno12.getText().toString()));
        garrafa12.setVacio(Integer.parseInt(vacio12.getText().toString()));
        garrafa12.setAveriado(Integer.parseInt(averiado12.getText().toString()));
        garrafa12.setRetiro(Integer.parseInt(retiro12.getText().toString()));
        garrafa12.setEntrega(Integer.parseInt(entrega12.getText().toString()));
        garrafa12.setCambio(Integer.parseInt(cambio12.getText().toString()));

        ItemCarga garrafa15 = new ItemCarga();
        garrafa15.setEnvaseId(3);
        garrafa15.setLleno(Integer.parseInt(lleno15.getText().toString()));
        garrafa15.setVacio(Integer.parseInt(vacio15.getText().toString()));
        garrafa15.setAveriado(Integer.parseInt(averiado15.getText().toString()));
        garrafa15.setRetiro(Integer.parseInt(retiro15.getText().toString()));
        garrafa15.setEntrega(Integer.parseInt(entrega15.getText().toString()));
        garrafa15.setCambio(Integer.parseInt(cambio15.getText().toString()));

        ItemCarga garrafa15me = new ItemCarga();
        garrafa15me.setEnvaseId(4);
        garrafa15me.setLleno(Integer.parseInt(lleno15me.getText().toString()));
        garrafa15me.setVacio(Integer.parseInt(vacio15me.getText().toString()));
        garrafa15me.setAveriado(Integer.parseInt(averiado15me.getText().toString()));
        garrafa15me.setRetiro(Integer.parseInt(retiro15me.getText().toString()));
        garrafa15me.setEntrega(Integer.parseInt(entrega15me.getText().toString()));
        garrafa15me.setCambio(Integer.parseInt(cambio15me.getText().toString()));

        ItemCarga garrafa30 = new ItemCarga();
        garrafa30.setEnvaseId(5);
        garrafa30.setLleno(Integer.parseInt(lleno30.getText().toString()));
        garrafa30.setVacio(Integer.parseInt(vacio30.getText().toString()));
        garrafa30.setAveriado(Integer.parseInt(averiado30.getText().toString()));
        garrafa30.setRetiro(Integer.parseInt(retiro30.getText().toString()));
        garrafa30.setEntrega(Integer.parseInt(entrega30.getText().toString()));
        garrafa30.setCambio(Integer.parseInt(cambio30.getText().toString()));

        ItemCarga garrafa45 = new ItemCarga();
        garrafa45.setEnvaseId(6);
        garrafa45.setLleno(Integer.parseInt(lleno45.getText().toString()));
        garrafa45.setVacio(Integer.parseInt(vacio45.getText().toString()));
        garrafa45.setAveriado(Integer.parseInt(averiado45.getText().toString()));
        garrafa45.setRetiro(Integer.parseInt(retiro45.getText().toString()));
        garrafa45.setEntrega(Integer.parseInt(entrega45.getText().toString()));
        garrafa45.setCambio(Integer.parseInt(cambio45.getText().toString()));

        items.add(garrafa10);
        items.add(garrafa12);
        items.add(garrafa15);
        items.add(garrafa15me);
        items.add(garrafa30);
        items.add(garrafa45);

        if (carga == null) {
            carga = new Carga();

            carga.setTipoId(2L);
            carga.setItems(items);
        } else {
            for (ItemCarga item: carga.getItems()) {
                for (ItemCarga item1: items) {
                    if (item.getEnvaseId().equals(item1.getEnvaseId())) {
                        item.setLleno(item1.getLleno());
                        item.setVacio(item1.getVacio());
                        item.setAveriado(item1.getAveriado());
                        item.setRetiro(item1.getRetiro());
                        item.setEntrega(item1.getEntrega());
                        item.setCambio(item1.getCambio());
                    }
                }
            }
        }

        JSONObject jsonCarga = new JSONObject();

        try {
            JSONObject jsonTipo = new JSONObject();
            jsonTipo.put("id", 2L);
            jsonTipo.put("tipo", "Reposicion");

            jsonCarga.put("id", carga.getId());
            jsonCarga.put("fecha", Calendar.getInstance().getTime().getTime());
            jsonCarga.put("tipo", jsonTipo);
            jsonCarga.put("hojaRutaId", hojaRutaId);

            JSONArray jsonItems = new JSONArray();

            for (int i = 0; i < carga.getItems().size(); i++) {
                JSONObject jsonItem = new JSONObject();
                jsonItem.put("id", carga.getItems().get(i).getId());
                jsonItem.put("envaseId", carga.getItems().get(i).getEnvaseId());
                jsonItem.put("lleno", carga.getItems().get(i).getLleno());
                jsonItem.put("vacio", carga.getItems().get(i).getVacio());
                jsonItem.put("averiado", carga.getItems().get(i).getAveriado());
                jsonItem.put("retiro", carga.getItems().get(i).getRetiro());
                jsonItem.put("entrega", carga.getItems().get(i).getEntrega());
                jsonItem.put("cambio", carga.getItems().get(i).getCambio());

                jsonItems.put(i, jsonItem);
            }

            jsonCarga.put("items", jsonItems);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonCarga;
    }

    private void cargarCarga(Carga carga) {
        if (carga != null) {
            for (ItemCarga item: carga.getItems()) {
                if (item.getEnvaseId() == 1) {
                    lleno10.setText(String.valueOf(item.getLleno()));
                    vacio10.setText(String.valueOf(item.getVacio()));
                    averiado10.setText(String.valueOf(item.getAveriado()));
                    retiro10.setText(String.valueOf(item.getRetiro()));
                    entrega10.setText(String.valueOf(item.getEntrega()));
                    cambio10.setText(String.valueOf(item.getCambio()));
                }

                if (item.getEnvaseId() == 2) {
                    lleno12.setText(String.valueOf(item.getLleno()));
                    vacio12.setText(String.valueOf(item.getVacio()));
                    averiado12.setText(String.valueOf(item.getAveriado()));
                    retiro12.setText(String.valueOf(item.getRetiro()));
                    entrega12.setText(String.valueOf(item.getEntrega()));
                    cambio12.setText(String.valueOf(item.getCambio()));
                }

                if (item.getEnvaseId() == 3) {
                    lleno15.setText(String.valueOf(item.getLleno()));
                    vacio15.setText(String.valueOf(item.getVacio()));
                    averiado15.setText(String.valueOf(item.getAveriado()));
                    retiro15.setText(String.valueOf(item.getRetiro()));
                    entrega15.setText(String.valueOf(item.getEntrega()));
                    cambio15.setText(String.valueOf(item.getCambio()));
                }

                if (item.getEnvaseId() == 4) {
                    lleno15me.setText(String.valueOf(item.getLleno()));
                    vacio15me.setText(String.valueOf(item.getVacio()));
                    averiado15me.setText(String.valueOf(item.getAveriado()));
                    retiro15me.setText(String.valueOf(item.getRetiro()));
                    entrega15me.setText(String.valueOf(item.getEntrega()));
                    cambio15me.setText(String.valueOf(item.getCambio()));
                }

                if (item.getEnvaseId() == 5) {
                    lleno30.setText(String.valueOf(item.getLleno()));
                    vacio30.setText(String.valueOf(item.getVacio()));
                    averiado30.setText(String.valueOf(item.getAveriado()));
                    retiro30.setText(String.valueOf(item.getRetiro()));
                    entrega30.setText(String.valueOf(item.getEntrega()));
                    cambio30.setText(String.valueOf(item.getCambio()));
                }

                if (item.getEnvaseId() == 6) {
                    lleno45.setText(String.valueOf(item.getLleno()));
                    vacio45.setText(String.valueOf(item.getVacio()));
                    averiado45.setText(String.valueOf(item.getAveriado()));
                    retiro45.setText(String.valueOf(item.getRetiro()));
                    entrega45.setText(String.valueOf(item.getEntrega()));
                    cambio45.setText(String.valueOf(item.getCambio()));
                }
            }
        }
    }

    private void reset() {
        lleno10.setText(String.valueOf(0));
        vacio10.setText(String.valueOf(0));
        averiado10.setText(String.valueOf(0));
        retiro10.setText(String.valueOf(0));
        entrega10.setText(String.valueOf(0));
        cambio10.setText(String.valueOf(0));

        lleno12.setText(String.valueOf(0));
        vacio12.setText(String.valueOf(0));
        averiado12.setText(String.valueOf(0));
        retiro12.setText(String.valueOf(0));
        entrega12.setText(String.valueOf(0));
        cambio12.setText(String.valueOf(0));

        lleno15.setText(String.valueOf(0));
        vacio15.setText(String.valueOf(0));
        averiado15.setText(String.valueOf(0));
        retiro15.setText(String.valueOf(0));
        entrega15.setText(String.valueOf(0));
        cambio15.setText(String.valueOf(0));

        lleno15me.setText(String.valueOf(0));
        vacio15me.setText(String.valueOf(0));
        averiado15me.setText(String.valueOf(0));
        retiro15me.setText(String.valueOf(0));
        entrega15me.setText(String.valueOf(0));
        cambio15me.setText(String.valueOf(0));

        lleno30.setText(String.valueOf(0));
        vacio30.setText(String.valueOf(0));
        averiado30.setText(String.valueOf(0));
        retiro30.setText(String.valueOf(0));
        entrega30.setText(String.valueOf(0));
        cambio30.setText(String.valueOf(0));

        lleno45.setText(String.valueOf(0));
        vacio45.setText(String.valueOf(0));
        averiado45.setText(String.valueOf(0));
        retiro45.setText(String.valueOf(0));
        entrega45.setText(String.valueOf(0));
        cambio45.setText(String.valueOf(0));
    }
}
