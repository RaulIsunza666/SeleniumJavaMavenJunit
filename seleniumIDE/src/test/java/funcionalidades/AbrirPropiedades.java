package funcionalidades;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AbrirPropiedades {

	//Método para abrir archivo JSON usando utilidades el JAR de Google
	public static JSONObject leerJson(String elemento) {
		JSONObject jobj = null;
		try {
			jobj = (JSONObject) abrirArchivoJson();
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
		return (JSONObject) jobj.get(elemento);
	}

	private static Object abrirArchivoJson() throws IOException, ParseException {
		return new JSONParser().parse(new FileReader(getArchivoJSON()));
	}

	public static Properties propiedades() {
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileReader("./src/test/resources/test.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propiedades;
	}

	public static String getDriver(String explorador) {
		return propiedades().getProperty(explorador.toLowerCase());
	}

	public static String getRutaGuardarImagen() {
		return propiedades().getProperty("screenShots");
	}

	public static String getArchivoJSON() {
		return propiedades().getProperty("rutaJSON");
	}

	public static String getIndetificadores(String identidicador){
		return propiedades().getProperty(identidicador);
	}
}
