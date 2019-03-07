package DatabaseTest;

import java.sql.*;
import java.awt.*;
import java.io.Console;
import javax.swing.*;
import javax.swing.event.*;

public class VLookup extends JApplet {
	String dbUrl = "jdbc:mysql://localhost:3306/javatest";
	String user = "root";
	String password = "wl";
	Statement s;
	JTextField searchFor = new JTextField(20);
	JLabel completion = new JLabel("                        ");
	JTextArea results = new JTextArea(40, 20);
	

	public void init() {
		searchFor.getDocument().addDocumentListener(new SearchL());
		JPanel p = new JPanel();
		p.add(new Label("Last name to search for:"));
		p.add(searchFor);
		p.add(completion);
		Container cp = getContentPane();
		cp.add(p, BorderLayout.NORTH);
		cp.add(results, BorderLayout.CENTER);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(dbUrl, user, password);
			s = c.createStatement();
		} catch (Exception e) {
			results.setText(e.toString());
		}
	}

	class SearchL implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
		}

		public void insertUpdate(DocumentEvent e) {
			textValueChanged();
		}

		public void removeUpdate(DocumentEvent e) {
			textValueChanged();
		}
	}

	public void textValueChanged() {
		ResultSet r;
		if (searchFor.getText().length() == 0) {
			return;
		}
		try {
			r = s.executeQuery("SELECT LAST FROM  people "
					+ "WHERE (LAST Like '" + searchFor.getText()
					+ "%') ORDER BY LAST");
			if (r.next())
				completion.setText(r.getString("last"));
			r = s.executeQuery("SELECT FIRST, LAST, EMAIL " + "FROM people "
					+ "WHERE (LAST='" + completion.getText()
					+ "') AND (EMAIL Is Not Null) " + "ORDER BY FIRST");
		} catch (Exception e) {
			results.setText(searchFor.getText() + "\n");
			results.append(e.toString());
			return;
		}
		results.setText("");
		try {
			while (r.next()) {
				results.append(r.getString("Last") + ", "
						+ r.getString("fIRST") + ": " + r.getString("EMAIL")
						+ "\n");
			}
		} catch (Exception e) {
			results.setText(e.toString());
		}
	}

	public static void main(String[] args) {
		VLookup vl = new VLookup();
	}
}
