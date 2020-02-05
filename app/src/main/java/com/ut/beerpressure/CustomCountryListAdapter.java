package com.ut.beerpressure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class CustomCountryListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String>countryMappers;
    public CustomCountryListAdapter(Context context, ArrayList<String>countryMappers){
        this.context = context;
        this.countryMappers = countryMappers;
    }
    @Override
    public int getCount() {
        return countryMappers.size();
    }

    @Override
    public String getItem(int i) {
        return countryMappers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final LinearLayout contactsView;
        if (view == null) {
            contactsView = new LinearLayout(context);
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) context.getSystemService(inflater);
            vi.inflate(R.layout.adapter_custom_country, contactsView, true);
        } else {
            contactsView = (LinearLayout) view;

        }
        RelativeLayout relativeLayout = contactsView.findViewById(R.id.rly);
        if(i%2==0)
            contactsView.setBackgroundColor(context.getResources().getColor(R.color.firstItemColor_DialogCountrySearch));
        else
            contactsView.setBackgroundColor(context.getResources().getColor(R.color.secondItemColor_DialogCountrySearch));



        TextView country_txt = contactsView.findViewById(R.id.country_txt);
        country_txt.setText(getItem(i));

        return contactsView;
    }

}
