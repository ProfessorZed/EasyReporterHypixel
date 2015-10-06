package easyreporter;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;


public class Forums extends JFrame {

	public Forums() {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("https://hypixel.net/forums/report-abuse-hackers.37/create-thread");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
	}
	public static void main(String[] args) {
		Forums linkTest = new Forums();
		linkTest.setSize(640,100);
		linkTest.setVisible(true);
	}
}