package steps;

import funcionalidades.AbrirPropiedades;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import funcionalidades.Funcionalidades;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Busqueda extends Funcionalidades {

	WebDriver driver;

	@Given("^el usuario selecciona (.*)?")
	public void paginaInicial(String explorador) {
		WebDriver driver = Funcionalidades.seleccionExplorador(explorador);
		// driver.manage().window().setSize(new Dimension(1680, 1025));
		driver.manage().window().maximize();
		guardarImagenALLURE(driver);
		this.driver = driver;
	}

	@Given("^ingresar a la URL de (.*) y hace clic?")
	public void ingresarAlaURL(String url) {
		driver.get(url);
		esperarEelementoClic(driver,"botonInicio");
		guardarImagen(driver);
		driver.findElement(By.className(AbrirPropiedades.getIndetificadores("botonInicio"))).click();
	}

	@When("^cuando el usario ingresa con el usuario (.*)?")
	public void ingresarUsuario(String usuario) {
		esperarElementoVisible(driver,"emailLogin");
		driver.findElement(By.id("emailLogin")).sendKeys(usuario);
		guardarImagen(driver);
	}

	@And("hace clic en el boton de ingresar")
	public void hacerClickEnBoton() {
		esperarElementoVisible(driver,"submitEmail");
		driver.findElement(By.id("submitEmail")).click();
	}

	@And("^ingresa la contraseña (.*)?")
	public void ingresarContraseña(String contraseña) {
		sleeper(3000);
		driver.findElement(By.id("password")).sendKeys(contraseña);
		guardarImagen(driver);
		driver.findElement(By.id("submitPassword")).click();
	}

	@And("se muestran los perfiles y seleecciona el admin")
	public void seleccionarPerfil() {
		try {
			sleeper(15000);
			// driver.findElement(By.xpath("//img[contains(@src,'avatar02')]")).click();
			guardarImagen(driver);
			driver.findElement(By.cssSelector("div.image-grid-item:nth-child(1)>div:nth-child(1)>img:nth-child(1)")).click();
			sleeper(14000);
		} catch (Exception e) {
			System.err.println(e);
			driver.close();
			driver.quit();
		}
	}

	@And("se muestra el home user")
	public void mostrarResultado() {
		guardarImagen(driver);
		Assert.assertEquals(driver.findElement(By.className("nav_profileMenu--div")).getText(), "Administrador");
	}

	@Then("cierro la sesion")
	public void cierroLaSesion() {
		mouseHover(driver);
		driver.findElement(By.cssSelector("*.dropdown-menu>li:nth-child(8)>a")).click();
	}

	@Then("se cierra el explorador")
	public void seCierraElExplorador() {
		driver.quit();
	}
}
