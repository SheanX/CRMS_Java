package CamSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Edit_Del_usr extends JFrame {

	private JPanel contentPane;
	private JTextField txtU_id;
	private JTextField txtemail;
	private JComboBox cmbUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Del_usr frame = new Edit_Del_usr();
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
	public Edit_Del_usr() {
		setTitle("Edit & Delete User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("User ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(40, 130, 82, 22);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setText("User Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(40, 80, 114, 22);
		contentPane.add(label_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(10, 52, 414, 178);
		contentPane.add(horizontalBox);
		
		JLabel label_4 = new JLabel("E-mail");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(40, 184, 72, 14);
		contentPane.add(label_4);
		
		txtU_id = new JTextField();
		txtU_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtU_id.setEditable(false);
		txtU_id.setBounds(223, 131, 187, 20);
		contentPane.add(txtU_id);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtemail.setBounds(164, 181, 246, 20);
		contentPane.add(txtemail);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(164, 80, 246, 22);
		contentPane.add(cmbUser);

		
		JButton btnSave = new JButton();
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				String UNameH = logS.txtusername.getText();
                String U_Mail_Z = txtemail.getText();
                String U_Name_Selected = cmbUser.getSelectedItem().toString();
                
                if (UNameH.equals("admin") && (U_Name_Selected != "admin"))
                		{
                	JOptionPane.showMessageDialog( null, "E-mail change request denied" );
                    
                }
                
                else {
                
            	Database db  = new Database();
            	String query = "UPDATE user SET email = '"+U_Mail_Z+"' WHERE u_name = '"+U_Name_Selected+"' ";
                int rows = db.Save_Del_Update(query);
                
                if (rows>0)
                {
   
                	JOptionPane.showMessageDialog( null, "User update Sucessful !" );
                    
                }
                else
                {
              
                	 JOptionPane.showMessageDialog(null, "User update Unsuccesful ","Try Again",JOptionPane.ERROR_MESSAGE);
                    
                }
                }
				}catch(Exception e1) {
  		          
    				javax.swing.JOptionPane.showMessageDialog(null, 
    	                  e1.getMessage(), 
    	                  " Exception", 
    	                  javax.swing.JOptionPane.WARNING_MESSAGE);	}
    			    
				
			}
		});
		btnSave.setText("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(28, 388, 126, 23);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton();
// Clear button click event
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearText();
			}
		});
		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBackground(Color.PINK);
		btnClear.setBounds(164, 388, 114, 23);
		contentPane.add(btnClear);
		
		JButton btnDelete = new JButton();
// Delete Button click event
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
				Database db = new Database();
				String U_Name_Selected = cmbUser.getSelectedItem().toString();
                String query = "DELETE FROM user WHERE u_name='"+U_Name_Selected+"'";
                   
               
                  	if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user ?", "Delete Warning",
      						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                  		 int rows = db.Save_Del_Update(query);
                  		 if (rows>0) {
                  			 JOptionPane.showMessageDialog( null, "Data Deletion Sucessful !" );
                  			ClearText();
                  			UserAddCombo();
                  		 }
                  		 
                  		 
                  	
                  	}
	
			}catch(Exception e1) {
		          
				javax.swing.JOptionPane.showMessageDialog(null, 
	                  e1.getMessage(), 
	                  " Exception", 
	                  javax.swing.JOptionPane.WARNING_MESSAGE);	}
			    }
		
			
		});
		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBackground(Color.ORANGE);
		btnDelete.setBounds(288, 388, 116, 23);
		contentPane.add(btnDelete);
		
		
		
		
	// Customer Mobile Combo box arrow click event
		cmbUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
				Fill_Text_Fields();
				
			 }
						      });					
		UserAddCombo();						
	}
	
	//Method to to get list of user names to the combo box
			private void UserAddCombo()
			    {
				try {
				String U_NameZ = logS.txtusername.getText().trim();
				if (U_NameZ.equals("admin")) {
				 Database db = new Database();
				 String query = "SELECT u_name FROM user";
				 ResultSet rs = db.GetData(query);
	          
				 while(rs.next())
				 {
	          
					 cmbUser.addItem(rs.getString(1));
				 }
				}
				else {
				 cmbUser.addItem(U_NameZ);
					
				}
				}catch(Exception e1) {
	          
				javax.swing.JOptionPane.showMessageDialog(null, 
	                  e1.getMessage(), 
	                  " Exception", 
	                  javax.swing.JOptionPane.WARNING_MESSAGE);	}
			    }
		
			
	//Method to to get list of user names to the combo box
			private void ClearText()
			    {
				
				txtemail.setText("");
				
				txtU_id.setText("");
				
			    }
	
			
	// Method to fill other fields after selecting user	by admin
			private void Fill_Text_Fields() {
			try {
				String U_Name_Selected = cmbUser.getSelectedItem().toString();
		
				if (U_Name_Selected.isEmpty() )
	            {
					JOptionPane.showMessageDialog(null, "Please select user from ComboBox","Empty Field",JOptionPane.ERROR_MESSAGE);
	                
	            }
	            else
	            {
	                
	                
	                Database db = new Database();
	                String query = "SELECT * FROM user WHERE u_name='"+U_Name_Selected+"' ";
	                ResultSet rs = db.GetData(query);
	                
	                
	                rs.next();
	                int rows = rs.getRow();
	                
	                
	                if (rows>0)
	                {
	                	
	                	String U_mailX = rs.getString("email");
	                	String U_idX = rs.getString("u_id");
	                	
	                	txtemail.setText(U_mailX);
	                	txtU_id.setText(U_idX);
	                	
	                }
	                else
	                {
	        
	                	JOptionPane.showMessageDialog(null, "Error in user account","Try again",JOptionPane.ERROR_MESSAGE);
		                
	                }	
	            }}
			
			catch(Exception e1)
	        {
	            javax.swing.JOptionPane.showMessageDialog(null, 
	                              e1.getMessage(), 
	                              "SQL Exception", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);	}
		
		}

}
