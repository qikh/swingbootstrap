package swingbootstrap;

import java.awt.Component;

import javax.swing.JScrollPane;

import swingbootstrap.ui.ScrollBarUI;

public class ScrollPane extends JScrollPane {

	public ScrollPane() {
		this(null, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

	public ScrollPane(Component view) {
		this(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

	public ScrollPane(int vsbPolicy, int hsbPolicy) {
		this(null, vsbPolicy, hsbPolicy);
	}

	public ScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		
		this.getVerticalScrollBar().setUI(new ScrollBarUI());
		this.getHorizontalScrollBar().setUI(new ScrollBarUI());
		
		this.getVerticalScrollBar().setUnitIncrement(16);
	}

}
