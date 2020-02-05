package com.ut.beerpressure;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class CustomCountryListDialog extends Dialog {
    private ArrayList<String> genders;
    private ListView countryList;
    ArrayList<String> arrayList;

    public CustomCountryListDialog(@NonNull Context context, ArrayList<String>genders) {
        super(context);
        this.genders = genders;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_country_search);
        arrayList =  new ArrayList<>();
        RelativeLayout search_lyt = (RelativeLayout) findViewById(R.id.search_lyt);
        countryList = (ListView) findViewById(R.id.list);

        search_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

            }
        });
        countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Defaults.gender = arrayList.get(i);
                dismiss();
            }
        });
        TextInputEditText search_txt = findViewById(R.id.search_txt);
        if(search_txt.getText().length()==0)
            arrayList.addAll(genders);
        else arrayList.clear();
        final CustomCountryListAdapter customCountryListAdapter = new CustomCountryListAdapter(getContext(),arrayList);

        countryList.setAdapter(customCountryListAdapter);
        search_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                arrayList.clear();
                for(int j = 0; j< genders.size(); j++){

                    if((genders.get(j).toLowerCase()).contains(charSequence.toString().toLowerCase())){
                        arrayList.add(genders.get(j));
                    }
                }
                if(charSequence.toString().trim().length()==0)
                    arrayList.addAll(genders);
                customCountryListAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        TextView cancel_txt = findViewById(R.id.cancel_txt);
        cancel_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
