package com.designfreed.appstock.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.designfreed.appstock.R;
import com.designfreed.appstock.entities.HojaRuta;

import java.util.List;

public class HojaRutaAdapter extends ArrayAdapter<HojaRuta> {
    public HojaRutaAdapter(Context context, List<HojaRuta> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.hojas_list_item, parent, false);
        }

        HojaRuta hojaRuta = getItem(position);

        Boolean est = hojaRuta.getControlStock();

        TextView estado = (TextView) listItemView.findViewById(R.id.estado);

        GradientDrawable estadoCircle = (GradientDrawable) estado.getBackground();
        estadoCircle.setColor(getEstadoColor(est));

        TextView chofer = (TextView) listItemView.findViewById(R.id.chofer);
        chofer.setText(hojaRuta.getChofer());

        return listItemView;
    }

    private int getEstadoColor(Boolean estado) {
        int estadoResourceColorId = R.color.estado1;

        if (!estado) {
            estadoResourceColorId = R.color.estado0;
        }

        return ContextCompat.getColor(getContext(), estadoResourceColorId);
    }
}
