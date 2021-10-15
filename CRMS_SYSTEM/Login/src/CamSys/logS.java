package CamSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import CamSys.Database;
import CamSys.home;
import CamSys.user;
import CamSys.LoginData;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class logS {
	
	private JFrame frmlogin;
//	public static JFrame frmlogin;
	static JTextField txtusername;
	private JPasswordField txtpassword;
	public static LoginData lg;
	public static String userIDD = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logS window = new logS();
					window.frmlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmlogin = new JFrame();
		frmlogin.getContentPane().setBackground(Color.WHITE);
		frmlogin.setBounds(200, 200, 674, 514);
		frmlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmlogin.getContentPane().setLayout(null);
		//public static loginData lg;
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setToolTipText("Click here to login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(300, 55, 111, 35);
		frmlogin.getContentPane().add(lblNewLabel);
		
		txtusername = new JTextField();
		txtusername.setBounds(317, 138, 155, 33);
		frmlogin.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblusername.setBounds(181, 141, 124, 30);
		frmlogin.getContentPane().add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpassword.setBounds(181, 204, 111, 30);
		frmlogin.getContentPane().add(lblpassword);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setToolTipText("clk");
		btnlogin.addActionListener(new ActionListener() {
			
			
// Login button click event *********
			public void actionPerformed(ActionEvent evt) {
				  
				try {
				
					String username = txtusername.getText();
					String password = txtpassword.getText();
					String passE =  LoginData.encrypt(password);
				
					if (username.trim().isEmpty() || password.trim().isEmpty())
		            {
		            
						JOptionPane.showMessageDialog(null, "Please fill all fields","Login Error",JOptionPane.ERROR_MESSAGE);
		                
		            }
		            else
		            {
		                
		                
		                Database db = new Database();
		                String query = "SELECT u_id,u_type FROM User WHERE u_name='"+username+"' AND u_pass='"+passE+"'";
		                ResultSet rs = db.GetData(query);
		                
		                
		                rs.next();
		                int rows = rs.getRow();
		                
		                
		                if (rows>0)
		                {
		                	userIDD = rs.getString("u_id");
		                	
		
		                	
		                    String uType = rs.getString("u_type");
		                    
		                    lg = new LoginData();
		                    lg.setUserID(rs.getString("u_id"));
		                    lg.setUserName(username);
		                    
		                    
		                    
		            /*        if (uType.equalsIgnoreCase("1") || uType.equalsIgnoreCase("Admin"))
		                    {
		                    	
		                    	JFrame home = new home();
								home.setVisible(true);
								frmlogin.setVisible(false);
							
		                        
		                    }
		                    else if(uType.equalsIgnoreCase("Normal"))
		                    {
		             */
		                    	JFrame home = new home();
								home.setVisible(true);
								frmlogin.setVisible(false);
							
		             //       }
		                    
		                    db.closeCon();
		                    
		                }
		                else
		                {
		        
		                	JOptionPane.showMessageDialog(null, "Invalid Username or Password","Try again",JOptionPane.ERROR_MESSAGE);
			                
		                }	
		            }}
				
				catch(SQLException e)
		        {
		            javax.swing.JOptionPane.showMessageDialog(null, 
		                              e.getMessage(), 
		                              "SQL Exception", 
		                              javax.swing.JOptionPane.WARNING_MESSAGE);	}
			
			}
			});
		 
	
		
		
		btnlogin.setBackground(Color.CYAN);
		btnlogin.setBounds(193, 351, 146, 23);
		frmlogin.getContentPane().add(btnlogin);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			
			
// Cancel button click event ****************************
			public void actionPerformed(ActionEvent e) {
				// to exit
				frmlogin = new JFrame ("Exit");
				// to show exit confirmation message
				if (JOptionPane.showConfirmDialog(frmlogin, "Are you sure you want to exit ?", "Login System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
				}
			}
		});
	
		 		
		
		btncancel.setBackground(new Color(240, 128, 128));
		btncancel.setBounds(356, 351, 124, 23);
		frmlogin.getContentPane().add(btncancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(181, 301, 300, 2);
		frmlogin.getContentPane().add(separator);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(314, 206, 158, 35);
		frmlogin.getContentPane().add(txtpassword);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(UIManager.getColor("Button.highlight"));
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		horizontalBox.setBounds(134, 31, 395, 400);
		frmlogin.getContentPane().add(horizontalBox);
		
		JButton btnNewButton = new JButton("Forgot Password?");
// Send Code Button Click Event
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Frm_Reset_Pass = new Frm_Reset_Pass();
				Frm_Reset_Pass.setVisible(true);
				frmlogin.setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(181, 273, 155, 23);
		frmlogin.getContentPane().add(btnNewButton);
	}
}

