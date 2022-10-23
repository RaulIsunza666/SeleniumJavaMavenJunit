package busqueda;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;

public class ListaDeElementosWeb {
  private AbrirPropiedades abrirJson = new AbrirPropiedades();
  private String llave = "";
  private String valor = "";

  public By identificarTipoSelector(String identificador) {
    By selector = null;
    JSONObject jsonElementos = abrirJson.leerJson(identificador);

    llave = (String) jsonElementos.get("tipoSelector");
    valor = (String) jsonElementos.get("rutaElemento");

    switch (llave) {
      case "className":
        selector = By.className(valor);
        break;
      case "id":
        selector = By.id(valor);
        break;
      case "cssSelector":
        selector = By.cssSelector(valor);
        break;
    }
    return selector;
  }
}
