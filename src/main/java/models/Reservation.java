package models;
 

public class Reservation {
	
	private Integer ReservationSend, ReservationReceive, ReservationProduct;
	private String ReservationMessage, ReservationDate;
	public Integer getReservationSend() {
		return ReservationSend;
	}
	public void setReservationSend(Integer reservationSend) {
		ReservationSend = reservationSend;
	}
	public Integer getReservationReceive() {
		return ReservationReceive;
	}
	public void setReservationReceive(Integer reservationReceive) {
		ReservationReceive = reservationReceive;
	}
	public Integer getReservationProduct() {
		return ReservationProduct;
	}
	public void setReservationProduct(Integer reservationProduct) {
		ReservationProduct = reservationProduct;
	}
	public String getReservationMessage() {
		return ReservationMessage;
	}
	public void setReservationMessage(String reservationMessage) {
		ReservationMessage = reservationMessage;
	}
	public String getReservationDate() {
		return ReservationDate;
	}
	public void setReservationDate(String reservationDate) {
		ReservationDate = reservationDate;
	}
	
	
}
