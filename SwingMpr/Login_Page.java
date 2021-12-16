package SwingMpr;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;



public class Login_Page extends JFrame implements ActionListener
{
	
	public static boolean bt =true;
	
	JLabel lbl_username,lbl_password,lbl_heading,lbl_error;
	JTextField tx1;
	JPasswordField tx2;
	JButton b1,b2,b3,b4;
	public static String maild="";
	//public static Frame f = new Frame();
	
	Login_Page()
	{
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setSize(600,600);
		this.setTitle("Newark Store Login");
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*f.setSize(450,800);
	    f.setVisible(true);
	    f.setLayout(null);
	    f.setBackground(new Color(168, 169, 173));*/	
		
		
		
		
		lbl_heading =new JLabel("Newark Store",JLabel.CENTER);
		lbl_heading.setFont(new Font("Serif",Font.BOLD,25));
		lbl_heading.setForeground(Color.BLACK);
		lbl_heading.setBackground(Color.WHITE);
		lbl_heading.setBounds(0,15,600,50);
		lbl_heading.setVisible(true);
		lbl_heading.setOpaque(true);
		
		
		lbl_username= new JLabel("Email ID");
		lbl_username.setFont(new Font("Serif",Font.BOLD,22));
		lbl_username.setForeground(Color.white);
		lbl_username.setBounds(100,200,150,25);
		lbl_username.setVisible(true);
		
		
		tx1=new JTextField(10);
		tx1.setFont(new Font("Serif",Font.BOLD,18));
		tx1.setBounds(300,200,150,25);
		
		lbl_password= new JLabel("Password");
		lbl_password.setFont(new Font("Serif",Font.BOLD,22));
		lbl_password.setForeground(Color.white);
		lbl_password.setBounds(100,250,150,25);
		lbl_password.setVisible(true);
		
		tx2=new JPasswordField(10);
		tx2.setFont(new Font("Serif",Font.BOLD,18));
		tx2.setBounds(300,250,150,25);
		
		
		lbl_error= new JLabel();
		lbl_error.setFont(new Font("Serif",Font.BOLD,15));
		lbl_error.setForeground(Color.white);
		lbl_error.setBounds(150,350,150,25);
		
		
		
		
		this.add(lbl_heading);
		this.add(lbl_username);
		this.add(lbl_password);
		this.add(tx1);
		this.add(tx2);
		this.add(lbl_error);

		
		b1=new JButton("LOGIN");
		b1.setForeground(Color.white);
		b1.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b1.setBounds(400,300,100,25);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		this.add(b1);
		
		
		b2=new JButton("Create Account");
		b2.setForeground(Color.white);
		b2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b2.setBounds(100,410,180,25);
		b2.addActionListener(this);
		b2.setBackground(Color.black);
	    this.add(b2);
	    
	    b4=new JButton("Forget Password");
		b4.setForeground(Color.white);
		b4.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b4.setBounds(300,410,180,25);
		b4.addActionListener(this);
		b4.setBackground(Color.black);
	    this.add(b4);
	    
	    this.revalidate();
		this.repaint();
		this.setVisible(true);
		
	   
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==b1)
		{    String d="";
		     String email="";
			FirstJDBC ob = new FirstJDBC();
			String s=tx1.getText();
			
			 Connection con = null;
		        PreparedStatement p = null;
		        ResultSet rs = null;
			
			   con = ob.connectDB();
			   try
			   {
				   String sql = "select * from customer_id where email_id="+'"'+s+'"';
				   System.out.println(sql); 
				   p = con.prepareStatement(sql);
				    rs= p.executeQuery();
				    
				    
				    if(rs.next())
				    {    d = rs.getString("password");
				    System.out.println(d); 
				       email = rs.getString("email_id");
				       System.out.println(email); 
				    		 
				    }
				    
			  
				    
			   }
				catch(Exception sql)
				{
					sql.printStackTrace();
				}
			   
		
			
			if(email.equals(tx1.getText()) && d.equals(String.valueOf(tx2.getPassword())) && !tx1.getText().equals("") && !String.valueOf(tx2.getPassword()).equals(""))
			{
				this.dispose();
			    Login_Page.maild=email;
				Store ps = new Store();
				bt=false;
				
				
			}
			else
			{  
				if(String.valueOf(tx2.getPassword()).equals("") || tx1.getText().equals("")){
					lbl_error.setText("Please fill all fields");	
				}
				else if(email.equals(""))
				{
					lbl_error.setText("NO ACCOUNT !");
				}
				else
				{
				System.out.println(email); 
				lbl_error.setText("INCORRECT PASSWORD !");
				}
				this.revalidate();
				this.repaint();
				 this.setVisible(true);
			}
			
		}
			
			
		
		
		if(e.getSource()== b2)
		{   
			this.dispose();
			new Sign_Up();
		}
		if(e.getSource()==b4)
		{
			this.dispose();
			new ForgotPassword(Login_Page.maild);
		}
		
		
	}
	
	



	public static void main(String[] args) 
	{
		
             new Login_Page();
	}      
}
