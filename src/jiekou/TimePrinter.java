package jiekou;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimePrinter implements ActionListener{//¶¯×÷¼àÌý

	public static void main(String[] args) {
		
		var listener = new TimePrinter();
		var timer = new Timer(1000,listener);
		timer.start();
		
		 
		JOptionPane.showMessageDialog(null, "Quit program");
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("at the tone,this tiem is "+Instant.ofEpochMilli(e.getWhen()));
		System.out.println("at the tone,this tiem is "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(e.getWhen())));
		Toolkit.getDefaultToolkit().beep();
	}


}
