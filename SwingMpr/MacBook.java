package SwingMpr;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.event.ActionListener;

public class MacBook extends JFrame implements ActionListener,ItemListener{
	
	JLabel MB_edition,MB_model,MB_memory,MB_color,MB_selected_choice,MB_price;  
	JRadioButton c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	List list; 
	ButtonGroup cg,cg1,cg2,cg3;
	JButton b1,b2,b3,b4; 
	String model,Mac_color,memory,edition;
	double base_macbook,memory_macbook,price;
	MacBook()
	{   this.setSize(500,800);
	    this.setTitle("Macbook");
	    this.setLayout(null);
	    this.getContentPane().setBackground(new Color(168, 169, 173));
		MB_edition = new JLabel("Please choose a edition");
		MB_edition.setBounds(25, 50, 250,40);
		MB_edition.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_edition);
		
		list = new List(3,false);
		list.add("M1");
		list.add("Intel i7");
		list.add("Intel i9");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);
		
		
		MB_model = new JLabel("Choose a model");
		MB_model.setBounds(25,130,250,20);
		MB_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_model);
		
		cg = new ButtonGroup();
		c1= new JRadioButton("Air");
		c1.setBounds(25,170,50,12);
		c1.setBackground(new Color(168, 169, 173));
		c1.addItemListener(this);
		this.add(c1);
		
		c3= new JRadioButton("Pro");
		c3.setBounds(25,210,50,12);
		c3.setBackground(new Color(168, 169, 173));
		c3.addItemListener(this);
		this.add(c3);
		
		
		MB_selected_choice= new JLabel();
		MB_selected_choice.setBounds(25,650, 400,20);
		this.add(MB_selected_choice);
		
		
		
		
		
		MB_memory=new JLabel("Choose a memory option");
		MB_memory.setBounds(25,260,250,20);
		MB_memory.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_memory);
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
		
		
		MB_color=new JLabel("Choose a Color ");
		MB_color.setBounds(25,410, 250,20);
		MB_color.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(MB_color);
		cg3 = new ButtonGroup();
		c9= new JRadioButton("SILVER");
		c9.setBounds(25,440,80,12);
		c9.setBackground(new Color(168, 169, 173));
		c9.addItemListener(this);
		this.add(c9);
		c10 = new JRadioButton("ROSE-GOLD");
		c10.setBounds(25,470,120,12);
		c10.setBackground(new Color(168, 169, 173));
		c10.addItemListener(this); 
		this.add(c10);
		c11= new JRadioButton("SPACE GREY");
		c11.setBounds(25,500,120,12);
		c11.setBackground(new Color(168, 169, 173));
		c11.addItemListener(this);
		this.add(c11);
		//c12= new Checkbox("SPACE GREY",cg3,false);
		//c12.setBounds(25,530,80,12);
		//c12.addItemListener(this);
		//this.add(c12);
		
		
		b1= new JButton("DONE");
		b1.setBackground(Color.white);
		b1.setForeground(Color.DARK_GRAY);
		b1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		b1.setBounds(160,570,80,40);
		b1.addActionListener(this);
		this.add(b1);
		
		b2= new JButton("CART");
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		b2.setBounds(60,570,80,40);
		b2.addActionListener(this);
		this.add(b2);
		
		b3= new JButton("CLEAR");
		b3.setBackground(Color.GREEN);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,12));
		b3.setBounds(260,570,80,40);
		b3.addActionListener(this);
		this.add(b3);
		
		b4 = new JButton("Back to store");
		b4.setBounds(320,700,100,25);
		b4.setFont(new Font("Arial",Font.PLAIN|Font.ITALIC,10));
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		this.add(b4);
		
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
		}
		if(e.getSource()==b1)
		{
			if(edition==null || model==null || memory==null || Mac_color==null)
			{
				MB_selected_choice.setText("Please select all the options ");
				//MB_selected_choice.setBounds(25,650, 400,20);
				MB_selected_choice.setFont(new Font("Arial",Font.PLAIN,16));
				//this.add(MB_selected_choice);
			}
			else
			{   System.out.println("Selected Choice : Macbook"+" "+edition+" "+model+" "+memory+" "+Mac_color+price);
				MB_selected_choice.setText("Selected Choice : Macbook"+" "+edition+" "+model+" "+memory+" "+Mac_color);
				//MB_selected_choice.setBounds(25,650, 450,20);
				System.out.println("Selected Choice : Macbook"+" "+edition+" "+model+" "+memory+" "+Mac_color);
				MB_selected_choice.setFont(new Font("Arial",Font.PLAIN,16));
				//this.add(MB_selected_choice);
				double mactotal= base_macbook+memory_macbook;
				getcart ob = new getcart();
	            new Cartdummy(price,"add");
	            ob.set_Macbook(edition+" " +model+" "+memory+" "+Mac_color+" ",price);
				MB_price=new JLabel("Price : "+price); 
				MB_price.setBounds(25,700, 450,20);
				MB_price.setFont(new Font("Arial",Font.PLAIN,16));
				this.add(MB_price);
			
		} 
		}
		
		if(e.getSource()==b2)
		{
			getcart oc= new getcart();
			oc.create_Frame(getcart.id, getcart.ap, getcart.mc, getcart.ip, getcart.idcost, getcart.ipcost, getcart.mccost, getcart.apcost);
		    
		}    
		if(e.getSource()==b3)
		{
			this.dispose();
			new MacBook();
		}
		if(e.getSource()==b4)
		{
			this.dispose();
			new Store();
		}
		//this.revalidate();
		//this.repaint();
		 //this.setVisible(true);
		
	}
   
	 


	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(c1.isSelected()==true)
		{
		
		    model="AIR";
		   base_macbook=70000;
		}
		if(c2.isSelected()==true)
		{
		    model="M1";
		    base_macbook=90000;
		    
		}
		if(c3.isSelected()==true)
		{
		    model="Pro";
		    base_macbook=100000;
		    
		}
		
		
		if(c5.isSelected()==true)
		{
		
		    memory="128GB";
		    memory_macbook=0;
		     
		}
		if(c6.isSelected()==true)
		{
		    memory="256GB";
		    memory_macbook=5000;
		    
		}
		if(c7.isSelected()==true)
		{
		    memory="512GB";
		    memory_macbook=10000;
		    
		}
		if(c8.isSelected()==true)
		{
		    memory="1 TB";
		    memory_macbook=20000;
		    
		}
		
		if(c9.isSelected()==true)
		{
		
		    Mac_color="SILVER";
		     
		}
		if(c10.isSelected()==true)
		{
		    Mac_color="ROSE-GOLD";
		    
		}
		if(c11.isSelected()==true)
		{
		    Mac_color="SPACE GREY";
		    
		}
		//if(c12.getState()==true)
		//{
		//    Mac_color="BLUE";
		    
		//}
		
		price=base_macbook+memory_macbook;
		
	}



	public static void main(String[] args)
	{
		new MacBook();
	}

}
