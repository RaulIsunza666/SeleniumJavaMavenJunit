package busqueda;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AbrirPropiedades {
	
	public Properties propiedades() throws IOException {
		Properties propiedades = new Properties();
		propiedades.load(new FileReader("./src/test/resources/test.properties"));
		return propiedades;
	}
	
	public String getURL() throws IOException {
		return propiedades().getProperty("urlPrueba");
	}
	
	public String getChromeDriver() throws IOException {
		return propiedades().getProperty("chromeDriver");
	}
	
	public String getEdgeDriver() throws IOException {
		return propiedades().getProperty("edgeDriver");
	}
	
	public String getFirefoxDriver() throws IOException {
		return propiedades().getProperty("firefoxDriver");
	}
	
	public String getRutaGuardarImagen() throws IOException {
		return propiedades().getProperty("screenShots");
	}
}
