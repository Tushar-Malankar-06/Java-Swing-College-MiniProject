package SwingMpr;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.event.ActionListener;


public class Thank_you  extends JFrame implements ActionListener {
	
	
	JLabel l1;
	JButton b1,b2;
	
	Thank_you()
	{
	
	

	
		    this.setSize(550,450);
		   
		    this.setLayout(null);
		    this.getContentPane().setBackground(Color.orange);
		    
		    
		    
		    l1 =new JLabel("THANK YOU FOR SHOPPING WITH US");
			l1.setFont(new Font("Tahoma",Font.BOLD,25));
			l1.setForeground(Color.BLACK);
			l1.setBackground(Color.white);
			l1.setBounds(30,125,550,50);
			l1.setVisible(true);
			this.add(l1);
			
			
			
			b2 = new JButton("EXIT");
			b2.setFont(new Font("Tahoma",Font.BOLD,15));
			b2.setForeground(Color.RED);
			b2.setBackground(Color.black);
			b2.setBounds(225,250,100,20);
			b2.addActionListener(this);;
			this.add(b2);		
			
			this.revalidate();
			this.repaint();
			 this.setVisible(true);
			
			
			
			
	}
	
	
		    
		   
@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			System.exit(0);		}
		
	   }




public static void main(String[] args) {
	new Thank_you();
}
	

}

