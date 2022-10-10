package PagsObjets;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjetHomeMercury;

public class PagObjetHomeMercury extends MapObjetHomeMercury {

	public PagObjetHomeMercury(WebDriver driver) {
		super(driver);
	}

	// METODO INICIAL
	public void urlAcceso(String url) throws IOException {
		driver.get(url);
	}

	// METODO LINK REGISTRO
	public void linkRegristro(File rutaCarpeta,String generarEvidencia)
			throws Exception {

		click(linkregistro, rutaCarpeta, generarEvidencia);
		tiempoEspera(2000);
	}
}