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
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

import CamSys.Database;
import CamSys.home;
import CamSys.user;
import CamSys.LoginData;

import java.text.SimpleDateFormat;  
import java.util.Date;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;  

public class FrmVehicleEdit extends JFrame {

	private JPanel contentPane;
	private JTextField txtVno;
	private JTextField txtMod_Yom;
	private JTextField txtColor;
	private JTextField txtNo_seats;
	private JTextField txtPu_price;
	private JTextField txtIns_no;
	private JTextField txtLst_Milleage;
	private JTextField txtCu_Milleage;
	private JTextField txtTire_Rl_Milleage;
	private JTextField txtDay_Rate;
	private JTextField txtExtra_Km;
	private JComboBox cmbV_no;
	private JButton btnSearch;
	private JButton btnDelete;
	private JDateChooser dcPu_date;
	private JDateChooser dcIns_ex_date;
	private JDateChooser dcRl_exp_date;
	
	private String Vno_out ="";
	private String vMod_YOM ="";
	private String vColor = "";
	private String vNo_seats = "";
	private String vPu_date = "";
	private String vPu_price = "";
	private String vIns_no = "";
	private String vIns_exp_date = "";
	private String vRl_exp_date = "";
	private String vLst_ser_milleage = "";
	private String vCurrent_milleage = "";	
	private String vTire_replace_milleage = "";	
	private String vDay_rate = "";
	private String vEx_km_rate = "";
	private String vAvailability ="";
	
	
	static SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");  
	private static Date xdateY = new Date();
	
	//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy")  ;	
	//private static String Todaydate = formatter1.format(xdateY.getDate());
	//Date xdatef=formatter1.parse(Todaydate); 
	
	private static String V_no;
	private static String vPu_dateY;   	
 	private static String vIns_exp_dateY ;
 	private static String vRl_exp_dateY ;
 	
 	private static Date vPu_dateeY;  
 	private static Date vIns_exp_dateeY;
 	private static Date vRl_exp_dateeY;
 	
 	static String last_service = "";
    static String current_milleage = "";
    static String Service_expect_km ="";
 	
    private static Integer last_servicee ;
    private static Integer current_milleagee ;
    private static Integer Service_expect_kmm ;

	
	
	
	DateTimeFormatter format = DateTimeFormatter
            .ofPattern("dd/MM/yyyy");
	private JTextField txtV_availability;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVehicleEdit frame = new FrmVehicleEdit();
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
	public FrmVehicleEdit() {
		setTitle("Vehicle Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1284, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExtraKmRate = new JLabel();
		lblExtraKmRate.setBounds(718, 420, 211, 14);
		lblExtraKmRate.setText("Extra Km Rate (LKR)");
		lblExtraKmRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblExtraKmRate);
		
		JLabel lblDayRatelkr = new JLabel();
		lblDayRatelkr.setBounds(718, 373, 211, 14);
		lblDayRatelkr.setText("Day Rate (LKR)");
		lblDayRatelkr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblDayRatelkr);
		
		JLabel label_2 = new JLabel();
		label_2.setBounds(718, 327, 211, 14);
		label_2.setText("Tire Replaced Milleage");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(718, 276, 211, 14);
		label_3.setText("Current Milleage");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(718, 233, 211, 14);
		label_4.setText("Last Service Milleage");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel();
		label_5.setBounds(718, 175, 211, 14);
		label_5.setText("Revenue Licen Expiry Date");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setBounds(718, 126, 187, 14);
		label_6.setText("Insuarace Expiery Date");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setBounds(718, 75, 144, 14);
		label_7.setText("Insuarance No");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel();
		label_8.setBounds(83, 396, 144, 14);
		label_8.setText("Purhase Price");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setBounds(83, 301, 144, 14);
		label_9.setText("No Seats");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel();
		label_10.setBounds(83, 350, 144, 14);
		label_10.setText("Purchase Date");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel();
		label_11.setBounds(83, 249, 178, 14);
		label_11.setText("Color");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel();
		label_12.setBounds(83, 200, 144, 14);
		label_12.setText("Model & YOM");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel();
		label_13.setBounds(83, 150, 144, 14);
		label_13.setText("Vehicle No");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(label_13);
		
