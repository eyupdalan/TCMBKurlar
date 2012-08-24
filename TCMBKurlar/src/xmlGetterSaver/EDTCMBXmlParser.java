package xmlGetterSaver;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class EDTCMBXmlParser {
	public Document _xmlDoc;
	public void setXmlDoc(Document _xmlDoc){
		this._xmlDoc=_xmlDoc;
	}
	public Document getXmlDoc(){
		return _xmlDoc;
	}
	
	public EDTCMBXmlParser(Document _xmlDoc){
		setXmlDoc(_xmlDoc);
	}
	
	public Date GetXmlDate(){
		Date date=new Date();
		try{
			NodeList nList=_xmlDoc.getElementsByTagName("Tarih_Date");
			Element tarih=(Element)nList.item(0);
			
			String trh=tarih.getAttribute("Date");
			
			SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=dateFormat.parse(trh);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}
	
	public ArrayList<TCMBCurrency> GetCurrecies(){
		ArrayList<TCMBCurrency> currencyList=new ArrayList<TCMBCurrency>();
		
		NodeList nList=_xmlDoc.getElementsByTagName("Currency");
		for (int i = 0; i < nList.getLength(); i++) {
			Element currencyElement=(Element)nList.item(i);
			TCMBCurrency currency=new TCMBCurrency();
			currency.setBanknoteBuying(getDoubleValue(currencyElement, "BanknoteBuying"));
			currency.setBanknoteSelling(getDoubleValue(currencyElement, "BanknoteSelling"));
			currency.setCrossRateEuro(getDoubleValue(currencyElement, "CrossRateEuro"));
			currency.setCrossRateOther(getDoubleValue(currencyElement, "CrossRateOther"));
			currency.setCrossRateUSD(getDoubleValue(currencyElement, "CrossRateUSD"));
			currency.setCurrencyCode(getTextValue(currencyElement, "CurrencyCode"));
			currency.setCurrencyName(getTextValue(currencyElement, "CurrencyName"));
			currency.setForexBuying(getDoubleValue(currencyElement, "ForexBuying"));
			currency.setForexSelling(getDoubleValue(currencyElement, "ForexSelling"));
			currency.setIsim(getTextValue(currencyElement, "Isim"));
			currency.setUnit(getIntValue(currencyElement, "Unit"));
			
			currencyList.add(currency);
		}
		
		return currencyList;
	}
	
	public ArrayList<String[]> GetCurrencyCodeNameList(){
		ArrayList<String[]> result=new ArrayList<String[]>();
		
		return result;
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			if(el.getFirstChild()!=null)
				textVal = el.getFirstChild().getNodeValue();
			else
				textVal=null;
		}

		return textVal;
	}
	
	private double getDoubleValue(Element ele, String tagName) {
		double doubleVal = 0;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			if(el.getFirstChild()!=null)
				doubleVal = Double.parseDouble(el.getFirstChild().getNodeValue());
			else
				doubleVal=-1;
		}

		return doubleVal;
	}
	
	private int getIntValue(Element ele, String tagName) {
		int intVal = 0;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			if(el.getFirstChild()!=null)
				intVal = Integer.parseInt(el.getFirstChild().getNodeValue());
			else
				intVal=-1;
		}

		return intVal;
	}
	
	
}
