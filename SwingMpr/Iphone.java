package SwingMpr;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.event.ActionListener;


public class Iphone extends JFrame implements ActionListener,ItemListener {
	
	JLabel Ip_edition,Ip_model,Ip_memory,Ip_color,Ip_output,Ip_price;
	JRadioButton c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	List list;
	ButtonGroup cg,cg1,cg2,cg3;
	JButton b1,b2,b3,b4;
	String model,Icolor,memory,edition;
	double base_iphone,memory_iphone;
	Iphone()
	{   this.setSize(450,800);
	    this.setTitle("Iphone");
	    
	    this.setLayout(null);
	    this.getContentPane().setBackground(new Color(168, 169, 173));
		Ip_edition = new JLabel("Please choose a edition?");
		Ip_edition.setBounds(25, 50, 250,40);
		Ip_edition.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_edition);
		
		list = new List(3,false);
		list.add("iphone 12");
		list.add("iphone 13");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);
		
		
		Ip_model = new JLabel("Please choose a model?");
		Ip_model.setBounds(25,130,250,20);
		Ip_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_model);
		
		cg = new ButtonGroup();
		c1= new JRadioButton("Mini");
		c1.setBounds(25,170,75,12);
		c1.setBackground(new Color(168, 169, 173));
		c1.addItemListener(this);
		this.add(c1);
		
		c3= new JRadioButton("Pro");
		c3.setBounds(25,210,75,12);
		c3.setBackground(new Color(168, 169, 173));
		c3.addItemListener(this);
		this.add(c3);
		c4= new JRadioButton("Pro max");
		c4.setBounds(25,230,75,12);
		c4.setBackground(new Color(168, 169, 173));
		c4.addItemListener(this);
		this.add(c4);
		
		
		
		Ip_memory=new JLabel("Please choose a memory optiom?");
		Ip_memory.setBounds(25,260,250,20);
		Ip_memory.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_memory);
		cg2 = new ButtonGroup();
		c5= new JRadioButton("128GB");
		c5.setBounds(25,290,75,12);
		c5.setBackground(new Color(168, 169, 173));
		c5.addItemListener(this);
		this.add(c5);
		c6= new JRadioButton("256GB");
		c6.setBounds(25,320,75,12);
		c6.setBackground(new Color(168, 169, 173));
		c6.addItemListener(this);
		this.add(c6);
		c7= new JRadioButton("512GB");
		c7.setBounds(25,350,75,12);
		c7.setBackground(new Color(168, 169, 173));
		c7.addItemListener(this);
		this.add(c7);
		c8= new JRadioButton("1 TB");
		c8.setBounds(25,380,75,12);
		c8.setBackground(new Color(168, 169, 173));
		c8.addItemListener(this);
		this.add(c8);
		
		
		Ip_color=new JLabel("Chose a Color ");
		Ip_color.setBounds(25,410, 250,20);
		Ip_color.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_color);
		cg3 = new ButtonGroup();
		c9= new JRadioButton("RED");
		c9.setBounds(25,440,80,12);
		c9.setBackground(new Color(168, 169, 173));
		c9.addItemListener(this);
		this.add(c9);
		c10 = new JRadioButton("ROSE-GOLD");
		c10.setBounds(25,470,110,12);
		c10.setBackground(new Color(168, 169, 173));
		c10.addItemListener(this);
		this.add(c10);
		c11= new JRadioButton("BLUE");
		c11.setBounds(25,500,80,12);
		c11.setBackground(new Color(168, 169, 173));
		c11.addItemListener(this);
		this.add(c11);
		c12= new JRadioButton("SPACE GREY");
		c12.setBounds(25,530,110,12);
		c12.setBackground(new Color(168, 169, 173));
		c12.addItemListener(this);
		this.add(c12);
		
		
		b1= new JButton("DONE");
		b1.setBackground(Color.white);
		b1.setForeground(Color.DARK_GRAY);
		b1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		b1.setBounds(160,570,80,40);
		b1.addActionListener(this);
		this.add(b1);
		
		b2= new JButton("CLEAR");
		b2.setBackground(Color.GREEN);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		b2.setBounds(260,570,80,40);
		b2.addActionListener(this);
		this.add(b2);
		
		b3= new JButton("CART");
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		b3.setBounds(60,570,80,40);
		b3.addActionListener(this);
		this.add(b3);
		
		b4 = new JButton("Back to store");
		b4.setBounds(320,700,100,25);
		b4.setFont(new Font("Arial",Font.PLAIN|Font.ITALIC,10));
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		this.add(b4);
		
		Ip_output = new JLabel();
		Ip_output.setBounds(25, 630,600,40);
		Ip_output.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_output);

		Ip_price = new JLabel();
		Ip_price.setBounds(25, 680,600,40);
		Ip_price.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_price);
		
		this.revalidate();
		this.repaint();
		 this.setVisible(true);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==list)
		{
			edition=list.getSelectedItem();
			c2= new JRadioButton(edition);
			c2.setBounds(25,190,100,12);
			c2.setBackground(new Color(168, 169, 173));
			c2.addItemListener(this);
			this.add(c2);
			this.revalidate();
			this.repaint();
			 this.setVisible(true);
		}
		if(e.getSource()==b1)
		{
			if(edition==null || model==null || memory==null || Icolor==null)
			{
				System.out.println("Please select all the options");
			}
			else
			{ double iptotal= base_iphone+memory_iphone;
			getcart ob = new getcart();
            new Cartdummy(iptotal,"add");
            ob.set_Iphone(edition+model+memory+Icolor,iptotal);
            Ip_output.setText("SELECTED CHOICE:"+edition+model+memory+Icolor);
            Ip_price.setText("Rs "+iptotal);
			      
		
		}
			this.revalidate();
			this.repaint();
			 this.setVisible(true);
		}
			if(e.getSource()==b2)
			{

				this.dispose();
				new Iphone();	
			}
			if(e.getSource()==b3)
			{
				this.dispose();
				getcart oc= new getcart();
				oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
			    
			}
			if(e.getSource()==b4)
			{
				this.dispose();
				new Store();
			}
			
		}
		
	
   
	


	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(c1.isSelected()==true)
		{
		
		    model="Mini";
		   base_iphone=70000;
		}
		 if(c2.isSelected()==true)
		{
		    model="13";
		    base_iphone=90000;
		    
		}
		if(c3.isSelected()==true)
		{
		    model="Pro";
		    base_iphone=100000;
		    
		}
		if(c4.isSelected()==true)
		{
		    model="Pro Max";
		    base_iphone=120000;
		}
		
		if(c5.isSelected()==true)
		{
		
		    memory="128GB";
		    memory_iphone=0;
		     
		}
		if(c6.isSelected()==true)
		{
		    memory="256GB";
		    memory_iphone=5000;
		    
		}
		if(c7.isSelected()==true)
		{
		    memory="512GB";
		    memory_iphone=10000;
		    
		}
		if(c8.isSelected()==true)
		{
		    memory="1 TB";
		    memory_iphone=20000;
		}
		
		if(c9.isSelected()==true)
		{
		
		    Icolor="RED";
		     
		}
		if(c10.isSelected()==true)
		{
		    Icolor="ROSE-GOLD";
		    
		}
		if(c11.isSelected()==true)
		{
		    Icolor="SPACE GREY";
		    
		}
		if(c12.isSelected()==true)
		{
		    Icolor="BLUE";
		    
		}
		
	}



	public static void main(String args[])
	{
		new Iphone();
	}
  
}
