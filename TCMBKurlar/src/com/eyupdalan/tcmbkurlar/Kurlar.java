package com.eyupdalan.tcmbkurlar;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;

public class Kurlar extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Spinner kurlar=(Spinner) findViewById(R.id.kurlar);
        
        
        setContentView(R.layout.activity_kurlar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_kurlar, menu);
        return true;
    }

    
}
