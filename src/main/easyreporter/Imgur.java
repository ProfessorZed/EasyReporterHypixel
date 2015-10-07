package easyreporter;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class Imgur extends JFrame {

	public Imgur() {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("http://imgur.com/");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
	}

	public static void main(String[] args) {
		Imgur linkTest = new Imgur();
		linkTest.setSize(640,100);
		linkTest.setVisible(true);
	}
}