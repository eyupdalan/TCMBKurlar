package com.eyupdalan.tcmbkurlar;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import xmlGetterSaver.*;

public class Kurlar extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurlar);
        
        Spinner kurlar=(Spinner) findViewById(R.id.kurlar);
        
        ArrayList<TCMBCurrency> liste=new ArrayList<TCMBCurrency>();
        EDXmlGetterSaver xgs=new EDXmlGetterSaver("http://www.tcmb.gov.tr/kurlar/today.xml");
        xgs.GetXmlFromUrl();
        EDTCMBXmlParser tcmb=new EDTCMBXmlParser(xgs.getXmlDoc());
        liste=tcmb.GetCurrecies();
        
        List<String> list=new ArrayList<String>();
                
        for (int i = 0; i < liste.size(); i++) {
			list.add(liste.get(i).Isim);			
		}
        
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kurlar.setAdapter(dataAdapter);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_kurlar, menu);
        return true;
    }

    
}
