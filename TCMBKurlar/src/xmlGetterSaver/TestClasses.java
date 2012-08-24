package xmlGetterSaver;

import java.util.ArrayList;
import java.util.Date;

public class TestClasses {
	public static void main(String[] args){
		System.out.println("Test class!");
		
		EDXmlGetterSaver xgs=new EDXmlGetterSaver("http://www.tcmb.gov.tr/kurlar/today.xml","C:\\Users\\edalan.KITAPYURDU\\Desktop\\test.xml");
		xgs.GetXmlFromUrl();
		System.out.println("xml file is taken");
		xgs.SaveXmlToLocal();
		System.out.println("xml file is saved");
		
		EDTCMBXmlParser tcmb=new EDTCMBXmlParser(xgs.getXmlDoc());
		Date date = tcmb.GetXmlDate();
		System.out.println(date);
		System.out.println();
		System.out.println("________________________________");
		System.out.println();
		ArrayList<TCMBCurrency> currencyList = tcmb.GetCurrecies();
		for (int i = 0; i < currencyList.size(); i++) {
			System.out.println(currencyList.get(i).Isim);
		}
	}
}

