package CamSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.temporal.ChronoUnit;

import CamSys.Database;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Frm_Add_Order extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrd_id;
	private JTextField txtCus_id;
	private JTextField txtCustomer_name;
	private JTextField txtStart_km;
	private JTextField txtEnd_km;
	private JTextField txtDamage_claim;
	private JTextField txtTotal;
	private JTextField txtAdvance;
	private JTextField txtBalance;
	private JTextField txtNo_days_rented;
	private JTextField txtDay_rent_total;
	private JTextField txtExtra_km_total;
	private JTextField txtTrip_milleage;
	private JButton btnClear;
	private JButton btnLoad;
	private JComboBox cmbV_no;
	private JComboBox cmbCustomer_mobile;
	private JDateChooser dcReserve_date;
	private JDateChooser dcTrip_start_date;
	private JDateChooser dcTrip_end_date;
	private JTextField txtDayRate;
	private JLabel lblVeextraKmRate;
	private JTextField txtEx_km_rate;
	private JLabel lblNoOfDays;
	private JLabel lblBasicPackageTotal;
	private JLabel lblExtraKmPrice;
	private JLabel lblTripMilleage;	
	private JLabel lblBalanceAmount;
	private JLabel lblVehicleDayRate ;
	private JTextField txtCus_address;
	private JTextField txtVmodel;
	private String Excess_kmmm;
	
	
	private String Ord_IDD ;
	private String Customer_ID ;
	private String C_name ;
	private String Starting_km ;
	private String End_km ;
	private String Damage_claims ;
	private String Ord_total ;
	private String Ord_advance;
	private String Ord_balance ;
	private String Ord_day_count ;
	private String Ord_day_rent_total ;
	private String Ord_extra_km ;
	private String Ord_trip_milleage ;
	private String Trip_start_date ;
	private String Trip_end_date;
	private String Reserved_date;
	private String Excess_km;
	private String noOfTripDays;
	private String Trip_milleage;
	private String Customer_mobile;
	private String Customer_address;
	private String Vday_rate;
	private String Excess_rate;
	private String Vmodel;
	private String V_no;
	private Boolean V_State;
	private boolean notEmpty;
	
	
	private Date xdate = new Date();
	private JTextField textField;
	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Add_Order frame = new Frm_Add_Order();
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
	public Frm_Add_Order() {
		setTitle("New Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1040, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);				
		
		
		
		JLabel lblOrderId = new JLabel();
		lblOrderId.setText("Order ID");
		lblOrderId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderId.setBounds(56, 72, 144, 14);
		contentPane.add(lblOrderId);
		
		JLabel lblCusId = new JLabel();
		lblCusId.setText("Customer Address ");
		lblCusId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCusId.setBounds(56, 116, 144, 14);
		contentPane.add(lblCusId);
		
		JLabel lblCusname = new JLabel();
		lblCusname.setText("Customer Name");
		lblCusname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCusname.setBounds(56, 160, 144, 14);
		contentPane.add(lblCusname);
		
		JLabel lblReserved = new JLabel();
		lblReserved.setText("Reserved Date");
		lblReserved.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReserved.setBounds(56, 255, 144, 14);
		contentPane.add(lblReserved);
		
		JLabel lblTripStartDate = new JLabel();
		lblTripStartDate.setText("Trip Start Date");
		lblTripStartDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTripStartDate.setBounds(56, 302, 144, 14);
		contentPane.add(lblTripStartDate);
		
		JLabel lblTripEndDate = new JLabel();
		lblTripEndDate.setText("Trip End Date");
		lblTripEndDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTripEndDate.setBounds(56, 350, 144, 14);
		contentPane.add(lblTripEndDate);
		
		JLabel lblS = new JLabel();
		lblS.setText("Starting Milleage");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblS.setBounds(56, 401, 144, 14);
		contentPane.add(lblS);
		
		JLabel lblTripEndMilleage = new JLabel();
		lblTripEndMilleage.setText("Trip End Milleage");
		lblTripEndMilleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTripEndMilleage.setBounds(56, 447, 144, 14);
		contentPane.add(lblTripEndMilleage);
		
		JLabel lblDamageClaim = new JLabel();
		lblDamageClaim.setText("Damage Claim");
		lblDamageClaim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDamageClaim.setBounds(56, 496, 144, 14);
		contentPane.add(lblDamageClaim);
		
		JLabel lblTotal = new JLabel();
		lblTotal.setText("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(531, 465, 144, 14);
		contentPane.add(lblTotal);
				
		JLabel lblAdvance = new JLabel();
		lblAdvance.setText("Advance Paid");
		lblAdvance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdvance.setBounds(531, 515, 144, 14);
		contentPane.add(lblAdvance);
		
		JLabel lblVehicleNumber = new JLabel();
		lblVehicleNumber.setText("Vehicle Number");
		lblVehicleNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleNumber.setBounds(531, 74, 144, 14);
		contentPane.add(lblVehicleNumber);
		
		JLabel lblCustomerMobile = new JLabel();
		lblCustomerMobile.setText("Customer Mobile");
		lblCustomerMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerMobile.setBounds(531, 118, 144, 14);
		contentPane.add(lblCustomerMobile);
				
		lblVehicleDayRate = new JLabel();
		lblVehicleDayRate.setText("Vehicle Day Rate");
		lblVehicleDayRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleDayRate.setBounds(531, 162, 144, 14);
		contentPane.add(lblVehicleDayRate);
			
		lblVeextraKmRate = new JLabel();
		lblVeextraKmRate.setText("Extra Km Rate");
		lblVeextraKmRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVeextraKmRate.setBounds(531, 203, 144, 14);
		contentPane.add(lblVeextraKmRate);
			
		lblNoOfDays = new JLabel();
		lblNoOfDays.setText("No Of Days Rented");
		lblNoOfDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoOfDays.setBounds(531, 252, 144, 14);
		contentPane.add(lblNoOfDays);
		
		lblBasicPackageTotal = new JLabel();
		lblBasicPackageTotal.setText("Day Rent Total");
		lblBasicPackageTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBasicPackageTotal.setBounds(531, 300, 144, 14);
		contentPane.add(lblBasicPackageTotal);
		
		lblExtraKmPrice = new JLabel();
		lblExtraKmPrice.setText("Extra KM Total");
		lblExtraKmPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExtraKmPrice.setBounds(531, 351, 144, 14);
		contentPane.add(lblExtraKmPrice);
		
		lblTripMilleage = new JLabel();
		lblTripMilleage.setText("Trip Milleage");
		lblTripMilleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTripMilleage.setBounds(531, 408, 144, 14);
		contentPane.add(lblTripMilleage);
				
		lblBalanceAmount = new JLabel();
		lblBalanceAmount.setText("Balance Amount");
		lblBalanceAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBalanceAmount.setBounds(531, 566, 144, 14);
		contentPane.add(lblBalanceAmount);
		
		txtOrd_id = new JTextField();
		txtOrd_id.setEditable(false);
		txtOrd_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOrd_id.setBounds(245, 69, 187, 20);
		contentPane.add(txtOrd_id);
		set_order_id();
		
		txtCus_id = new JTextField();
		txtCus_id.setEnabled(false);
		txtCus_id.setEditable(false);
		txtCus_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCus_id.setBounds(470, 116, 19, 20);
		txtCus_id.setVisible(false);
		contentPane.add(txtCus_id);
		
		txtCustomer_name = new JTextField();
		txtCustomer_name.setEditable(false);
		txtCustomer_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCustomer_name.setBounds(245, 157, 187, 20);
		contentPane.add(txtCustomer_name);
		
		txtStart_km = new JTextField();
		txtStart_km.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtStart_km.setBounds(245, 404, 187, 20);
		contentPane.add(txtStart_km);
		
		txtEnd_km = new JTextField();
		txtEnd_km.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEnd_km.setBounds(245, 450, 187, 20);
		contentPane.add(txtEnd_km);
		
		txtDamage_claim = new JTextField();
		txtDamage_claim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDamage_claim.setBounds(245, 496, 187, 20);
		contentPane.add(txtDamage_claim);
		txtDamage_claim.setText("0");
		txtDamage_claim.enable(false);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTotal.setBounds(729, 462, 187, 20);
		contentPane.add(txtTotal);
		
		txtAdvance = new JTextField();
		txtAdvance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAdvance.setBounds(729, 512, 187, 20);
		contentPane.add(txtAdvance);
		
		txtDayRate = new JTextField();
		txtDayRate.setEditable(false);
		txtDayRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDayRate.setBounds(729, 157, 187, 20);
		contentPane.add(txtDayRate);
		
		txtEx_km_rate = new JTextField();
		txtEx_km_rate.setEditable(false);
		txtEx_km_rate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEx_km_rate.setBounds(729, 200, 187, 20);
		contentPane.add(txtEx_km_rate);
		
		txtNo_days_rented = new JTextField();
		txtNo_days_rented.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNo_days_rented.setEditable(false);
		txtNo_days_rented.setBounds(729, 247, 187, 20);
		contentPane.add(txtNo_days_rented);
		
		txtDay_rent_total = new JTextField();
		txtDay_rent_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDay_rent_total.setEditable(false);
		txtDay_rent_total.setBounds(729, 295, 187, 20);
		contentPane.add(txtDay_rent_total);
		
		txtExtra_km_total = new JTextField();
		txtExtra_km_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtExtra_km_total.setEditable(false);
		txtExtra_km_total.setBounds(729, 346, 187, 20);
		contentPane.add(txtExtra_km_total);
		
		txtTrip_milleage = new JTextField();
		txtTrip_milleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTrip_milleage.setEditable(false);
		txtTrip_milleage.setBounds(729, 405, 187, 20);
		contentPane.add(txtTrip_milleage);
		

		txtBalance = new JTextField();
		txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBalance.setEditable(false);
		txtBalance.setBounds(729, 563, 187, 20);
		contentPane.add(txtBalance);
		
		cmbV_no = new JComboBox();
		cmbV_no.setBounds(741, 70, 175, 22);
		contentPane.add(cmbV_no);
		vehiclenoadd();
		
		cmbCustomer_mobile = new JComboBox();
		cmbCustomer_mobile.setBounds(741, 114, 175, 22);
		contentPane.add(cmbCustomer_mobile);
		mobileadd();
						
		dcReserve_date = new JDateChooser();
		dcReserve_date.setBounds(245, 255, 187, 20);
		contentPane.add(dcReserve_date);
		dcReserve_date.setDateFormatString("yyyy/MM/dd");
		dcReserve_date.setDate(xdate);
		
		
		dcTrip_start_date = new JDateChooser();
		dcTrip_start_date.setBounds(245, 302, 187, 20);
		contentPane.add(dcTrip_start_date);
		dcTrip_start_date.setDateFormatString("yyyy/MM/dd");
		dcTrip_start_date.setDate(xdate);
		
		
		dcTrip_end_date = new JDateChooser();
		dcTrip_end_date.setBounds(245, 350, 187, 20);
		contentPane.add(dcTrip_end_date);
		dcTrip_end_date.setDateFormatString("yyyy/MM/dd");
		dcTrip_end_date.setDate(xdate);
	
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.PINK);
// Clear button click event
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				clear_text();
				set_order_id() ;
				}
				catch(Exception e1) {
		             
		             javax.swing.JOptionPane.showMessageDialog(null, 
		                     e1.getMessage(), 
		                     " Exception", 
		                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
		     
				}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(56, 605, 116, 23);
		contentPane.add(btnClear);
		
		
		
		btnLoad = new JButton("Load");
		btnLoad.setBackground(Color.CYAN);
// Load button click event
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				fill_customer_fields();
				fill_vehicle_fields();
				
				
            	
            	if(checkNotEmpty()) {
					trip_milleage_count();
					trip_day_count();
					excess_km_count();
					vDay_total_count();
					
					order_total_cal();
					order_balance_cal();
					
				
				}
				
				 }
		        catch(Exception e1)
		        {
		                javax.swing.JOptionPane.showMessageDialog(null,
		                    e1.getMessage(),
		                    "SQL Exception",
		                    javax.swing.JOptionPane.WARNING_MESSAGE);
		        }
			}
				
		});
		
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLoad.setBounds(197, 605, 103, 23);
		contentPane.add(btnLoad);
		
		txtCus_address = new JTextField();
		txtCus_address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCus_address.setEditable(false);
		txtCus_address.setBounds(245, 110, 187, 20);
		contentPane.add(txtCus_address);		
		
		txtVmodel = new JTextField();
		txtVmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtVmodel.setEditable(false);
		txtVmodel.setBounds(245, 203, 187, 20);
		contentPane.add(txtVmodel);
		
		JLabel lblVehicleModel = new JLabel();
		lblVehicleModel.setText("Vehicle Model ");
		lblVehicleModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleModel.setBounds(56, 206, 144, 14);
		contentPane.add(lblVehicleModel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
// Save button click event
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
		        {
		     
		       	        Ord_IDD = txtOrd_id.getText();
		       			Customer_ID = txtCus_id.getText();
		       			C_name = txtCustomer_name.getText();
		       			Starting_km = txtStart_km.getText();
		       			End_km = txtEnd_km.getText();
		       			Damage_claims = txtDamage_claim.getText();
		       			Ord_total = txtTotal.getText();
		       			Ord_advance = txtAdvance.getText();
		       			Ord_balance = txtBalance.getText();
		       			Ord_day_count = txtNo_days_rented.getText();
		       			Ord_day_rent_total = txtDay_rent_total.getText() ;
		       			Ord_extra_km = txtExtra_km_total.getText();
		       			Ord_trip_milleage = txtTrip_milleage.getText();
		       			V_no = cmbV_no.getSelectedItem().toString();
		    			
		       			//
		       			//excess_km_count();
		       			
		            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")  ;
		            	Reserved_date = dateFormat.format(dcReserve_date.getDate());
		            	Trip_start_date = dateFormat.format(dcTrip_start_date.getDate());
		            	Trip_end_date = dateFormat.format(dcTrip_end_date.getDate());
		       			
				        Excess_rate = txtEx_km_rate.getText().trim();
				        Vday_rate =  txtDayRate.getText().trim();
				        Customer_address = txtCus_address.getText();
				        Vmodel = txtVmodel.getText().trim();
		  
		                
		                String message ="";
		                
		                TextValidations();
		                
		            	if(checkNotEmpty()) {
		    
		                    
		                    Database db = new Database();
		                    String query = "INSERT INTO orderx (ord_id, cus_id, reserved_date, vehicle_no, start_date,end_date, str_km, total, adv_paid, Contact_One) VALUES ('"+ Ord_IDD+"','"+Customer_ID+"','"+Reserved_date+"','"+V_no+"','"+Trip_start_date+"','"+Trip_end_date+"','"+Starting_km +"','"+Ord_total+"','"+Ord_advance+"','"+Customer_mobile+"')";

		                    int rows = db.Save_Del_Update(query);

		                    if (rows>0)
		                    {
		                 
		                    	JOptionPane.showMessageDialog( null, "Data Insertion Sucessful !" );
		                    	AvailabilitySet();
		                     //   clear_text();
		                    //	set_order_id();
		                        
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
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(316, 605, 116, 23);
		contentPane.add(btnSave);
		
		JButton btnCreateInvoice = new JButton("Create Invoice");
		btnCreateInvoice.setBackground(Color.CYAN);
//Create invoice button click event
		btnCreateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?useSSL=false","root","");
					
					HashMap param = new HashMap();
					param.put("ord_idx",Ord_IDD);
					param.put("c_idx",Customer_ID);
					param.put("c_namex",C_name);
					param.put("s_kmx",Starting_km);
					param.put("e_kmx",End_km);
					param.put("damagex",Damage_claims);
					param.put("ototalx",Ord_total);
					param.put("oad_x",Ord_advance);
					param.put("obalancex",Ord_balance);
					param.put("odaycountx",Ord_day_count);
					param.put("odtotalx",Ord_day_rent_total);
					
					param.put("oexkmx",Ord_extra_km);
					param.put("otripkmx",Ord_trip_milleage);
					param.put("vnox",V_no);
					param.put("exratex",Excess_rate);
					param.put("vdayratex",Vday_rate);
					param.put("caddrx",Customer_address);
					param.put("vmodelx",Vmodel);
					param.put("vredatex",Reserved_date);
					param.put("tripstartdatex",Trip_start_date);
					param.put("tripenddatex",Trip_end_date);
					param.put("excess_kmxx",Excess_kmmm);
					param.put("cmobilex",Customer_mobile);
					
					
					String sql = "SELECT * FROM orderx";
			
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\GTC\\Desktop\\ProjectCRMS\\src\\CamSys\\Invoice.jrxml");
					
					JRDesignQuery updateQuery = new JRDesignQuery();
					
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport,param, con);
					
					JasperViewer.viewReport(JasperPrint, false);
					
					
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			
			
				
				
				
			}
		});
		btnCreateInvoice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateInvoice.setBounds(640, 628, 234, 23);
		contentPane.add(btnCreateInvoice);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(926, 348, 19, 20);
		contentPane.add(textField);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(27, 46, 439, 515);
		contentPane.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_1.setBounds(503, 46, 447, 557);
		contentPane.add(horizontalBox_1);
		
	}
	
	
	
