package PagesObjects;

import java.io.File;
import java.io.IOException;
import MapsObjects.MapsObjetAlerts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjetAlerts extends MapsObjetAlerts {

	public PagObjetAlerts(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	public void alerts(String comentario,File rutaCarpeta,String generarEvidencia)
			throws Exception, InterruptedException, IOException {
		
		// SELECCIONAR ALGUNA ALERTA
		tiempoEspera(1000);
		click(btnAlertButton, rutaCarpeta, generarEvidencia,"click al boton alerta");
		click( btnAceptar, rutaCarpeta, generarEvidencia,"click a aceptar");

		click(btnTimerAlertButton, rutaCarpeta, generarEvidencia,"click al boton alerta con tiempo de espera");
		//tiempoEspera(5000);
		click( btnAceptar, rutaCarpeta, generarEvidencia,"click a aceptar");

		scrollVertical(rutaCarpeta, 90, 1500, 1000, 1);
		
		click( btnConfirmButton, rutaCarpeta, generarEvidencia,"click a al boton confirmar o cancelar");
		//tiempoEspera(1000);
		click( btnNegative, rutaCarpeta, generarEvidencia,"click en cancelar");

		click(btnConfirmButton, rutaCarpeta,generarEvidencia,"click a al boton confirmar o cancelar");
		//tiempoEspera(1000);
		click( btnPositive, rutaCarpeta, generarEvidencia,"click en aceptar");

		click(btnpromtButton, rutaCarpeta,generarEvidencia,"click boton alerta con campo de texto");
		sendkey(comentario, txtpromtButton,rutaCarpeta,generarEvidencia,"insertar el texto");
		tiempoEspera(1000);
		click(btnPositive, rutaCarpeta, generarEvidencia,"click en aceptar");
		
		

	}
}