package swingbootstrap;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swingbootstrap.ui.NavlinkUI;

public class Navlink extends JButton {

	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_RIGHT = 1;

	private Navbar navbar;
	private boolean isLeftNode = false;
	private int navigationAlignment = ALIGN_LEFT;

	private JLabel titleLabel;
	
	private JPanel containerPanel;
	private JPanel linkPanel;

	public Navbar getNavbar() {
		return navbar;
	}

	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}

	public int getNavigationAlignment() {
		return navigationAlignment;
	}

	public void setNavigationAlignment(int alignment) {
		this.navigationAlignment = alignment;
	}

	public boolean isLeftNode() {
		return isLeftNode;
	}

	public void setLeftNode(boolean isLeftNode) {
		this.isLeftNode = isLeftNode;
	}

	public JPanel getContainerPanel() {
		return containerPanel;
	}

	public void setContainerPanel(JPanel containerPanel) {
		this.containerPanel = containerPanel;
	}

	public JPanel getLinkPanel() {
		return linkPanel;
	}

	public void setLinkPanel(JPanel linkPanel) {
		this.linkPanel = linkPanel;
	}
	
	public Navlink(String title) {
		this(title, null, null, null);
	}

	public Navlink(Icon icon) {
		this(null, icon, null, null);
	}
	
	public Navlink(String title, JPanel containerPanel, JPanel linkPanel) {
		this(title, null, containerPanel, linkPanel);
	}
	
	public Navlink(Icon icon, JPanel containerPanel, JPanel linkPanel) {
		this(null, icon, containerPanel, linkPanel);
	}

	public Navlink(String title, Icon icon, JPanel containerPanel, JPanel linkPanel) {
		super(title, icon);
		this.containerPanel = containerPanel;
		this.linkPanel = linkPanel;

		setOpaque(false);

		setBackground(Color.decode("#F6F6F6"));

		setFont(getFont().deriveFont(16f));

		setBorder(BorderFactory.createEmptyBorder());
		
		setMargin(new Insets(0, 8, 0, 8));

		NavlinkUI navUI = new NavlinkUI();
		setUI(navUI);

		// Change text color to darker color and change cursor to hand cursor
		// when hover.
		addMouseListener(new MouseListener() {
			private Color colorSave;
			private int cursorSave;

			public void mouseEntered(MouseEvent e) {
				colorSave = Navlink.this.getForeground();
				cursorSave = Navlink.this.getCursor().getType();
				Navlink.this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				Navlink.this.setForeground(Navlink.this.getForeground().darker());
			}

			public void mouseExited(MouseEvent e) {
				Navlink.this.setForeground(colorSave);
				Navlink.this.setCursor(Cursor.getPredefinedCursor(cursorSave));
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				route();
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	@Override
	public void setForeground(Color fg) {
		super.setForeground(fg);

		if (this.titleLabel != null) {
			this.titleLabel.setForeground(fg);
		}
	}
	
	public void route() {
		if (containerPanel != null && linkPanel != null) {
			containerPanel.removeAll();
			containerPanel.add(linkPanel, "grow");
			containerPanel.revalidate();
			containerPanel.repaint();
		}
	}
}
