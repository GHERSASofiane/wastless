package status;



public class Reponse
{
private String status;
private String message;
private Object reponse;


public Reponse(String status, String erreur) {
	this.status = status;
	this.message = erreur;
	
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
	return message;
}

public void setErreur(String erreur) {
	this.message = erreur;
}

public Object getReponse() {
	return reponse;
}

public void setReponse(Object reponse) {
	this.reponse = reponse;
}
}

