package com.telecom;

import java.util.*;

public class Inventory {
    ArrayList<Connection> con=new ArrayList<Connection>();
	public Inventory(ArrayList<Connection> con) {
		this.con=con;
	}
	
	public boolean addConnection(int con1,int cust1) {
		boolean flag = true;
		
	/*	Inventory i=new Inventory();
		int conId=i.getUniqueConnectionId();
		int cusId=i.getUniqueCustomerIds();
		System.out.println("con:"+conId+" cus:"+cusId); */
		
		for(Connection c : con) {
			if((c.getConnectionId()==con1) || (c.getCustomerId()==cust1)) {
				flag=false;
			}
		}
		if(flag == false)
		   return false;
		else {
			return true;
		}
	}
	
	public double recharge(int connectionId,double amount) {
		for(Connection c : con) {
			if(c.getConnectionId()==connectionId) {
				c.recharge(amount);
				return c.getBalance();
			}
		}
		return -1;
	}
	
	public double deduct(int connectionId,double amount) throws ConnectionLockedException {
		for(Connection c : con) {
			if(c.getConnectionId()==connectionId) {
				if(c.getBalance()>0) {
					c.deduct(amount);
					return c.getBalance();
				}
				else {
					throw new ConnectionLockedException(c.getBalance());
				}
			}
		}
		return -1;
	}
	
	public double balance(int connectionId) {
		for(Connection c : con) {
			if(c.getConnectionId()==connectionId) {
				return c.getBalance();
			}
		}
		return -1;
	}
	
	public int lastConnectionId() {
		int id=0;
		for(Connection c : con) {
			id=c.getConnectionId();
		}
		return id;
	}
	
	public int lastCustomerId() {
		int id=0;
		for(Connection c : con) {
			id=c.getCustomerId();
		}
		return id;
	}
	
}
