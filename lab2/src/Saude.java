
public class Saude {
	String statusGeral = "boa", valor, statusMental = "boa", statusFisica = "boa"; 

	public String getStatusGeral() {
		if (statusMental.equals("boa")) {
			if(statusFisica.equals("boa")) {
				statusGeral = "boa";
			}
			else {
				statusGeral = "ok";
			}
		}
		else {
			if(statusFisica.equals("boa")) {
				statusGeral = "ok";
			}
			else {
				statusGeral = "fraca";
			}
		}
		return statusGeral;
	}

	public void defineSaudeMental(String statusMental) {
		this.statusMental = statusMental;
	}

	public void defineSaudeFisica(String statusFisica) {
		this.statusFisica = statusFisica;
		
	}

}
