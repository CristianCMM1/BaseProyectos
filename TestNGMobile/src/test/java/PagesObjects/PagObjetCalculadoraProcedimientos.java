package PagesObjects;

import java.io.File;
import java.io.IOException;
import MapsObjects.MapObjetCalculadora;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjetCalculadoraProcedimientos extends MapObjetCalculadora {

	public PagObjetCalculadoraProcedimientos(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=(AppiumDriver<MobileElement>) driver; 
	}


	// METODO LINK CALCULADORA
	public void calculadora(File rutaCarpeta, String nomTest,String num1,String condicion,String num2,String generarEvidencia)
			throws InterruptedException, IOException {

		try {
			variosNumeros(nomTest,num1,btnNumeros, rutaCarpeta,generarEvidencia);
			
			
			tiempoEspera(2000);	
			click(localizadorVariable(btnOperaciones,condicion), rutaCarpeta, generarEvidencia,"Ingresar numero");
			variosNumeros(nomTest,num2,btnNumeros, rutaCarpeta,generarEvidencia); 
			tiempoEspera(2000);	
			click(btnigual, rutaCarpeta,generarEvidencia,"Seleccionar boton igual");
			tiempoEspera(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	
}