		txtVno = new JTextField();
		txtVno.setBounds(345, 150, 187, 20);
		txtVno.setEnabled(false);
		txtVno.setEditable(false);
		txtVno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtVno);
		
		txtMod_Yom = new JTextField();
		txtMod_Yom.setBounds(345, 197, 187, 20);
		txtMod_Yom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtMod_Yom);
		
		txtColor = new JTextField();
		txtColor.setBounds(345, 246, 187, 20);
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtColor);
		
		txtNo_seats = new JTextField();
		txtNo_seats.setBounds(345, 298, 187, 20);
		txtNo_seats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtNo_seats);
		
		dcPu_date = new JDateChooser();
		dcPu_date.setBounds(345, 347, 187, 20);
		contentPane.add(dcPu_date);
		dcPu_date.setDateFormatString("dd/MM/yyyy");
		
		txtPu_price = new JTextField();
		txtPu_price.setBounds(345, 393, 187, 20);
		txtPu_price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtPu_price);
		
		txtIns_no = new JTextField();
		txtIns_no.setBounds(979, 75, 187, 20);
		txtIns_no.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtIns_no);
		
		dcIns_ex_date = new JDateChooser();
		dcIns_ex_date.setBounds(979, 126, 187, 20);
		contentPane.add(dcIns_ex_date);
		dcIns_ex_date.setDateFormatString("dd/MM/yyyy");
		
		txtLst_Milleage = new JTextField();
		txtLst_Milleage.setBounds(979, 233, 187, 20);
		txtLst_Milleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtLst_Milleage);
		
		dcRl_exp_date = new JDateChooser();
		dcRl_exp_date.setBounds(979, 175, 187, 20);
		contentPane.add(dcRl_exp_date);
		dcRl_exp_date.setDateFormatString("dd/MM/yyyy");
		
		txtCu_Milleage = new JTextField();
		txtCu_Milleage.setBounds(979, 276, 187, 20);
		txtCu_Milleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtCu_Milleage);
		
		txtTire_Rl_Milleage = new JTextField();
		txtTire_Rl_Milleage.setBounds(979, 327, 187, 20);
		txtTire_Rl_Milleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtTire_Rl_Milleage);
		
		txtDay_Rate = new JTextField();
		txtDay_Rate.setBounds(979, 374, 187, 20);
		txtDay_Rate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDay_Rate);
		
		txtExtra_Km = new JTextField();
		txtExtra_Km.setBounds(979, 420, 187, 20);
		txtExtra_Km.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtExtra_Km);
		
		cmbV_no = new JComboBox();
		cmbV_no.setBounds(240, 47, 175, 22);
		contentPane.add(cmbV_no);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(83, 511, 218, 29);
