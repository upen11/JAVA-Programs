package Assignment;

import java.util.Scanner;

class PaytmApp {

	public PaytmApp() {
		System.out.println("Welcome to Paytm");
	}

	String MobNo;
	double amtToPay;
	double bal;
	
void viewBalance()
{
	bal = 10000;
	System.out.println("\nInitial Wallet Balance is \u20b9"+ bal);
	System.out.println();
}
	
PaytmApp(String MobNo, double amtToPay )
{
	this.MobNo = MobNo;
	this.amtToPay = amtToPay;
}

void show()
{	
	System.out.println("\n---------------PAYING--------------------");
	System.out.println("\u20b9"+amtToPay +" to Mob No."+MobNo);
	System.out.println("------------------------------------------");
}

Scanner sc = new Scanner(System.in);

double addamt,add;
void AddMoney()
{	
	System.out.println("Enter Amount to add: \u20b9");
	addamt = sc.nextDouble();
	bal+=addamt;
	System.out.println("\nUpdated Wallet Balance: \u20b9"+bal);
}


void MakePayment()
{	
	if(bal>=amtToPay)
	{	System.out.println("\n---------------SUCCESS--------------------");
		System.out.println("Payment of \u20b9"+amtToPay +" Done: ");
		System.out.println("-------------------------------------------");
		bal-= amtToPay;
	System.out.println("\nRemainaing amount in wallet: \u20b9"+bal);
	}
	else
		{
		System.out.println("\n--------------PAYMENT FAILED-------------------");
		System.out.println("Insufficient Balance in Wallet. Add \u20b9"+(amtToPay-bal)+ " more");
		System.out.println("-----------------------------------------------");
		AddMoney();
		MakePayment();
		}
	}
}
class Check extends PaytmApp {

Check()
{
	
}
Check(String MobNo, double amtToPay) {
		super(MobNo, amtToPay);
	}

void checkAmt()
{	

	System.out.println("\nWallet Balance is: \u20b9"+bal);

	if(bal<amtToPay) {
		add = amtToPay - bal;
		super.MakePayment();
	}
	else
		super.MakePayment();
}

}

	
public class Paytm
	{
		 public static void main(String[] args)
		{
			Scanner sc = new Scanner(System.in);
			Check ref1 = new Check();
			
			ref1.viewBalance();
	while(true)
		{
			 System.out.println("Enter 1:To pay, 2:To Add Money, 0:Exit");
			 int c = sc.nextInt();
			 
			 
			 if(c == 0) {
			  System.out.println("Thank You For Using PAYTM APP :)");
			   break;
			 }
			 
			 sc.nextLine();
			 
			 switch(c)
			 {
			 case 1:
				 
				 System.out.println("Enter Mobile No. of Receiver: ");
				 ref1.MobNo = sc.nextLine();
				 System.out.println("Enter Amout to pay: ");
				 ref1.amtToPay = sc.nextDouble();
				 ref1.show();
				 ref1.checkAmt();
				 break;
				 
			 case 2:
				 ref1.AddMoney();
				 break;
			 
			 
			 default:
				 System.out.println("Invalid Choice");
			 }
			  
			}
	sc.close();
	}
	}