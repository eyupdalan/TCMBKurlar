package xmlGetterSaver;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class EDXmlGetterSaver {
	public Document _xmlDoc;
	public void setXmlDoc(Document _xmlDoc){
		this._xmlDoc=_xmlDoc;
	}
	public Document getXmlDoc(){
		return _xmlDoc;
	}
	
	public String _xmlUrl;
	public void setXmlUrl(String _xmlUrl){
		this._xmlUrl=_xmlUrl;
	}
	public String getXmlUrl(){
		return _xmlUrl;
	}
	
	public String _xmlLocalPath;
	public void setXmlLocalPath(String _xmlLocalPath){
		this._xmlLocalPath=_xmlLocalPath;
	}
	public String getXmlLocalPath(){
		return _xmlLocalPath;
	}
	
	public EDXmlGetterSaver(String _xmlUrl){
		setXmlUrl(_xmlUrl);
	}
	
	public EDXmlGetterSaver(String _xmlUrl,String _xmlLocalPath){
		setXmlUrl(_xmlUrl);
		setXmlLocalPath(_xmlLocalPath);
	}
	
	public void GetXmlFromUrl(){
		try{
			DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
			setXmlDoc(db.parse(new URL(getXmlUrl()).openStream()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void GetXmlFromLocal(){
		try{
			DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
			setXmlDoc(db.parse(new File(getXmlLocalPath())));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void SaveXmlToLocal(){
		try{
			Transformer transformer=TransformerFactory.newInstance().newTransformer();
			DOMSource source=new DOMSource(getXmlDoc());
			StreamResult result=new StreamResult(new File(getXmlLocalPath()));
			transformer.transform(source, result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
