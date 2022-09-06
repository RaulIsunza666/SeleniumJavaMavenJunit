package steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import busqueda.AbrirPropiedades;
import busqueda.Funcionalidades;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Busqueda extends Funcionalidades {
	
	WebDriver driver;
	AbrirPropiedades propiedades = new AbrirPropiedades();
	
	 @Given("^el usuario selecciona (.*)?")
	   public void PaginaInicial(String explorador) throws InterruptedException, IOException{
		 
		 if ("Firefox".equalsIgnoreCase(explorador)) {
			System.setProperty("webdriver.gecko.driver", propiedades.getFirefoxDriver());
			driver = new FirefoxDriver();
		 	} else if ("Chrome".equalsIgnoreCase(explorador)) {
		 		System.setProperty("webdriver.chrome.driver", propiedades.getChromeDriver());
			    driver = new ChromeDriver();
		 		} else if ("Edge".equalsIgnoreCase(explorador)){
		 			System.setProperty("webdriver.edge.driver", propiedades.getEdgeDriver());
					driver = new EdgeDriver();
		 			} else {
		 				driver = new SafariDriver();
		 			}
		 
		 driver.get(propiedades.getURL());
		 //driver.manage().window().setSize(new Dimension(1680, 1025));
		 driver.manage().window().maximize();
		 Thread.sleep(4000);
		 GuardarImagen(driver);
		 driver.findElement(By.cssSelector(".\\_2L3j8")).click();
	   }
	 
	   @When("^cuando el usario ingresa con el usuario (.*)?")
	   public void BuscarArticulo(String usuario) throws InterruptedException, IOException{
		   Thread.sleep(2500);
		   driver.findElement(By.id("emailLogin")).sendKeys(usuario);
		   GuardarImagen(driver);
	   }

	   @And("hace clic en el boton de ingresar")
	   public void HacerClickEnBoton() throws InterruptedException, IOException{
		   Thread.sleep(1500);
		   driver.findElement(By.id("submitEmail")).click();
	   }

	   @And("^ingresa la contraseña (.*)?")
	   public void IngresarContraseña(String contraseña) throws InterruptedException,  IOException{
		   Thread.sleep(1500);
		   driver.findElement(By.id("password")).sendKeys(contraseña);
		   GuardarImagen(driver);
		   driver.findElement(By.id("submitPassword")).click();
	   }
	   
	   @And("se muestran los perfiles y seleecciona el admmin")
	   public void SeleccionarPerfil() throws InterruptedException, IOException{
		   try {
			   Sleeper(driver);
			   GuardarImagen(driver);
			   driver.findElement(By.cssSelector(".image-grid-item:nth-child(1) > .icon > .img-icon")).click();
		} catch (NoSuchElementException e) {
			driver.quit();
		}
	   }
	   
	   @Then("se muestra el home user")
	   public void MostrarResultado() throws InterruptedException, IOException{
		   Thread.sleep(2500);
		   GuardarImagen(driver);
		   Assert.assertEquals(driver.findElement(By.className("nav_profileMenu--div")).getText(), "Administrador");
	   }
}
