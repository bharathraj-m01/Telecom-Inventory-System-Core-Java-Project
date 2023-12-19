package com.telecom;

public class PrePaid extends Connection{

	public PrePaid(int connectionId,int customerId,double balance) {
		super(connectionId, customerId, balance);
	}

	@Override
	public double recharge(double amount) {
	   balance+=amount;
	   return balance;
	
	}

	@Override
	public double deduct(double amount) {
		balance-=amount;
		return balance;
	}

}
