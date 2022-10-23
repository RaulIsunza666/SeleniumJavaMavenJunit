package busqueda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AbrirPropiedades {

	public JSONObject leerJson(String elemento) {
		JSONObject jobj = null;
		try {
			jobj = (JSONObject) abrirArchivoJson();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		JSONObject entidad = (JSONObject) jobj.get(elemento);
		return  entidad;
	}

	private Object abrirArchivoJson() throws IOException, ParseException{
		FileReader json = new FileReader("./src/test/resources/identificadores.json");
		return new JSONParser().parse(json);
	}

	private Properties propiedades()  {
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileReader("./src/test/resources/test.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propiedades;
	}
	
	public String getChromeDriver() {
		return propiedades().getProperty("chromeDriver");
	}
	
	public String getEdgeDriver() {
		return propiedades().getProperty("edgeDriver");
	}
	
	public String getFirefoxDriver() {
		return propiedades().getProperty("firefoxDriver");
	}
	
	public String getRutaGuardarImagen() {
		return propiedades().getProperty("screenShots");
	}

}
