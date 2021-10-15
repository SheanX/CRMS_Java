package CamSys;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import CamSys.Database;
import CamSys.LoginData;
import CamSys.logS;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class password_reset_panel extends JPanel {
	
// declare variables 
	private String uID = "";
	private String userName = "";
	    
	
	private JTextField txt_uname_out;
	private JPasswordField txt_cu_pass;
	private JPasswordField txt_new_pass;
	private JPasswordField txt_re_new_pass;

	/**
	 * Create the panel.
	 */
	public password_reset_panel() {
		setLayout(null);
		
		JLabel lblusername = new JLabel();
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblusername.setBounds(70, 88, 144, 14);
		lblusername.setText("Username");
		add(lblusername);
		
		JLabel lbl_cu_pass = new JLabel();
		lbl_cu_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_cu_pass.setBounds(70, 139, 157, 14);
		lbl_cu_pass.setText("Current Password");
		add(lbl_cu_pass);
		
		JLabel lbl_new_pass = new JLabel();
		lbl_new_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_new_pass.setBounds(70, 194, 126, 14);
		lbl_new_pass.setText("New Password");
		add(lbl_new_pass);
		
		JLabel lbl_re_new_pass = new JLabel();
		lbl_re_new_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_re_new_pass.setBounds(70, 250, 208, 14);
		lbl_re_new_pass.setText("Re-type new Password");
		add(lbl_re_new_pass);
		
		txt_uname_out = new JTextField();
		txt_uname_out.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_uname_out.setBounds(309, 85, 173, 20);
		txt_uname_out.setText("<dynamic>");
		txt_uname_out.setEditable(false);
		add(txt_uname_out);
		
		txt_cu_pass = new JPasswordField();
		txt_cu_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_cu_pass.setBounds(309, 136, 173, 20);
		add(txt_cu_pass);
		
		txt_new_pass = new JPasswordField();
		txt_new_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_new_pass.setBounds(309, 191, 173, 20);
		add(txt_new_pass);
		
		txt_re_new_pass = new JPasswordField();
		txt_re_new_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_re_new_pass.setBounds(309, 247, 173, 20);
		add(txt_re_new_pass);
		
		JButton btn_clr = new JButton();
// clear buton click event
		btn_clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		
		btn_clr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_clr.setBounds(309, 332, 112, 23);
		btn_clr.setText("Clear");
		add(btn_clr);
		
		JButton btn_re_pass = new JButton();
		
		
//password reset button click event
		btn_re_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if(checkNotEmpty())
		        {
		            try
		            {
		                //String uID = Login.getUserID();
		                String uName = txt_uname_out.getText();
		                String currPass = txt_cu_pass.getText();
		                String newPass1 = txt_new_pass.getText();
		                String newPass2 = txt_re_new_pass.getText();
		                
		                Database db = new Database();
		                String query = "SELECT uID FROM Users WHERE uName = '"+uName+"' AND uPass = '"+currPass+"' ";
		                java.sql.ResultSet rs = db.GetData(query);
		                
		                rs.next();
		                int row = rs.getRow();
		                
		                if(row>0 && uID.equals(rs.getString("uID")))
		                {
		                    if(newPass1.equals(newPass2))
		                    {
		                        String newPass = newPass1;
		                        
		                        db = new Database();
		                        query = "UPDATE Users SET uPass = '"+newPass+"' WHERE uID = '"+uID+"' ";
		                        int rows = db.Save_Del_Update(query);
		                        
		                        if (rows>0)
		                        {
		           
		                        	JOptionPane.showMessageDialog( null, "Password Reset Sucessful !" );
		                            
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
				
			}
		});
		btn_re_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_re_pass.setBounds(131, 332, 144, 23);
		btn_re_pass.setText("Reset Password");
		add(btn_re_pass);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(344, 44, 0, 0);
		add(label_4);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblusername, lbl_cu_pass, lbl_new_pass, lbl_re_new_pass, txt_uname_out, txt_cu_pass, txt_new_pass, txt_re_new_pass, btn_clr, btn_re_pass, label_4}));
							
	}
	
	
	
//function to clear text fields
	 private void clearText()
	    {
	        txt_cu_pass.setText("");
	        txt_new_pass.setText("");
	        txt_re_new_pass.setText("");
	    }
	 
	 
	 
//function to get username from login form 
	 private void setValues()
	    {
	        userName = logS.lg.getUserName();
	        logS.txtusername.setText(userName);
	        uID = logS.lg.getUserID();
	    }
	 
	 
	 
//function to confirm fields are not empty
	 private boolean checkNotEmpty()
	    {
	        boolean notEmpty = true;
	        String reason ="";
	        if(uID.trim().isEmpty())
	        {
	            notEmpty = false;
	            reason ="User ID not set";
	        }
	        if(txt_uname_out.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            reason ="User Name not set";
	        }
	        if(txt_cu_pass.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            reason ="Current Password is Empty";
	        }
	        if(txt_new_pass.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            reason ="New Password is Empty";
	        }
	        if(txt_re_new_pass.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            reason ="Re-tyoe new Password";
	        }
	        if(!notEmpty)
	        {
	            javax.swing.JOptionPane.showMessageDialog(null, 
	                              reason, 
	                              "Empty", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);
	        }
	        return notEmpty;
	        
	    }
	    
	    

}
