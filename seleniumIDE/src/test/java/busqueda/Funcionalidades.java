package busqueda;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Funcionalidades {
	
	AbrirPropiedades guardarImagen = new AbrirPropiedades();
	
	public void guardarImagen(WebDriver driver){
		
		 // Convert web driver object to TakeScreenshot
	    TakesScreenshot imagen = (TakesScreenshot) driver;
	    // Call getScreenshotAs method to create image file
	    File source = imagen.getScreenshotAs(OutputType.FILE);
	    // Copy file at destination
	    try {
			FileHandler.copy(source, new File(guardarImagen.getRutaGuardarImagen() + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println("imagen tomada");
	}
	  
	public void Sleeper(long segundos) {
		 try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
	
}
