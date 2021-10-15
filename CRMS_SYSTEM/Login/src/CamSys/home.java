package CamSys;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import CamSys.Database;
import CamSys.user;
import CamSys.LoginData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.proteanit.sql.DbUtils;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.BevelBorder;

public class home extends JFrame {
	
	private JFrame home;
	private JPanel frmhome;
	
	private JLabel lblUserName;
	private String Uname;
	
	private JButton btnVehicleReport;
	private JButton btnSalesReport;
	private JButton btnEditOrder;
	private JButton btnsignout;
	private JButton btnAddUser;
	private JButton btn_pass_reset;
	private JButton btnVehicleAdd;
	private JButton btnCustomerAdd;
	private JButton btnEditCustomer;
	private JButton btnEditVehicle;
	private JButton btnAddOrder;
	
	private Box BoxReport;
	private Box BoxVehicle;
	private Box BoxUser;
	private Box BoxCustomer;
	private Box BoxOrder;
	private JButton btnUseredit;
	private JButton btnAvailableVehicleReport;
	private JButton btnInsuaranceClaimsReport;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		
		Uname=logS.txtusername.getText();
		
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 625);
		home = new JFrame();
		frmhome =  new JPanel();
		frmhome.setBackground(Color.GRAY);
		frmhome.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frmhome);
		frmhome.setLayout(null);
		VehicleMaintenanceMethods.checkinsuarance();
		
		lblUserName = new JLabel("<Dynamic>");
		lblUserName.setBounds(90, 11, 70, 14);
		frmhome.add(lblUserName);
		FillUserName();
		
		BoxUser = Box.createHorizontalBox();
		BoxUser.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		BoxUser.setBounds(20, 110, 202, 198);
		frmhome.add(BoxUser);
		
		BoxCustomer = Box.createHorizontalBox();
		BoxCustomer.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		BoxCustomer.setBounds(256, 110, 211, 152);
		frmhome.add(BoxCustomer);
		
		BoxVehicle = Box.createHorizontalBox();
		BoxVehicle.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		BoxVehicle.setBounds(506, 110, 202, 152);
		frmhome.add(BoxVehicle);
		
		BoxReport = Box.createHorizontalBox();
		BoxReport.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		BoxReport.setBounds(404, 288, 304, 276);
		frmhome.add(BoxReport);
		
		BoxOrder = Box.createHorizontalBox();
		BoxOrder.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		BoxOrder.setBounds(20, 359, 327, 143);
		frmhome.add(BoxOrder);
		
		JLabel lblNewLabel_1 = new JLabel("Home Menu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(289, 40, 202, 38);
		frmhome.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Logged In As ");
		lblNewLabel.setBounds(10, 11, 85, 14);
		frmhome.add(lblNewLabel);
		
		
// Add User button initialize & click event
		btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String args[] = {};
				New_usr.main(args);

			}
		});
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddUser.setBounds(38, 129, 164, 38);
		frmhome.add(btnAddUser);
		
		
		
// Password reset button initializing & click event
		btn_pass_reset = new JButton("Password Reset");
		btn_pass_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

            	JFrame frm_pass_reset = new frm_pass_reset();
				frm_pass_reset.setVisible(true);
				
				dispose();
			}
		});
		btn_pass_reset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_pass_reset.setBounds(38, 192, 164, 38);
		frmhome.add(btn_pass_reset);
		
		
		
// Sign-out button initializing & click event
		btnsignout = new JButton("Sign Out");
		btnsignout.setBackground(new Color(255, 160, 122));
		btnsignout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				String args[] = {};
				logS.main(args);
				dispose();
			
			}
		});
		btnsignout.setBounds(576, 11, 133, 38);
		btnsignout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmhome.add(btnsignout);
		
		
		
// Customer Add button initializing & click event
		btnCustomerAdd = new JButton("Customer Add");
		btnCustomerAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame Frm_New_Customer = new Frm_New_Customer();
				Frm_New_Customer.setVisible(true);
				
				//dispose();
				
			}
		});
		btnCustomerAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCustomerAdd.setBounds(280, 129, 164, 38);
		frmhome.add(btnCustomerAdd);
		
		
		
// Edit Customer button initializing & click event
		btnEditCustomer = new JButton("Edit Customer");
		btnEditCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmcustomeredit = new frmcustomeredit();
				frmcustomeredit.setVisible(true);
				
			//	dispose();
				
			}
		});
		btnEditCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditCustomer.setBounds(280, 192, 164, 38);
		frmhome.add(btnEditCustomer);
		
		
		
// Vehicle Add button initialize & click event
		btnVehicleAdd = new JButton("Vehicle Add");
		btnVehicleAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frm_add_vehicle = new frm_add_vehicle();
				frm_add_vehicle.setVisible(true);
				
		
				
			}
		});
		btnVehicleAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVehicleAdd.setBounds(526, 129, 164, 38);
		frmhome.add(btnVehicleAdd);
		
		
		
// Edit Vehicle button initialize & click event
		btnEditVehicle = new JButton("Edit Delete Vehicle");
		btnEditVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame FrmVehicleEdit = new FrmVehicleEdit();
				FrmVehicleEdit.setVisible(true);
					
			}
		});
		btnEditVehicle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditVehicle.setBounds(526, 192, 170, 38);
		frmhome.add(btnEditVehicle);
		
		
		
