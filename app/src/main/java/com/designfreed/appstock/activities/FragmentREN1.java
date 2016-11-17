package com.designfreed.appstock.activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.designfreed.appstock.R;
import com.designfreed.appstock.entities.Carga;
import com.designfreed.appstock.entities.ItemCarga;
import com.designfreed.appstock.loaders.CargaLoader;

import java.util.ArrayList;
import java.util.List;

public class FragmentREN1 extends Fragment implements LoaderManager.LoaderCallbacks<List<Carga>> {
    private static final String SERVICE_URL = "http://bybgas.dyndns.org:8080/StockService/services/stockService/getCargaByHojaRuta?";
    private static final Long REN1 = 3L;
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
    private ProgressBar progressBar;
    private Long hojaRutaId;
    List<Carga> cargas;

    public FragmentREN1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tipos_carga_ren1, container, false);

        hojaRutaId = getArguments().getLong("id");

        cargas = new ArrayList<>();

        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);

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

//        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//
//        if (networkInfo != null && networkInfo.isConnected()) {
//            getActivity().getLoaderManager().initLoader(0, null, this).forceLoad();
//        } else {
//            progressBar.setVisibility(View.GONE);
//        }

        return rootView;
    }

    @Override
    public Loader<List<Carga>> onCreateLoader(int i, Bundle bundle) {
        return new CargaLoader(getContext(), SERVICE_URL, hojaRutaId);
    }

    @Override
    public void onLoadFinished(Loader<List<Carga>> loader, List<Carga> cargas) {
        this.cargas = null;

        this.cargas = cargas;

        if (this.cargas != null) {
            for (Carga carga: cargas) {
                if (carga.getTipoId().equals(3L)) {
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

                    break;
                }
            }
        }

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<List<Carga>> loader) {
        this.cargas = null;

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
