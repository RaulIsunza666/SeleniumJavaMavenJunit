package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import busqueda.Funcionalidades;
import busqueda.IniciarDriver;
import busqueda.ListaDeElementosWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Busqueda extends Funcionalidades {

	IniciarDriver seleccionExplorador = new IniciarDriver();
	ListaDeElementosWeb buscarElemento = new ListaDeElementosWeb();
	WebDriver driver;

	 @Given("^el usuario selecciona (.*)?")
	   public void PaginaInicial(String explorador) {
		 WebDriver driver = seleccionExplorador.SeleccionExplorador(explorador);
		 //driver.manage().window().setSize(new Dimension(1680, 1025));
		 driver.manage().window().maximize();
		 this.driver = driver;
	   }
	 
	 @Given("^ingresar a la URL de (.*) y da clic en (.*)?")
	 public void ingresarAlaURL(String url, String identificador) {
		 driver.get(url);
		 Sleeper(10000);
		 guardarImagen(driver);
		 driver.findElement(buscarElemento.identificarTipoSelector(identificador)).click();
	 }
	 
	   @When("^cuando el usario ingresa con el usuario (.*)?")
	   public void ingresarUsuario(String usuario) {
		   Sleeper(3000);
		   driver.findElement(By.id("emailLogin")).sendKeys(usuario);
		   guardarImagen(driver);
	   }

	   @And("hace clic en el boton de ingresar")
	   public void hacerClickEnBoton() {
		   Sleeper(3000);
		   driver.findElement(By.id("submitEmail")).click();
	   }

	   @And("^ingresa la contraseña (.*)?")
	   public void ingresarContraseña(String contraseña) {
		   Sleeper(3000);
		   driver.findElement(By.id("password")).sendKeys(contraseña);
		   guardarImagen(driver);
		   driver.findElement(By.id("submitPassword")).click();
	   }
	   
	   @And("se muestran los perfiles y seleecciona el admin")
	   public void seleccionarPerfil() {
		   try {
			   Sleeper(15000);
			   //driver.findElement(By.xpath("//img[contains(@src,'avatar02')]")).click();
			   driver.findElement(By.cssSelector("div.image-grid-item:nth-child(1)>div:nth-child(1)>img:nth-child(1)")).click();
			   guardarImagen(driver);
			   Sleeper(21000);
		} catch (Exception e) {
			System.err.println(e);
			driver.close();
			driver.quit();
		}
	   }
	   
	   @Then("se muestra el home user")
	   public void mostrarResultado() {
		   guardarImagen(driver);
		   Assert.assertEquals(driver.findElement(By.className("nav_profileMenu--div")).getText(), "Administrador");
	   }
}
