package com.telecom;

public class ConnectionLockedException extends Exception{
      double currentBalance;
	public ConnectionLockedException(double balance) {
		// TODO Auto-generated constructor stub
		System.out.println(getMessage());
		System.out.println("Your Current Balance is"+balance);
	}
	
	public String getMessage() {
		return "Your Balance is Low!";
	}

}
