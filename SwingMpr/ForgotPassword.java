package SwingMpr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class ForgotPassword extends JFrame implements ActionListener{
	
	JLabel email_f,email_en,email_v,label_error4;
	JTextField text_email_en;
	JPasswordField text_email_v;
	JButton b1,b2;
	String y;
	public static String reset_email;
   static int k=0;
	Emailsend u = new Emailsend();
	
	
	ForgotPassword(String login)
	{
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setSize(800,600);
		this.setTitle("Forget Password");
		
		
		email_f =new JLabel("Email Verification");
		email_f.setFont(new Font("Tahoma",Font.BOLD,25));
		email_f.setForeground(Color.BLACK);
		email_f.setBackground(Color.WHITE);
		email_f.setBounds(10,50,800,50);
		email_f.setVisible(true);
		email_f.setOpaque(true);
		this.add(email_f);
		
		
		
		email_en =new JLabel("Enter Email");
		email_en.setFont(new Font("Tahoma",Font.BOLD,25));
		email_en.setForeground(Color.white);
		email_en.setBounds(50,160,200,50);
		email_en.setVisible(true);
		
		this.add(email_en);
		
		
		text_email_en = new JTextField();  
		text_email_en.setFont(new Font("TimesRoman",Font.BOLD,24));
        text_email_en.setBounds(275,170,250,35);   
        this.add(text_email_en);
        
        email_v =new JLabel("Email Code");
		email_v.setFont(new Font("Tahoma",Font.BOLD,25));
		email_v.setForeground(Color.white);
		email_v.setBounds(50,230,200,50);
		email_v.setVisible(true);
		this.add(email_v);
		
		text_email_v = new JPasswordField();  
		text_email_v.setFont(new Font("TimesRoman",Font.BOLD,24));
        text_email_v.setBounds(275,230,250,35);   
        this.add(text_email_v);
        
        
        label_error4 =new JLabel();
		label_error4.setFont(new Font("Tahoma",Font.BOLD,20));
		label_error4.setForeground(Color.white);
		label_error4.setBounds(50,280,400,50);
		label_error4.setVisible(false);
		
		this.add(label_error4);
        
        
        
        b1=new JButton("Verify Email");
		b1.setForeground(Color.white);
		b1.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
		b1.setBounds(575,180,150,25);
		b1.setOpaque(true);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		
		this.add(b1);
        
		
		 b2=new JButton("Proceed");
			b2.setForeground(Color.white);
			b2.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,20));
			b2.setBounds(575,280,150,25);
			b2.setOpaque(true);
			b2.setBackground(Color.black);
			b2.addActionListener(this);
			//b2.setVisible(false);
			this.add(b2);
			this.revalidate();
			this.repaint();
			 this.setVisible(true);
	}
         
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(text_email_en.getText().equals("")==true)
			{   
				label_error4.setVisible(true);
				label_error4.setText("Enter your email");
			}
			else
			{   label_error4.setVisible(false);
				int l=u.generate();
			   System.out.println(l);
			   System.out.println("one");
			   y=text_email_en.getText();
				 try {
					 System.out.print("Pika"+k++);
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
		
		
		if(e.getSource()==b2)
		{
			if(String.valueOf(text_email_v.getPassword()).equals("")==true)
			{   
				label_error4.setVisible(true);
				label_error4.setText("Enter your password");
				this.revalidate();
				this.repaint();
				 this.setVisible(true);
			}
			else if(u.verified(String.valueOf(text_email_v.getPassword()))==0)
			{      System.out.print(getFocusTraversalKeysEnabled());
				 String d="";
			     String email="";
				FirstJDBC ob = new FirstJDBC();
				String s=text_email_en.getText();
				
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
					       System.out.println();
					    		 
					    }
					    
				  
					    
				   }
					catch(Exception sql)
					{
						sql.printStackTrace();
						label_error4.setText("Invalid Credentials");
								
					}
				   
					
					if(email.equals(""))
					{   System.out.print("F");
						label_error4.setVisible(true);
						label_error4.setText("NO ACCOUNT");
						this.revalidate();
						this.repaint();
						this.setVisible(true);
					}
					else {
						reset_email=text_email_en.getText();
						this.dispose();
						new ResetPassword();
					}
					
		}
		}
		
	}
	
public static void sendmail(String y,int l) throws Exception{
	  Emailsend.sendMail(y,l);
	  
	  
	  System.out.println(k);	
	  k++;
		
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new ForgotPassword("he");
	}

}