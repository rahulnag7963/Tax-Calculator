package taxcalculator;

import java.util.Scanner;

public class taxcal {
	public static void main(String[] args) {
		
		taxcal t = new taxcal();
		
		Scanner in = new Scanner (System.in);
		
		
		System.out.println("Enter I");
		double I = in.nextDouble();
		
		System.out.println("Enter Invest");
		double IN = in.nextDouble();
		System.out.println("Enter D");
		double D = in.nextDouble();
		System.out.println("Enter Y");
		int y = in.nextInt();
		
		
	double tax = t.FederalDivs(I, D, y);
	System.out.println(tax);
		
		
		
	}
		
	public double FedIncomeTax(double income, int year) {
	double n;
	if(year<=2020) {n=1;}
	else {
	n = 1+(0.01744*(year - 2020));}	
	int b0 = (int) Math.round(13229*n);
	int b1 = (int) Math.round(48535*n);
	int b2 = (int) Math.round(97069*n) ;
	int b3 = (int) Math.round(150473*n);
	int b4 = (int) Math.round(214368*n);

	double tax;
	double tax1=b1*0.15;
	double tax2=b2*0.205;
	double tax3=b3*0.26;
	double tax4=b4*0.29;

	if (income <=b0) {
		tax=0; return tax;}
	

	if(b0 < income && income < b1)
	{ tax = income*0.15; return tax;}

	if(b1 < income && income < b2) 
	{tax = tax1 + ((income-b1)*0.205);
	return tax;}

	if(b2 < income && income < b3)
	{tax = tax1 + tax2 + ((income-b2)*0.26); 
	return tax;}

	if ( b3 < income && income <b4) {
	tax = tax1 +tax2+ tax3 +((income-b3)*0.29); 
	return tax;}
		
	if(income > b4) {
	tax = tax1 +tax2+ tax3 + tax4 +((b4-income)*0.33); 
	return tax;}	
	

	return -1;}

	public double bcIncomeTax (double income, int year) {
	double n;
	if(year<=2020) {n=1;}
	else {
	n = 1+(0.01744*(year-2020));
	}
	int b0 =  (int) Math.round(10949*n);
	int b1 = (int) Math.round(41725*n);
	int b2 = (int) Math.round(83451*n);
	int b3 = (int) Math.round(95812*n);
	int b4 = (int) Math.round(116344*n);
	int b5 = (int) Math.round(157748*n);
	int b6 = (int) Math.round(222000*n);
	
	
	double tax;
	double tax1=b1*0.0506;
	double tax2=b2*0.077;
	double tax3=b3*0.105;
	double tax4=b4*0.1229;
	double tax5=b5*0.147;
	double tax6=b6*0.168;	
		if(income <=b0) { return 0;}
		if(income >b0 && income <b1) {
		tax = income*0.0506; return tax;}
		
		
		if( b1 < income && income < b2)
		{tax = tax1 + ((income-b1)*0.077);
		return tax;}

			//else { tax = tax1 + ((income-b1)*0.077);
			//return tax;}

		if(b2 < income && income < b3)
		{tax = tax1 + tax2 + ((income-b2)*0.105); 
		return tax;}

		if(b3 < income && income < b4)	
		{tax = tax1 + tax2 + tax3 + ((income-b3)*0.1229); 
		return tax;}
			
		if(b4 < income && income < b5)	
		{tax = tax1 + tax2 + tax3 + tax4 + (income-b4)*0.147; 
		return tax;}
	
		if(b5 < income && income <b6) {
			tax = tax1 + tax2 + tax3 + tax4 + tax5 + ((income-b5)*0.168); 
			return tax;}
		
		if (income > b6) {tax5 = b5*0.168;
			tax = tax1 + tax2 + tax3 + tax4 + tax5 + tax6 + ((b6-income)*0.209);
			return tax;}
			
		//13229 is the min tax credit.
		
		
		
		
			return -1;}


	public double FederalDivs(double income, double divI, int year) {

	double MU = divI*1.38;
	
	double i = income +MU;
	
	double fTax =FedIncomeTax(i,year);
	
	
	double in = MU*0.150198;
	
	double Fdiv_tax= fTax-in;
	
	return Fdiv_tax;}	

	public double ProvincialDivs(double income, double divI, int year) {

	double MU = divI*1.38;
	
	double i = income +MU;
	
	double pTax = bcIncomeTax(i,year);
	
	double in = MU*0.12;
	
	double PBdiv_tax= pTax-in;
	
	return PBdiv_tax;}

	public double TaxCredit (double income, int Year) {
		double a;
		double TC;
		if(Year <=2020) {
		 a =1;	
		}
		else {
		a = 1.01744*(Year-2020);}

		if(income < 13229*a) {return 0;   }
		
		
		int b1 = (int)Math.round(150473*a); 
		
		if(income > b1) {
		TC = (12298*a)*0.15;}
		
		else {
			TC = (13229*a)*0.15;}	
		return TC;	}
	
	public double BCTaxCredit (double income, int Year) {
		double a;
		double TC;
		if(Year <=2020) {
		 a =1;	
		}
		else {
		a = 1.01744*(Year-2020);}

		if(income < 13229*a) {return 0;}
		
		
		int b1 = (int)Math.round(150473*a); 
		
		if(income > b1) {
		TC = (12298*a)*0.33;}
		
		else {
			TC = (13229*a)*0.33;}	
		return TC;}
	

	
	
	
	
	
}
	


