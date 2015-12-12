package me.zed.easyreport;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class MainReporter extends JFrame {

	private JFrame frame;
	private JComboBox<String> comboBoxPerm;
	private JTextArea textAreaResult;
	private TextArea textAreaProof;
	private JComboBox<String> comboBoxColor;
	private JLabel lblName;
	private JLabel lblProof;
	private JLabel lblOffense;
	private JLabel lblDoYouGive;
	private JComboBox<String> comboBoxRank;
	private JLabel lblRank;
	private TextArea textAreaName;
	private JComboBox<String> comboTitle;
	private JComboBox<String> comboOffense;
	private JLabel commentlbl;
	private TextArea commenttxt;
	private JLabel lblMadeByProfessorzed;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainReporter window = new MainReporter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainReporter() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("EasyReport Tool for Hypixel Players v2.2");
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.setBounds(100, 100, 825, 570);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 java.net.URL url = this.getClass().getResource("logo2.png");
		 Toolkit kit = Toolkit.getDefaultToolkit();
		 Image img2 = kit.createImage(url);
		 frame.setIconImage(img2);


		JButton btnNewButton = new JButton("Click when ready!");
		btnNewButton.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name, proof, comboperm, comborank, combotitle, combooffense, txtcomment;
				name = textAreaName.getText();
				txtcomment = commenttxt.getText();
				combooffense = comboOffense.getSelectedItem().toString();
				proof = textAreaProof.getText();
				comboperm = comboBoxPerm.getSelectedItem().toString();
				comborank = comboBoxRank.getSelectedItem().toString();
				combotitle = comboTitle.getSelectedItem().toString();
				System.out.println(combotitle + name + combooffense + proof + comboperm + txtcomment);
				textAreaResult.setText(String.format(
						"[LIST][*][B][COLOR=#0000ff]In-Game Name: \r\n [/COLOR][/B]%s %s[/COLOR][/LIST]%n"
								+ "[LIST][*][B][COLOR=#0000ff]Reason: \r\n [/COLOR][/B]%s[/LIST]%n"
								+ "[LIST][*][B][COLOR=#0000ff]Evidence: \r\n [/COLOR][/B][URL]%s[/URL][/LIST]%n"
								+ "[LIST][*][B][COLOR=#0000ff]Do you give us permission to share your proof: \r\n [/COLOR][/B]%s[/LIST]%n"
								+ "\r\n" + "[" + combotitle + "] " + name,
						getFormattedRank(comborank), name, combooffense + " " + txtcomment, proof, comboperm,
						combotitle));

				String myString = textAreaResult.getText();
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null,
						"Report copied to clipboard!" + "\r\n" + "Use CTRL + V for easy paste ;)");
				textAreaName.setText("");
				textAreaProof.setText("");
				comboOffense.setSelectedItem("Offense:");
				comboBoxRank.setSelectedItem("Default");
				comboBoxPerm.setSelectedItem("Yes.");
				comboTitle.setSelectedItem("Title");
				textAreaResult.setText("");
				commenttxt.setText("");
			}
		});

		JButton forums = new JButton("Forums");
		forums.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		forums.setBounds(342, 474, 145, 35);
		frame.getContentPane().add(forums);
		forums.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		JButton imgur = new JButton("Imgur");
		imgur.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		imgur.setBounds(497, 474, 145, 35);
		frame.getContentPane().add(imgur);
		imgur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});

		JButton Youtube = new JButton("Youtube");
		Youtube.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		Youtube.setBounds(652, 474, 145, 35);
		frame.getContentPane().add(Youtube);
		Youtube.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});

		btnNewButton.setBounds(10, 462, 322, 58);
		frame.getContentPane().add(btnNewButton);

		textAreaName = new TextArea();
		textAreaName.setBounds(10, 67, 322, 42);
		frame.getContentPane().add(textAreaName);

		textAreaProof = new TextArea();
		textAreaProof.setBounds(10, 205, 322, 42);
		frame.getContentPane().add(textAreaProof);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(SystemColor.desktop);
		lblName.setBounds(140, 38, 46, 14);
		frame.getContentPane().add(lblName);

		lblProof = new JLabel("Proof");
		lblProof.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProof.setForeground(SystemColor.desktop);
		lblProof.setBounds(140, 185, 39, 14);
		frame.getContentPane().add(lblProof);

		lblOffense = new JLabel("Offense");
		lblOffense.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOffense.setForeground(SystemColor.desktop);
		lblOffense.setBounds(140, 253, 58, 14);
		frame.getContentPane().add(lblOffense);

		lblDoYouGive = new JLabel("Do you give the staff permission to share your proof?");
		lblDoYouGive.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoYouGive.setForeground(new Color(0, 0, 0));
		lblDoYouGive.setBackground(Color.WHITE);
		lblDoYouGive.setBounds(10, 392, 345, 14);
		frame.getContentPane().add(lblDoYouGive);

		lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRank.setForeground(SystemColor.desktop);
		lblRank.setBounds(140, 115, 46, 14);
		frame.getContentPane().add(lblRank);

		comboBoxPerm = new JComboBox<String>();
		comboBoxPerm.setModel(new DefaultComboBoxModel<String>(new String[] { "Yes.", "No." }));
		comboBoxPerm.setToolTipText("");
		comboBoxPerm.setBounds(14, 417, 318, 34);
		frame.getContentPane().add(comboBoxPerm);

		comboTitle = new JComboBox<String>();
		comboTitle.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Inappropriate chat", "Hacking", "Teaming" }));
		comboTitle.setToolTipText("Title");
		comboTitle.setBounds(342, 36, 151, 35);
		frame.getContentPane().add(comboTitle);

		textAreaResult = new JTextArea();
		textAreaResult.setBackground(Color.WHITE);
		textAreaResult.setForeground(Color.BLACK);
		textAreaResult.setEditable(false);
		textAreaResult.setBounds(481, 111, 318, 269);
		textAreaResult.setColumns(10);
		frame.getContentPane().add(textAreaResult);

		comboBoxRank = new JComboBox<String>();
		comboBoxRank.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Mutliple Ranks", "Default", "VIP", "VIP+", "MVP", "MVP+" }));
		comboBoxRank.setToolTipText("Rank");
		comboBoxRank.setBounds(10, 140, 322, 34);
		frame.getContentPane().add(comboBoxRank);

		JLabel label = new JLabel("");
		label.setBackground(SystemColor.menu);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(342, 53, 798, 391);
		frame.getContentPane().add(label);
		Image img = new ImageIcon(this.getClass().getResource("Hypixel.png")).getImage();
		label.setIcon(new ImageIcon(img));

		comboBoxColor = new JComboBox<String>();
		comboBoxColor.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Original (Black)", "Red", "Blue", "Green" }));
		comboBoxColor.setBounds(563, 36, 122, 20);
		frame.getContentPane().add(comboBoxColor);

		JLabel lblColors = new JLabel("Colors:");
		lblColors.setBounds(610, 11, 46, 14);
		frame.getContentPane().add(lblColors);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxColor.getSelectedItem().toString() == "Original (Black)") {
					lblName.setForeground(Color.BLACK);
					lblProof.setForeground(Color.BLACK);
					lblOffense.setForeground(Color.BLACK);
					lblDoYouGive.setForeground(Color.BLACK);
					lblRank.setForeground(Color.BLACK);
					JOptionPane.showMessageDialog(null, "Changed colors to the original " + "\r\n" + "Color (Black)");
				}
				if (comboBoxColor.getSelectedItem().toString() == "Red") {
					lblName.setForeground(Color.RED);
					lblProof.setForeground(Color.RED);
					lblOffense.setForeground(Color.RED);
					lblDoYouGive.setForeground(Color.RED);
					lblRank.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "Changed colors to Red.");
				}
				if (comboBoxColor.getSelectedItem().toString() == "Blue") {
					lblName.setForeground(Color.BLUE);
					lblProof.setForeground(Color.BLUE);
					lblOffense.setForeground(Color.BLUE);
					lblDoYouGive.setForeground(Color.BLUE);
					lblRank.setForeground(Color.BLUE);
					JOptionPane.showMessageDialog(null, "Changed colors to Blue.");
				}
				if (comboBoxColor.getSelectedItem().toString() == "Green") {
					lblName.setForeground(Color.GREEN);
					lblProof.setForeground(Color.GREEN);
					lblOffense.setForeground(Color.GREEN);
					lblDoYouGive.setForeground(Color.GREEN);
					lblRank.setForeground(Color.GREEN);

					JOptionPane.showMessageDialog(null, "Changed colors to Green.");
				}
			}
		});
		btnConfirm.setBounds(695, 36, 89, 23);
		frame.getContentPane().add(btnConfirm);

		JLabel lblThreadTitle = new JLabel("Thread Title");
		lblThreadTitle.setBounds(384, 11, 69, 14);
		frame.getContentPane().add(lblThreadTitle);

		comboOffense = new JComboBox();
		comboOffense.setModel(
				new DefaultComboBoxModel(new String[] { "Inappropriate chat.", "Hacking.", "Teaming in Solo." }));
		comboOffense.setToolTipText("Offense:");
		comboOffense.setBounds(10, 278, 322, 35);
		frame.getContentPane().add(comboOffense);

		commenttxt = new TextArea();
		commenttxt.setBounds(10, 352, 322, 42);
		frame.getContentPane().add(commenttxt);

		commentlbl = new JLabel("Comment for the offense.");
		commentlbl.setHorizontalAlignment(SwingConstants.CENTER);
		commentlbl.setForeground(Color.BLACK);
		commentlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		commentlbl.setBackground(Color.WHITE);
		commentlbl.setBounds(10, 332, 345, 14);
		frame.getContentPane().add(commentlbl);

		lblMadeByProfessorzed = new JLabel("Made by Professor_Zed");
		lblMadeByProfessorzed.setFont(new Font("AR DECODE", Font.PLAIN, 21));
		lblMadeByProfessorzed.setBounds(610, 506, 187, 25);
		frame.getContentPane().add(lblMadeByProfessorzed);
	}

	private String getFormattedRank(String rank) {
		switch (rank.toLowerCase()) {
		case "default":
			return "[COLOR=#AAAAAA][Default]";
		case "vip":
			return "[COLOR=#55FF55][VIP]";
		case "vip+":
			return "[COLOR=#55FF55][VIP[/COLOR][COLOR=#FFAA00]+[/COLOR][COLOR=#55FF55]]";
		case "mvp":
			return "[COLOR=#55FFFF][MVP]";
		case "mvp+":
			return "[COLOR=#55FFFF][MVP[/COLOR][COLOR=#FF5555]+[/COLOR][COLOR=#55FFFF]]";
		case "mutliple ranks":
			return "[COLOR=#404040]";
		default:
			return rank;
		}
	}
}