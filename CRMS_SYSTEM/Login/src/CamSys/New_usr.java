package CamSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.util.regex.*;

//import graphicscard.comparison.software.Database;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.border.BevelBorder;

public class New_usr {

	private JFrame frmNewUserRegister;
	private JTextField txtuid;
	private JTextField txtuname;
	private JPasswordField txtpass;
	private JPasswordField txtrtpass;
	private JTextField txtmail;
	private static boolean check;
	//private String email;
	private static  String uMail;
	private String message;
	private boolean Uname_Ex ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_usr window = new New_usr();
					window.frmNewUserRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public New_usr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmNewUserRegister = new JFrame();
		frmNewUserRegister.getContentPane().setBackground(Color.WHITE);
		frmNewUserRegister.setTitle("New User Register");
		frmNewUserRegister.setBounds(100, 100, 492, 505);
		frmNewUserRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewUserRegister.getContentPane().setLayout(null);
		
		
		
		txtuid = new JTextField();
		txtuid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtuid.setEditable(false);
		txtuid.setBounds(226, 80, 187, 20);
		frmNewUserRegister.getContentPane().add(txtuid);
		
		txtuname = new JTextField();
		txtuname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtuname.setBounds(226, 136, 187, 20);
		frmNewUserRegister.getContentPane().add(txtuname);
		
		txtrtpass = new JPasswordField();
		txtrtpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtrtpass.setBounds(226, 243, 187, 20);
		frmNewUserRegister.getContentPane().add(txtrtpass);
		
		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpass.setBounds(226, 190, 187, 22);
		frmNewUserRegister.getContentPane().add(txtpass);
		
		txtmail = new JTextField();
		txtmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmail.setBounds(226, 296, 187, 20);
		frmNewUserRegister.getContentPane().add(txtmail);
		
		
		
		JLabel label_2 = new JLabel();
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setText("Password");
		label_2.setBounds(64, 188, 72, 22);
		frmNewUserRegister.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setText("Re-type Password");
		label_3.setBounds(64, 240, 133, 22);
		frmNewUserRegister.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("Register User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(169, 11, 168, 30);
		frmNewUserRegister.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(64, 302, 72, 14);
		frmNewUserRegister.getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel();
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setText("User Name");
		label_1.setBounds(64, 133, 114, 22);
		frmNewUserRegister.getContentPane().add(label_1);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setText("User ID");
		label.setBounds(64, 77, 82, 22);
		frmNewUserRegister.getContentPane().add(label);
		
		
		
// to load the uid when form opens
		setUID();
		
		JButton btnSave = new JButton();
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.addActionListener(new ActionListener() {
		
			
			
// Save button click event
			public void actionPerformed(ActionEvent e) {
				try
		        {  //
		            
		            	check = true;		            
		            
		                String uID = txtuid.getText().trim();
		                String uName = txtuname.getText().trim();
		                String uType = "Normal";
		                String uPass1 = txtpass.getText();
		                String uPass1X = LoginData.encrypt(uPass1);
		                System.out.println("uPass1X : " + uPass1X);
		                System.out.println("uPass1 : " + uPass1);
		                String uPass2 = txtrtpass.getText();
		                String uPass2X = LoginData.encrypt(uPass2);
		                uMail = txtmail.getText();
		               
		                boolean MailResult = MailValid(uMail);
		                U_existance_check();
		                
		                message ="";
		                
		                if(uID.isEmpty())
		                {
		                    check = false;
		                    message = "UserID is Empty";
		                }
		                if(uName.isEmpty())
		                {
		                    check = false;
		                    message = "Usename is Empty";
		                }
		                if(uPass1.isEmpty())
		                {
		                    check = false;
		                    message = "Password is Empty";
		                }
		                if(uPass2.isEmpty())
		                {
		                    check = false;
		                    message = "Please Re-type password";
		                }
		                if(!uPass1.equals(uPass2))
		                {
		                    check = false;
		                    message = "Passwords do not match"; 
		                }
		                if(uMail.isEmpty())
		                {
		                    check = false;
		                    message = "E-mail field is empty"; 
		                }
		                if (MailResult==false)
		                {
		                	check = false;
		                    message = "E-mail entered is not valid"; 
		                }
		                
		                if (Uname_Ex==true)
		                {
		                	check = false;
		                    message = "Try again with a different username"; 
		                }

		                if(check)
		                {
		                   // String uPass = uPass1X = uPass2X;
		                   
		                    Database db = new Database();
		                    String query = "INSERT INTO user (u_id,u_name,u_pass,u_type,email) VALUES ('"+uID+"','"+uName+"','"+uPass1X+"','"+uType+"','"+uMail+"')";

		                    int rows = db.Save_Del_Update(query);

		                    if (rows>0)
		                    {
		                   
		                    	JOptionPane.showMessageDialog( null, "Data Insertion Sucessful !" );
		                        setUID();
		                        clearText();
		                        
		                    }
		                    else
		                    {
		               
		                        JOptionPane.showMessageDialog(null, "Data insertion failed ","Insert Error",JOptionPane.ERROR_MESSAGE);

		                    }
		                }
		                else
		                {
		                   
		                	 JOptionPane.showMessageDialog(null, message,"Insert Error",JOptionPane.ERROR_MESSAGE);
		                    
		                }
		        }
		        catch(SQLException ex)
		        {
		                javax.swing.JOptionPane.showMessageDialog(null,
		                    ex.getMessage(),
		                    "SQL Exception",
		                    javax.swing.JOptionPane.WARNING_MESSAGE);
		        }

		   
		        
			}
		});
		
		
		btnSave.setText("Save");
		btnSave.setBounds(108, 406, 89, 23);
		frmNewUserRegister.getContentPane().add(btnSave);
		
		JButton btnclear = new JButton();
		btnclear.setBackground(Color.PINK);
		btnclear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnclear.setText("Clear");
		btnclear.setBounds(239, 406, 82, 23);
		frmNewUserRegister.getContentPane().add(btnclear);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(34, 59, 411, 282);
		frmNewUserRegister.getContentPane().add(horizontalBox);
		
		
	}

