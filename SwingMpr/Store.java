package SwingMpr;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Store extends JFrame implements ActionListener
{
	JLabel heading,items;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	public static boolean cart_visible=false;
	
	Store()
	{
		this.setSize(450,700);
		this.setLayout(null);
		this.setTitle("Welcome Page");
		this.getContentPane().setBackground(Color.gray);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		heading = new JLabel("Welcome ");
		heading.setBounds(150,50,250,50);
		heading.setFont(new Font("Arial",Font.BOLD,16));
		this.add(heading);
		
		
		items = new JLabel("What are you looking for");
		items.setBounds(25,150,250,50);
	    items.setFont(new Font("Arial",Font.BOLD,16));
	    this.add(items);
	    
	    b1= new JButton("Iphone");
	    b1.setBounds(150,200,150,45);
	    b1.setFont(new Font("Arial",Font.BOLD,16));
	    b1.setBackground(Color.black);
	    b1.setForeground(Color.white);
	    b1.addActionListener(this);
	    this.add(b1);
	    
	    b2= new JButton("Ipad");
	    b2.setBounds(150,260,150,45);
	    b2.setFont(new Font("Arial",Font.BOLD,16));
	    b2.setBackground(Color.black);
	    b2.setForeground(Color.white);
	    b2.addActionListener(this);
	    this.add(b2);
	    
	    
	    b3= new JButton("MacBook");
	    b3.setBounds(150,320,150,45);
	    b3.setFont(new Font("Arial",Font.BOLD,16));
	    b3.setBackground(Color.black);
	    b3.setForeground(Color.white);
	    b3.addActionListener(this);
	    this.add(b3);
	    
	    b4= new JButton("AirPods");
	    b4.setBounds(150,380,150,45);
	    b4.setFont(new Font("Arial",Font.BOLD,16));
	    b4.setBackground(Color.black);
	    b4.setForeground(Color.white);
	    b4.addActionListener(this);
	    this.add(b4);
	    
	    b5= new JButton("View Cart");
	    b5.setBounds(150,440,150,45);
	    b5.setFont(new Font("Arial",Font.BOLD,16));
	    b5.setBackground(Color.black);
	    b5.setForeground(Color.white);
	    b5.addActionListener(this);
	    this.add(b5);
	    
	    b6= new JButton("CHAT");
	    b6.setBounds(150,500,150,45);
	    b6.setFont(new Font("Arial",Font.BOLD,16));
	    b6.setBackground(Color.black);
	    b6.setForeground(Color.white);
	    b6.addActionListener(this);
	    
	    b7= new JButton("Pay");
	    b7.setBounds(150,560,150,45);
	    b7.setFont(new Font("Arial",Font.BOLD,16));
	    b7.setBackground(Color.black);
	    b7.setForeground(Color.white);
	    b7.addActionListener(this);
	    
	    
	  
	    this.add(b6);
	    this.add(b7);
	    
	    this.revalidate();
		this.repaint();
		 this.setVisible(true);
	    /*b8= new Button("Pay");
	    b8.setBounds(150,560,150,45);
	    b8.setFont(new Font("Arial",Font.BOLD,16));
	    b8.setBackground(Color.black);
	    b8.setForeground(Color.white);
	    b8.addActionListener(this);*/
	}
	
	public static void main(String[] args) {
		new Store();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{  
		    this.dispose();
			new Iphone();
			
		}
		
		if(e.getSource()==b2)
		{   this.dispose();
			new Ipad();
		}
		if(e.getSource()==b3)
		{    this.dispose();
			new MacBook();
		}
		if(e.getSource()==b4)
		{   this.dispose();
			new Airpod();
		}
		if(e.getSource()==b5)
		{  this.dispose();
			getcart oc= new getcart();
			oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		}
		if(e.getSource()==b6)
		{   this.dispose();
			new Chatbox();
		}
		if(e.getSource()==b7)
		{   this.dispose();
			new Apple_Pay(Cartdummy.gtotal);
		}
		
	}
	
	
	
}


	
	


