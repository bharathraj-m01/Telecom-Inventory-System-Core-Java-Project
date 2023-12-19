package com.telecom;

import java.util.*;
import java.util.Scanner;

public class ConnectionDemo {
	public static void main(String[] args) {
		try {
		ArrayList<Connection> list=new ArrayList<Connection>();
		ConnectionDemo d1=new ConnectionDemo();
		Connection c1=new PrePaid(1001,90001,100);
	    Connection c2=new PrePaid(1002,90002,50);
		Connection c3=new PrePaid(1003,90003,1);
        
		Inventory i1=d1.addObject(list, c1);
		i1=d1.addObject(list, c2);
		i1=d1.addObject(list, c3);
		
		/* list.add(c1);
		list.add(c2);
		list.add(c3); 
		Inventory i1=new Inventory(list); */
		
		System.out.println("Welcome to ABC Telecommunication Network!!!");
		System.out.println();
		System.out.println("Add Connection - Enter 1");
		System.out.println("Recharge - Enter 2");
		System.out.println("Deduct - Enter 3");
		System.out.println("Check Balance - Enter 4");
		System.out.println("Exit - Enter 0");
		System.out.println();
		System.out.print("Enter your Choice:");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		System.out.println();
		double status,a;
		int connection;
		while(choice!=0) {
		switch(choice) {
		    case 1:{
		    	int lastConId=i1.lastConnectionId();
		    	int lastCustId=i1.lastCustomerId();
		    	lastConId++;
		    	lastCustId++;
		    	boolean check=i1.addConnection(lastConId,lastCustId);
		    	//System.out.println("Last Connectio  Id:"+lastConId+"Last Customer Id:"+lastCustId);
		    	
		    /*	conn1.setConnectionId(lastConId);
		    	conn1.setCustomerId(lastCustId);
		    	conn1.setBalance(0); 
		    	Inventory i2=new Inventory();
		    	Inventory i2=new Inventory(list); */
		    	
		    	if(check == true) {
		    		Connection conn1 = new PrePaid(lastConId,lastCustId,0);
			    	i1=d1.addObject(list, conn1);
			    	System.out.println("Your Connection added Successfully :)");
		    		System.out.println("Your Connection Id:"+conn1.getConnectionId());
		    		System.out.println("Your Customer Id:"+conn1.getCustomerId());
		    		System.out.println("Your Balance:"+conn1.getBalance());
		    	}
		    	else {
		    		System.out.println("Your Connection didn't add Successfully :(");
		    		System.out.println("Please Try Again");
		    	}
		    	System.out.println();
		    	break;
		    }
		    
		    case 2:{
		    	System.out.print("Enter your Connection Id:");
		    	connection=scan.nextInt();
		    	System.out.print("Enter the Recharge Amount:");
		    	a=scan.nextDouble();
		    	System.out.println();
		    	
		        status=i1.recharge(connection, a);
		    	
		    	if(status == -1) {
					System.out.println("Recharge is Failed");
					System.out.println("Check your Connection ID");
				}
				else {
					 System.out.println("Recharge is Sucessfully Done!!");
					 System.out.println("Your Balance:Rs."+status);
				}
		    	System.out.println();
		    	break;
		    }
		    
		    case 3:{
		    	System.out.print("Enter your Connection Id:");
		    	connection=scan.nextInt();
		    	System.out.print("Enter the Deduction Amount:");
		    	a=scan.nextDouble();
		    	System.out.println();
		    	
		    	status=i1.deduct(connection, a);
		    	
		    	if(status == -1) {
					System.out.println("Deduction is not successfully done");
				}
				else {
					System.out.println("Balance after deduction:Rs."+status);
				}
		    	System.out.println();
		    	break;
		    }
		    
		    case 4:{
		    	System.out.print("Enter your Connection Id:");
		    	connection=scan.nextInt();
		    	System.out.println();
		    	
		    	status=i1.balance(connection);
		    	
		    	if(status != -1) {
		    		System.out.println("Your Balance:Rs."+status);
		    	}
		    	else {
		    		System.out.println("Check Your Connection Id");
		    	}
		    	System.out.println();
		    	break;
		    }
		    
		    case 0:{
		    	System.out.println();
		    	System.out.println("Thanks for Visiting!!!");
		    	break;
		    }
		    	
		    
		    default:
		    {
		    	System.out.println("Wrong Input... Check Your Entered Input");
		    }
		} 
		System.out.println("---------------------------------------------------------");
	/*	System.out.println("Add Connection - Enter 1");
		System.out.println("Recharge - Enter 2");
		System.out.println("Deduct - Enter 3");
		System.out.println("Check Balance - Enter 4");
		System.out.println("Exit - Enter 0"); */
		System.out.println(); 
		System.out.print("Enter your Choice:");
    	choice=scan.nextInt();
    	if(choice==0) {
    		System.out.println("Thanks for Visiting!!!");
    		break;
    	}
    	  
		}
		
		/*	double r=i1.recharge(1001,10);
			if(r==-1) {
				System.out.println("Recharge is Failed");
				System.out.println("Check your Connection ID");
			}
			else {
				 System.out.println("Recharge is Sucessfully Done!!");
				 System.out.println("Your Balance:"+r);
			}
			
			double d=i1.deduct(1003,20);
			if(d==-1) {
				System.out.println("Deduction is not successfully done");
			}
			else {
				System.out.println("Balance after deduction:"+d);
			} 
	
		Connection c4=new PrePaid(1002,90004,497);
		
		list.add(c4);
		
		Inventory i2=new Inventory(list); */
			
		} catch (ConnectionLockedException e) {
			e.printStackTrace();
		}
	}
	
	public Inventory addObject(ArrayList<Connection> list,Connection obj) {
		list.add(obj);
		Inventory i1=new Inventory(list);
		return i1;
		
	}

}