// Save button click event
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkNotEmpty())
		        {
		            try
		            {
		            	Renewal_Changes();
		            	vMod_YOM = txtMod_Yom.getText();
		            	vColor = txtColor.getText().trim();
		            	vNo_seats = txtNo_seats.getText().trim();		            	
		            	vPu_price = txtPu_price.getText().trim();
		            	vIns_no = txtIns_no.getText().trim();		            	
		            	vLst_ser_milleage = txtLst_Milleage.getText().trim(); 
		            	vCurrent_milleage = txtCu_Milleage.getText().trim();
		            	vTire_replace_milleage = txtTire_Rl_Milleage.getText().trim();
		            	vDay_rate = txtDay_Rate.getText().trim();
		            	vEx_km_rate = txtExtra_Km.getText().trim(); 
		            	vAvailability=txtV_availability.getText().trim();
		            	
		            	
		            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy")  ;
				        vPu_date = dateFormat.format(dcPu_date.getDate());
				        vIns_exp_date = dateFormat.format(dcIns_ex_date.getDate());
				        vRl_exp_date = dateFormat.format(dcRl_exp_date.getDate());
		            			            				     		                		                	
				        
				        
		                Database db = new Database();
		                String query = "UPDATE vehicle SET mod_yom = '"+vMod_YOM+"' , color = '"+vColor+"' , no_seats = '"+vNo_seats+"' , pu_date = '"+vPu_date+"' , pu_price = "+vPu_price+" , ins_no = '"+vIns_no+"' , ins_ex_dt = '"+vIns_exp_date+"' , rl_ex_dt = '"+vRl_exp_date+"', lst_ser_km = "+vLst_ser_milleage+" , cu_km = "+vCurrent_milleage+" , tr_rp_km = "+vTire_replace_milleage+",day_rate = "+vDay_rate+" , ex_km_rate = "+vEx_km_rate+", Availability = "+vAvailability+" WHERE vehicle_no = '"+Vno_out+"' ";
		                int rows = db.Save_Del_Update(query);
		                
		                if (rows>0)
		                {

		                	 clearText();
		                    
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              "Data Updated Successfully. "+rows+" Rows updated", 
		                              "Message", 
		                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
		                    
		                  
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
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnSave);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(461, 45, 89, 23);
// Search button click event ## To fill the text fields
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					

				    Vno_out = txtVno.getText().trim();
				
					if (Vno_out.isEmpty() )
		            {
		            
						JOptionPane.showMessageDialog(null, "Please fill all fields","Login Error",JOptionPane.ERROR_MESSAGE);
		                
		            }
		            else
		            {
		                
		                
		                Database db = new Database();
		                String query = "SELECT * FROM vehicle WHERE vehicle_no='"+Vno_out+"'";
		                ResultSet rs = db.GetData(query);
		                
		                
		                rs.next();
		                int rows = rs.getRow();
		                
		                
		                if (rows>0)
		                {
		                	vMod_YOM = rs.getString("mod_yom");
		                	vColor = rs.getString("color");
		                	vNo_seats = rs.getString("no_seats");
		                	vPu_date = rs.getString("pu_date");
		                	vPu_price = rs.getString("pu_price");
		                	vIns_no = rs.getString("ins_no");
		                	vIns_exp_date = rs.getString("ins_ex_dt");
		                	vRl_exp_date = rs.getString("rl_ex_dt");
		                	vLst_ser_milleage = rs.getString("lst_ser_km");
		                	vCurrent_milleage = rs.getString("cu_km");
		                	vTire_replace_milleage = rs.getString("tr_rp_km");
		                	vDay_rate = rs.getString("day_rate");
		                	vEx_km_rate = rs.getString("ex_km_rate");
		                	vAvailability = rs.getString("Availability");
		                			                	
		                	txtMod_Yom.setText(vMod_YOM);
		                	txtColor.setText(vColor);
		                	txtNo_seats.setText(vNo_seats);
		                	txtPu_price.setText(vPu_price);
		                	txtIns_no.setText(vIns_no);
		                	txtLst_Milleage.setText(vLst_ser_milleage);
		                	txtCu_Milleage.setText(vCurrent_milleage);
		                	txtTire_Rl_Milleage.setText(vTire_replace_milleage);
		                	txtDay_Rate.setText(vDay_rate);
		                	txtExtra_Km.setText(vEx_km_rate);
		                	txtV_availability.setText(vAvailability);
		                	
		                	SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");  
		                	Date vPu_datee=formatter1.parse(vPu_date);  
		                	Date vIns_exp_datee=formatter1.parse(vIns_exp_date);
		                	Date vRl_exp_datee=formatter1.parse(vRl_exp_date);
		                	
		                	dcPu_date.setDate(vPu_datee);
		                	dcIns_ex_date.setDate(vIns_exp_datee);
		                	dcRl_exp_date.setDate(vRl_exp_datee);
		                	
		                    
		                }
		                else
		                {
		        
		                	JOptionPane.showMessageDialog(null, "Invalid vehicle number","Try again",JOptionPane.ERROR_MESSAGE);
			                
		                }	
		            }}
				
				catch(SQLException | ParseException e1)
		        {
		            javax.swing.JOptionPane.showMessageDialog(null, 
		                              e1.getMessage(), 
		                              "SQL Exception", 
		                              javax.swing.JOptionPane.WARNING_MESSAGE);	}
			
			}
				
				
			
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnSearch);
		
	
		
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.PINK);
		btnDelete.setBounds(332, 511, 218, 29);
// Delete button click event
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Vno_out=txtVno.getText();
				
				if (Vno_out.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Error occured","Try again",JOptionPane.ERROR_MESSAGE);   
				}
				else
				{
					  Database db = new Database();
	                  String query = "DELETE FROM `vehicle` WHERE vehicle_no='"+Vno_out+"'";
	                     
	                 
	                    	if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this vehicle ?", "Delete Warning",
	        						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
	                    		 int rows = db.Save_Del_Update(query);
	                    		 if (rows>0) {
	                    			 JOptionPane.showMessageDialog( null, "Data Deletion Sucessful !" );
	                    			 clearText();
	     	                         vehiclenoadd();
	                    		 }  
	                        
	                    }
				}
				}catch(Exception e1) {
		             
		             javax.swing.JOptionPane.showMessageDialog(null, 
		                     e1.getMessage(), 
		                     " Exception", 
		                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnDelete);
	//	Del_Visibility_change();
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(38, 113, 543, 344);
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(204, 26, 377, 64);
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(horizontalBox_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_2.setBounds(669, 51, 551, 466);
		contentPane.add(horizontalBox_2);
		
		JLabel lblAvailability = new JLabel();
		lblAvailability.setText("Availability");
		lblAvailability.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAvailability.setBounds(718, 471, 211, 14);
		contentPane.add(lblAvailability);
		
		txtV_availability = new JTextField();
		txtV_availability.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtV_availability.setBounds(979, 465, 187, 20);
		contentPane.add(txtV_availability);
	
		
// Vehicle Number Combo box arrow click event
		cmbV_no.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 fill_Vno_txtfield();
 
	         }
	      });
		vehiclenoadd();
		fill_Vno_txtfield();
		
	}
	
