package busqueda;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Funcionalidades {
	
	AbrirPropiedades guardarImagen = new AbrirPropiedades();
	
	public void GuardarImagen(WebDriver driver) throws IOException{
		
		 // Convert web driver object to TakeScreenshot
	    TakesScreenshot imagen = (TakesScreenshot) driver;
	    // Call getScreenshotAs method to create image file
	    File source = imagen.getScreenshotAs(OutputType.FILE);
	    // Copy file at destination
	    FileHandler.copy(source, new File(guardarImagen.getRutaGuardarImagen() + System.currentTimeMillis() + ".png"));
	    System.out.println("imagen tomada");
	}
	  
	public void Sleeper(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
}
