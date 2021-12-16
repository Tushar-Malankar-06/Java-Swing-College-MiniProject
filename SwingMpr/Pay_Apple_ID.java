package SwingMpr;

import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class Pay_Apple_ID extends JFrame implements ActionListener
{

	JLabel label_id,label_email,label_upi_id, label_password,label_confirmpassword,label_heading,label_error,label_error2, label_error3, label_pin;
	JTextField text_id,text_email,text_upi_id; 
	JPasswordField text_password, text_confirmpassword, text_pin;
	JButton b, b2;	
	int a;
	String text;
	
	Pay_Apple_ID()
	{
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setSize(600,600);
		this.setTitle("Newark Store Payment Gateway Part 2");
		
		
		label_heading =new JLabel("Set Up Newark Payment",JLabel.CENTER);
		label_heading.setFont(new Font("Tahoma",Font.BOLD,25));
		label_heading.setForeground(Color.BLACK);
		label_heading.setBackground(Color.WHITE);
		label_heading.setBounds(0,25,600,50);
		label_heading.setOpaque(true);
		label_heading.setVisible(true);
		
		this.add(label_heading);
		
		label_id= new JLabel("Newark Id");
		label_id.setFont(new Font("Tahoma",Font.BOLD,22));
		label_id.setForeground(Color.white);
		label_id.setBounds(100,100,150,25);
		label_id.setVisible(true);	

		this.add(label_id);
		
		text_id = new JTextField(20);
		text_id.setFont(new Font("Tahoma",Font.BOLD,18));
		text_id.setBounds(325,100,150,25);

		this.add(text_id);

		label_password= new JLabel("Set Password");
		label_password.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_password.setForeground(Color.white);
		label_password.setBounds(100,150,150,25);
		label_password.setVisible(true);
		
		this.add(label_password);

		text_password = new JPasswordField(20);
		text_password.setFont(new Font("Tahoma",Font.BOLD,18));
		text_password.setBounds(325,150,150,25);
		//text_password.setEchoChar('*');
		
		this.add(text_password);
		
		label_confirmpassword = new JLabel("Confirm Password");
		label_confirmpassword.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_confirmpassword.setForeground(Color.white);
		label_confirmpassword.setBounds(100,200,225,25);
		label_confirmpassword.setVisible(true); 
		
		this.add(label_confirmpassword);

		text_confirmpassword = new JPasswordField(20);
		text_confirmpassword.setFont(new Font("Tahoma",Font.BOLD,18));
		text_confirmpassword.setBounds(325,200,150,25);
		//text_confirmpassword.setEchoChar('*');
		
		this.add(text_confirmpassword);

		label_pin= new JLabel("Set Pin");
		label_pin.setFont(new Font("Times New Roman",Font.BOLD,22));
		label_pin.setForeground(Color.white);
		label_pin.setBounds(100,250,150,25);
		label_pin.setVisible(true);

		this.add(label_pin);


		text_pin = new JPasswordField(20);
		text_pin.setFont(new Font("Tahoma",Font.BOLD,18));
		text_pin.setBounds(325,250,150,25);
		
		this.add(text_pin);

		b=new JButton("Register");
		b.setForeground(Color.black);
		b.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b.setBounds(200,300,150,25);
		b.addActionListener(this);
		b.setBackground(Color.white);
		
		this.add(b);
		
		label_error= new JLabel();
		label_error.setFont(new Font("Times New Roman",Font.ITALIC,22));
		label_error.setForeground(Color.white);
		label_error.setBounds(100,350,450,25);
		label_error.setVisible(true);

		this.add(label_error);	

		label_error2 = new JLabel("uppercase letter, one lowercase letter, one number and one ");
		label_error2.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error2.setForeground(Color.white);
		label_error2.setBounds(100,375,450,25);
			
		label_error3 = new JLabel("special character");
		label_error3.setFont(new Font("Times New Roman",Font.ITALIC,15));
		label_error3.setForeground(Color.white);
		label_error3.setBounds(100,400,450,25);
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b)
		{
			label_error.setText("");
			boolean a=false;
			label_error2.setVisible(false);
			label_error3.setVisible(false);
			if (text_id.getText().equals("") || String.valueOf(text_password.getPassword()).equals("") || String.valueOf(text_confirmpassword.getPassword()).equals("") || String.valueOf(text_pin.getPassword()).equals(""))
			{
				label_error.setText("Please fill all fields");
				
			}
			else if(String.valueOf(text_password.getPassword()).equals(String.valueOf(text_confirmpassword.getPassword())) && !String.valueOf(text_password.getPassword()).equals(""))
			{	
				boolean strong_password = Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", String.valueOf(text_password.getPassword()));
				if (strong_password)
				{
					text = String.valueOf(text_pin.getPassword());
					boolean Pin = Pattern.matches("[0-9]{4}", String.valueOf(text_pin.getPassword()));
					if(Pin)
					{   
						create_AppleId(text_id.getText(), String.valueOf(text_password.getPassword()), String.valueOf(text_pin.getPassword()));
						text_id.setText("");
						JOptionPane.showMessageDialog(this, "Account Created Successfully");
						this.dispose();
						new Login_Page();
						a=true;
					}
					else
					{
						label_error.setText("Invalid Pin. Enter 4-digit Pin");
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
			if(a==false) {
				this.revalidate();
				this.repaint();
				this.setVisible(true);
			}
		}
	}
	public static void create_AppleId(String AppleId,String Password, String PIN)
	{
      FirstJDBC obc = new FirstJDBC();
      Connection con =obc.connectDB();
      
      PreparedStatement p = null;
      String q ="INSERT INTO appleid_database(Apple_ID,Apple_password,Newark_pin,email_id) "
	            + "VALUES(?,?,?,?)";
      //ResultSet rs = null;
      try
      {
      
      p = con.prepareStatement(q);
      
      p.setString(1,AppleId);
	  p.setString(2,Password);
	  p.setString(3,PIN);
	  p.setString(4,Sign_Up.registration_mail);
	  
      p.executeUpdate();
      }
      catch( Exception sql)
      {
    	  sql.printStackTrace();
      }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pay_Apple_ID();
	}

}