package com.designfreed.appstock.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.designfreed.appstock.entities.Carga;

import java.util.List;

public class CargasPagerAdapter extends FragmentPagerAdapter{
    private List<Carga> cargas;
    private Bundle parametros = new Bundle();
    private Carga cargaINIC = null;
    private Carga cargaREN1 = null;
    private Carga cargaREPO = null;
    private Carga cargaREN2 = null;

    public CargasPagerAdapter(FragmentManager fm, Long hojaRutaId, String chofer, List<Carga> cargas) {
        super(fm);
        this.parametros.putLong("id", hojaRutaId);
        this.parametros.putString("chofer", chofer);
        this.cargas = cargas;

        for (Carga carga: cargas) {
            if (carga.getTipoId().equals(1L)) {
                cargaINIC = carga;
            }

            if (carga.getTipoId().equals(2L)) {
                cargaREPO = carga;
            }

            if (carga.getTipoId().equals(3L)) {
                cargaREN1 = carga;
            }

            if (carga.getTipoId().equals(4L)) {
                cargaREN2 = carga;
            }
        }

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentINIC inic = new FragmentINIC();
                parametros.putSerializable("cargaINIC", cargaINIC);
                inic.setArguments(parametros);
                return inic;
            case 1:
                FragmentREN1 ren1 = new FragmentREN1();
                parametros.putSerializable("cargaREN1", cargaREN1);
                ren1.setArguments(parametros);
                return ren1;
            case 2:
                FragmentREPO repo = new FragmentREPO();
                parametros.putSerializable("cargaREPO", cargaREPO);
                repo.setArguments(parametros);
                return repo;
            case 3:
                FragmentREN2 ren2 = new FragmentREN2();
                parametros.putSerializable("cargaREN2", cargaREN2);
                ren2.setArguments(parametros);
                return ren2;
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "INIC";
            case 1:
                return "REN1";
            case 2:
                return "REPO";
            case 3:
                return "REN2";
        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
