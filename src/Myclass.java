
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Myclass extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3929404820971625718L;
	private JButton[]buttonNum;
	private static  String names[]={"7","8","9","AC","OFF","4","5","6","+","-","1","2","3","*","/","0",".","Ans","%","="};
	//private static final String[]name={"Blue","","Green","Pink","Orange"};
	//private static final Color[] color={Color.BLUE,Color.CYAN,Color.GREEN,Color.ORANGE};
	//private static final Color[]colors={Color.CYAN,Color.YELLOW,Color.BLUE,Color.GREEN};
	private JPanel panel1;
	private JPanel namespanel;
	private JTextField display;
	boolean a=false;
	boolean[]operator=new boolean[5]; 
	double tempory[]={0,0};
	double total;
	public Myclass()
	{
		super("SN Calculator");
		JMenu menu1=new JMenu("File",true);
		JMenuItem mi1=new JMenuItem("New");
		JMenuItem mi2=new JMenuItem("Save");
		JMenuItem mi3=new JMenuItem("Exit");
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.add(mi3);
		mi1.addActionListener(this);
		mi2.setEnabled(false);
		mi3.addActionListener(this);
		mi1.setActionCommand("New");
		mi2.setActionCommand("Exit");
		JMenu menu2=new JMenu("User",true);
		JMenuItem item[]=new JMenuItem[5];
		item[0]=new JMenuItem("UserAbout");
		item[0].addActionListener(this);
		menu2.add(item[0]);
		JMenu menu2_1=new JMenu("Formula");
		menu2_1.addActionListener(this);
		menu2_1.setActionCommand("Formula");
		JMenuItem menu2_1_1=new JMenuItem("Simple");
		JMenuItem menu2_1_2=new JMenuItem("Advance");
		menu2_1_1.addActionListener(this);
		menu2_1_2.addActionListener(this);
		menu2_1_1.setActionCommand("Simple");
		menu2_1_2.setActionCommand("Advance");
		menu2_1.add(menu2_1_1);
		menu2_1.add(menu2_1_2);
		menu2.addSeparator();
		menu2.add(menu2_1);
		menu2.addSeparator();
		for(int count=1;count<item.length;count++)
		{
			
			item[count]=new JMenuItem("Theme "+(count));
			
			item[count].addActionListener(this);
			
			menu2.add(item[count]);
		}
		item[0].setActionCommand("UserAbout");
		item[1].setEnabled(false);
		item[2].setEnabled(false);
		item[3].setEnabled(false);
		item[4].setEnabled(false);
		JMenu menu3=new JMenu("About",true);
		JMenuItem aboutCalculator=new JMenuItem("Calculator");
		JMenuItem aboutMe=new JMenuItem("ME");
		aboutCalculator.addActionListener(this);
		aboutMe.addActionListener(this);
		aboutCalculator.setActionCommand("Calculator");
		aboutMe.setActionCommand("ME");
		menu3.add(aboutCalculator);
		menu3.add(aboutMe);
		JMenuBar menubar=new JMenuBar();
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.setBackground(Color.cyan);
		setJMenuBar (menubar);
		panel1=new JPanel();
		display=new JTextField(20);
		display.setFont(new Font("Courier",Font.PLAIN,16));
	    display.setHorizontalAlignment(JTextField.RIGHT);
		display.setText("");
		display.setEditable(false);
		display.setBackground(Color.LIGHT_GRAY);
		panel1.add(display);
		add(panel1,BorderLayout.NORTH);
		buttonNum=new JButton[names.length];
		namespanel=new JPanel();
		namespanel.setLayout(new GridLayout(4,5,1,1));
		Insets button=new Insets(6,10,6,10);
		//operatorpanel=new JPanel();
		//operatorpanel.setLayout(new GridLayout(5,1));
		for(int count=0;count<names.length;count++)
		{
			buttonNum[count]=new JButton(names[count]);
			buttonNum[count].setBackground(Color.BLACK);
			buttonNum[count].setForeground(Color.WHITE);
			buttonNum[count].setFont(new Font("Courier",Font.ITALIC,13));
			namespanel.add(buttonNum[count]);
			buttonNum[count].setMargin(button);
			buttonNum[count].addActionListener(this);
		}
		buttonNum[3].setForeground(Color.RED);
		buttonNum[4].setForeground(Color.RED);
		buttonNum[17].setForeground(Color.GREEN);
		buttonNum[19].setForeground(Color.GREEN);
		buttonNum[8].setForeground(Color.orange);
		buttonNum[9].setForeground(Color.orange);
		buttonNum[13].setForeground(Color.orange);
		buttonNum[14].setForeground(Color.orange);
		buttonNum[18].setForeground(Color.orange);
		add(namespanel,BorderLayout.WEST);
		for(int i=0;i<=4;i++)
		{
			operator[i]=false;
		}
		addWindowListener(
				new WindowAdapter()
					{
					public void windowClosing(WindowEvent e)
						{
							System.exit(0);
						}
					}
				);
		
	}
	public void clear()
	{
		try{
			display.setText("0");
			display.requestFocus();
			for(int i=0;i<4;i++)
			{
			  operator[i]=false;
			}
			for(int i=0;i<2;i++)
			{
				tempory[i]=0;
			}
		}
		catch(NullPointerException e)
		{
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if (s == "Exit")
   			System.exit(0);
   			
		if(s=="Clear")
		{
			clear();
		}
		if (s=="Calculator")
   		{
   			String m = "Calculator ver. 1.0\nOpenExhibit Software(JavaBased)\nCopyright 2014\nAll rights reserved";
   			JOptionPane.showMessageDialog(null,m, "About Calculator", JOptionPane.INFORMATION_MESSAGE);
   		}
		if(s=="ME")
		{
			String message = "Name:Sree Narayan Chakraborty\nStudying in Computer Science & Telecommunication Engineering\n7th Batch\nNoakhali Science & Technology University\n\n" +
					"Email:narayanchakraborty1993@gmail.com"
					;
   			JOptionPane.showMessageDialog(null,message, "About Calculator", JOptionPane.INFORMATION_MESSAGE);
		}
			if(s=="UserAbout")
			{
				   boolean c=true;
			    String name=JOptionPane.showInputDialog(null, "Ask for user Name (returns a String)",
			            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
			    int student=JOptionPane.showConfirmDialog(null, "Are You a Student (returns an int)",
			            "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
			    String school = null;
			    switch (student) {
		         case JOptionPane.YES_OPTION:{
		            System.out.println("You clicked YES");
		            school=JOptionPane.showInputDialog(null, "Ask for your School Name (returns a String)",
				            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		               c=false;
		            break;}
		         case JOptionPane.NO_OPTION:
		            System.out.println("You clicked NO"); break;
		         case JOptionPane.CANCEL_OPTION:
		            System.out.println("You clicked Cancel");
		            break;
			    }
		            if(!c)
		        	JOptionPane.showMessageDialog(null,"Name:"+name+"\nStudent of "+school, "About Calculator", JOptionPane.INFORMATION_MESSAGE);
		           else
		            	JOptionPane.showMessageDialog(null,name, "About Calculator", JOptionPane.INFORMATION_MESSAGE);
			}
			if(s=="Simple")
			{
					String m= "Basic Formula:\n"+
						"1.(x + y)2 = x^2 + 2xy + y^2\n"+
						 "2.(x - y)2 = x^2 - 2xy + y^2 \n"+
						"3.(x2 – y2) = (x + y) (x – y) \n"+
						 "4.(x - y)3 = x^3 – 3x^2 y + 3xy^2 - y^3 \n"+
						"5.(x + y)3 = x^3 + 3x^2y + 3xy^2 + y^3 ";
                      JOptionPane.showMessageDialog(null,m,"SimpleFormula",JOptionPane.INFORMATION_MESSAGE);
				}
			if(s=="Advance")
			{
				
				String w;
				try {
					w = "Exponent laws:\n"+
 " 1.(x^ m)(y^n) = y^(m + n)\n"+
"2. (xy)^m = (x^m)(y^m)\n"+
"3. (x^m)^n = x^mn\n"+
"4. x^0 = 1 \n"+
"5. (x^m)/(y^n) = x^(m – n) \n"+
"6. x -m = 1 / (x m)\n"+
"Area Of a Circle: A=πr^2 \n"+
"Expansion of a Sum:(1+x)^n=1+nx/1!+(n(n-1) x^2)/2!+⋯\n"+
"Phythagorean formula:a^2+b^2=c^2 \n"+
"Quadratic formula:         x=(-b±√(b^2-4ac))/2a \n"+

  " Taylor Expansion:	e^x=1+x/1!+x^2/2!+x^3/3!+⋯,-∞<x<∞  \n";
					 JOptionPane.showMessageDialog(null,w,"AdvanceFormula",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					  
				}
				
				
			}
		String input=display.getText();
		
		if(e.getSource()==buttonNum[0])
		{
			display.setText(input+"7");
		}
		if(e.getSource()==buttonNum[1])
		{
			display.setText(input+"8");
		}
		if(e.getSource()==buttonNum[2])
		{
			display.setText(input+"9");
		}
		if(e.getSource()==buttonNum[4])
		{
			System.exit(0);
		}
		if(e.getSource()==buttonNum[5])
		{
			display.setText(input+"4");
		}
		if(e.getSource()==buttonNum[6])
		{
			display.setText(input+"5");
		}
		if(e.getSource()==buttonNum[7])
		{
			display.setText(input+"6");
		}
		if(e.getSource()==buttonNum[10])
		{
			display.setText(input+"1");
		}
		if(e.getSource()==buttonNum[11])
		{
			display.setText(input+"2");
		}
		if(e.getSource()==buttonNum[12])
		{
			display.setText(input+"3");
		}	
		if(e.getSource()==buttonNum[15])
		{
			display.setText(input+"0");
		}
		if(e.getSource()==buttonNum[16])
		{
			display.setText(input+".");
		}
		if(input.equals(names[8])||input.equals(names[9])||input.equals(names[13])||input.equals(names[14])||input.equals(names[18]))
		{
			clear();
		}
		else
		{
			try{
				if(e.getSource()==buttonNum[8])
				{
					//add function
					tempory[0]=Double.parseDouble(display.getText());
					operator[0]=true;
					display.setText("");
				}
				if(e.getSource()==buttonNum[9])
				{
					//subtract function
					tempory[0]=Double.parseDouble(display.getText());
					operator[1]=true;
					display.setText("");
				}
				if(e.getSource()==buttonNum[13])
				{
					tempory[0]=Double.parseDouble(display.getText());
					operator[2]=true;
					display.setText("");
				}
				if(e.getSource()==buttonNum[14])
				{
					tempory[0]=Double.parseDouble(display.getText());
					operator[3]=true;
					display.setText("");
				}
				if(e.getSource()==buttonNum[18])
				{
					tempory[0]=Double.parseDouble(display.getText());
					operator[4]=true;
					display.setText("");
				}
				if((e.getSource()==buttonNum[19]||e.getSource()==buttonNum[17]))
				 {
						tempory[1]=Double.parseDouble(display.getText());
				    	if(operator[0]==true)
				    	{
				    		total=tempory[0]+tempory[1];
				    	}
				    	else if(operator[1]==true)
				    	{
				    		total=tempory[0]-tempory[1];
				    	}
				    	else if(operator[2]==true)
				  		{
				    		total=tempory[0]*tempory[1];
				  		}
				    	else if(operator[3]==true)
				    	{
				    		total=tempory[0]/tempory[1];
				    	}
				    	else if(operator[4]==true)
				    	{
				    		total=tempory[0]%tempory[1];
				    	}
				    	display.setText(""+total);
			      }
			
				if(e.getSource()==buttonNum[3])
				{
					clear();
				}
			}
			catch(NumberFormatException e1)
			{
				clear();
				//display.setText("Error");
			}
		}
		
		/*
		if(e.getSource()==buttonNum[17])
		{
			getResult();
		}*/
		
}
}
