package CamSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import com.sun.net.ssl.internal.ssl.Provider;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.security.Security;
import java.sql.ResultSet;


public class Frm_Reset_Pass extends JFrame {
	
	// declare variables 
		private String uID = "";
		private String userName = "";
		int randomCode;

		    
		
	//	private JTextField txt_uname_out;
	//	private JPasswordField txt_cu_pass;
	//	private JPasswordField txt_new_pass;
	//	private JPasswordField txt_re_new_pass;
	
	private JPanel ResetPanel;
	private JTextField txtUname;
	private JPasswordField txt_new_passs;
	private JPasswordField txt_re_new_passd;
	private JTextField txtmailx;
	private JTextField txt_secu_code;
	private JTextField txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Reset_Pass frame = new Frm_Reset_Pass();
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
	public Frm_Reset_Pass() {
		setTitle("E-Mail Verification Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 578);
		ResetPanel = new JPanel();
		ResetPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ResetPanel);
		ResetPanel.setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(102, 84, 144, 14);
		ResetPanel.add(label);
		
		JLabel lblSecurityCode = new JLabel();
		lblSecurityCode.setText("Security Code");
		lblSecurityCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSecurityCode.setBounds(102, 233, 157, 14);
		ResetPanel.add(lblSecurityCode);
		
		JLabel label_2 = new JLabel();
		label_2.setText("New Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(102, 360, 126, 14);
		ResetPanel.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Re-type new Password");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(102, 411, 208, 14);
		ResetPanel.add(label_3);
		
		txtUname = new JTextField();
		txtUname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUname.setBounds(344, 81, 173, 20);
		ResetPanel.add(txtUname);
		
		txt_new_passs = new JPasswordField();
		txt_new_passs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_new_passs.setBounds(344, 357, 173, 20);
		ResetPanel.add(txt_new_passs);
		
		txt_re_new_passd = new JPasswordField();
		txt_re_new_passd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_re_new_passd.setBounds(344, 408, 173, 20);
		ResetPanel.add(txt_re_new_passd);
		
		txtmailx = new JTextField();
		txtmailx.setEnabled(false);
		txtmailx.setEditable(false);
		txtmailx.setVisible(false);
		txtmailx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmailx.setBounds(188, 81, 151, 20);
		ResetPanel.add(txtmailx);
		
		JButton btn_send_code = new JButton();
// Send Code Button Click Event
		btn_send_code.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisibilityResetHide();
				try{ //txt_secu_code.setEnabled(false);
					 String Umail="";
					 String Unamex = txtUname.getText();
					 Database db = new Database();
		                String query = "SELECT email FROM user WHERE u_name='"+Unamex+"'";
		                ResultSet rs = db.GetData(query);
		                
		                rs.next();
		                int rows = rs.getRow();
		                
		                if (rows>0)
		                {
		                	Umail = rs.getString("email");
		                	txtmailx.setText(Umail);
		                }
					
					Random rand = new Random();
					randomCode=rand.nextInt(999999);
				
					//txts.setText("");
					
					
					String host = "smtp.gmail.com";
					String user ="peramenuu2001@gmail.com";
					String pass="shehan97";
					String to = txtmailx.getText();
					String subject="CRMS System Account Reseting Code";
					String message ="Your CRMS account reset code is "+randomCode;
					
					boolean sessionDebug = false;

					Properties pros = System.getProperties();
					
		/*			pros.put("mail.smtp.starttls.enable", "true");
				//	pros.put("mail.smtp.starttls.required", "true");
					pros.put("mail.smtp.host", "host");
					pros.put("mail.smtp.port","587");
					pros.put("mail.smtp.auth","true");
					pros.put("mail.smtp.starttls.required", "true");
		*/
					    pros.setProperty("mail.transport.protocol", "smtp");     
					    pros.setProperty("mail.host", "smtp.gmail.com");  
					    pros.put("mail.smtp.auth", "true");  
					    pros.put("mail.smtp.port", "465");  
					    pros.put("mail.debug", "true");  
					    pros.put("mail.smtp.socketFactory.port", "465");  
					    pros.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
					    pros.put("mail.smtp.socketFactory.fallback", "false"); 
					
					java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
					
					Session mailSession = Session.getDefaultInstance(pros, null);
					mailSession.setDebug(sessionDebug);
					Message msg = new MimeMessage(mailSession);
					msg.setFrom(new InternetAddress(user));
					
					InternetAddress [] address = {new InternetAddress(to)};
					msg.setRecipients(Message.RecipientType.TO, address);
					msg.setSubject(subject);
					msg.setText(message);
					
					Transport transport = mailSession.getTransport("smtp");
					transport.connect(host, user, pass);
					transport.sendMessage(msg, msg.getAllRecipients());
					transport.close();
					
					JOptionPane.showMessageDialog(null, "Verification code has been send to the user's email");
					txt_secu_code.setEnabled(true);
					}catch(Exception ex){
					
					JOptionPane.showMessageDialog(rootPane, ex);
					
					}
				
			}
		});
		btn_send_code.setText("Send Code");
		btn_send_code.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_send_code.setBounds(166, 129, 144, 23);
		ResetPanel.add(btn_send_code);
		
		JButton btn_clr = new JButton();
