package easyreporter;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class Youtube extends JFrame {

	public Youtube() {

					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("https://www.youtube.com/upload");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
	}

	public static void main(String[] args) {
		Youtube linkTest = new Youtube();
		linkTest.setSize(640,100);
		linkTest.setVisible(true);
	}
}