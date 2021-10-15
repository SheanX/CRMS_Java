package CamSys;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CamSys.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.*;  

public class Frm_New_Customer extends JFrame {
	//private JFrame Frm_New_Customer;
	private JPanel contentPane;
	private JTextField txtcusid;
	private JTextField txtcname;
	private JTextField txtdlnum;
	private JTextField txtnic;
	private JTextField txtadr;
	private JTextField txtcon1;
	private JTextField txtcon2;
	private JTextField txtoccu;
	private JTextField txtwtel;
	
	private Boolean check;
	private String CharTestInput ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_New_Customer frame = new Frm_New_Customer();
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
	public Frm_New_Customer() {
		setTitle("New Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerid = new JLabel();
		lblCustomerid.setText("Customer_Id");
		lblCustomerid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerid.setBounds(116, 48, 144, 14);
		contentPane.add(lblCustomerid);
		
		JLabel lblCustomername = new JLabel();
		lblCustomername.setText("Customer_Name");
		lblCustomername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomername.setBounds(116, 98, 144, 14);
		contentPane.add(lblCustomername);
		
		JLabel lblDrivingLicenseNumber = new JLabel();
		lblDrivingLicenseNumber.setText("Driving License Number");
		lblDrivingLicenseNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDrivingLicenseNumber.setBounds(116, 147, 178, 14);
		contentPane.add(lblDrivingLicenseNumber);
		
		JLabel lblNicNumber = new JLabel();
		lblNicNumber.setText("NIC Number");
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNicNumber.setBounds(116, 199, 144, 14);
		contentPane.add(lblNicNumber);
		
		JLabel lblAddress = new JLabel();
		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(116, 248, 144, 14);
		contentPane.add(lblAddress);
		
		JLabel lblContactmobile = new JLabel();
		lblContactmobile.setText("Contact (Mobile)");
		lblContactmobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactmobile.setBounds(116, 291, 144, 14);
		contentPane.add(lblContactmobile);
		
		JLabel lblContactsecond = new JLabel();
		lblContactsecond.setText("Contact (Second)");
		lblContactsecond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactsecond.setBounds(116, 344, 144, 14);
		contentPane.add(lblContactsecond);
		
		JLabel lblContactWorkplace = new JLabel();
		lblContactWorkplace.setText("Occupation");
		lblContactWorkplace.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactWorkplace.setBounds(116, 395, 144, 14);
		contentPane.add(lblContactWorkplace);
		
		JLabel label_3 = new JLabel();
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(116, 447, 144, 14);
		contentPane.add(label_3);
		
		JLabel lblContactWorkplace_1 = new JLabel();
		lblContactWorkplace_1.setText("Contact Workplace");
		lblContactWorkplace_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactWorkplace_1.setBounds(116, 447, 144, 14);
		contentPane.add(lblContactWorkplace_1);
		
		txtcusid = new JTextField();
		txtcusid.setEditable(false);
		txtcusid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcusid.setBounds(376, 45, 187, 20);
		contentPane.add(txtcusid);
		CUSID();
		
		txtcname = new JTextField();
		txtcname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcname.setBounds(376, 92, 187, 20);
		contentPane.add(txtcname);
		
		txtdlnum = new JTextField();
		txtdlnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtdlnum.setBounds(376, 141, 187, 20);
		contentPane.add(txtdlnum);
		
		txtnic = new JTextField();
		txtnic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtnic.setBounds(376, 193, 187, 20);
		contentPane.add(txtnic);
		
		txtadr = new JTextField();
		txtadr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtadr.setBounds(376, 242, 187, 20);
		contentPane.add(txtadr);
		
		txtcon1 = new JTextField();
		txtcon1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcon1.setBounds(376, 285, 187, 20);
		contentPane.add(txtcon1);
		
		txtcon2 = new JTextField();
		txtcon2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcon2.setBounds(376, 338, 187, 20);
		contentPane.add(txtcon2);
		
		txtoccu = new JTextField();
		txtoccu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtoccu.setBounds(376, 389, 187, 20);
		contentPane.add(txtoccu);
		
		txtwtel = new JTextField();
		txtwtel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtwtel.setBounds(376, 441, 187, 20);
		contentPane.add(txtwtel);
		
		JButton btnsave = new JButton("Save");
		btnsave.setBackground(Color.GREEN);
// Save button click event
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
		        {
		            
		            check = true;	
		           // CheckTwo=true;
		            
		            	String cId = txtcusid.getText().trim();
		                String cName = txtcname.getText().trim();
		                String cDlnumber = txtdlnum.getText().trim();
		                String cNic = txtnic.getText().trim();
		                String cAddress = txtadr.getText();
		                String cContact1 = txtcon1.getText().trim();
		                String cContact2 = txtcon2.getText().trim();
		                String cOccupation = txtoccu.getText();
		                String cWorktel = txtwtel.getText().trim();
		                
		                
		                
		                String message ="";
		                TextValidations();
		                if(cId.isEmpty())
		                {
		                    check = false;
		                    message = "Customer ID is Empty";
		                }
		                if(cName.isEmpty())
		                {
		                    check = false;
		                    message = "Customer Name is Empty";
		                }
		                if(cDlnumber.isEmpty())
		                {
		                    check = false;
		                    message = "Customer Driving Licen Number is Empty";
		                }
		                if(cNic.isEmpty())
		                {
		                    check = false;
		                    message = "Customer NIC number is Empty";
		                }
		                if(cAddress.isEmpty())
		                {
		                    check = false;
		                    message = "Customer Address is Empty";
		                }
		                if(cContact1.isEmpty())
		                {
		                    check = false;
		                    message = "Customer Contact 1 is Empty";
		                }
		                if(cContact2.isEmpty())
		                {
		                    check = false;
		                    message = "Customer Contact 2 is Empty";
		                }
		                if(cOccupation.isEmpty())
		                {
		                    check = false;
		                    message = "Customer occupation is Empty";
		                }
		                if(cWorktel.isEmpty())
		                {
		                    check = false;
		                    message = "Customer workplace telephone number is Empty";
		                }

		                if(check)
		                	//if(CheckTwo){
		                {
		                    
		                    Database db = new Database();
		                    String query = "INSERT INTO customer (cus_id,cus_name,dl_no,nic_no,address,contact_one,contact_two,occupation,office_tel) VALUES ('"+cId+"','"+cName+"','"+cDlnumber+"','"+cNic+"','"+cAddress+"','"+cContact1+"','"+cContact2+"','"+cOccupation+"','"+cWorktel+"')";

		                    int rows = db.Save_Del_Update(query);

		                    if (rows>0)
		                    {
		                 
		                    	JOptionPane.showMessageDialog( null, "Data Insertion Sucessful !" );
		                        
		                        clearText();
		                        CUSID();
		                        
		                    }
		                    else
		                    {
	
		                        JOptionPane.showMessageDialog(null, "Data insertion failed ","Insert Error",JOptionPane.ERROR_MESSAGE);

		                    }
		                }
		                else
		                {
		 
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              message, 
		                              "Error", 
		                             javax.swing.JOptionPane.WARNING_MESSAGE);
		           
		
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
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsave.setBounds(158, 531, 136, 29);
		contentPane.add(btnsave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.PINK);
// Clear button click event
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
				CUSID();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(339, 532, 111, 28);
		contentPane.add(btnClear);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(67, 24, 545, 469);
		contentPane.add(horizontalBox);
		
		
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
	
// Method to generate customer id 
	 private void CUSID()
	    {
	        try
	            {
	                Database db = new Database();
	                String query = "SELECT MAX(cus_id) AS McusID FROM customer";
	                ResultSet rs = db.GetData(query);
	                
	                rs.next();
	                
	                int rows = rs.getRow();
	                if(rows > 0)
	                {
	                    int McusID = Integer.parseInt(rs.getString("McusID"));
	                    McusID++;
	                    String cusID = String.format("%04d", McusID);
	                    txtcusid.setText(String.valueOf(cusID));
	                
	                }
	                else
	                {
	                   
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
	 
// Method to execute check validations methods
		private void TextValidations()
	    {	
			// contact one text length check
			String txtcon1ST=txtcon1.getText();
			ContactLengthTest(txtcon1ST,"Contact Mobile length is not valid");
			
			// contact one character check
			CharachterTest(txtcon1ST,"Contact Mobile can only contain numbers");
			
			
			
			
	       // contact two text length check
			String  txtcon2ST= txtcon2.getText();
			ContactLengthTest(txtcon2ST,"Contact Second length is not valid");
			
		   // contact two character check
			CharachterTest(txtcon2ST,"Contact Second can only contain numbers");
			
			
			
			
			// contact work text length check
			 String txtwtelST = txtwtel.getText();
			 ContactLengthTest(txtwtelST,"Contact Workplace length is not valid");
			
			// contact work character check
			 CharachterTest(txtwtelST,"Contact Workplace can only contain numbers");
			
			
			// nic number text length check 
			String txtnicST;
			txtnicST=txtnic.getText();
			if (txtnicST.length()==10 || txtnicST.length()==12) {
				
			}
			else {
				check = false;
				JOptionPane.showMessageDialog(null, "NIC number is not valid:", "Validation Error",JOptionPane.WARNING_MESSAGE);
			}
			
	    }

//Method to check for only numeric characters 
	private void CharachterTest(String CharTestInput,String MessageX) {
		
		char[] txtConArrX = CharTestInput.toCharArray();
		char[] numX = {'0','1','2','3','4','5','6','7','8','9'};
		int j;

		//  System.out.println("CharTestInput: "+ CharTestInput);
		//  System.out.println("txtConArrX: "+ String.valueOf(txtConArrX));
		//  System.out.println("numX: "+ String.valueOf(numX));
		for (int i = 0; i < txtConArrX.length; i++) {
		
			  for( j = 0; j < numX.length; j++) {
				  System.out.println("txtConArrX[i]: "+String.valueOf(txtConArrX[i]));
				  System.out.println("numX[j]: "+String.valueOf(numX[j]));
			    if (txtConArrX[i]==numX[j]) {
			
			    	break;
			    }
			    
			  }
			  if ((numX.length)==j) {
				 // System.out.println(numX[i]);
				  JOptionPane.showMessageDialog(null, MessageX, "Validation Error",JOptionPane.WARNING_MESSAGE);
				  check = false;
				  break;
			  }
			  
			 
			}		

	}
	
	
// contactlength validation method
	private void ContactLengthTest(String ContactLengthTestInput, String MessageZ)
	    {
	
		if (ContactLengthTestInput.length()!=10) {
			check = false;
			JOptionPane.showMessageDialog(null, MessageZ , "Validation Error",JOptionPane.WARNING_MESSAGE);
		} 
	    }	
	
}
