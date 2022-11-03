package pruebasJunit;

import java.util.Set;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.openqa.selenium.By;

import funcionalidades.AbrirPropiedades;
import funcionalidades.Funcionalidades;


public class PruebaJson {
  String driver = "";

  @Test
  public void abrir() {
      String resultado = AbrirPropiedades.getIndetificadores("botonIniciio");
       System.out.println(resultado);
  }

  public String prueba(String explorador){

      Set<Entry<Object, Object>> lista = AbrirPropiedades.propiedades().entrySet();
      lista.stream().forEach(elementos -> {
        if (explorador.equalsIgnoreCase((String)elementos.getKey())) {
          driver = (String) elementos.getKey();
        } else {
          System.out.printf("No existe el elemento %s",explorador);
        }
      });
      //lista.stream().forEach(elementos -> System.out.println(elementos.getValue()));
      //lista.stream().forEach(System.out::println);
      return driver;
  }
   
}
