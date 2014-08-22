package swingbootstrap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import swingbootstrap.util.SwingUtil;

public class SwingBootstrap {

	private Form form;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingBootstrap window = new SwingBootstrap();
					window.form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingBootstrap() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UIConfig.loadConfig();

		form = new Form();
		form.setPreferredSize(new Dimension(1366, 768));
		form.pack();
		SwingUtil.centerOnScreen(form);

		form.getContentPane().setLayout(new MigLayout("fill", "[fill]", "[fill]"));

		// Create ScrollPane.
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBorder(null);
		form.getContentPane().add(scrollPane, "cell 0 0");

		// Create the main panel and put to scroll pane.
		JPanel mainPanel = new JPanel();
		scrollPane.setViewportView(mainPanel);
		mainPanel.setLayout(new MigLayout("gap 0, insets 0", "[100%]", "[70][fill]"));

		// Create the navigation panel.
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.WHITE);
		navigationPanel.setLayout(new MigLayout("gap 0, insets 0", "[10%][80%][]", "[100%]"));
		mainPanel.add(navigationPanel, "cell 0 0 1 1, grow");

		// Create the content panel.
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new MigLayout("gap 0, ins 0", "[100%]", "[fill]"));
		mainPanel.add(contentPanel, "cell 0 1 1 1, grow");

		WelcomePanel welcomePanel = new WelcomePanel();

		// Construct the navigation links.
		Font navLinkFont = new Font("Arial", Font.BOLD, 14);
		List<JComponent> navLinkList = new ArrayList<JComponent>();

		// Create navbar and add to the panel.
		Navbar navbar = new Navbar("Swing Bootstrap");
		navigationPanel.add(navbar, "cell 1 0 1 1, grow");

		navbar.setBorder(null);
		navbar.setForeground(UIConfig.getBrandColor());
		navbar.setFont(new Font("Arial", Font.BOLD, 16));
		navbar.setBackground(Color.WHITE);

		// 1) Welcome Link.
		Navlink welcomeLink = new Navlink("Welcome", contentPanel, welcomePanel);
		welcomeLink.setForeground(UIConfig.getBrandColor());
		welcomeLink.setFont(navLinkFont);
		welcomeLink.route(); // Route to the link.
		navLinkList.add(welcomeLink);

		// 2) Getting Started Link.
		Navlink startLink = new Navlink("Getting Started");
		startLink.setForeground(UIConfig.getBrandColor());
		startLink.setFont(navLinkFont);
		navLinkList.add(startLink);

		// 3) Components Link.
		Navlink componentsLink = new Navlink("Components", contentPanel, new ComponentsPanel());
		componentsLink.setForeground(UIConfig.getBrandColor());
		componentsLink.setFont(navLinkFont);
		navLinkList.add(componentsLink);

		// 4) Customize Link.
		Navlink customizeLink = new Navlink("Customize");
		customizeLink.setForeground(UIConfig.getBrandColor());
		customizeLink.setFont(navLinkFont);
		navLinkList.add(customizeLink);

		// 5) Expo Link.
		Navlink expoLink = new Navlink("Expo");
		expoLink.setForeground(UIConfig.getBrandColor());
		expoLink.setFont(navLinkFont);
		expoLink.setNavigationAlignment(Navlink.ALIGN_RIGHT);
		navLinkList.add(expoLink);

		// 6) Exit Link.
		Navlink exitLink = new Navlink("Quit");
		exitLink.setForeground(UIConfig.getBrandColor());
		exitLink.setFont(navLinkFont);
		exitLink.setNavigationAlignment(Navlink.ALIGN_RIGHT);
		exitLink.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				form.dispose();
			}
		});
		navLinkList.add(exitLink);

		// Set navigation link.
		navbar.setNavLinkList(navLinkList);
	}

}
