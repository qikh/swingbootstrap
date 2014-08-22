package swingbootstrap.util;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;

public class SwingUtil {

	/**
	 * Detect if the application is running on Linux platform.
	 * 
	 * @return true if is running on Linux.
	 */
	public static boolean isLinux() {
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().contains("linux")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Detect if the application is running on Windows platform.
	 * 
	 * @return true if is running on Windows.
	 */
	public static boolean isWindows() {
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().contains("windows")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get screen size for specific Window.
	 * 
	 * @param wnd
	 *            Window on the screen.
	 * @return size of the screen.
	 */
	public static Rectangle getScreenSize(Window wnd) {
		Rectangle sb;

		if (wnd == null) {
			sb = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
					.getBounds();
		} else {
			sb = wnd.getGraphicsConfiguration().getBounds();
		}

		return sb;
	}

	/**
	 * Get screen insets (menu bar or tool bar) for specific Window.
	 * 
	 * @param wnd
	 *            Window on the screen.
	 * @return size of the screen.
	 */
	public static Insets getScreenInsets(Window wnd) {
		Insets si;

		if (wnd == null) {
			si = Toolkit.getDefaultToolkit().getScreenInsets(
					GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
							.getDefaultConfiguration());
		} else {
			si = wnd.getToolkit().getScreenInsets(wnd.getGraphicsConfiguration());
		}
		return si;
	}

	/**
	 * Set the Window to full screen.
	 * 
	 * @param wnd
	 *            the Window.
	 */
	public static void fullScreen(Window wnd) {
		Rectangle screenBounds = SwingUtil.getScreenSize(wnd);
		wnd.setBounds(screenBounds);
	}

	/**
	 * Move the Window to center of screen.
	 * 
	 * @param wnd
	 *            the Window.
	 */
	public static void centerOnScreen(Window wnd) {
		Rectangle screenBounds = SwingUtil.getScreenSize(wnd);
		wnd.setBounds((int) (screenBounds.getWidth() - wnd.getWidth()) / 2,
				(int) (screenBounds.getHeight() - wnd.getHeight()) / 2, wnd.getWidth(), wnd.getHeight());
	}

	/**
	 * Move the Window to center of parent Window.
	 * 
	 * @param wnd
	 *            the Window.
	 */
	public static void centerOnParent(Window wnd) {
		Container parent = wnd.getParent();

		if (parent != null) {
			Point parentPosition = parent.getLocationOnScreen();
			wnd.setLocation(parentPosition.x + (parent.getWidth() - wnd.getWidth()) / 2,
					parentPosition.y + (parent.getHeight() - wnd.getHeight()) / 2);
		} else {
			centerOnScreen(wnd);
		}
	}

	/**
	 * If translucent was supported on the OS. Low end PC running on Linux may
	 * not support translucent feature.
	 * 
	 * @return true if translucent was supported.
	 */
	public static boolean isTranslucentSupported() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		boolean isUniformTranslucencySupported = gd
				.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT);
		return isUniformTranslucencySupported;
	}

	/**
	 * Set the Window to transparent window.
	 * 
	 * @param wnd
	 *            the Window.
	 */
	public static void setWindowTransparent(Window wnd) {
		if (SwingUtil.isTranslucentSupported()) {
			wnd.setBackground(new Color(0, 0, 0, 0));
		}
	}
	
	public BufferedImage toCompatibleImage(BufferedImage image) {
		// obtain the current system graphical settings
		GraphicsConfiguration gfx_config = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		/*
		 * if image is already compatible and optimized for current system
		 * settings, simply return it
		 */
		if (image.getColorModel().equals(gfx_config.getColorModel()))
			return image;

		// image is not optimized, so create a new image that is
		BufferedImage new_image = gfx_config.createCompatibleImage(image.getWidth(), image.getHeight(),
				image.getTransparency());

		// get the graphics context of the new image to draw the old image on
		Graphics2D g2d = (Graphics2D) new_image.getGraphics();

		// actually draw the image and dispose of context no longer needed
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		// return the new optimized image
		return new_image;
	}
}
