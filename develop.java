package collie;

import java.util.Scanner;

public class develop {
	//variables declaration
int credit;
static int mpesa;
static int pin;
static int amount;
int bundle;
int j;
//to be used every where
static void airTime(){
	System.out.print("Airtime balance= ");
	Scanner here=new Scanner(System.in);
	amount=here.nextInt();
	}
static void mpesaBal(){
	System.out.print("Mpesa Balance= ");
	Scanner here=new Scanner(System.in);
	mpesa=here.nextInt();
}
static void mpesaPin(){
	System.out.print("my Mpesa pin= ");
	Scanner here=new Scanner(System.in);
	pin=here.nextInt();
}
//collect customer data, airtime bal, mpesa balance, mpesa pin
static void initialize(){
	System.out.println("Collecting customer data...");
	airTime();
	mpesaBal();
	mpesaPin();
	System.out.println("Airtime Balance= "+amount);
	System.out.println("MPESA Balance= "+mpesa);
	System.out.println("****");
}
//menu1
void startHere(){
	System.out.println("1.Data Bundle(WITH NO EXPIRY)");
	System.out.println("2.Calls & SMS(NO EXPIRY)");
	System.out.println("3.Normal Data Bundle WITH EXPIRY");
	System.out.println("4.Check Balance");
	Scanner here=new Scanner(System.in);
	int y=here.nextInt();
	if(y==1){
	dispay();
	}
	else if(y==2){
		System.out.println("Still under development");
	}
	else if(y==3){
		System.out.println("Still under development");
	}
	else{
		System.out.println("INVALID CHOICE TRY AGAIN");
	}
}
//mpesa pin verification
void yourPin(){
	System.out.println("Please Enter your Mpesa pin");
	Scanner choice=new Scanner(System.in);
	j=choice.nextInt();
}
//make an option from menu1
void chooseHere(){
	Scanner here=new Scanner(System.in);
	int y=here.nextInt();
	if(y==1){
		chooseAmount();
		System.out.println("_____________________ ");
	}
	else if(y==2){
		System.out.println("Enter the other number");
		int other=here.nextInt();
		System.out.println("_____________________ ");
		chooseAmount();
		System.out.println("_____________________ ");
	}
	else if(y==3){
		System.out.println("STILL UNDER DEVELOPMENT!!! ");
	}
else if(y==4){
	System.out.println("STILL UNDER DEVELOPMENT!!! ");
	}
else if(y==0){
	startHere();
	}
else if(y==00){
	startHere();
	}
	else{
		System.out.println("INVALID CHOICE TRY AGAIN");
		chooseHere();
	}
}
void dispay(){
	System.out.println("Get Data(NO EXPIRY DATE)");
	System.out.println("");
	System.out.println("1.Buy for My number");
	System.out.println("2.Buy for other number");
	System.out.println("3.Okoa Data");
	System.out.println("4Data Balance");
	System.out.println("0.BACK"+"  "+"00.HOME" );
	chooseHere();
}
void chooseAmount(){
	System.out.println("Enter amount you wish to spend");
	bundle = 0;
	Scanner here=new Scanner(System.in);
	credit=here.nextInt();
	System.out.println("_____________________");
if(credit>0&&credit<11){
		bundle=credit*2;
	}
	else if(credit>10&&credit<51){
		bundle=(credit*7)/2;
	}
	else if(credit>50&&credit<10001){
		bundle=credit*5;
	}
	else{
		System.out.println("Invalid amount entered.");
		chooseAmount();
	}
System.out.println("confirm purchase of "+bundle+"MBs(NO EXPIRY DATE)@kSH50");
payWith();
}
void payWith(){
	System.out.println();
	System.out.println("Pay with:");
	System.out.println("1.Airtime");
	System.out.println("2.M-PESA");
	System.out.println("3.Enter a Different Amount");
	Scanner here=new Scanner(System.in);
	int y=here.nextInt();
	if(y==1){
		//buy bundles using airtime
		if(credit<=amount){
			System.out.println("You have succesfully purchased"+bundle+"MBs with NO EXPIRY for Kshs"+credit);
		}
		else{
			System.out.println("You have insufficient funds");
			payWith();
		}
	}
	//buy bundles via mpesa
	else if(y==2){
		yourPin();
		if(j==pin){
			if(credit<=mpesa){
				System.out.println("You have succesfully purchased "+bundle+"MBs with NO EXPIRY for Kshs"+credit);
			}
			else{
				System.out.println("You have insufficient funds");
				payWith();
			}
		}
		else{
			System.out.println("You Entered wrong pin");
			System.out.println("Please try again");
			payWith();
		}
	}
	else if(y==3){
	chooseAmount();
	}
	else{
		System.out.println("INVALID CHOICE TRY AGAIN");
		payWith();
	}	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
develop view=new develop();
view.startHere();
	}
}
