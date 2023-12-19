package com.telecom;

public abstract class Connection {
        private int connectionId;
        private int customerId;
        protected double balance;
        public Connection(int connectionId,int customerId,double balance) {
        	this.connectionId=connectionId;
        	this.customerId=customerId;
        	this.balance=balance;
        }
		public int getConnectionId() {
			return connectionId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public double getBalance() {
			return balance;
		}
		public void setConnectionId(int connectionId) {
			this.connectionId = connectionId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
        public abstract double recharge(double amount);
        public abstract double deduct(double amount);
}
