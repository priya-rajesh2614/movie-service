package com.movieservice.dto;


import java.util.List;

public class PaymentRequest {
    private String userEmail;
    private String paymentMethod;
    public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public List<Long> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(List<Long> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	private Double amount;
    private List<Long> selectedSeats;

}
