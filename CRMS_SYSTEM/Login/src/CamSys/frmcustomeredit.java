package CamSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import graphicscard.comparison.software.Database;
import CamSys.Database;
import CamSys.home;
import CamSys.user;
import CamSys.LoginData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class frmcustomeredit extends JFrame {

	private JPanel contentPane;
	private JTextField txtcname;
	private JTextField txtdlnum;
	private JTextField txtnic;
	private JTextField txtadr;
	private JTextField txtcon1;
	private JTextField txtcon2;
	private JTextField txtoccu;
	private JTextField txtwtel;
	private JComboBox cmbCusNo;
	
	private String cId ="";
	private String cName = "";
	private String cDlno = "";
	private String cNic = "";
	private String cAddress = "";
	private String cMobile = "";
	private String cCon2 = "";
	private String cOccupation = "";
	private String cOfficetel = "";
	private JTextField txtcidd;
	
	private boolean notEmpty;
	private String message;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmcustomeredit frame = new frmcustomeredit();
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
	public frmcustomeredit() {
		setTitle("Customer Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Customer_Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(81, 180, 144, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Driving License Number");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(81, 229, 178, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setText("NIC Number");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(81, 281, 144, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel();
		label_4.setText("Address");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(81, 330, 144, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Contact (Mobile)");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(81, 373, 144, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setText("Contact (Second)");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(81, 426, 144, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setText("Occupation");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(81, 477, 144, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel();
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(81, 529, 144, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setText("Contact Workplace");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_9.setBounds(81, 529, 144, 14);
		contentPane.add(label_9);
		
		txtcname = new JTextField();
		txtcname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcname.setBounds(341, 174, 187, 20);
		contentPane.add(txtcname);
		
		txtdlnum = new JTextField();
		txtdlnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtdlnum.setBounds(341, 223, 187, 20);
		contentPane.add(txtdlnum);
		
		txtnic = new JTextField();
		txtnic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtnic.setBounds(341, 275, 187, 20);
		contentPane.add(txtnic);
		
		txtadr = new JTextField();
		txtadr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtadr.setBounds(341, 324, 187, 20);
		contentPane.add(txtadr);
		
		txtcon1 = new JTextField();
		txtcon1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcon1.setBounds(341, 367, 187, 20);
		contentPane.add(txtcon1);
		
		txtcon2 = new JTextField();
		txtcon2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcon2.setBounds(341, 420, 187, 20);
		contentPane.add(txtcon2);
		
		txtoccu = new JTextField();
		txtoccu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtoccu.setBounds(341, 471, 187, 20);
		contentPane.add(txtoccu);
		
		txtwtel = new JTextField();
		txtwtel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtwtel.setBounds(341, 523, 187, 20);
		contentPane.add(txtwtel);
		
		txtcidd = new JTextField();
		txtcidd.setEnabled(false);
		txtcidd.setEditable(false);
		txtcidd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcidd.setBounds(546, 174, 18, 20);
		contentPane.add(txtcidd);
		
		cmbCusNo = new JComboBox();
		cmbCusNo.setBounds(175, 57, 175, 22);
		contentPane.add(cmbCusNo);
		
		JButton btnsave = new JButton("Save");
		btnsave.setBackground(Color.GREEN);
// Save button click event
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkNotEmpty())
		        {
		            try
		            {
		            	cId = txtcidd.getText();
		                cName = txtcname.getText().trim();
	                	cDlno = txtdlnum.getText().trim();
	                	cNic = txtnic.getText().trim();
	                	cAddress = txtadr.getText().trim();
	                	cMobile = txtcon1.getText().trim();
	                	cCon2 = txtcon2.getText().trim();
	                	cOccupation = txtoccu.getText().trim();
	                	cOfficetel = txtwtel.getText().trim();             
		                
		                Database db = new Database();
		                String query = "UPDATE customer SET cus_name = '"+cName+"' , dl_no = '"+cDlno+"' , nic_no = '"+cNic+"' , address = '"+cAddress+"' , contact_one = '"+cMobile+"' , contact_two = '"+cCon2+"' , occupation = '"+cOccupation+"' , office_tel = '"+cOfficetel+"' WHERE cus_id = '"+cId+"' ";
		                int rows = db.Save_Del_Update(query);
		                
		                if (rows>0)
		                {

		            		//JOptionPane.showMessageDialog(null, "Data update Sucessful !");
		                    
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              "Data Updated Successfully. "+rows+" Rows updated", 
		                              "Message", 
		                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
		                    
		                   // update_btn.setEnabled(false);
		                  //  loadTable();
		                	clearText();
		                }
		                else
		                {
		                    
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              "Data Update failed. "+rows+" Rows updated", 
		                              "Error", 
		                              javax.swing.JOptionPane.WARNING_MESSAGE);
		                }
		            }
		            catch(java.sql.SQLException e1)
		            {
		                javax.swing.JOptionPane.showMessageDialog(null, 
		                              e1.getMessage(), 
		                              "SQL Exception", 
		                              javax.swing.JOptionPane.WARNING_MESSAGE);
		            }
		            
		            
		        }
				
			}
		});
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsave.setBounds(236, 607, 155, 37);
		contentPane.add(btnsave);
		
		JButton btnclr = new JButton("Clear");
		btnclr.setBackground(Color.PINK);
// Clear button click event
		btnclr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		
		btnclr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnclr.setBounds(411, 607, 89, 37);
		contentPane.add(btnclr);
		
		
		
		JButton btnSearch = new JButton("Search");
// Search button click event
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String mobilenumber = cmbCusNo.getSelectedItem().toString();
				   // String  = txtsearch.getText();
				
					if (mobilenumber.trim().isEmpty() )
		            {
		            
						JOptionPane.showMessageDialog(null, "Please fill all fields","Login Error",JOptionPane.ERROR_MESSAGE);
		                
		            }
		            else
		            {
		                
		                
		                Database db = new Database();
		                String query = "SELECT * FROM customer WHERE contact_one='"+mobilenumber+"'";
		                ResultSet rs = db.GetData(query);
		                
		                
		                rs.next();
		                int rows = rs.getRow();
		                
		                
		                if (rows>0)
		                {
		                	cId = rs.getString("cus_id");
		                	cName = rs.getString("cus_name");
		                	cDlno = rs.getString("dl_no");
		                	cNic = rs.getString("nic_no");
		                	cAddress = rs.getString("address");
		                	cMobile = rs.getString("contact_one");
		                	cCon2 = rs.getString("contact_two");
		                	cOccupation = rs.getString("occupation");
		                	cOfficetel = rs.getString("office_tel");
		                	
		                	txtcidd.setText(cId);
		                	txtcname.setText(cName);
		                	txtdlnum.setText(cDlno);
		                	txtnic.setText(cNic);
		                	txtadr.setText(cAddress);
		                	txtcon1.setText(cMobile);
		                	txtcon2.setText(cCon2);
		                	txtoccu.setText(cOccupation);
		                	txtwtel.setText(cOfficetel);
		                	
		                
							
		                    
		                  //  db.closeCon();
		                    
		                }
		                else
		                {
		        
		                	JOptionPane.showMessageDialog(null, "Invalid customer mobile number","Try again",JOptionPane.ERROR_MESSAGE);
			                
		                }	
		            }}
				
				catch(SQLException e1)
		        {
		            javax.swing.JOptionPane.showMessageDialog(null, 
		                              e1.getMessage(), 
		                              "SQL Exception", 
		                              javax.swing.JOptionPane.WARNING_MESSAGE);	}
			
			}
				
			
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(424, 55, 89, 23);
		contentPane.add(btnSearch);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(143, 35, 404, 64);
		contentPane.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_1.setBounds(42, 148, 544, 524);
		contentPane.add(horizontalBox_1);
		CustomeraAddCombo();
		
		
		
		
	}
	
