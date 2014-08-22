package swingbootstrap;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

import swingbootstrap.ui.ButtonUI;

public class Button extends JButton {

	protected Color selectColor = Color.decode("#EBEBEB");
	protected Color focusColor = Color.decode("#EBEBEB");
	protected Color disabledTextColor = Color.decode("#878787");

	private boolean isLeftNode = false;
	private boolean isRightNode = false;
	
	private ButtonGroup btnGroup = null;

	public void setSelectColor(Color selectColor) {
		this.selectColor = selectColor;
	}

	public Color getSelectColor() {
		return selectColor;
	}

	public Color getFocusColor() {
		return focusColor;
	}

	public void setFocusColor(Color focusColor) {
		this.focusColor = focusColor;
	}

	public Color getDisabledTextColor() {
		return disabledTextColor;
	}

	public void setDisabledTextColor(Color disabledTextColor) {
		this.disabledTextColor = disabledTextColor;
	}

	public boolean isLeftNode() {
		return isLeftNode;
	}

	public void setLeftNode(boolean isLeftNode) {
		this.isLeftNode = isLeftNode;
	}

	public boolean isRightNode() {
		return isRightNode;
	}

	public void setRightNode(boolean isRightNode) {
		this.isRightNode = isRightNode;
	}

	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}

	public void setBtnGroup(ButtonGroup btnGroup) {
		this.btnGroup = btnGroup;
	}

	public Button() {
		this(null, null);
		// TODO Auto-generated constructor stub
	}

	public Button(Action a) {
		this();
		setAction(a);
	}

	public Button(Icon icon) {
		this(null, icon);
	}

	public Button(String text) {
		this(text, null);
	}
	
	public Button(String text, Icon icon) {
		super(text, icon);
		
		setOpaque(false);
		
		setBackground(Color.WHITE);

		setFont(getFont().deriveFont(16f));

		setBorder(BorderFactory.createEmptyBorder());
		
		if (text == null) {
			setMargin(new Insets(0, 10, 0, 10));
		}

		ButtonUI navUI = new ButtonUI();
		setUI(navUI);

	}

}
