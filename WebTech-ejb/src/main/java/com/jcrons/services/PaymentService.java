package com.jcrons.services;

import javax.ejb.Local;

@Local
public interface PaymentService {
	
	public void doPayment();
	
	public void savePaymentInfo(int value, String username, int idContent);

}
