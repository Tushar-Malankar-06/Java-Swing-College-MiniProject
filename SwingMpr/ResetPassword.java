package SwingMpr;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Pattern;


public class ResetPassword extends JFrame implements ActionListener {
	JLabel password_f,password_en,password_v,label_error4,label_error,label_error2,label_error3;
	JPasswordField text_password_en,text_password_v;
	JButton b2;
	String y;
	public static String email="";
	ResetPassword()
	{
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setSize(800,600);
		this.setTitle("Forget Password");
		
		password_f =new JLabel("Reset Password", SwingConstants.CENTER);
		password_f.setFont(new Font("Tahoma",Font.BOLD,25));
		password_f.setForeground(Color.BLACK);
		password_f.setBackground(Color.WHITE);
		password_f.setBounds(0,50,800,50);
		password_f.setOpaque(true);
		password_f.setVisible(true);
		
		this.add(password_f);
		
		
		
		password_en =new JLabel("New Password", SwingConstants.LEFT);
		password_en.setFont(new Font("Tahoma",Font.BOLD,20));
		password_en.setForeground(Color.white);
		password_en.setBounds(50,160,200,50);
		password_en.setVisible(true);
		
		this.add(password_en);
		
		
		text_password_en = new JPasswordField();  
		text_password_en.setFont(new Font("TimesRoman",Font.BOLD,24));
        text_password_en.setBounds(275,170,250,35);   
        this.add(text_password_en);
        
        password_v =new JLabel("Confirm Password", SwingConstants.LEFT);
		password_v.setFont(new Font("Tahoma",Font.BOLD,20));
		password_v.setForeground(Color.white);
		password_v.setBounds(50,230,200,50);
		password_v.setVisible(true);
		this.add(password_v);
		
		text_password_v = new JPasswordField();  
		text_password_v.setFont(new Font("TimesRoman",Font.BOLD,24));
        text_password_v.setBounds(275,230,250,35);   
        this.add(text_password_v);
        
        
        label_error4 =new JLabel();
		label_error4.setFont(new Font("Tahoma",Font.BOLD,25));
		label_error4.setForeground(Color.white);
		label_error4.setBounds(50,380,400,50);
		label_error4.setVisible(true);
		
		this.add(label_error4);
        
		
	    b2=new JButton("Proceed");
		b2.setForeground(Color.white);
		b2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(575,280,150,25);
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setOpaque(true);
		b2.setVisible(true);
		this.add(b2);
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			if(String.valueOf(text_password_en.getPassword()).equals(String.valueOf(text_password_v.getPassword()))){
			boolean strong_password = Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", String.valueOf(text_password_en.getPassword()));
			if (strong_password){    
				label_error4.setVisible(false);
				reset(String.valueOf(text_password_v.getPassword()));
				this.dispose();
				new Login_Page();
				}
			
			else{   
				label_error4.setVisible(true);
				label_error4.setText("Please enter a strong password");
				text_password_en.setText("");
				text_password_v.setText("");
				this.revalidate();
				this.repaint();
				this.setVisible(true);
			}
			}
//			if (!String.valueOf(text_password_en.getPassword()).equals(String.valueOf(text_password_v.getPassword())))
			else{
				label_error4.setVisible(true);
				label_error4.setText("Password Mismatch");
				text_password_en.setText("");
				text_password_v.setText("");
				this.revalidate();
				this.repaint();
				this.setVisible(true);
			}
		
	   }
	
	}
	
	public static void reset(String pass)
	{
		 FirstJDBC obc = new FirstJDBC();
	      Connection con =obc.connectDB();
	      
	      PreparedStatement p = null;
	      String q ="UPDATE  customer_id SET password=? where email_id=?";
	      //ResultSet rs = null;
	      try
	      {
	      
	      p = con.prepareStatement(q);
	      
	      
		  p.setString(1,pass);
		  p.setString(2,ForgotPassword.reset_email);
		  
		  
	      p.executeUpdate();
	      }
	      /*catch (SQLIntegrityConstraintViolationException o) 
	      {
	    	  Sign_Up l = new Sign_Up() ;
	    	  l.errorofrepeat();
	    	  
			// TODO: handle exception
		  }*/
	      catch(Exception sql)
	      {    
	    	  sql.printStackTrace();}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ResetPassword();
		

	}

}