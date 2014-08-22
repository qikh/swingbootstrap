package swingbootstrap;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import swingbootstrap.ui.RoundRectBorder;

public class WelcomePanel extends JPanel{

	public WelcomePanel() {
		setLayout(new MigLayout("gap 0, insets 0", "[100%]", "[600][200]"));
		
		Color navLinkColor = Color.decode("#583F7E");
		
		JPanel brandPanel = new JPanel();
		brandPanel.setBackground(navLinkColor);
		brandPanel.setLayout(new MigLayout("gap 0, insets 0", "[100%]", "[10%][20%]6%[15%]5%[12%]3%[5%][]"));
		add(brandPanel, "cell 0 0 1 1, grow");

		JLabel logoLabel = new JLabel("S");
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setFont(new Font("Sans", Font.PLAIN, 120));
		logoLabel.setBorder(new RoundRectBorder(Color.WHITE, 1, 30));
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		brandPanel.add(logoLabel, "cell 0 1 1 1, gapleft 44%, gapright 45%, grow");

		JLabel motoLabel = new JLabel(
				"<html><center>The most popular front-end framework for developing responsive,<br> mobile like projects on the desktop.</center></html>");
		motoLabel.setForeground(Color.WHITE);
		motoLabel.setFont(new Font("Arial", Font.PLAIN, 32));
		motoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		brandPanel.add(motoLabel, "cell 0 2 1 1, grow, gapleft 10%, gapright 10%");

		JLabel downloadLabel = new JLabel("<html><center>Download Bootstrap</center></html>");
		downloadLabel.setForeground(Color.WHITE);
		downloadLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		downloadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		downloadLabel.setBorder(new RoundRectBorder(Color.WHITE, 1, 10));
		brandPanel.add(downloadLabel, "cell 0 3 1 1, grow, gapleft 40%, gapright 40%");

		JLabel versionLabel = new JLabel("Currently v0.1");
		versionLabel.setForeground(Color.decode("#846CAF"));
		versionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		brandPanel.add(versionLabel, "cell 0 4 1 1, grow, gapleft 40%, gapright 40%");

		JLabel designLabel = new JLabel(
				"<html><center><font color=#484848 size=7>Designed for everyone, everywhere.</font><br><font color=gray size=5>Bootstrap makes front-end web development faster and easier. It's made for folks of all skill levels, devices of all shapes, and projects of all sizes.</font></center></html>");
		designLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(designLabel, "cell 0 1 1 1, grow, gapleft 20%, gapright 20%");
	}
}
