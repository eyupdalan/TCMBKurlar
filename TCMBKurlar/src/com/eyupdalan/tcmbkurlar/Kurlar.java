package com.eyupdalan.tcmbkurlar;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import xmlGetterSaver.*;

public class Kurlar extends Activity {
	ArrayList<TCMBCurrency> liste=new ArrayList<TCMBCurrency>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurlar);
        
        Spinner kurlar=(Spinner) findViewById(R.id.kurlar);
        
        
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
        
        kurlar.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// TODO Auto-generated method stub
				int index=(int) parent.getItemIdAtPosition(pos);
				
				TextView txtCurrencyCode=(TextView) findViewById(R.id.txtCurrencyCode);
				txtCurrencyCode.setText(liste.get(index).CurrencyCode);
				
				TextView txtCurrencyName=(TextView) findViewById(R.id.txtCurrencyName);
				txtCurrencyName.setText(liste.get(index).CurrencyName);
				
				TextView txtForexBuying=(TextView) findViewById(R.id.txtForexBuying);
				txtForexBuying.setText(String.valueOf(liste.get(index).ForexBuying));
				
				TextView txtForexSelling=(TextView) findViewById(R.id.txtForexSelling);
				txtForexSelling.setText(String.valueOf(liste.get(index).ForexSelling));
				
				TextView txtBanknoteBuying=(TextView) findViewById(R.id.txtBanknoteBuying);
				txtBanknoteBuying.setText(String.valueOf(liste.get(index).BanknoteBuying));
				
				TextView txtBanknoteSelling=(TextView) findViewById(R.id.txtBanknoteSelling);
				txtBanknoteSelling.setText(String.valueOf(liste.get(index).BanknoteSelling));
				
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_kurlar, menu);
        return true;
    }

    
}
