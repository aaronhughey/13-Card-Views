package com.hfad.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class StoresDetailActivity extends AppCompatActivity {
    public static final String EXTRA_STORES_ID = "storesId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        int storesId = (Integer)getIntent().getExtras().get(EXTRA_STORES_ID);
        String storesName = Stores.stores[storesId].getName();
        TextView textView = (TextView)findViewById(R.id.stores_text);
        textView.setText(storesName);
        int storesImage = Stores.stores[storesId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.stores_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, storesImage));
        imageView.setContentDescription(storesName);
    }
}
