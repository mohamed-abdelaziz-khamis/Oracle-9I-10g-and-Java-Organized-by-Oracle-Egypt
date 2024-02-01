import	java.awt.*;
import	java.awt.event.*;
import	javax.swing.*;

public class MyInterface extends JFrame
{
	JLabel lab;
	JButton btn1,btn2,btn3;
	JPanel p1;
	MyInterface()
	{
		super("Apply Interfaces");

		p1 = (JPanel)getContentPane();
		p1.setLayout(new FlowLayout());
		lab = new JLabel();
		btn1 = new JButton("Windows");
		btn2 = new JButton("Motif");
		btn3 = new JButton("Metal");

		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);

		btn1.addActionListener(new btn1handler());
		btn2.addActionListener(new btn2handler());
		btn3.addActionListener(new btn3handler());
	}

	class btn1handler implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				SwingUtilities.updateComponentTreeUI(MyInterface.this);
			}
			catch (Exception e)
			{};
		}
	}

	class btn2handler implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				SwingUtilities.updateComponentTreeUI(MyInterface.this);
			}
			catch (Exception e)
			{};
		}
	}
	
	class btn3handler implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			try
			{
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				SwingUtilities.updateComponentTreeUI(MyInterface.this);
			}
			catch (Exception e)
			{};
		}
	}
}