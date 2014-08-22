package swingbootstrap;

import java.awt.Color;

import javax.swing.JFrame;

public class Form extends JFrame {

	public Form() {
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(UIConfig.getDefaultAppIcon());

		getContentPane().setBackground(Color.WHITE);
	}

}