// Method to to get list of vehicle numbers to the combo box
		private void vehiclenoadd()
		    {
			try {
			 Database db = new Database();
             String query = "SELECT vehicle_no FROM vehicle";
             ResultSet rs = db.GetData(query);
             
             
             while(rs.next())
             {
             
            	 cmbV_no.addItem(rs.getString(1));
             }
     
			}catch(Exception e1) {
             
             javax.swing.JOptionPane.showMessageDialog(null, 
                     e1.getMessage(), 
                     " Exception", 
                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
     
       
		    }
		
// Method to fill vehicle number text box 
		private void fill_Vno_txtfield() {
			String cmbout = cmbV_no.getSelectedItem().toString();
			txtVno.setText(cmbout);
			
		}

// Method to check the existence of empty text fields
		private boolean checkNotEmpty()
	    {
	        boolean notEmpty = true;
	        String message = "";
	        

	        
	        if(txtMod_Yom.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer name is empty";
	        }
	        if(txtColor.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer driving licen number";
	        }
	        if(txtNo_seats.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer NIC number is empty";
	        }
	        if(txtPu_price.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer address is empty";
	        }
	        if(txtIns_no.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer mobile number is empty";
	        }
	        if(txtLst_Milleage.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer second contact number is empty";
	        }
	        if(txtCu_Milleage.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer occupation is empty";
	        }
	        if(txtTire_Rl_Milleage.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer workplace telephone number is empty";
	        }
	        if(txtDay_Rate.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer occupation is empty";
	        }
	        if(txtExtra_Km.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer workplace telephone number is empty";
	        }
	        if(txtV_availability.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Availability field is null";
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
		
		// Method to clean textboxes
		private void clearText()
	    {
			txtVno.setText("");
			txtMod_Yom.setText("");
			txtColor.setText("");
			txtNo_seats.setText("");
			txtPu_price.setText("");
			txtIns_no.setText("");
			txtLst_Milleage.setText("");
			txtCu_Milleage.setText("");
			txtTire_Rl_Milleage.setText("");
			txtDay_Rate.setText("");
			txtExtra_Km.setText("");
			txtV_availability.setText("");   
	    }
		
		
//Method to check insuarance & revenue renewal reset
		public static void Renewal_Changes()
	    {
			try {
				
				Database db = new Database();
		//		String queryy = "SELECT vehicle_no,pu_date,ins_ex_dt,rl_ex_dt FROM vehicle ";
				String query = "SELECT * FROM vehicle ";
				ResultSet rs = db.GetData(query);

				
		
			while (rs.next()) {
		
		     			     
		    	V_no = rs.getString("vehicle_no");	
		     	vPu_dateY = rs.getString("pu_date");     	
		     	vIns_exp_dateY = rs.getString("ins_ex_dt");
		     	vRl_exp_dateY = rs.getString("rl_ex_dt");
		     	String vAvailabilityy = rs.getString("Availability");
		     	
		     	 last_servicee = Integer.parseInt(last_service);
			     current_milleagee = Integer.parseInt(last_service) ;
			     Service_expect_kmm = last_servicee + 4000 ;
		     	
		     	
		     	vPu_dateeY=formatter1.parse(vPu_dateY);  
		     	vIns_exp_dateeY=formatter1.parse(vIns_exp_dateY);
		     	vRl_exp_dateeY=formatter1.parse(vRl_exp_dateY);
		     	
		  //   	System.out.println( vPu_dateY + ", " + vRl_exp_dateY  + ", " + vIns_exp_dateeY  
           //             );
		     	if (vAvailabilityy.equals(0)) {
		     	if (vIns_exp_dateeY.after(xdateY)) {
		     		JOptionPane.showMessageDialog(null, "Vehicle Insurance Renewed  " + V_no,"Notification",JOptionPane.INFORMATION_MESSAGE);
		     		VehicleMaintenanceMethods.AvailabilitySetOne();
		     	}
		     	
		     	
		     	if (vRl_exp_dateeY.after(xdateY)) {
		     		JOptionPane.showMessageDialog(null, "Vehicle Revenue license Renewed  " + V_no,"Notification",JOptionPane.INFORMATION_MESSAGE);
		     		VehicleMaintenanceMethods.AvailabilitySetOne();
		     	}
		     	
		     	if (Service_expect_kmm < current_milleagee) {
		     		JOptionPane.showMessageDialog(null, "Please service the vehicle  " + V_no,"Vehicle Service Warning",JOptionPane.WARNING_MESSAGE);
		     		VehicleMaintenanceMethods.AvailabilitySetOne();
		     	}
		     	
		     	
		     	}
			}}

		catch(SQLException | ParseException e1)
		{
		 javax.swing.JOptionPane.showMessageDialog(null, 
		                   e1.getMessage(), 
		                   "SQL Exception", 
		                   javax.swing.JOptionPane.WARNING_MESSAGE);	}


			
	    }	
		
}