// Method to clean textboxes
	private void clearText()
	    {
	        txtwtel.setText("");
	        txtoccu.setText("");
	        txtcon2.setText("");
	        txtcon1.setText("");
	        txtadr.setText("");
	        txtnic.setText("");
	        txtdlnum.setText("");
	        txtcname.setText("");

	       
	    }

// Method to find out empty text fields
private boolean checkNotEmpty()
	    {
	        notEmpty = true;
	        message = "";
	        if(txtcname.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer name is empty";
	        }
	        if(txtdlnum.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer driving licen number";
	        }
	        if(txtnic.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer NIC number is empty";
	        }
	        if(txtadr.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer address is empty";
	        }
	        if(txtcon1.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer mobile number is empty";
	        }
	        if(txtcon2.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer second contact number is empty";
	        }
	        if(txtoccu.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer occupation is empty";
	        }
	        if(txtwtel.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer workplace telephone number is empty";
	        }
	        
	        
	        if(!notEmpty)
	        {
	            javax.swing.JOptionPane.showMessageDialog(null, 
	                              message, 
	                              "Empty", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);
	        }
	        
	        return notEmpty;
	    }

//Method to to get list of customer mobile numbers to the combo box
		private void CustomeraAddCombo()
		    {
			try {
			 Database db = new Database();
			 String query = "SELECT contact_one FROM customer";
			 ResultSet rs = db.GetData(query);
          
          
			 while(rs.next())
			 {
          
				 cmbCusNo.addItem(rs.getString(1));
			 }
  
			}catch(Exception e1) {
          
			javax.swing.JOptionPane.showMessageDialog(null, 
                  e1.getMessage(), 
                  " Exception", 
                  javax.swing.JOptionPane.WARNING_MESSAGE);	}
  
    
		    }
		
		
// contactlength test method
		private void ContactLengthTest(String ContactLengthTestInput, String MessageZ)
		    {
		
			if (ContactLengthTestInput.length()!=10) {
				notEmpty = false;
				JOptionPane.showMessageDialog(null, MessageZ , "Validation Error",JOptionPane.WARNING_MESSAGE);
			} 
		    }	
}
