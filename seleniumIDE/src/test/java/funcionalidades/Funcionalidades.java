package funcionalidades;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import io.qameta.allure.Allure;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Funcionalidades {
	private static WebDriver driver;
	private static String llave = "";
  private static String valor = "";

	public void guardarImagen(WebDriver driver) {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot imagen = (TakesScreenshot) driver;
		// Call getScreenshotAs method to create image file
		File source = imagen.getScreenshotAs(OutputType.FILE);
		// Copy file at destination
		try {
			FileHandler.copy(source, new File(AbrirPropiedades.getRutaGuardarImagen() + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("imagen tomada");
	}

	public byte[] guardarImagenALLURE(WebDriver driver){
		byte[] captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("captura", new ByteArrayInputStream(captura));
		return captura;
	}
	public void esperarEelementoClic(WebDriver driver, String identificador) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.className(AbrirPropiedades.getIndetificadores(identificador))));
	}

	public void esperarElementoVisible(WebDriver driver, String identificador) {
		WebElement webElement = driver.findElement(By.id(identificador));
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(webElement));
	}

	public void mouseHover(WebDriver driver){
		new Actions(driver).moveToElement(actualizarReferencia(driver)).perform();
	}

	private WebElement actualizarReferencia(WebDriver driver){
		WebElement elemento = driver.findElement(By.cssSelector("li.dropdown"));
		return elemento;
	}

	public void sleeper(long tiempo){
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	public static WebDriver seleccionExplorador(String explorador) {
		switch (explorador.toLowerCase()) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", AbrirPropiedades.getDriver(explorador));
				driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", AbrirPropiedades.getDriver(explorador));
				driver = new ChromeDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", AbrirPropiedades.getDriver(explorador));
				driver = new EdgeDriver();
				break;
			default:
				driver = new SafariDriver();
				break;
		}
		return driver;
	}

	//Esperar a que un elemento esté presente mendiante JS
	public static void esperar(){
		new WebDriverWait(driver, Duration.ofSeconds(5))
		.until(webDriver -> ((JavascriptExecutor)webDriver)
		.executeScript("return document.readyState")
		.equals("complete"));
	}
}
