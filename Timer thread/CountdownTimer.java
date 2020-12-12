/**
 * Document  : CountdownTimer.java
 * Created on: 03-04-2020, 11:06:56 PM
 * Author    : Nivesh-GC
 */

package thread;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;

public class CountdownTimer implements Runnable
{
	JTextField tf;
	JLabel label;
	JFrame jf;
	
	public void run()
	{
		buildGUI();
	}
	
	public void buildGUI()
	{
		jf = new JFrame("Countdown Timer");
		JPanel jp = new JPanel();
		label = new JLabel("");
		tf = new JTextField(15); //shows 15 characters at a time
		tf.setEnabled(false);
		Font f = new Font("Verdana", 0, 20);
		tf.setFont(f);
		tf.setBackground(Color.BLACK);	//frame background
		jp.setBackground(Color.blue);		//panel background
		
		jf.add(jp);	//add panel
		jp.add(tf);	//add TextField
		jp.add(label);	//add label
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300,100);
		jf.setResizable(false);
		
		display();
	}//end buildGUI
	
	void display()
	{
		for(int i = 60; i >= 0; i--)
		{
			try
			{
				Thread.sleep(1000);	//delay of 1 second
				String s = Integer.toString(i); 	//typecasting variable: i
				tf.setText("  " + s + " seconds to go...");
			}//end try
			catch(Exception e)
			{
				System.out.println(e);
			}//end catch
		}//end for
		JOptionPane.showMessageDialog(jf, "Time up !! !!!");
		tf.setText("");
		tf.setEnabled(false);
	}//end display()
	
	
	
	//---------------------Main---------------------
	public static void main(String args[])
	{
		CountdownTimer obj = new CountdownTimer();
		Thread CountdownThread = new Thread(obj);
		CountdownThread.start();
	}
}
