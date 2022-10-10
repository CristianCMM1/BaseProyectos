package PagsObjets;

import java.io.File;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjetRegistroMercury;

public class PagObjetRegistroMercury extends MapObjetRegistroMercury {

	

	//CONSTRUCTOR DE LA CLASE
	public PagObjetRegistroMercury(WebDriver driver) {
		super(driver);
	}

	//METODO REGISTRO MERCURY
	public void registrarseMercury( File rutaCarpeta, String generarEvidencia,String firstName, String lastName
			,String phone,String email, String address, String city, String state,String postalCode,String country,
			String usserName, String password, String confirmPassword) throws Exception {

		// INGRESAR PRIMER NOMBRE
		borrar(txtfirstName, rutaCarpeta, generarEvidencia);
		sendkey(firstName,txtfirstName,rutaCarpeta,generarEvidencia);

		// INGRESAR APELLIDO
		sendkey(lastName, txtLastName,rutaCarpeta,generarEvidencia);
		//submit(txtLastName, rutaCarpeta);
		tiempoEspera(2000);

		// INGRESAR NUMERO CELULAR
		sendkey(phone, txtPhone,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);

		// INGRESAR EMAIL
		sendkey(email, txtEmail,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		//submit(txtEmail, rutaCarpeta);

		// INGRESAR DIRECCION
		sendkey(address, txtAddress,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		//submit(txtAddress, rutaCarpeta);

		// INGRESAR CIUDAD
		sendkey(city,txtCity,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		//submit(txtCity, rutaCarpeta);

		// INGRESAR ESTADO
		sendkey(state, txtState,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		//submit(txtState, rutaCarpeta);

		// INGRESAR CODIGO POSTAL
		sendkey(postalCode, txtPostalCode,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		//submit(txtPostalCode, rutaCarpeta);
		
		// INGRESAR COUNTRY
		click(txtCountry,rutaCarpeta,generarEvidencia);
		sendkey(country, txtCountry,rutaCarpeta,generarEvidencia);
		
		// INGRESAR USER NAME
		
		sendkey(usserName, txtUserName,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		// INGRESAR PASSWORD
		sendkey(password, txtPassword,rutaCarpeta,generarEvidencia);
		
		// INGRESAR  CONFIRMAR PASSWORD
		sendkey(confirmPassword, txtconfirmPassword,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//ENVIAR
		click(btnEnviar,rutaCarpeta,generarEvidencia);
		
		
		
	}
}