// Add order button initialize & click event
		btnAddOrder = new JButton("Add Order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame Frm_Add_Order = new Frm_Add_Order();
				Frm_Add_Order.setVisible(true);
				
			}
		});
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddOrder.setBounds(38, 380, 288, 38);
		frmhome.add(btnAddOrder);
		
		
		
// Edit Order button initialize & click event
		btnEditOrder = new JButton("Edit & Delete Order");
		btnEditOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame FrmOrderEdit = new FrmOrderEdit();
				FrmOrderEdit.setVisible(true);
				
			}
		});
		btnEditOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditOrder.setBounds(38, 440, 288, 38);
		frmhome.add(btnEditOrder);
		
		
	
// Sales Report button initialize & click event
		btnSalesReport = new JButton("Sales Report");
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?useSSL=false","root","");
					
					
					String sql = "SELECT * FROM orderx";
			
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\GTC\\Desktop\\ProjectCRMS\\src\\CamSys\\Sales_Report.jrxml");
					
					JRDesignQuery updateQuery = new JRDesignQuery();
					
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null, con);
					
					JasperViewer.viewReport(JasperPrint, false);
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			
			}
		});
		btnSalesReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalesReport.setBounds(430, 507, 260, 38);
		frmhome.add(btnSalesReport);
		
		
		
// Vehicle report button initialize & click event
		btnVehicleReport = new JButton("Due Vehicle Report");
		btnVehicleReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?useSSL=false","root","");
					
					
					String sql = "SELECT * FROM orderx";
			
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\GTC\\Desktop\\ProjectCRMS\\src\\CamSys\\Vehi_Due.jrxml");
	
					JRDesignQuery updateQuery = new JRDesignQuery();
					
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null, con);
					
					JasperViewer.viewReport(JasperPrint, false);
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
			}
		});
		btnVehicleReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVehicleReport.setBounds(430, 359, 260, 38);
		frmhome.add(btnVehicleReport);
		
		btnInsuaranceClaimsReport = new JButton("Insuarance Claims Report");
// Insurance claim report open button Click event 
		btnInsuaranceClaimsReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?useSSL=false","root","");
					
					
					String sql = "SELECT * FROM orderx";
			
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\GTC\\Desktop\\ProjectCRMS\\src\\CamSys\\Claims_Report.jrxml");
	
					JRDesignQuery updateQuery = new JRDesignQuery();
					
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null, con);
					
					JasperViewer.viewReport(JasperPrint, false);
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
				
			}
		});
		btnInsuaranceClaimsReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsuaranceClaimsReport.setBounds(430, 457, 260, 38);
		frmhome.add(btnInsuaranceClaimsReport);
		
		btnUseredit = new JButton("User Edit & Delete");
// Edit & delete Order button click event
		btnUseredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame Edit_Del_usr = new Edit_Del_usr();
				Edit_Del_usr.setVisible(true);
				
			}	
		});
		btnUseredit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUseredit.setBounds(38, 250, 164, 38);
		frmhome.add(btnUseredit);
		
		btnAvailableVehicleReport = new JButton("Available Vehicle Report");
		btnAvailableVehicleReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?useSSL=false","root","");
					
					
					String sql = "SELECT * FROM vehicle WHERE Availability=1 ";
			
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\GTC\\Desktop\\ProjectCRMS\\src\\CamSys\\Available_Vehicle_ReportX.jrxml");
	
					JRDesignQuery updateQuery = new JRDesignQuery();
					
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null, con);
					
					JasperViewer.viewReport(JasperPrint, false);
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
					
				
			}
		});
		btnAvailableVehicleReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAvailableVehicleReport.setBounds(430, 310, 260, 38);
		frmhome.add(btnAvailableVehicleReport);
		
		JButton btnUnavailableVehicles = new JButton("Unavailable Vehicles");
//  unavailable vehicles report button click event
		btnUnavailableVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?useSSL=false","root","");
					
					
					String sql = "SELECT * FROM vehicle WHERE Availability=9";
			
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\GTC\\Desktop\\ProjectCRMS\\src\\CamSys\\Unavailavle_vehicles_report.jrxml");
	
					JRDesignQuery updateQuery = new JRDesignQuery();
					
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null, con);
					
					JasperViewer.viewReport(JasperPrint, false);
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
					
				
				
				
			}
		});
		btnUnavailableVehicles.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUnavailableVehicles.setBounds(430, 408, 260, 38);
		frmhome.add(btnUnavailableVehicles);
	
		
		AccessControl();
	}
	
// Method to clean textboxes
			private void FillUserName()
		    {
				lblUserName.setText(Uname);
		    }
	
			
// Method to control access for other admins
			private void AccessControl()
		    {
				if (Uname.trim().equals("admin")  || Uname.trim().equals("Admin") )
				{
					btnVehicleReport.setVisible(true);
					btnSalesReport.setVisible(true);
					BoxReport.setVisible(true);
					
					btnVehicleAdd.setVisible(true);
					btnEditVehicle.setVisible(true);
					btnAddUser.setVisible(true);
					
					btnInsuaranceClaimsReport.setVisible(true);
					
					
				}
				else
				{
					//btnVehicleReport.setVisible(false);
					btnSalesReport.setVisible(false);
				//	BoxReport.setVisible(false);
					
					btnVehicleAdd.setVisible(false);
					btnEditVehicle.setVisible(false);
					btnAddUser.setVisible(false);
					
					btnInsuaranceClaimsReport.setVisible(false);
					
					btnUseredit.setVisible(false);
					BoxVehicle.setVisible(false);
				
					
				}
		    }
}
