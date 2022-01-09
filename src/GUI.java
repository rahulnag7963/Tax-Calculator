import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import taxcalculator.taxcal;

public class GUI implements ActionListener {
private static JButton b;
private static JTextField s1;
private static JTextField s2;
private static JTextField s3;
private static JTextField s4;

private static JLabel Welcome;
private static JLabel IncomeTax;
private static JLabel InvestmentIncome;
private static JLabel DivIncome;
private static JLabel Year,msg,msg1,msg2,msg3,msg4;
private static JLabel error;
private static JFrame f;
private static JPanel p;

public static void main(String[] args) {
	
	 f = new JFrame();
	 p = new JPanel();
	
	// Setup for GUI

	f.setTitle("Tax Calculator");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(800,800);
	f.add(p);
	p.setLayout(null);
	//Welcomes users to program
	Welcome = new JLabel ("This project was made to help people with their taxes. Please enter the following:");
	Welcome.setBounds(10,20,480,25);
	p.add(Welcome);
	
	/*s1-s4 used to enter the following values to project their taxes now 
	and into the future. */
	IncomeTax = new JLabel ("Income earned from job: ");
	IncomeTax.setBounds(10,50,180,25);
	p.add(IncomeTax);
	
	s1 = new JTextField();
	s1.setBounds(300,50,160,25);
	p.add(s1);
	
	
	InvestmentIncome = new JLabel ("Enter Income earned from investments: ");
	InvestmentIncome.setBounds(10,80,280,25);
	p.add(InvestmentIncome);	
	
	s2 = new JTextField();
	s2.setBounds(300,80,160,25);
	p.add(s2);
		 
	
	DivIncome = new JLabel ("Enter Income earned from dividends: ");
	DivIncome.setBounds(10,110,280,25);
	p.add(DivIncome);
	
	s3 = new JTextField();
	s3.setBounds(300,110,160,25);
	p.add(s3);
	
	
	Year = new JLabel ("Enter the year (must be 2020 or later): ");
	Year.setBounds(10,140,280,25);
	p.add(Year);			
	
	
	s4 = new JTextField();
	s4.setBounds(300,140,160,25);
	p.add(s4);
				

	msg = new JLabel();
	msg.setBounds(300,200,380,25);
	p.add(msg);
	
	msg1 = new JLabel();
	msg1.setBounds(300,230,380,25);
	p.add(msg1);
	
	msg2 = new JLabel();
	msg2.setBounds(300,260,380,25);
	p.add(msg2);
	
	msg3 = new JLabel();
	msg3.setBounds(300,290,480,25);
	p.add(msg3);
	
	msg4 = new JLabel();
	msg4.setBounds(300,320,380,25);
	p.add(msg4);
	
	
	error = new JLabel();
	error.setBounds(300,200,380,25);
	
	
	b = new JButton("Enter");
	b.setBounds(10, 170, 80, 25);
	b.addActionListener(new GUI());
	p.add(b);
	p.setBackground(Color.lightGray);
	ImageIcon image = new ImageIcon("tax.png");
	f.setIconImage(image.getImage());
	
	f.setVisible(true);
	p.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
		try {
		String S1 = s1.getText();
		String S2 = s2.getText();
		String S3 = s3.getText();
		String S4 = s4.getText();
		
		double I = Double.parseDouble(S1);
		double Invest = Double.parseDouble(S2);
		double Div = Double.parseDouble(S3);
		int Year = Integer.parseInt(S4);
		
		double Income = I +(Invest/2);
		
		double M = I+Invest+Div;
		
		taxcal t = new taxcal();
		
		double tax = t.FederalDivs(Income, Div, Year) + t.ProvincialDivs(Income, Div, Year);
		
		double T = tax - t.TaxCredit(Income, Year);
		
		int te = (int) Math.round(T);
		
		double AT = 100*(tax/M); 
		
		int at = (int) Math.round(AT);
		
		double pT =  (t.ProvincialDivs(Income, Div, Year));
		
		int PT = (int) Math.round(pT);
		
		double fT =  t.FederalDivs(Income, Div, Year);
		
		int FT = (int) Math.round(fT);
		
		double LEFTOVER = M - T;
		
		int leftover = (int) Math.round(LEFTOVER);
		
		p.remove(error);
		msg.setText("Tax Amount equals: "+ te);
		msg1.setText("Average Tax rate (Actual percentage payed on taxes): "+ at+"%");
		msg2.setText("Provincial Tax amount payed: "+ PT);
		msg3.setText("Federal Tax amount payed: "+ FT);
		msg4.setText("Income left after taxes: "+ leftover );
		
		} catch (Exception E) {
		p.add(error);
		error.setText("Error. Please enter valid numbers (0,1,2,3,4,5,6,7,8,9).");	
		}
		
		
		}
	}

}
