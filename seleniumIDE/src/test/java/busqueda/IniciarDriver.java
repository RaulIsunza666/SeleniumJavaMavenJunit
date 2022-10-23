package busqueda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class IniciarDriver {
    AbrirPropiedades propiedades = new AbrirPropiedades();
    WebDriver driver;

    public WebDriver SeleccionExplorador(String explorador) {
        switch (explorador) {
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", propiedades.getFirefoxDriver());
                driver = new FirefoxDriver();
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", propiedades.getChromeDriver());
                driver = new ChromeDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", propiedades.getEdgeDriver());
                driver = new EdgeDriver();
                break;
            default:
                driver = new SafariDriver();
                break;
        }
        return driver;
    }
}
