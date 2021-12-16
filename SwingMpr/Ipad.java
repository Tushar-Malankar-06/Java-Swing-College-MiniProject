package SwingMpr;



import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class Ipad extends JFrame implements ActionListener,ItemListener{
	
	JLabel Ip_edition,Ip_model,Ip_memory,Ip_color,output,accesories;
	JRadioButton c5,c6,c7,c8,c9,c10,c11,c12,c13;
	JCheckBox c1,c2,c3,c4;
	List list;
	ButtonGroup cg,cg1,cg2,cg3;
	JButton b1,b2,b3,b4;
	String Idcolor,Idmemory,Idedition,acc_final;
	String[] acc = new String[4]; 
	
	static String[] idbill = new String[5];
	static int z=0;
	 double fprice;
	 double base_ipad=0,a_price1=0,base_memory=0,a_price2=0,a_price3=0,a_price4=0,base_price=0;
	 
	Ipad(int z,String exceed)
	{
		 this.setSize(450,800);
		    this.setVisible(true);
		    this.setLayout(null);
		    this.getContentPane().setBackground(new Color(168, 169, 173));
		    Label l1= new Label("Exceeding:ITEM LIMIT 4");
		    new Store();
		    l1.setFont(new Font("Tahoma",Font.PLAIN,15));
		    l1.setBounds(25, 50, 250,40);
		    this.add(l1);
		    
		
	}
	 
	 
	 
	Ipad()
	{   this.setSize(650,900);
	
	    this.setLayout(null);
	    this.getContentPane().setBackground(new Color(168, 169, 173));
	    this.setTitle("Ipad");
		Ip_edition = new JLabel("Please choose a Ipad?");
		Ip_edition.setBounds(25, 50, 250,40);
		Ip_edition.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_edition);
		
		b4 = new JButton("Back to store");
		b4.setBounds(300,740,200,25);
		b4.setFont(new Font("Arial",Font.PLAIN|Font.ITALIC,16));
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		this.add(b4);
		
		
		list = new List(3,false);
		list.add("ipad mini");
		list.add("ipad (entry level)");
		list.add("ipad Air");
		list.add("Ipad Pro");
		list.setBounds(25,100,250,20);
		list.addActionListener(this);
		this.add(list);
		
		
		Ip_model = new JLabel("Please choose Your Acessories ");
		Ip_model.setBounds(25,130,250,20);
		Ip_model.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_model);
		
		
		c1= new JCheckBox("magic keyboard",false);
		c1.setBounds(25,170,250,12);
		c1.addItemListener(this);
		c1.setBackground(new Color(168, 169, 173));
		this.add(c1);
		
		c2= new JCheckBox("apple pencil 2nd generation",false);
		c2.setBounds(25,190,200,12);
		c2.addItemListener(this);
		c2.setBackground(new Color(168, 169, 173));
		this.add(c2);
		
		c3= new JCheckBox("protective case",false);
		c3.setBounds(25,210,250,12);
		c3.addItemListener(this);
		c3.setBackground(new Color(168, 169, 173));
		this.add(c3);
		c4= new JCheckBox("Screen guard",false);
		c4.setBounds(25,230,260,12);
		c4.addItemListener(this);
		c4.setBackground(new Color(168, 169, 173));
		this.add(c4);
		
		
		
		Ip_memory=new JLabel("Please choose a memory optiom?");
		Ip_memory.setBounds(25,260,250,20);
		Ip_memory.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_memory);
		cg2 = new ButtonGroup();
		c5= new JRadioButton("32GB");
		c5.setBounds(25,290,80,12);
		c5.setBackground(new Color(168, 169, 173));
		c5.addItemListener(this);
		this.add(c5);
		c6= new JRadioButton("64GB");
		c6.setBounds(25,320,80,12);
		c6.setBackground(new Color(168, 169, 173));
		c6.addItemListener(this);
		this.add(c6);
		c7= new JRadioButton("128GB");
		c7.setBounds(25,350,80,12);
		c7.setBackground(new Color(168, 169, 173));
		c7.addItemListener(this);
		this.add(c7);
		c8= new JRadioButton("512GB");
		c8.setBounds(25,380,80,12);
		c8.addItemListener(this);
		c8.setBackground(new Color(168, 169, 173));
		this.add(c8);
		cg2.add(c5);
		cg2.add(c6);
		cg2.add(c7);
		cg2.add(c8);
		
		
		Ip_color=new JLabel("Chose a Color ");
		Ip_color.setBounds(25,410, 250,20);
		Ip_color.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(Ip_color);
		cg3 = new ButtonGroup();
		c9= new JRadioButton("RED");
		c9.setBounds(25,440,180,12);
		c9.addItemListener(this);
		c9.setBackground(new Color(168, 169, 173));
		this.add(c9);
		c10 = new JRadioButton("ROSE-GOLD");
		c10.setBounds(25,470,180,12);
		c10.addItemListener(this);
		c10.setBackground(new Color(168, 169, 173));
		this.add(c10);
		c11= new  JRadioButton("BLUE");
		c11.setBounds(25,500,180,12);
		c11.addItemListener(this);
		c11.setBackground(new Color(168, 169, 173));
		this.add(c11);
		c12= new JRadioButton("SPACE GREY");
		c12.setBounds(25,530,180,12);
		c12.addItemListener(this);
		c12.setBackground(new Color(168, 169, 173));
		this.add(c12);
		cg3.add(c9);
		cg3.add(c10);
		cg3.add(c11);
		cg3.add(c12);
		
		
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
		
		output=new JLabel();
		output.setBounds(25,640,600,20);
		output.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(output);
		accesories=new JLabel();
		accesories.setBounds(25,680,600,20);
		accesories.setFont(new Font("Arial",Font.PLAIN,16));
		this.add(accesories);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==list)
			
		{
			if(list.getSelectedItem()==null)
			{
			output.setText("Please enter a Ipad Model ");
			
			}
			else
			{
				Idedition=list.getSelectedItem();
				if(Idedition.equals("ipad mini"))
				{
					base_price=40000.0;
					
				}  
				else if(Idedition.equals("ipad (entry level)"))
				{
					base_price=30000.0;
				
			    }
				else if(Idedition.equals("ipad Air"))
				{
					base_price=50000.0;
					
				}
				else if(Idedition.equals("Ipad Pro"))
				{
					base_price=90000.0;
				}
				}
			this.revalidate();
			this.repaint();
			this.setVisible(true);
				
		}
		
		if(e.getSource()==b1)
		{  
		
		if(base_price!=0.0 && base_memory!=0.0  )
			{ 
			
			//idbill[j]= Idedition+" "+Idmemory+" "+Idcolor+" "+fprice;
			fprice= base_memory+base_price+a_price1+a_price2+a_price3+a_price4;
				output.setText(Idedition+" "+Idmemory+" "+Idcolor+" "+fprice);
				accesories.setText(acc[0]+acc[1]+acc[2]+acc[3]);
				
             //Icount a =new Icount();	
             //Icount.price[1]=fprice;
             getcart ob = new getcart();
             new Cartdummy(fprice,"add");
             ob.set_Ipad(Idedition+" "+Idmemory+" "+Idcolor+"("+acc[0]+acc[1]+acc[2]+acc[3]+")", fprice);
             
             z++;
             if(z>4)
             {
            	 this.dispose();
            	 new Ipad(z,"Ipad");
            	 
            	 
             }
	         //a.setPrice(fprice,Idedition+" "+Idmemory+" "+Idcolor+"("+acc[0]+acc[1]+acc[2]+acc[3]+")");
	         //a.getPrice();y.artoutput(Idedition+" "+Idmemory+" "+Idcolor+"("+acc[0]+acc[1]+acc[2]+acc[3], fprice);
	         
	         
			}
		else
		{
			output.setText("select all options");
			
			
		}
		this.revalidate();
		this.repaint();
		this.setVisible(true);
		}
		
		if(e.getSource()==b2)
		{
			int o = list.getSelectedIndex();
			list.deselect(o);
			c1.setSelected(rootPaneCheckingEnabled);
			c2.setSelected(false);
			c3.setSelected(false);
			c4.setSelected(false);
			c5.setSelected(false);
			c6.setSelected(false);
			c7.setSelected(false);
			c8.setSelected(false);
			c9.setSelected(false);
			c10.setSelected(false);
			c11.setSelected(false);
			c12.setSelected(false);
			this.dispose();
			new Ipad();
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
		
		    acc[0]="Magic keyboard  ";
		   a_price1=7000;
		}
		if(c1.isSelected()==false)
		{
		
		    acc[0]=" ";
		   a_price1=0;
		}
		
		if(c2.isSelected()==true)
		{
		    acc[1]="apple pencil 2nd generation  ";
		    a_price2=8000;
		    
		}
		if(c2.isSelected()==false)
		{
		
		    acc[1]=" ";
		   a_price2=0;
		}
		if(c3.isSelected()==true)
		{
		    acc[2]="protective Case  ";
		    a_price3=1000;
		    
		}
		if(c3.isSelected()==false)
		{
		
		    acc[2]=" ";
		   a_price3=0;
		}
		if(c4.isSelected()==true)
		{
		    acc[3]="Screen Guard";
		    a_price4=1000;
		}
		if(c4.isSelected()==false)
		{
		
		    acc[3]=" ";
		   a_price4=0;
		}
		if(c1.isSelected()==false && c2.isSelected()==false && c3.isSelected()==false && c4.isSelected()==false)
		{
			accesories.setText("Acessories: None");
			
		}
		
		if(c5.isSelected()==true)
		{
		
		    Idmemory="32GB";
		    base_memory=0.01;
		     
		}
		if(c6.isSelected()==true)
		{
		    Idmemory="64GB";
		    base_memory=5000.0;
		    
		}
		if(c7.isSelected()==true)
		{
		    Idmemory="128GB";
		    base_memory=10000.0;
		    
		}
		if(c8.isSelected()==true)
		{
		    Idmemory="512GB";
		    base_memory=20000.0;
		}
		
		/*if(c8.isSelected()==false && c7.isSelected()==false && c6.isSelected()==false && c5.isSelected()==false)
		{
			output.setText("select all options");
			
		}*/
		if(c9.isSelected()==true)
		{
		
		    Idcolor="RED";
		     
		}
		if(c10.isSelected()==true)
		{
		    Idcolor="ROSE-GOLD";
		    
		}
		if(c11.isSelected()==true)
		{
		    Idcolor="SPACE GREY";
		    
		}
		if(c12.isSelected()==true)
		{
		    Idcolor="BLUE";
		    
		}
		/*if(c9.isSelected()==false && c10.isSelected()==false && c11.isSelected()==false && c12.isSelected()==false)
		{
			output.setText("Select all options");
		}*/
		
	}
   
	
	
	


	public static void main(String[] args)
	{
		new Ipad();
	}
}