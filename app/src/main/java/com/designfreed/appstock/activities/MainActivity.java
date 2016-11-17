package com.designfreed.appstock.activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.designfreed.appstock.R;
import com.designfreed.appstock.adapters.HojaRutaAdapter;
import com.designfreed.appstock.entities.HojaRuta;
import com.designfreed.appstock.loaders.HojaRutaLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<HojaRuta>> {
    private static final String SERVICE_URL = "http://bybgas.dyndns.org:8080/StockService/services/stockService/getHojasByFecha?fecha=22/06/2016";

    private HojaRutaAdapter adapter;
    private ListView hojasListView;
    private TextView emptyView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        emptyView = (TextView) findViewById(R.id.empty);

        adapter = new HojaRutaAdapter(this, new ArrayList<HojaRuta>());

        hojasListView = (ListView) findViewById(R.id.list);
        hojasListView.setEmptyView(emptyView);
        hojasListView.setAdapter(adapter);
        hojasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HojaRuta hoja = (HojaRuta) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(), CargaActivity.class);
                intent.putExtra("id", hoja.getId());
                intent.putExtra("chofer", hoja.getChofer());
                startActivity(intent);
            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            getLoaderManager().initLoader(0, null, this).forceLoad();
        } else {
            progressBar.setVisibility(View.GONE);
            emptyView.setText("No hay conexion a internet disponible");
        }
    }

    @Override
    public android.content.Loader<List<HojaRuta>> onCreateLoader(int i, Bundle bundle) {
        return new HojaRutaLoader(this, SERVICE_URL);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<HojaRuta>> loader, List<HojaRuta> hojaRutas) {
        adapter.clear();

        if (hojaRutas != null && !hojaRutas.isEmpty()) {
            emptyView.setText("");
            adapter.addAll(hojaRutas);
        } else {
            emptyView.setText("No existen hojas de rutas abiertas");
        }

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<HojaRuta>> loader) {
        adapter.clear();
    }
}
