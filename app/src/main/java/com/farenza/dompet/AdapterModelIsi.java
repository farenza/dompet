package com.farenza.dompet;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by farenza on 05/03/18.
 */

public class AdapterModelIsi extends ArrayAdapter<ModelIsi> {

    private int lastPosition = -1;
    Context mContext;
    // View lookup cache
    private static class ViewHolder{
        TextView tvNama_Transaksi;
        TextView tvNominal;
    }

    public AdapterModelIsi(Context context, ArrayList<ModelIsi> users) {
        super(context, 0, users);
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        ModelIsi ModelIsi_class = getItem(position);
        final View result;
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tampilan_list, parent, false);

            viewHolder.tvNama_Transaksi = (TextView) convertView.findViewById(R.id.TVTRANSACTION);
            viewHolder.tvNominal = (TextView) convertView.findViewById(R.id.TVMONEY);
            // Cache the viewHolder object inside the fresh view
            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.tvNama_Transaksi.setText(ModelIsi_class.nama_transaksi);
        viewHolder.tvNominal.setText(String.valueOf(ModelIsi_class.nominal));
        // Return the completed view to render on screen

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        return convertView;
    }

}