// Method to fill vehicle number text box 
		private void clear_text() {
			try {
			txtOrd_id.setText("");
			txtCus_id.setText("");
			txtDay_rent_total.setText("");
			txtCustomer_name.setText("");
			txtStart_km.setText("");
			txtEnd_km.setText("");
			txtDamage_claim.setText("");
			txtTotal.setText("");
			txtAdvance.setText("");
			txtExtra_km_total.setText("");
			txtNo_days_rented.setText("");	
			txtTrip_milleage.setText("");
			txtBalance.setText("");
        	txtDayRate.setText("");
        	txtEx_km_rate.setText("");	                	
        	txtVmodel.setText("");       
			}
			catch(Exception e1) {
	             
	             javax.swing.JOptionPane.showMessageDialog(null, 
	                     e1.getMessage(), 
	                     " Exception", 
	                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
	     
			}
		
		

// Method to to get list of customer mobile phone numbers to the combo box
		private void mobileadd()
		    {
			try {
			 Database db = new Database();
             String query = "SELECT contact_one FROM customer";
             ResultSet rs = db.GetData(query);
             
             
             while(rs.next())
             {
             
            	 cmbCustomer_mobile.addItem(rs.getString(1));
             }
     
			}catch(Exception e1) {
             
             javax.swing.JOptionPane.showMessageDialog(null, 
                     e1.getMessage(), 
                     " Exception", 
                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
     
       
		    }
		
		
// Method to calculate the order total
		private void order_total_cal() {
			try {					
			Excess_km = txtExtra_km_total.getText();
			int Excess_kmm = Integer.parseInt(Excess_km);  
			
			noOfTripDays = txtNo_days_rented.getText();
			int noOfTripDayss = Integer.parseInt(noOfTripDays); 
			
			Vday_rate = txtDayRate.getText();
			int Vday_ratee = Integer.parseInt(Vday_rate);
						
			Excess_rate = txtEx_km_rate.getText();
			int Excess_ratee = Integer.parseInt(Excess_rate);
						
			int Ord_totall =  (Excess_kmm * Excess_ratee) + (noOfTripDayss * Vday_ratee ) ;
			Ord_total = Integer.toString(Ord_totall);
			
		
			txtTotal.setText(Ord_total);
						
				}
		catch(Exception e1) {
            
            javax.swing.JOptionPane.showMessageDialog(null, 
                    e1.getMessage(), 
                    " Exception", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);	}
    
		}
	
		
// Method to calculate the order balance
		private void order_balance_cal() {
			try {
			Ord_total =	txtTotal.getText()	;	
			int Ord_totall = Integer.parseInt(Ord_total ); 
			
			Ord_advance = txtAdvance.getText();
			int Ord_advancee = Integer.parseInt(Ord_advance ); 
			
			int Ord_balancee = Ord_totall - Ord_advancee;
			Ord_balance = Integer.toString(Ord_balancee);
			txtBalance.setText(Ord_balance);								
				}
		catch(Exception e1) {
            
            javax.swing.JOptionPane.showMessageDialog(null, 
                    e1.getMessage(), 
                    " Exception", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);	}
    
		}
	

		
		
// Method to calculate the excess km of the trip
		private void excess_km_count() {
			try {			
			noOfTripDays = txtNo_days_rented.getText();
			int noOfTripDayss = Integer.parseInt(noOfTripDays);  
			
			Trip_milleage = txtTrip_milleage.getText();
			int Trip_milleagee = Integer.parseInt(Trip_milleage);  
			int Excess_kmm =  Trip_milleagee - (noOfTripDayss * 100)  ;
			Excess_kmmm = Integer.toString(Excess_kmm);
			if (Excess_kmm > 0) {
				txtExtra_km_total.setText(Excess_kmmm);
			}
			else {
			txtExtra_km_total.setText("0");
				}}
			catch(Exception e1) {
	             
	             javax.swing.JOptionPane.showMessageDialog(null, 
	                     e1.getMessage(), 
	                     " Exception", 
	                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
			}
		
		// Method to calculate the total for noraml 100km for the days of trip
				private void vDay_total_count() {
					try {	
						
					noOfTripDays = txtNo_days_rented.getText();
					int noOfTripDayss = Integer.parseInt(noOfTripDays);  
					
					Vday_rate = txtDayRate.getText();
					int Vday_ratee = Integer.parseInt(Vday_rate); 
					
					int Vday_total =   noOfTripDayss * Vday_ratee  ;
					String Vday_totall = Integer.toString(Vday_total);
					
					if ( Vday_total > 0) {
						txtDay_rent_total.setText(Vday_totall);
					}
					else {
						 JOptionPane.showMessageDialog(null, "Error","Please check the other feilds & try again ",JOptionPane.ERROR_MESSAGE);
						}}
					catch(Exception e1) {
			             
			             javax.swing.JOptionPane.showMessageDialog(null, 
			                     e1.getMessage(), 
			                     " Exception", 
			                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
					}
				
		
			
		
// Method to calculate the trip milleage 
		private void trip_day_count() {
			try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")  ;
	        Trip_start_date = dateFormat.format(dcTrip_start_date.getDate());
	        Trip_end_date = dateFormat.format(dcTrip_end_date.getDate());
	        
			LocalDate dateBefore = LocalDate.parse(Trip_start_date);
			LocalDate dateAfter = LocalDate.parse(Trip_end_date);
			
			long noOfTripDays = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			String noOfTripDayss = Long.toString(noOfTripDays);
			
			txtNo_days_rented.setText(noOfTripDayss);
			}
			catch(Exception e1) {
	             
	             javax.swing.JOptionPane.showMessageDialog(null, 
	                     e1.getMessage(), 
	                     " Exception", 
	                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
	     
			}
		
// Method to calculate the trip milleage 
		private void trip_milleage_count() {
			try {
			Starting_km = txtStart_km.getText();
			End_km = txtEnd_km.getText();

			int Starting_kmm =Integer.parseInt(Starting_km); 
			int End_kmm =Integer.parseInt(End_km); 
			Integer milleage_count =   End_kmm - Starting_kmm;
			String milleage_countt = Integer.toString(milleage_count);
			txtTrip_milleage.setText(milleage_countt);
			}
			catch(Exception e1) {
	             
	             javax.swing.JOptionPane.showMessageDialog(null, 
	                     e1.getMessage(), 
	                     " Exception", 
	                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
	     
			}
		
		
		
// Method to to get list of vehicle numbers to the combo box
				private void vehiclenoadd()
				    {
					try {
					 Database db = new Database();
		             String query = "SELECT vehicle_no FROM vehicle WHERE Availability=1 ";
		             ResultSet rs = db.GetData(query);
		             
		             while(rs.next())
		             {
		             
		            	 cmbV_no.addItem(rs.getString(1));
		             }
		     
					}
					catch(Exception e1) {
		             
		             javax.swing.JOptionPane.showMessageDialog(null, 
		                     e1.getMessage(), 
		                     " Exception", 
		                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
		     
		       
				    }
		

		
// Method to fill Order id text box 
		private void set_order_id() {
			
			    
			    		try
			            {
			                Database db = new Database();
			                String query = "SELECT MAX(ord_id) AS M_ord_ID FROM orderx";
			                ResultSet rs = db.GetData(query);
			                
			                rs.next();
			                
			                int rows = rs.getRow();
			                if(rows > 0)
			                {
			                    int Max_ord_ID = Integer.parseInt(rs.getString("M_ord_ID"));
			                    Max_ord_ID++;
			                    String ord_ID = String.format("%04d", Max_ord_ID);
			                    txtOrd_id.setText(String.valueOf(ord_ID));
			                
			                }
			                else
			                {
			                   
			                	 JOptionPane.showMessageDialog(null, "Error","Error occured while creating a new Order Id",JOptionPane.ERROR_MESSAGE);
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
		
// Method to fill the customer related fields extracted from customer table
		private void fill_customer_fields() {
			try {
				
				Customer_mobile = cmbCustomer_mobile.getSelectedItem().toString();
			
			
				if (Customer_mobile.isEmpty() )
	            {
	            
					JOptionPane.showMessageDialog(null, "Please fill all fields","Login Error",JOptionPane.ERROR_MESSAGE);
	                
	            }
	            else
	            {
	                
	                
	                Database db = new Database();
	                String query = "SELECT * FROM customer WHERE contact_one='"+Customer_mobile+"'";
	                ResultSet rs = db.GetData(query);
	                
	                
	                rs.next();
	                int rows = rs.getRow();
	                
	                
	                if (rows>0)
	                {
	                	
	                	
	                	Customer_ID = rs.getString("cus_id");
	                	C_name = rs.getString("cus_name");	                	
	                	Customer_address = rs.getString("address");
	                	
	                	txtCus_id.setText(Customer_ID);
	                	txtCustomer_name.setText(C_name);	                	
	                	txtCus_address.setText(Customer_address);
	                		                    
	                }
	                else
	                {
	        
	                	JOptionPane.showMessageDialog(null, "Invalid customer mobile number","Try again",JOptionPane.ERROR_MESSAGE);
		                
	                }	
	            }}
			
			catch(SQLException  e1)
	        {
	            javax.swing.JOptionPane.showMessageDialog(null, 
	                              e1.getMessage(), 
	                              "SQL Exception", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);	}
		
		}		
		

		
		
		
		
		
		
// Method to fill vehicle related fields extracted from vehicle table
		private void fill_vehicle_fields() {
			try {
				
				String V_no = cmbV_no.getSelectedItem().toString();
			
			
				if (V_no.isEmpty() )
	            {
	            
					JOptionPane.showMessageDialog(null, "Please fill all fields","Login Error",JOptionPane.ERROR_MESSAGE);
	                
	            }
	            else
	            {
	                
	                
	                Database db = new Database();
	                String query = "SELECT * FROM vehicle WHERE vehicle_no='"+V_no+"'";
	                ResultSet rs = db.GetData(query);
	                
	                
	                rs.next();
	                int rows = rs.getRow();
	                
	                
	                if (rows>0)
	                {
	                	
	                	Vday_rate = rs.getString("day_rate");
	                	Excess_rate = rs.getString("ex_km_rate");	                	
	                	Vmodel = rs.getString("mod_yom");
	                	
	                	String Cu_km = rs.getString("cu_km");
	                	
	                	txtDayRate.setText(Vday_rate);
	                	txtEx_km_rate.setText(Excess_rate);	                	
	                	txtVmodel.setText(Vmodel);
	                	txtStart_km.setText(Cu_km);
	                	
	                }
	                else
	                {
	        
	                	JOptionPane.showMessageDialog(null, "Invalid vehicle number","Try again",JOptionPane.ERROR_MESSAGE);
		                
	                }	
	            }}
			
			catch(SQLException  e1)
	        {
	            javax.swing.JOptionPane.showMessageDialog(null, 
	                              e1.getMessage(), 
	                              "SQL Exception", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);	}
		
		}	
	
		
// Method to check empty fields
		private boolean checkNotEmpty()
	    {
	        notEmpty = true;
	        String message = "";
	        
	     
	        if(txtOrd_id.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Order ID is empty";
	        }
	        if(txtCus_id.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer ID is empty";
	        }
	        if(txtCustomer_name.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer Name is empty";
	        }
	        if(txtStart_km.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Trip Starting Milleage is empty";
	        }
	        if(txtDayRate.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Vehicle per Day Rent is empty";
	        }
	        if(txtEx_km_rate.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Vehicle Extra Km Rate is empty";
	        }
	        if(txtCus_address.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Customer Address is empty";
	        }
	        if(txtVmodel.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Vehicle Model is empty";
	        }
	        if(txtAdvance.getText().trim().isEmpty())
	        {
	            notEmpty = false;
	            message = "Order Advance is empty";
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

// Method to calculate the trip milleage 
		private void AvailabilitySet() {
			try {
		                    
		            	int V_StateX = 0;
		                Database db = new Database();
		                
		                String query = "UPDATE vehicle SET Availability = '"+V_StateX+"'  WHERE 	vehicle_no = '"+V_no+"' ";
		                int rows = db.Save_Del_Update(query);
		                
		                if (rows>0)
		                {
		                    
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              "Vehicle State Changed Successfully. "+rows+" Rows updated", 
		                              "Message", 
		                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
		                    
		            
		                }
		                else
		                {
		                    
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              "Vehicle State Change Failed. "+rows+" Rows updated", 
		                              "Error", 
		                              javax.swing.JOptionPane.WARNING_MESSAGE);
		                }
				
				}
			catch(Exception e1) {
	             
	             javax.swing.JOptionPane.showMessageDialog(null, 
	                     e1.getMessage(), 
	                     " Exception", 
	                     javax.swing.JOptionPane.WARNING_MESSAGE);	
	     
			} 
			
		}

//Method to check for only numeric characters 
		private void CharachterTest(String CharTestInput,String MessageX) {
			
			char[] txtConArrX = CharTestInput.toCharArray();
			char[] numX = {'0','1','2','3','4','5','6','7','8','9'};
			int j;

			for (int i = 0; i < txtConArrX.length; i++) {
			
				  for( j = 0; j < numX.length; j++) {
					  System.out.println("txtConArrX[i]: "+String.valueOf(txtConArrX[i]));
					  System.out.println("numX[j]: "+String.valueOf(numX[j]));
				    if (txtConArrX[i]==numX[j]) {
				
				    	break;
				    }
				    
				  }
				  if ((numX.length)==j) {
				
					  JOptionPane.showMessageDialog(null, MessageX, "Validation Error",JOptionPane.WARNING_MESSAGE);
					  notEmpty = false;
					  break;
				  }
				  
				 
				}			
		}

// Method to execute check validations methods
			private void TextValidations()
			    {	
					// Starting Milleage text check
					Starting_km = txtStart_km.getText();
					CharachterTest(Starting_km,"Starting Milleage can only contain numbers");
					
					// Ending Milleage test check
					End_km = txtEnd_km.getText();
					CharachterTest(End_km,"Ending Milleage can only contain numbers");
		       
					// Damage Claim test check
					Damage_claims = txtDamage_claim.getText();
					CharachterTest(Damage_claims,"Damage claim can only contain numbers");	
		       		
					// Damage Claim test check
					Ord_advance = txtAdvance.getText();
					CharachterTest(Ord_advance,"Advance amount can only contain numbers");	
		       								
			    }		
			

		
		
}
