package status;

public class Reponse {

	private String status;
	private String erreur;
	private Object reponse;
	
	
	public Reponse(String status, String erreur) {
		this.status = status;
		this.erreur = erreur;
		
	}
	
	public Reponse(String status, Object rep) {
		this.status = status;
		this.reponse = rep;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public Object getReponse() {
		return reponse;
	}

	public void setReponse(Object reponse) {
		this.reponse = reponse;
	}
	
	
	
}
