package SwingMpr;

import java.util.regex.Pattern;
import javax.swing.*;

import studyJDBC.FirstJDBC;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Sign_Up extends JFrame implements ActionListener
{
	
	JLabel label_username,label_email,label_mobilenumber, label_password,label_confirmpassword,label_heading,label_error,label_error2, label_error3,label_error4, label_pin,street,city,state,zipcode;
	JTextField text_username,text_email,text_mobilenumber,text_street,text_city,text_state,text_zipcode; 
	JPasswordField text_password, text_confirmpassword, text_pin;
	JButton b,b2,b3,b4,b5,b6;	
	int a;
	String text;
	public String y;
	public static String registration_mail;
	Emailsend u = new Emailsend();

	Sign_Up()
	{
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setSize(700, 725);
		this.setTitle("Sign Up");
		
		label_heading =new JLabel("Newark Store Sign Up",SwingConstants.CENTER);
		label_heading.setFont(new Font("Tahoma",Font.BOLD,25));
		label_heading.setForeground(Color.BLACK);
		label_heading.setBackground(Color.WHITE);
		label_heading.setBounds(0,15,800,50);
		label_heading.setOpaque(true);
		label_heading.setVisible(true);
		
		this.add(label_heading);
		
		label_username= new JLabel("Username");
		label_username.setFont(new Font("Tahoma",Font.BOLD,22));
		label_username.setForeground(Color.white);
		label_username.setBounds(100,100,150,25);
		label_username.setVisible(true);	

		this.add(label_username);
		
		text_username = new JTextField(20);
		text_username.setFont(new Font("Tahoma",Font.BOLD,18));
		text_username.setBounds(325,100,150,25);

		this.add(text_username);

		label_email= new JLabel("Email");
		label_email.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_email.setForeground(Color.white);
		label_email.setBounds(100,150,150,25);
		label_email.setVisible(true);
		
		this.add(label_email);

		text_email = new JTextField(20);
		text_email.setFont(new Font("Tahoma",Font.BOLD,18));
		text_email.setBounds(325,150,150,25);

		this.add(text_email);
             
		label_pin = new JLabel("Set 4-digit PIN");
		label_pin.setFont(new Font("Serif",Font.BOLD,22));
		label_pin.setForeground(Color.white);
		label_pin.setBounds(100,200,200,25);
		label_pin.setVisible(true);
		//label_pin.setBounds(100,350,200,25);
		//label_pin.setVisible(true);

		this.add(label_pin);
		
		text_pin = new JPasswordField(20);
		text_pin.setFont(new Font("Tahoma",Font.BOLD,18));
		text_pin.setBounds(325,200,150,25);

		
		label_mobilenumber = new JLabel("Mobile Number");
		label_mobilenumber.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_mobilenumber.setForeground(Color.white);
		label_mobilenumber.setBounds(100,250,175,25);
		label_mobilenumber.setVisible(true); 
		
		this.add(label_mobilenumber);

		text_mobilenumber = new JTextField(20);
		text_mobilenumber.setFont(new Font("Tahoma",Font.BOLD,18));
		text_mobilenumber.setBounds(325,250,150,25);

		this.add(text_mobilenumber);

		label_password= new JLabel("Password");
		label_password.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_password.setForeground(Color.white);
		label_password.setBounds(100,300,150,25);
		label_password.setVisible(true);

		this.add(label_password);


		text_password = new JPasswordField(20);
		text_password.setFont(new Font("Tahoma",Font.BOLD,18));
		text_password.setBounds(325,300,150,25);
		text_password.setEchoChar('*');

		this.add(text_password);

		label_confirmpassword = new JLabel("Confirm Password");
		label_confirmpassword.setFont(new Font("Serif",Font.BOLD,22));
		label_confirmpassword.setForeground(Color.white);
		label_confirmpassword.setBounds(100,350,200,25);
		label_confirmpassword.setVisible(true);

		this.add(label_confirmpassword);

		text_confirmpassword = new JPasswordField(20);
		text_confirmpassword.setFont(new Font("Tahoma",Font.BOLD,18));
		text_confirmpassword.setBounds(325,350,150,25);
		text_confirmpassword.setEchoChar('*');	

		this.add(text_confirmpassword);
		
		
		street= new JLabel("Flat no/street");
		street.setFont(new Font("Serif",Font.BOLD,22));
		street.setForeground(Color.white);
		street.setBounds(100,400,200,25);
		street.setVisible(true);

		this.add(street);

		text_street = new JTextField(20);
		text_street.setFont(new Font("Tahoma",Font.BOLD,18));
		text_street.setBounds(325,400,150,25);
		

		this.add(text_street);
		
		
		city= new JLabel("City");
		city.setFont(new Font("Serif",Font.BOLD,22));
		city.setForeground(Color.white);
	     city.setBounds(100,450,200,25);
	     city.setVisible(true);

		this.add(city);

		text_city = new JTextField(20);
		text_city.setFont(new Font("Tahoma",Font.BOLD,18));
		text_city.setBounds(325,450,150,25);
		
		this.add(text_city);
		
		 state = new JLabel("State");
		state.setFont(new Font("Serif",Font.BOLD,22));
		state.setForeground(Color.white);
	     state.setBounds(100,500,200,25);
	     state.setVisible(true); 
	     this.add(state);

		text_state = new JTextField(20);
		text_state.setFont(new Font("Tahoma",Font.BOLD,18));
		text_state.setBounds(325,500,150,25);
		
		this.add(text_state);
		
		zipcode= new JLabel("Zipcode");
		zipcode.setFont(new Font("Serif",Font.BOLD,22));
		zipcode.setForeground(Color.white);
	     zipcode.setBounds(100,550,200,25);
	     zipcode.setVisible(true);

		this.add(zipcode);

		 text_zipcode= new JTextField(20);
		text_zipcode.setFont(new Font("Tahoma",Font.BOLD,18));
		text_zipcode.setBounds(325,550,150,25);
		
		this.add(text_zipcode);


		
		
		b2=new JButton("Verify Email");
		b2.setForeground(Color.white);
		b2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(500,150,150,25);
		b2.addActionListener(this);
		
		this.add(b2);


		
		this.add(text_pin);
		
		b=new JButton("Register");
		b.setForeground(Color.white);
		b.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b.setBounds(200,600,100,25);
		b.addActionListener(this);
		this.add(b);
		
		b4=new JButton("NEXT");
		b4.setBackground(Color.white);
		b4.setForeground(Color.black);
		b4.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b4.setBounds(500,650,300,25);
		b4.addActionListener(this);
		b4.setVisible(false);
		this.add(b4);
		
		b5=new JButton("Go to LOGIN");
		b5.setForeground(Color.white);
		b5.setBackground(Color.black);
		b5.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b5.setBounds(500,600,200,25);
		b5.addActionListener(this);
		b5.setVisible(false);
		this.add(b5);
		
		b6=new JButton("Go to hell");
		b6.setForeground(Color.white);
		b6.setBackground(Color.black);
		b6.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b6.setBounds(500,600,200,25);
		b6.addActionListener(this);
		b6.setVisible(false);
		this.add(b6);

		label_error= new JLabel();
		label_error.setFont(new Font("Times New Roman",Font.ITALIC,22));
		label_error.setForeground(Color.white);
		label_error.setBounds(100,650,450,25);
		label_error.setVisible(true);

		this.add(label_error);	

		label_error2 = new JLabel("uppercase letter, one lowercase letter, one number and one ");
		label_error2.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error2.setForeground(Color.white);
		label_error2.setBounds(100,700,450,25);
			
		label_error3 = new JLabel("special character");
		label_error3.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error3.setForeground(Color.white);
		label_error3.setBounds(100,750,450,25);
		
		
		label_error4 = new JLabel("Please enter your email");
		label_error4.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error4.setForeground(Color.white);
		label_error4.setBounds(500,250,450,25);
		label_error4.setVisible(false);
		this.add(label_error4);
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);


		
	}
		
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==b)
		{   
			boolean abcd=false;
			System.out.println("hey1");
			label_error2.setVisible(false);
			label_error3.setVisible(false);
		
			if (text_username.getText().equals("") || text_email.getText().equals("") || String.valueOf(text_password.getPassword()).equals("") || String.valueOf(text_confirmpassword.getPassword()).equals("") || String.valueOf(text_pin.getPassword()).equals("") || text_mobilenumber.getText().equals(""))
			{
				label_error.setText("Please fill all fields");
			}
			else if(String.valueOf(text_password.getPassword()).equals((String.valueOf(text_confirmpassword.getPassword()))) && !text_password.getPassword().toString().equals(""))
			{	
				System.out.println(String.valueOf(text_password.getPassword()));
				System.out.println(text_password.getPassword());
				System.out.println(text_password.getPassword().toString());
				
				boolean strong_password = Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", String.valueOf(text_password.getPassword()));
				if (strong_password)
				{
					
					text = String.valueOf(text_pin.getPassword());
					boolean Mob_No = Pattern.matches("[0-9]{10}",text_mobilenumber.getText());
					if(Mob_No)
						{
					  	try {
    							a = Integer.parseInt(text);
				    			// OK, valid number.
  							if(1000<=a  && a<10000)
								{
								boolean isemail = Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+{2,6}$", (String.valueOf(text_email.getText())).toUpperCase());
								if(isemail){
									
									if(u.verified(String.valueOf(text_pin.getPassword()))==0)
									{   
										System.out.print(String.valueOf(u.verified(String.valueOf(text_pin.getPassword()))));
										create_new(text_username.getText(),text_mobilenumber.getText(),text_email.getText(),text_street.getText(),text_city.getText(),text_state.getText(),text_zipcode.getText(),String.valueOf(text_confirmpassword.getPassword()));
								        	Sign_Up.registration_mail=text_email.getText();
										label_error.setText("Account Created Successfully");
									text_username.setText("");
									 text_email.setText("");
									text_mobilenumber.setText("");
									text_state.setText("");
									text_street.setText("");
									text_city.setText(" ");
									text_zipcode.setText(" ");
									b.setVisible(false);
									b4.setVisible(true);
									abcd=true;
									this.dispose();
									new Pay_Sign_Up();
								
									// Add in Database
										}
									
								}
								else
									{
									label_error.setText("Invald Email");
									}
								}
							else
								{
								label_error.setText("Invalid Pin");
								}
							} catch (NumberFormatException nfe) {
								label_error.setText("Invalid PIN");
								// Not a number.
  								}
						}
					else{
						label_error.setText("Please Enter Valid Mobile Number");
					}
				}
				else{
					label_error.setText("Please enter a strong 8-digit password containing at least one ");	
					label_error.setFont(new Font("Times New Roman",Font.ITALIC,15));
					
					label_error2.setVisible(true);
					label_error3.setVisible(true);

					this.add(label_error2);	
					this.add(label_error3);	
						
					}			
			}			
			else
			{
				label_error.setText("Password Mismatch");
			}
			text_password.setText("");
			text_confirmpassword.setText("");
			text_pin.setText("");
			if(abcd==false) {
				this.revalidate();
				this.repaint();
				this.setVisible(true);
			}
		}
		// handle null pointer exception here
		if(e.getSource()==b2)
		{  
			
			if(text_email.getText().equals("")==true)
		{   System.out.println("hey");
			label_error4.setVisible(true);
			label_error4.setText("Enter your email");
		}
		else
		{   label_error4.setVisible(false);
			int l=u.generate();
		   System.out.println(l);
		   y=text_email.getText();
			 try {
				sendmail(y,l);
			} catch (Exception e1) {
				// TODO Auto-generated catch block	
				e1.printStackTrace();
			}
			 
		}

			this.revalidate();
			this.repaint();
			this.setVisible(true);
	
		}
		if(e.getSource()==b4)
		{   
			this.dispose();
			new Pay_Sign_Up();
		}
		if(e.getSource()==b5)
		{
			this.dispose();
			new Login_Page();
		}
		if(e.getSource()==b6)
		{
			this.dispose();
			new Pay_Sign_Up();
		}
	


	}
	public static void sendmail(String y,int l) throws Exception{
		  Emailsend.sendMail(y,l);
		  System.out.println("Hw");
		  
			
	}
	public static void create_new(String name,String mobile_no, String email, String flat,String city,String stt,String pincode, String pasword)
	{
      FirstJDBC obc = new FirstJDBC();
      Connection con =obc.connectDB();
      
      PreparedStatement p = null;
      String q ="INSERT INTO customer_id(username,phone,email_id,street,city ,state,zip_code,password) "
	            + "VALUES(?,?,?,?,?,?,?,?)";
      //ResultSet rs = null;
      try
      {
      
      p = con.prepareStatement(q);
      
      p.setString(1,name);
	  p.setString(2,mobile_no);
	  p.setString(3, email);
	  p.setString(4,flat);
	  p.setString(5, city);
	  p.setString(6, stt);
	  p.setString(7, pincode);
	  p.setString(8, pasword);
      p.executeUpdate();
      }
      catch (SQLIntegrityConstraintViolationException o) 
      {
    	  Sign_Up l = new Sign_Up() ;
    	  l.errorofrepeat();
    	  
		// TODO: handle exception
	  }
      catch(Exception sql)
      {    
    	  sql.printStackTrace();}
	}
	
	public void  errorofrepeat()
	{
		label_error.setText("ACCOUNT ALREADY PRESENT");
		b5.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		
             new Sign_Up();
	}      
}