	public int getTextFieldHorizontalAlignment() {
		return txtuid.getHorizontalAlignment();
	}
	public void setTextFieldHorizontalAlignment(int horizontalAlignment) {
		txtuid.setHorizontalAlignment(horizontalAlignment);
	}
	
// To clear text fields 
	private void clearText()
    {
        txtuname.setText("");
        txtpass.setText("");
        txtrtpass.setText("");
    	txtmail.setText("");
    }
	
	
	
// To set the user ID automatically
	 private void setUID()
	    {
	        try
	            {
	                Database db = new Database();
	                String query = "SELECT MAX(u_id) AS MAXuID FROM user";
	                ResultSet rs = db.GetData(query);
	                
	                rs.next();
	                
	                int rows = rs.getRow();
	                if(rows > 0)
	                {
	                    int MAXuID = Integer.parseInt(rs.getString("MAXuID"));
	                    MAXuID++;
	                    String newUID = String.format("%04d", MAXuID);
	                    txtuid.setText(String.valueOf(newUID));
	                
	                }
	                else
	                {
	                   // output_lbl.setText("Minimum ID not set in the table in the database");
	                	 JOptionPane.showMessageDialog(null, "Data insertion failed","Insert Error",JOptionPane.ERROR_MESSAGE);
	                }
	                
	                db.closeCon();
	                    
	            }
	            catch(SQLException ex)
	            {
	                javax.swing.JOptionPane.showMessageDialog(null, 
	                              ex.getMessage(), 
	                              "SQL Exception", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);
	            }
	    }
	 
	 
// Email text field validation method
	 public static boolean MailValid(String email)
	 {
		
	//	 email.isEuMail;
		 email.equals(uMail);
		 String regex = "^(.+)@(.+)$";
		 Pattern pattern = Pattern.compile(regex);

		 return pattern.matcher(email).matches();
		
	 }
	 
// Username existence check
	 public void U_existance_check()
	 {
		 String uNameP = txtuname.getText().trim();
		 Uname_Ex = false;
		try {
			 Database db = new Database();
             String query = "SELECT u_id FROM user WHERE u_name= '"+uNameP+"' ";
             ResultSet rs = db.GetData(query);
             
             rs.next();
             
             int rows = rs.getRow();
             if(rows > 0)
             {
             
            	 JOptionPane.showMessageDialog(null, "Username already taken","Insert Error",JOptionPane.ERROR_MESSAGE);
            	 Uname_Ex = true ;
             }
		}
		 catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null, 
                          ex.getMessage(), 
                          "SQL Exception", 
                          javax.swing.JOptionPane.WARNING_MESSAGE);
        }
	 }
	 
	 
}
