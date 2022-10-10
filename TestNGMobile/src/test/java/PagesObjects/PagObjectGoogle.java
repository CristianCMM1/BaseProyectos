package PagesObjects;

import java.io.File;
import java.io.IOException;
import MapsObjects.MapObjetGoogle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjectGoogle extends MapObjetGoogle {

	public PagObjectGoogle(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=(AppiumDriver<MobileElement>) driver;
	}
	//METODO BUSCADOR DE GOOGLE
	public void buscador(File rutaCarpeta, String nomTest,String generarEvidencia,String url) throws Exception, InterruptedException, IOException
	{
	//CREAR NUEVA PESTA�A	
	tiempoEspera(2000);	
	click(btnOpciones, rutaCarpeta,generarEvidencia,"ingresar a opciones");
	click(btnNuevaPestaña, rutaCarpeta,generarEvidencia,"Crear nueva pestaña");
	tiempoEspera(2000);	
	
	//INGRESAR EL TEXTO A BUSCAR
	try {
		click(txtbuscador,rutaCarpeta,generarEvidencia,"Ingresar al buscador");
		sendkey(url,txtbuscador, rutaCarpeta,generarEvidencia,"Ingresar la url");
		tiempoEspera(2000);
		enter(rutaCarpeta);
		tiempoEspera(2000);
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
}
}