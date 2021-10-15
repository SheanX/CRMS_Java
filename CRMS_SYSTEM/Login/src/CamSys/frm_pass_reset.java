package CamSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import CamSys.Database;
import CamSys.LoginData;
import CamSys.logS;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frm_pass_reset extends JFrame {

	// declare variables
	private String uID = "";
	private String userName = "";

	// private String uuu="";
	// private String uuu =logS.txtusername.getText();

	// txt_uname_out.setText(String.valueOf(uuu));
	// txt_uname_out.text()=logS.txtusername.getText();;

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;
	private JPasswordField passwordField_5;
	private JTextField txt_uname_out;
	private JPasswordField txt_cu_pass;
	private JPasswordField txt_new_pass;
	private JPasswordField txt_re_new_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_pass_reset frame = new frm_pass_reset();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_pass_reset() {

//		setValues();  

		setTitle("Password Reset Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 0, 0);
		label_5.setText("Username");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_5);

		JLabel label_6 = new JLabel();
		label_6.setBounds(0, 0, 0, 0);
		label_6.setText("Current Password");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_6);

		JLabel label_7 = new JLabel();
		label_7.setBounds(0, 0, 0, 0);
		label_7.setText("New Password");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_7);

		JLabel label_8 = new JLabel();
		label_8.setBounds(0, 0, 0, 0);
		label_8.setText("Re-type new Password");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_8);

		textField_1 = new JTextField();
		textField_1.setBounds(0, 0, 0, 0);
		textField_1.setText("<dynamic>");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		// setValues();

		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(0, 0, 0, 0);
		passwordField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(passwordField_3);

		passwordField_4 = new JPasswordField();
		passwordField_4.setBounds(0, 0, 0, 0);
		passwordField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(passwordField_4);

		passwordField_5 = new JPasswordField();
		passwordField_5.setBounds(0, 0, 0, 0);
		passwordField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(passwordField_5);

		JButton button_2 = new JButton();
		button_2.setBounds(0, 0, 0, 0);
		button_2.setText("Clear");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(button_2);

		JButton button_3 = new JButton();
		button_3.setBounds(0, 0, 0, 0);
		button_3.setText("Reset Password");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(button_3);

		JLabel label_9 = new JLabel();
		label_9.setBounds(5, 5, 789, 0);
		contentPane.add(label_9);

		JLabel label = new JLabel();
		label.setText("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(189, 131, 144, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel();
		label_1.setText("Current Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(189, 182, 157, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel();
		label_2.setText("New Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(189, 237, 126, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel();
		label_3.setText("Re-type new Password");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(189, 293, 208, 14);
		contentPane.add(label_3);

		txt_uname_out = new JTextField();
		txt_uname_out.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_uname_out.setEditable(false);
		txt_uname_out.setBounds(428, 128, 173, 20);
		contentPane.add(txt_uname_out);
		//setValues();

		txt_cu_pass = new JPasswordField();
		txt_cu_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_cu_pass.setBounds(428, 179, 173, 20);
		contentPane.add(txt_cu_pass);

		txt_new_pass = new JPasswordField();
		txt_new_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_new_pass.setBounds(428, 234, 173, 20);
		contentPane.add(txt_new_pass);

		txt_re_new_pass = new JPasswordField();
		txt_re_new_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_re_new_pass.setBounds(428, 290, 173, 20);
		contentPane.add(txt_re_new_pass);

		 setValues();

		JButton btn_clr = new JButton();
		btn_clr.setBackground(Color.PINK);
// clear button click event
		btn_clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});

		btn_clr.setText("Clear");
		btn_clr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_clr.setBounds(428, 375, 112, 23);
		contentPane.add(btn_clr);

		JButton btn_re_pass = new JButton();
		btn_re_pass.setBackground(Color.CYAN);

// reset button click event
		btn_re_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// TODO add your handling code here:
				if (checkNotEmpty()) {
					try {
						String uID = LoginData.getUserIDD();
						String uName = txt_uname_out.getText();
						String currPass = LoginData.encrypt(txt_cu_pass.getText());
						String newPass1 = LoginData.encrypt(txt_new_pass.getText());
						String newPass2 = LoginData.encrypt(txt_re_new_pass.getText());

						Database db = new Database();
						String query = "SELECT u_id FROM user WHERE u_name = '" + uName + "' AND u_pass = '" + currPass
								+ "' ";
						java.sql.ResultSet rs = db.GetData(query);

						rs.next();
						int row = rs.getRow();

					//	if (row > 0 && uID.equals(rs.getString("u_id"))) {
						if (row > 0 ) {
							if (newPass1.equals(newPass2)) {
								String newPass = newPass1;

								db = new Database();
								query = "UPDATE user SET u_pass = '" + newPass + "' WHERE u_id = '" + uID + "' ";
								int rows = db.Save_Del_Update(query);

								if (rows > 0) {
									
									JOptionPane.showMessageDialog(null, "Password Reset Sucessful !");
								
									dispose();
				
									
									String args[] = {};
									logS.main(args);
									

								} else {
									
									JOptionPane.showMessageDialog(null, "Password Reset Unsuccesful ", "Try Again",
											JOptionPane.ERROR_MESSAGE);

								}
							} else {
							
								JOptionPane.showMessageDialog(null, "Password doesnt match", "Retype password",
										JOptionPane.ERROR_MESSAGE);

							}
						} else {
						
							javax.swing.JOptionPane.showMessageDialog(null, "Invalid current password", "Error",
									javax.swing.JOptionPane.WARNING_MESSAGE);

						}
						clearText();

					} catch (java.sql.SQLException e1) {
						javax.swing.JOptionPane.showMessageDialog(null, e1.getMessage(), "SQL Exception",
								javax.swing.JOptionPane.WARNING_MESSAGE);
					}

				}

			}

		});
		btn_re_pass.setText("Reset Password");
		btn_re_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_re_pass.setBounds(250, 375, 144, 23);
		contentPane.add(btn_re_pass);

		JLabel label_4 = new JLabel();
		label_4.setBounds(463, 87, 0, 0);
		contentPane.add(label_4);
	}

//function to clear text fields
	private void clearText() {
		txt_cu_pass.setText("");
		txt_new_pass.setText("");
		txt_re_new_pass.setText("");
	}

//function to get username from login form 
	private void setValues() {

		userName = logS.lg.getUserName();
		txt_uname_out.setText(userName);
		uID = logS.lg.getUserID();


	}

//function to confirm fields are not empty
	private boolean checkNotEmpty() {
		boolean notEmpty = true;
		String reason = "";
		if (uID.trim().isEmpty()) {
			notEmpty = false;
			reason = "User ID not set";
		}
		if (txt_uname_out.getText().trim().isEmpty()) {
			notEmpty = false;
			reason = "User Name not set";
		}
		if (txt_cu_pass.getText().trim().isEmpty()) {
			notEmpty = false;
			reason = "Current Password is Empty";
		}
		if (txt_new_pass.getText().trim().isEmpty()) {
			notEmpty = false;
			reason = "New Password is Empty";
		}
		if (txt_re_new_pass.getText().trim().isEmpty()) {
			notEmpty = false;
			reason = "Re-tyoe new Password";
		}
		if (!notEmpty) {
			javax.swing.JOptionPane.showMessageDialog(null, reason, "Empty", javax.swing.JOptionPane.WARNING_MESSAGE);
		}
		return notEmpty;

	}
}
