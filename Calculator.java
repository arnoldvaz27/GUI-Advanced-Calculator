import java.awt.event.*;
import java.awt.*;

class Calculator extends Frame implements ActionListener
{
	TextField tf;
	int st=1,op=0;
	Label lb;
	int opr;
	double val1,val2;
	
	public Calculator()
	{
		setLayout(new FlowLayout());
		setFont(new Font("Arial",Font.BOLD,14));
	
		tf = new TextField(30);
		tf.setEditable(false);
		tf.setFont(new Font("Comic Sans MS",Font.BOLD,20));

		lb = new Label("ON");
		lb.setForeground(Color.red);
	
		Button btn1 = new Button("1");
		Button btn2 = new Button("2");
		Button btn3 = new Button("3");
		Button btn4 = new Button("4");
		Button btn5 = new Button("5");
		Button btn6 = new Button("6");
		Button btn7 = new Button("7");
		Button btn8 = new Button("8");
		Button btn9 = new Button("9");
		Button btn10 = new Button("0");
		Button btn11 = new Button(".");
		Button btn12 = new Button("=");
		Button btn13 = new Button("+");
		Button btn14 = new Button("-");
		Button btn15 = new Button("*");
		Button btn16 = new Button("/");
		Button btn17 = new Button("SQRT");
		Button btn18 = new Button("FACTO");
		Button btn19 = new Button("sin");
		Button btn20 = new Button("cos");
		Button btn21 = new Button("tan");
		Button btn22 = new Button("CLR");
		Button btn23 = new Button("BKSP");
		Button btn24 = new Button("ON/OFF");

		add(tf);
		add(btn1);add(btn2);add(btn3);add(btn4);add(btn5);add(btn6);add(btn7);add(btn8);add(btn9);add(btn10);add(btn11);add(btn12);add(btn13);			add(btn14);add(btn15);add(btn16);add(btn17);add(btn18);add(btn19);add(btn20);add(btn21);add(btn22);add(btn23);add(btn24);add(lb);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);
		btn17.addActionListener(this);
		btn18.addActionListener(this);
		btn19.addActionListener(this);
		btn20.addActionListener(this);
		btn21.addActionListener(this);
		btn22.addActionListener(this);
		btn23.addActionListener(this);
		btn24.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		
		if(s.equals("ON/OFF"))
		{
			if(op%2==1)
			{
				st=1;
				op++;
				tf.setEnabled(true);
				lb.setText("ON");
			}
			
			else
			{
				st=2;
				op++;
				tf.setEnabled(false);
				tf.setText("");
				lb.setText("OFF");				
			}

		}
		if(st==1)
		{
			if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || 					s.equals("9") || s.equals("0"))
		 	{	
				Button bt = (Button)e.getSource();
				tf.setText(tf.getText() + "" + bt.getLabel());
			}
			
			if(s.equals("."))
			{
				String t;
				t=tf.getText();
				int ind = t.indexOf(".");
				boolean b =ind ==-1 ? true:false;
				if(b)
				{
					tf.setText(tf.getText()+".");
				}
			}
			if(s.equals("+"))
			{
				val1 = Double.parseDouble(tf.getText());
				opr=1;
				tf.setText("");
			}
			if(s.equals("-"))
			{
				val1 = Double.parseDouble(tf.getText());
				opr=2;
				tf.setText("");
			}
			if(s.equals("*"))
			{
				val1 = Double.parseDouble(tf.getText());
				opr=3;
				tf.setText("");
			}
			if(s.equals("/"))
			{
				val1 = Double.parseDouble(tf.getText());
				opr=4;
				tf.setText("");
			}
			if(s.equals("="))
			{
				val2 = Double.parseDouble(tf.getText());
				String t;
				switch(opr)
				{
					case 1: t = "" + (val1+val2);		
						if(t.endsWith(".0"))
						{
							t = "" + t.substring(0,t.length() -2);
						}
						tf.setText(t);
					break;
					case 2: t = "" + (val1-val2);		
						if(t.endsWith(".0"))
						{
							t = "" + t.substring(0,t.length() -2);
						}
						tf.setText(t);
					break;
					case 3: t = "" + (val1*val2);		
						if(t.endsWith(".0"))
						{
							t = "" + t.substring(0,t.length() -2);
						}
						tf.setText(t);
					break;
					case 4: t = "" + (val1/val2);		
						if(t.endsWith(".0"))
						{
							t = "" + t.substring(0,t.length() -2);
						}
						tf.setText(t);
					break;
				}
			}
			if(s.equals("CLR"))
			{
				tf.setText("");
			}
			if(s.equals("FACTO"))
			{	
				String t;
				t=tf.getText();
				int ind = t.indexOf(".");
				boolean b = ind == -1 ? false:true;
				if(b)
				{
					tf.setText("Invalid");
				}
				else
				{
					int n = Integer.parseInt(tf.getText());
					long f = 1;
					int i ;
					for (i=1;i<=n;i++)
					{
						f=f*i;	
					}
					tf.setText(""+f);
				}
			}
			if(s.equals("SQRT"))
			{
				val1 = Double.parseDouble(tf.getText());
				double res = Math.sqrt(val1);
				tf.setText(""+res);
			}
			if(s.equals("sin"))
			{
				val1 = Double.parseDouble(tf.getText());
				double res = Math.sin(val1);
				tf.setText(""+res);
			}
			if(s.equals("cos"))
			{
				val1 = Double.parseDouble(tf.getText());
				double res = Math.cos(val1);
				tf.setText(""+res);
			}
			if(s.equals("tan"))
			{
				val1 = Double.parseDouble(tf.getText());
				double res = Math.tan(val1);
				tf.setText(""+res);
			}
			if(s.equals("BKSP"))
			{
				String t = tf.getText();
				tf.setText(t.substring(0,t.length()-1));
			}
		}
	}
	public static void main(String args[])
	{
		Calculator fr = new Calculator();
		fr.setSize(400,400);
		fr.setVisible(true);
		fr.setTitle("My Calculator");
	}
}