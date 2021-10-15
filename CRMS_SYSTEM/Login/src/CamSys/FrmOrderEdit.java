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

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class FrmOrderEdit extends JFrame {
	private JTextField txtOrd_id;
	private JTextField txtCus_address;
	private JTextField txtCustomer_name;
	private JTextField txtStart_km;
	private JTextField txtEnd_km;
	private JTextField txtDamage_claim;
	private JTextField txtVmodel;
	private JTextField txtCus_id;
	private JTextField txtDayRate;
	private JTextField txtEx_km_rate;
	private JTextField txtNo_days_rented;
	private JTextField txtDay_rent_total;
	private JTextField txtExtra_km;
	private JTextField txtTrip_milleage;
	private JTextField txtTotal;
	private JTextField txtPaymentF;
	private JTextField txtBalance;
	private JComboBox cmbV_no;
	private JComboBox cmbOrd_date;
	private JComboBox cmbCustomer_mobile;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnClear;
	private JButton btnInvoice;
	private JDateChooser dcTrip_end_date;

	
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
	private String milleage_countt;
	private String ExcesTotalX;
	private String  DayRentTotalX;
	private String Ord_PaymentFinal;
	private String Ord_PaymentFinalX;
	private JButton btnDelete;
		
	
	private Date xdate = new Date();
	private JTextField txt_reserve_date;
	private String Excess_kmmX;
	private JTextField txtPreviousAdvance;
	
	
	private boolean V_State;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOrderEdit frame = new FrmOrderEdit();
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
	public FrmOrderEdit() {
		setTitle("Edit & Delete Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1044, 750);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("Order ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(58, 171, 144, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Customer Address ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(58, 287, 144, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Customer Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(58, 224, 144, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Reserved Date");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(58, 348, 144, 14);
		getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Trip End Date");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(58, 413, 144, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setText("Starting Milleage");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(58, 471, 144, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setText("Trip End Milleage");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(58, 527, 144, 14);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel();
		label_8.setText("Damage Claim");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(58, 584, 144, 14);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setText("Vehicle Model ");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_9.setBounds(421, 78, 144, 14);
		getContentPane().add(label_9);
		

		JLabel label_10 = new JLabel();
		label_10.setText("Vehicle Number");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(421, 34, 144, 14);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel();
		label_11.setText("Customer Mobile");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(34, 34, 144, 14);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel();
		label_12.setText("Vehicle Day Rate");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_12.setBounds(576, 176, 144, 14);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel();
		label_13.setText("Extra Km Rate");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_13.setBounds(576, 217, 144, 14);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel();
		label_14.setText("No Of Days Rented");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_14.setBounds(576, 266, 144, 14);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel();
		label_15.setText("Day Rent Total");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_15.setBounds(576, 314, 144, 14);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel();
		label_16.setText("Extra KM Total");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_16.setBounds(576, 365, 144, 14);
		getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel();
		label_17.setText("Trip Milleage");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_17.setBounds(576, 422, 144, 14);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel();
		label_18.setText("Total");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_18.setBounds(576, 479, 144, 14);
		getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel();
		label_19.setText("Advance Paid");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_19.setBounds(576, 529, 144, 14);
		getContentPane().add(label_19);
		
		JLabel lblFinalPayment = new JLabel();
		lblFinalPayment.setText("Final Payment");
		lblFinalPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFinalPayment.setBounds(576, 580, 144, 14);
		getContentPane().add(lblFinalPayment);
		
		JLabel lblOrderDate = new JLabel();
		lblOrderDate.setText("Trip Start Date");
		lblOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderDate.setBounds(34, 78, 144, 14);
		getContentPane().add(lblOrderDate);
		
		txtOrd_id = new JTextField();
		txtOrd_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOrd_id.setEditable(false);
		txtOrd_id.setBounds(249, 168, 187, 20);
		getContentPane().add(txtOrd_id);
		
		txtCus_address = new JTextField();
		txtCus_address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCus_address.setEditable(false);
		txtCus_address.setBounds(249, 281, 187, 20);
		getContentPane().add(txtCus_address);
		
		txtCustomer_name = new JTextField();
		txtCustomer_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCustomer_name.setEditable(false);
		txtCustomer_name.setBounds(249, 218, 187, 20);
		getContentPane().add(txtCustomer_name);
		
		txtStart_km = new JTextField();
		txtStart_km.setEnabled(false);
		txtStart_km.setEditable(false);
		txtStart_km.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtStart_km.setBounds(249, 468, 187, 20);
		getContentPane().add(txtStart_km);
		
		txtEnd_km = new JTextField();
		txtEnd_km.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEnd_km.setBounds(249, 524, 187, 20);
		getContentPane().add(txtEnd_km);
		
		txtDamage_claim = new JTextField();
		txtDamage_claim.setText("0");
		txtDamage_claim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDamage_claim.setBounds(249, 581, 187, 20);
		getContentPane().add(txtDamage_claim);
		
		txtVmodel = new JTextField();
		txtVmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtVmodel.setEditable(false);
		txtVmodel.setBounds(576, 72, 187, 20);
		getContentPane().add(txtVmodel);
		
		txtCus_id = new JTextField();
		txtCus_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCus_id.setEnabled(false);
		txtCus_id.setEditable(false);
		txtCus_id.setBounds(446, 218, 51, 20);
		getContentPane().add(txtCus_id);
				
		txtDayRate = new JTextField();
		txtDayRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDayRate.setEditable(false);
		txtDayRate.setBounds(774, 171, 187, 20);
		getContentPane().add(txtDayRate);
		
		txtEx_km_rate = new JTextField();
		txtEx_km_rate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEx_km_rate.setEditable(false);
		txtEx_km_rate.setBounds(774, 214, 187, 20);
		getContentPane().add(txtEx_km_rate);
		
		txtNo_days_rented = new JTextField();
		txtNo_days_rented.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNo_days_rented.setEditable(false);
		txtNo_days_rented.setBounds(774, 261, 187, 20);
		getContentPane().add(txtNo_days_rented);
		
		txtDay_rent_total = new JTextField();
		txtDay_rent_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDay_rent_total.setEditable(false);
		txtDay_rent_total.setBounds(774, 309, 187, 20);
		getContentPane().add(txtDay_rent_total);
		
		txtExtra_km = new JTextField();
		txtExtra_km.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtExtra_km.setEditable(false);
		txtExtra_km.setBounds(774, 360, 187, 20);
		getContentPane().add(txtExtra_km);
		
		txtTrip_milleage = new JTextField();
		txtTrip_milleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTrip_milleage.setEditable(false);
		txtTrip_milleage.setBounds(774, 419, 187, 20);
		getContentPane().add(txtTrip_milleage);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTotal.setEditable(false);
		txtTotal.setBounds(774, 476, 187, 20);
		getContentPane().add(txtTotal);
		
		txtPaymentF = new JTextField();
		txtPaymentF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPaymentF.setBounds(774, 577, 187, 20);
		getContentPane().add(txtPaymentF);
		txtPaymentF.setText("0"); // Default Value
		
		txtBalance = new JTextField();
		txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBalance.setEditable(false);
		txtBalance.setBounds(774, 620, 187, 20);
		getContentPane().add(txtBalance);
		
		txt_reserve_date = new JTextField();
		txt_reserve_date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_reserve_date.setEditable(false);
		txt_reserve_date.setBounds(249, 342, 187, 20);
		getContentPane().add(txt_reserve_date);
		
		dcTrip_end_date = new JDateChooser();
		dcTrip_end_date.setBounds(249, 407, 187, 20);
		getContentPane().add(dcTrip_end_date);
				
		cmbV_no = new JComboBox();
		cmbV_no.setBounds(577, 26, 175, 22);
		getContentPane().add(cmbV_no);
	//	vehiclenoadd();

		cmbOrd_date = new JComboBox();
		cmbOrd_date.setBounds(188, 72, 175, 22);
		getContentPane().add(cmbOrd_date);
		
		cmbCustomer_mobile = new JComboBox();
		cmbCustomer_mobile.setBounds(187, 26, 175, 22);
		getContentPane().add(cmbCustomer_mobile);
		mobileadd();
		
//Clear button click event
		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.PINK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear_text();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(34, 677, 89, 23);
		getContentPane().add(btnClear);

//Load button click event		
		btnLoad = new JButton("Load");
		btnLoad.setBackground(Color.CYAN);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trip_day_count();
				trip_milleage_count();
				excess_km_count();
				vDay_total_count();
				order_total_cal();
				order_balance_cal();
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLoad.setBounds(138, 677, 100, 23);
		getContentPane().add(btnLoad);
		

		btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
// Save button click event
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkNotEmpty())
		        {
		            try
		            {	
		            	End_km = txtEnd_km.getText();
		            	Damage_claims = txtDamage_claim.getText();
		            	Ord_total = txtTotal.getText();
						
		            	Excess_km = txtExtra_km.getText();
		            	noOfTripDays = txtNo_days_rented.getText();	
		            	Trip_milleage = txtTrip_milleage.getText();
		            	Ord_balance = txtBalance.getText();
		            //	Excess_kmmm = txtExtra_km;
		            	
		            	Ord_PaymentFinalX = txtPaymentF.getText();
		            	Ord_advance = txtPreviousAdvance.getText();
		            	Reserved_date = txt_reserve_date.getText();

		            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")  ;
		            	Trip_end_date = dateFormat.format(dcTrip_end_date.getDate());		                	
				        
				        
		                Database db = new Database();
		                String query = "UPDATE orderx SET end_date = '"+Trip_end_date+"' , end_km = '"+End_km+"' , dmg_claim = '"+Damage_claims+"' , total = '"+Ord_total+"' , adv_paid = '"+Ord_advance+"'  , 	Final_Payment = '"+Ord_PaymentFinalX+"' ";
		                int rows = db.Save_Del_Update(query);
		                
		                if (rows>0)
		                {

		            	
		                    
		                    javax.swing.JOptionPane.showMessageDialog(null, 
		                              "Data Updated Successfully. "+rows+" Rows updated", 
		                              "Message", 
		                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
		                    
		                    AvailabilitySet();
		                    Ord_State_Set();
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
		btnSave.setBounds(249, 677, 152, 23);
		getContentPane().add(btnSave);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(27, 11, 814, 107);
		getContentPane().add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_1.setBounds(33, 146, 476, 491);
		getContentPane().add(horizontalBox_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox_2.setBounds(553, 146, 451, 514);
		getContentPane().add(horizontalBox_2);
		
		btnInvoice = new JButton("Create Invoice");
		btnInvoice.setBackground(Color.CYAN);
// Invoice button click event
		btnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					Excess_km = txtExtra_km.getText();
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
					param.put("odaycountx",noOfTripDays);
					param.put("odtotalx",DayRentTotalX);
					
					param.put("oexkmx",ExcesTotalX);
					param.put("otripkmx",Ord_trip_milleage);
					param.put("vnox",V_no);
					param.put("exratex",Excess_rate);
					param.put("vdayratex",Vday_rate);
					param.put("caddrx",Customer_address);
					param.put("vmodelx",Vmodel);
					param.put("vredatex",Reserved_date);
					param.put("tripstartdatex",Trip_start_date);
					param.put("tripenddatex",Trip_end_date);
					param.put("Excess_kmmm",Excess_kmmX);
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
		btnInvoice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInvoice.setBounds(643, 677, 234, 23);
		getContentPane().add(btnInvoice);
		
		JLabel label_4 = new JLabel();
		label_4.setText("Balance Amount");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(576, 623, 144, 14);
		getContentPane().add(label_4);
		
		txtPreviousAdvance = new JTextField();
		txtPreviousAdvance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPreviousAdvance.setEditable(false);
		txtPreviousAdvance.setBounds(774, 529, 187, 20);
		getContentPane().add(txtPreviousAdvance);
		
		btnDelete = new JButton("Delete");
// Delete button click event
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 Ord_IDD = txtOrd_id.getText();
				 if (Ord_IDD.equals(null)) {
					 JOptionPane.showMessageDialog( null, "Select the order first" );
				 }
				 else {
				 Database db = new Database();
                 String query = "DELETE FROM orderx WHERE 	ord_id ='"+Ord_IDD+"'";
                    
                
                   	if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this vehicle ?", "Delete Warning",
       						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                   		 int rows = db.Save_Del_Update(query);
                   		 if (rows>0) {
                   			 JOptionPane.showMessageDialog( null, "Data Deletion Sucessful !" );
                   			
                   		 } 
                   		 }
				 }
				}
				 catch(Exception e1)
	            {
	                javax.swing.JOptionPane.showMessageDialog(null, 
	                              e1.getMessage(), 
	                              "Exception", 
	                              javax.swing.JOptionPane.WARNING_MESSAGE);
	            }
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBackground(Color.YELLOW);
		btnDelete.setBounds(411, 679, 152, 23);
		getContentPane().add(btnDelete);
		
	
		
// Customer Mobile Combo box arrow click event
		cmbCustomer_mobile.addActionListener(new ActionListener() {
			@Override
			   public void actionPerformed(ActionEvent e) {
			
				cmbV_no.removeAllItems();
					fill_customer_fields();
					vehiclenoadd();
			         }
			      });
		
				
// Vehicle Number Combo box arrow click event
		cmbV_no.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					 
				cmbOrd_date.removeAllItems();
						fill_vehicle_fields();
						order_dates_add();
					         }
		});
	
	
	
// Order Date Combo box arrow click event
		cmbOrd_date.addActionListener(new ActionListener() {
				@Override
				   public void actionPerformed(ActionEvent e) {
						
					try {
						Customer_mobile = cmbCustomer_mobile.getSelectedItem().toString();
						V_no = cmbV_no.getSelectedItem().toString();
						Trip_start_date = cmbOrd_date.getSelectedItem().toString();
						Customer_ID = txtCus_id.getText();
						
						if (Trip_start_date.isEmpty() )
			            {
			            
							JOptionPane.showMessageDialog(null, "Please select the trip start date","Invalid data",JOptionPane.ERROR_MESSAGE);
			                
			            }
			            else
			            {
			                
			                
			                Database db = new Database();
			                String query = "SELECT * FROM orderx WHERE vehicle_no='"+V_no+"' AND start_date='"+Trip_start_date+"' AND cus_id = '"+Customer_ID+"' ";
			                ResultSet rs = db.GetData(query);
			                
			                
			                rs.next();
			                int rows = rs.getRow();
			                
			                
			                if (rows>0)
			                {
			                	
			                	Ord_IDD = rs.getString("ord_id");
			                	Starting_km = rs.getString("str_km");
			                	Ord_advance = rs.getString("adv_paid");
			                	Reserved_date = rs.getString("reserved_date");
			                	Trip_end_date = rs.getString("end_date");
			                	Ord_advance = rs.getString("adv_paid");
			                	
			               
			                	Ord_PaymentFinalX = rs.getString("Final_Payment");
			                	
			                	txtOrd_id.setText(Ord_IDD);
			                	txtStart_km.setText(Starting_km);
			                	txtPaymentF.setText(Ord_PaymentFinalX);
			                	txt_reserve_date.setText(Reserved_date);
			                	txtPreviousAdvance.setText(Ord_advance);
			                	
			                	SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
			                	Date Otrip_end_date=formatter1.parse(Trip_end_date);  
	
			                	dcTrip_end_date.setDate(Otrip_end_date);
			                	
			                	
			                    
			                }
			                else
			                {
			        
			                	JOptionPane.showMessageDialog(null, "Invalid customer mobile number","Try again",JOptionPane.ERROR_MESSAGE);
				                
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
		AccessControl();
}
	
	

// Method to fill vehicle number text box 
			private void clear_text() {
				try {
				txtOrd_id.setText("");
				txtCus_id.setText("");
				txtCustomer_name.setText("");
				txtStart_km.setText("");
				txtEnd_km.setText("");
				txtDamage_claim.setText("");
				txtTotal.setText("");
				txtPaymentF.setText("");
				txtExtra_km.setText("");
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
				private void order_dates_add()
					{
						try {
							 Customer_ID = txtCus_id.getText();
							 V_no = cmbV_no.getSelectedItem().toString();
							 Database db = new Database();
				             String query = "SELECT start_date FROM orderx WHERE vehicle_no ='"+V_no+"' AND cus_id ='"+Customer_ID+"' ";
				             ResultSet rs = db.GetData(query);
				             
				             
				             while(rs.next())
				             {
				             
				            	 cmbOrd_date.addItem(rs.getString(1));
				             }
				     
							}catch(Exception e1) {
				             
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
				Excess_km = txtExtra_km.getText();
				Integer Excess_kmm = Integer.parseInt(Excess_km); 
				Excess_kmmX = Excess_kmm.toString();
				
				noOfTripDays = txtNo_days_rented.getText();
				int noOfTripDayss = Integer.parseInt(noOfTripDays); 
				
				Vday_rate = txtDayRate.getText();
				int Vday_ratee = Integer.parseInt(Vday_rate);
					
				Integer DayRentTotal = Vday_ratee * noOfTripDayss;
				DayRentTotalX = DayRentTotal.toString();
				
				Excess_rate = txtEx_km_rate.getText();
				int Excess_ratee = Integer.parseInt(Excess_rate);
				
				Integer excess_total = Excess_kmm * Excess_ratee;
				ExcesTotalX = excess_total.toString();
				
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
				
				Ord_advance = txtPreviousAdvance.getText();
				int Ord_advancee = Integer.parseInt(Ord_advance ); 
				
				Ord_PaymentFinal = txtPaymentF.getText();
				int PaymentF = Integer.parseInt(Ord_PaymentFinal); 
				
				int Ord_balancee = (Ord_totall - (Ord_advancee + PaymentF));
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
				String Excess_kmmm = Integer.toString(Excess_kmm);
				if (Excess_kmm > 0) {
					txtExtra_km.setText(Excess_kmmm);
				}
				else {
				txtExtra_km.setText("0");
					}}
				catch(Exception e1) {
		             
		             javax.swing.JOptionPane.showMessageDialog(null, 
		                     e1.getMessage(), 
		                     " Exception", 
		                     javax.swing.JOptionPane.WARNING_MESSAGE);	}
				}
			
			
// Method to calculate the trip days 
			private void trip_day_count() {
				try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")  ;
		    //    Trip_start_date = dateFormat.format(dcTrip_start_date.getDate());
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
				milleage_countt = Integer.toString(milleage_count);
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
							
						 Customer_ID = txtCus_id.getText();
						 Database db = new Database();
			             String query = "SELECT DISTINCTROW vehicle_no FROM orderx WHERE cus_id ='"+Customer_ID+"' ";
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
		                	
		                	txtDayRate.setText(Vday_rate);
		                	txtEx_km_rate.setText(Excess_rate);	                	
		                	txtVmodel.setText(Vmodel);                	
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
		        boolean notEmpty = true;
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
		        if(txtPaymentF.getText().trim().isEmpty())
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

			
// Method to change the vehicle state & current_milleage
			private void AvailabilitySet() {
				try {
					Ord_balance = txtBalance.getText();
					End_km = txtEnd_km.getText();
					
			           if(Ord_balance.equals("0") ) {      
			            	int V_StateX = 1;
			                Database db = new Database();
			                
			                String query = "UPDATE vehicle SET Availability = '"+V_StateX+"' , cu_km = '"+End_km+"' WHERE vehicle_no = '"+V_no+"' ";
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
			           else
			           {
			        	   JOptionPane.showMessageDialog(null, "Warning","Due balance available, Please check again ",JOptionPane.WARNING_MESSAGE); 
			           }
				
					}
				catch(Exception e1) {
		             
		             javax.swing.JOptionPane.showMessageDialog(null, 
		                     e1.getMessage(), 
		                     " Exception", 
		                     javax.swing.JOptionPane.WARNING_MESSAGE);	
		     
				} 
				
			}
			
// Method to change the order state
			private void Ord_State_Set() {
				try {
					Ord_balance = txtBalance.getText();
					Ord_IDD = txtOrd_id.getText();
			           if(Ord_balance.equals("0") ) {      
			            	int Ord_StateX = 1;
			                Database db = new Database();
			                
			                String query = "UPDATE orderx SET Ord_State = '"+Ord_StateX+"'  WHERE ord_id = '"+Ord_IDD+"' ";
			                int rows = db.Save_Del_Update(query);
			                
			                if (rows>0)
			                {
			                    
			                    javax.swing.JOptionPane.showMessageDialog(null, 
			                              "Order State Changed Successfully. "+rows+" Rows updated", 
			                              "Message", 
			                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
			                    
			                }
			                else
			                {
			                    
			                    javax.swing.JOptionPane.showMessageDialog(null, 
			                              "Order State Change Failed. "+rows+" Rows updated", 
			                              "Error", 
			                              javax.swing.JOptionPane.WARNING_MESSAGE);
			                }
					
			           }
			           else
			           {
			        	   JOptionPane.showMessageDialog(null, "Warning","Due balance available, Please check again ",JOptionPane.WARNING_MESSAGE); 
			           }
				
					}
				catch(Exception e1) {
		             
		             javax.swing.JOptionPane.showMessageDialog(null, 
		                     e1.getMessage(), 
		                     " Exception", 
		                     javax.swing.JOptionPane.WARNING_MESSAGE);	
		     
				} 
				
			}
			
		// Method to control access for other admins
			private void AccessControl()
				{	String UnameM = logS.txtusername.getText();
					if (UnameM.trim().equals("admin")  || UnameM.trim().equals("Admin") )
						{
								btnDelete.setVisible(true);
						}
					else
						{
								btnDelete.setVisible(false);
						}
					    }
}