// Clear Button click Event
		btn_clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUname.setText("");
			}
		});
		btn_clr.setText("Clear");
		btn_clr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_clr.setBounds(327, 131, 112, 23);
		ResetPanel.add(btn_clr);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(70, 59, 474, 109);
		ResetPanel.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_1.setBounds(70, 206, 474, 109);
		ResetPanel.add(horizontalBox_1);
		
		JButton btnSubmitcode = new JButton();
// Code Submit button click event
		btnSubmitcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Integer.valueOf(txt_secu_code.getText()).equals(randomCode)){
					JOptionPane.showMessageDialog(null, "Verification Succssful, Please create a new password");
					setVisibilityResetShow();
				}
				else {
					JOptionPane.showMessageDialog(null, "Verification Unsuccessful, Re-enter the code");
				}
			}
		});
		btnSubmitcode.setText("Submit Code");
		btnSubmitcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmitcode.setBounds(166, 274, 144, 23);
		ResetPanel.add(btnSubmitcode);
		
		JButton btnClr1 = new JButton();
// Security code clear button click event
		btnClr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txt_secu_code.setText("");
			}
		});
		btnClr1.setText("Clear");
		btnClr1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClr1.setBounds(327, 274, 112, 23);
		ResetPanel.add(btnClr1);
		
		JButton btnResetPassword = new JButton();
// Password Reset Button click Event
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			            try
			            {
			                //String uID = Login.getUserID();
			                String uName = txtUname.getText();
			               // String currPass = txt_secu_code.getText();
			                String newPass1 = LoginData.encrypt(txt_new_passs.getText());
			                String newPass2 = LoginData.encrypt(txt_re_new_passd.getText());
			                
			                Database db = new Database();
			                String query = "SELECT u_id FROM user WHERE u_name = '"+uName+"' ";
			                java.sql.ResultSet rs = db.GetData(query);
			                
			                rs.next();
			                int row = rs.getRow();
			                
			                if(row>0)
			                {
			                	uID=rs.getString("u_id");
			                    if(newPass1.equals(newPass2))
			                    {
			                        String newPass = newPass1;
			                        
			                        db = new Database();
			                        query = "UPDATE user SET u_pass = '"+newPass+"' WHERE u_id = '"+uID+"' ";
			                        int rows = db.Save_Del_Update(query);
			                        
			                        if (rows>0)
			                        {
			           
			                        	JOptionPane.showMessageDialog( null, "Password Reset Sucessful !" );
			                        	String args[] = {};
			            				logS.main(args);
			            				dispose();
			                            
			                        }
			                        else
			                        {
			                      
			                        	 JOptionPane.showMessageDialog(null, "Password Reset Unsuccesful ","Try Again",JOptionPane.ERROR_MESSAGE);
			                            
			                        }
			                    }
			                    else
			                    {
			               
			                    	 JOptionPane.showMessageDialog(null, "Password doesnt match","Retype password",JOptionPane.ERROR_MESSAGE);
			                        
			                    }
			                }
			                else
			                {
			
			                    javax.swing.JOptionPane.showMessageDialog(null, 
			                              "Invalid current password", 
			                              "Error", 
			                              javax.swing.JOptionPane.WARNING_MESSAGE);
			                    
			                }
			                clearText();
			            
			                
			            }
			            catch (java.sql.SQLException e1)
			            {
			                javax.swing.JOptionPane.showMessageDialog(null, 
			                              e1.getMessage(), 
			                              "SQL Exception", 
			                              javax.swing.JOptionPane.WARNING_MESSAGE);
			            }
			            
			            
			        }
				
				
			
		
		});
		btnResetPassword.setText("Reset Password");
		btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResetPassword.setBounds(166, 455, 144, 23);
		ResetPanel.add(btnResetPassword);
		
		JButton btnClr3 = new JButton();
// Clear password fields
		btnClr3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_new_passs.setText("");
		        txt_re_new_passd.setText("");
			}
		});
		btnClr3.setText("Clear");
		btnClr3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClr3.setBounds(327, 455, 112, 23);
		ResetPanel.add(btnClr3);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_2.setBounds(70, 343, 474, 155);
		ResetPanel.add(horizontalBox_2);
		
		txt_secu_code = new JTextField();
		txt_secu_code.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_secu_code.setBounds(344, 227, 173, 20);
		ResetPanel.add(txt_secu_code);
		
		txts = new JTextField();
		txts.setEnabled(false);
		txts.setEditable(false);
		txts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txts.setBounds(241, 230, 90, 20);
		ResetPanel.add(txts);
		txts.setVisible(false);
		
	}
	
	
	//function to clear text fields
		 private void clearText()
		    {
		       
		        txt_new_passs.setText("");
		        txt_re_new_passd.setText("");
		    }
		 
		 
		 
	//function to get username from login form 
		 private void setValues()
		    {
		        userName = logS.lg.getUserName();
		        logS.txtusername.setText(userName);
		        uID = logS.lg.getUserID();
		    }
	
		 
	//function to get show the pass reset text boxes 
		 private void setVisibilityResetShow()
		    {
			 txt_new_passs.setVisible(true);
		     txt_re_new_passd.setVisible(true);
		    }
		
		//function to get hide the pass reset text boxes 
		 private void setVisibilityResetHide()
		    {
			 txt_new_passs.setVisible(false);
		     txt_re_new_passd.setVisible(false);
		    }
		 
		 
	
}
