package CamSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import CamSys.Database;
import CamSys.LoginData;
import CamSys.logS;


public class VehicleMaintenanceMethods {
	
	static SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");  
	private static Date xdateY = new Date();
	
	//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy")  ;	
	//private static String Todaydate = formatter1.format(xdateY.getDate());
	//Date xdatef=formatter1.parse(Todaydate); 
	
	static String V_no;
	static String vPu_dateY;   	
 	static String vIns_exp_dateY ;
 	static String vRl_exp_dateY ;
 	
 	static Date vPu_dateeY;  
 	static Date vIns_exp_dateeY;
 	static Date vRl_exp_dateeY;
 	
 	static String last_service = "";
    static String current_milleage = "";
    static String Service_expect_km ="";
 	
    private static Integer last_servicee ;
    private static Integer current_milleagee ;
    private static Integer Service_expect_kmm ;

//Method to check insuarance & revenue licen expire date
		public static void checkinsuarance()
	    {
			try {
				
				Database db = new Database();
				String query = "SELECT * FROM vehicle ";
				ResultSet rs = db.GetData(query);

				
		
			while (rs.next()) {
		
		     			     
		    	V_no = rs.getString("vehicle_no");	
		     	vPu_dateY = rs.getString("pu_date");     	
		     	vIns_exp_dateY = rs.getString("ins_ex_dt");
		     	vRl_exp_dateY = rs.getString("rl_ex_dt");
		     	last_service = rs.getString("lst_ser_km");
		     	current_milleage = rs.getString("cu_km");
		     	

		        last_servicee = Integer.parseInt(last_service);
		        current_milleagee = Integer.parseInt(last_service) ;
		        Service_expect_kmm = last_servicee + 4000 ;
		        
		     	
		     	vPu_dateeY=formatter1.parse(vPu_dateY);  
		     	vIns_exp_dateeY=formatter1.parse(vIns_exp_dateY);
		     	vRl_exp_dateeY=formatter1.parse(vRl_exp_dateY);
		     	
		   //  	System.out.println( vPu_dateY + ", " + vRl_exp_dateY  + ", " + vIns_exp_dateeY  
             //           );
		     	
		     	if (vIns_exp_dateeY.before(xdateY)) {
		     		JOptionPane.showMessageDialog(null, "Please renew the insuarance of vehicle  " + V_no,"Insuarance Expire Warning",JOptionPane.WARNING_MESSAGE);
		     		AvailabilitySetZero();
		     	}
		     	
		     	if (vRl_exp_dateeY.before(xdateY)) {
		     		JOptionPane.showMessageDialog(null, "Please renew the Revenue Licen of vehicle  " + V_no,"Revenue Licen Expire Warning",JOptionPane.WARNING_MESSAGE);
		     		AvailabilitySetZero();
		     	}
		     	
		     	if (Service_expect_kmm < current_milleagee) {
		     		JOptionPane.showMessageDialog(null, "Please service the vehicle  " + V_no,"Vehicle Service Warning",JOptionPane.WARNING_MESSAGE);
		     		AvailabilitySetZero();
		     	}
		   
			}}

		catch(SQLException | ParseException e1)
		{
		 javax.swing.JOptionPane.showMessageDialog(null, 
		                   e1.getMessage(), 
		                   "SQL Exception", 
		                   javax.swing.JOptionPane.WARNING_MESSAGE);	}


			
	    }
	    
	
		
// Method to set availability minus 1
				private static void AvailabilitySetZero() {
					try {
				                    
				            	int V_StateX = 9;
				                Database db = new Database();
				                
				                String query = "UPDATE vehicle SET Availability = '"+V_StateX+"'  WHERE vehicle_no = '"+V_no+"' ";
				                int rows = db.Save_Del_Update(query);
				                
				                if (rows>0)
				                {
				                    
				                /*    javax.swing.JOptionPane.showMessageDialog(null, 
				                              "Vehicle State Changed Successfully. "+rows+" Rows updated", 
				                              "Message", 
				                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
				                    
				            */
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

				
// Method to set availability one
				public static void AvailabilitySetOne() {
					try {
				                    
				            	int V_StateX = 1;
				                Database db = new Database();
				                
				                String query = "UPDATE vehicle SET Availability = '"+V_StateX+"'  WHERE vehicle_no = '"+V_no+"' ";
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
				
				

				
}
