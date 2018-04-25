package panel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame panel = new JFrame("Byte Coins");
		panel.setContentPane(new GamePanel());
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
		panel.setResizable(true);	
		panel.pack();	
		panel.setLocationRelativeTo(null);
	}
}
