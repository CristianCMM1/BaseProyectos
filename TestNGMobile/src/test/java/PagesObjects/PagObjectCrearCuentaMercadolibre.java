package PagesObjects;

import java.io.File;
import MapsObjects.MapObjectCrearCuentaMercadolibre;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjectCrearCuentaMercadolibre extends MapObjectCrearCuentaMercadolibre {

	public PagObjectCrearCuentaMercadolibre(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=(AppiumDriver<MobileElement>) driver;
	}
	//METODO CREAR CUENTA
	public void crearCuenta(File rutaCarpeta, String nomTest,String nombre,String apellido,String documento,String email,String clave, String generarEvidencia)
			throws Exception {
		
	//LLENAR LOS CAMPOS DE TEXTO
	sendkey(nombre,txtfirstName,rutaCarpeta,generarEvidencia,"Ingresa el nombre");
	sendkey(apellido,txtlastName,rutaCarpeta,generarEvidencia,"Ingresar el apellido");
	
	//SELECCIONAR ERL TIPO DE DOCUMENTO
	click(btnDocumento, rutaCarpeta,generarEvidencia,"desplegar lista de documentos");
	tiempoEspera(2000);
	click(btnSelecDocumento, rutaCarpeta,generarEvidencia,"Seleccionar tipo de documento");
	tiempoEspera(2000);
	
	//MOVER LA PANTALLA HACIA ABAJO
	scrollVertical( rutaCarpeta, 1014, 1739,1200,1);
	
	//LLENAR LOS CAMPOS DE TEXTO
	sendkey(documento,txtDocumento,rutaCarpeta,generarEvidencia,"ingesar Tipo de documento");
	sendkey(email,txtemail,rutaCarpeta,generarEvidencia,"Ingresar email"); 
	sendkey(clave,txtpassword,rutaCarpeta,generarEvidencia,"Ingresar contraseña");
	scrollVertical( rutaCarpeta, 1014, 1739, 800, 1);
	tiempoEspera(1000);
	
	//CLICK AL CHECKBOX
	click(checkbox, rutaCarpeta,generarEvidencia,"click al Checkbox");
	tiempoEspera(2000);
	}

}
