package pruebasJunit;

import org.junit.Test;
import org.openqa.selenium.By;

import busqueda.ListaDeElementosWeb;

public class PruebaJson {

  @Test
  public void abrir() {
    ListaDeElementosWeb pruebaId = new ListaDeElementosWeb();
      By resultado = pruebaId.identificarTipoSelector("inicio");
      System.out.println(resultado);
      System.out.println("Archivo abierto");
  }
   

}
