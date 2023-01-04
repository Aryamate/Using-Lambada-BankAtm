package Transaction1;
import java.io.StreamTokenizer;
import java.util.Scanner;

import Transaction.*;
public class BankMain {

	public static void main(String[] args) {//starting point 
		Scanner sc = new Scanner(System.in); //creating obj of scanner class 
		int c=3;//set c= 3
		boolean t=false; // t=false -> which tell us pin is not verify yet
		while(c!=0) {// if c become 0 then loop will break and c is still false;
			c--;// decrement of c
			System.out.println("Enter pin No");
			int pin=sc.nextInt();//1111
			String cString=Integer.toString(pin);//converting pin in integer.u
			if(cString.length()==4) {// cheacking pin lenght is 4 or not ->if 4  then cond true
				CheackPin ck = new CheackPin(pin);// creating a checkpin class ob here
				if(ck.verify()) {// using checkpin ob we verify pin pin is valid or not 
					c=0;// if pin is valid the c=0 means loop break; 
					t=true;// and t will be true mensa pin verified sucessfully

					System.out.println("1. Withdraw");
					System.out.println("2. Deposit");
					System.out.println("Enter Choice");
					int ch=sc.nextInt();// ch store choice of user its may be 1 or 2
					switch (ch) {
					case 1 ->{
						transaction ob = amt->{
							double cb=transaction.cob.getBal(ch);
							// cb store the balance of cob(avilable bal in a/c),  which is avilable in transaction class
							if(amt<cb) {
								cb=cb-amt;
								System.out.println(amt+"Rs Withdraw Succesfully!!");
								System.out.println("Current balance :"+cb);	//cob.getBal(cb) calling a get bal method with current balance and updating it!
								System.out.println("Transaction Succesfull!!");
							}else System.out.println("Insufficent Balance");
						};
						
					}
					case 2 ->{
						System.out.println("Enter the Amount");//creating a obj of Deposite class
						int amt=sc.nextInt();
						if(amt>0&& amt%100==0) {
							transaction ob= amt1->{
								double cb=transaction.cob.getBal(ch);
								cb=cb+amt1;
								System.out.println("Amount Deposit : "+amt);
								System.out.println("Balance Amount  :"+cb);
								System.out.println("Transaction Succesfull!!");
							};
						}else System.out.println("Invalid Amount !!!");
					}
					default ->System.out.println("Inalid choice");
					}
				}else System.out.println("Invalid Pin Try again !!! \n");
			}else System.out.println("Invalid Pin Try again !!! \n");

		}
		if(!t)System.out.println("Transcation Blocked Temporary!!");
		sc.close();
	}

}
