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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import CamSys.Database;
import CamSys.LoginData;
import CamSys.logS;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.Color;


public class frm_add_vehicle extends JFrame {

	private JPanel contentPane;
	private JTextField txtvehicleno;
	private JTextField txtmodelyom;
	private JTextField txtcolor;
	private JTextField txtnoseats;
	private JTextField txtpuprice;
	private JTextField txtinno;
	private JTextField txtlsmi;
	private JTextField txtcumi;
	private JTextField txttrmi;
	private JTextField txtdrate;
	private JTextField txtexrate;
	private JDateChooser dcpudate;
	private JDateChooser dciedate;
	private JDateChooser dcrledate;
	
	private Date xdate = new Date();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_add_vehicle frame = new frm_add_vehicle();
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
	public frm_add_vehicle() {
		setTitle("Add Vehicle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVehicleNo = new JLabel();
		lblVehicleNo.setText("Vehicle No");
		lblVehicleNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVehicleNo.setBounds(90, 77, 144, 14);
		contentPane.add(lblVehicleNo);
		
		JLabel lblModelYom = new JLabel();
		lblModelYom.setText("Model & YOM");
		lblModelYom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelYom.setBounds(90, 127, 144, 14);
		contentPane.add(lblModelYom);
		
		JLabel lblColor = new JLabel();
		lblColor.setText("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColor.setBounds(90, 176, 178, 14);
		contentPane.add(lblColor);
		
		JLabel lblNoSeats = new JLabel();
		lblNoSeats.setText("No Seats");
		lblNoSeats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoSeats.setBounds(90, 228, 144, 14);
		contentPane.add(lblNoSeats);
		
		JLabel lblPurchaseDate = new JLabel();
		lblPurchaseDate.setText("Purchase Date");
		lblPurchaseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPurchaseDate.setBounds(90, 277, 144, 14);
		contentPane.add(lblPurchaseDate);
		
		JLabel lblPurhasePrice = new JLabel();
		lblPurhasePrice.setText("Purhase Price");
		lblPurhasePrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPurhasePrice.setBounds(90, 320, 144, 14);
		contentPane.add(lblPurhasePrice);
		
		JLabel lblInsuaranceNo = new JLabel();
		lblInsuaranceNo.setText("Insuarance No");
		lblInsuaranceNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInsuaranceNo.setBounds(90, 373, 144, 14);
		contentPane.add(lblInsuaranceNo);
		
		JLabel lblInsuaraceExpieryDate = new JLabel();
		lblInsuaraceExpieryDate.setText("Insuarace Expiery Date");
		lblInsuaraceExpieryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInsuaraceExpieryDate.setBounds(90, 424, 187, 14);
		contentPane.add(lblInsuaraceExpieryDate);
		
		JLabel lblRevenueLicenExpiry = new JLabel();
		lblRevenueLicenExpiry.setText("Revenue Licen Expiry Date");
		lblRevenueLicenExpiry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRevenueLicenExpiry.setBounds(90, 473, 211, 14);
		contentPane.add(lblRevenueLicenExpiry);
		
		JLabel lblLastServiceMilleage = new JLabel();
		lblLastServiceMilleage.setText("Last Service Milleage");
		lblLastServiceMilleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastServiceMilleage.setBounds(90, 531, 211, 14);
		contentPane.add(lblLastServiceMilleage);
		
		JLabel lblCurrentMilleage = new JLabel();
		lblCurrentMilleage.setText("Current Milleage");
		lblCurrentMilleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentMilleage.setBounds(90, 574, 211, 14);
		contentPane.add(lblCurrentMilleage);
		
		JLabel lblTireReplacedMilleage = new JLabel();
		lblTireReplacedMilleage.setText("Tire Replaced Milleage");
		lblTireReplacedMilleage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTireReplacedMilleage.setBounds(90, 625, 211, 14);
		contentPane.add(lblTireReplacedMilleage);
		
		JLabel lblDayRate = new JLabel();
		lblDayRate.setText("Day Rate");
		lblDayRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDayRate.setBounds(90, 671, 211, 14);
		contentPane.add(lblDayRate);
		
		JLabel lblExtraKmRate = new JLabel();
		lblExtraKmRate.setText("Extra Km Rate");
		lblExtraKmRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExtraKmRate.setBounds(90, 718, 211, 14);
		contentPane.add(lblExtraKmRate);
		
		txtvehicleno = new JTextField();
		txtvehicleno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtvehicleno.setBounds(357, 74, 187, 20);
		contentPane.add(txtvehicleno);
		
		txtmodelyom = new JTextField();
		txtmodelyom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmodelyom.setBounds(357, 121, 187, 20);
		contentPane.add(txtmodelyom);
		
		txtcolor = new JTextField();
		txtcolor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcolor.setBounds(357, 170, 187, 20);
		contentPane.add(txtcolor);
		
		txtnoseats = new JTextField();
		txtnoseats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtnoseats.setBounds(357, 222, 187, 20);
		contentPane.add(txtnoseats);
		
		txtpuprice = new JTextField();
		txtpuprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpuprice.setBounds(357, 314, 187, 20);
		contentPane.add(txtpuprice);
		
		txtinno = new JTextField();
		txtinno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtinno.setBounds(357, 367, 187, 20);
		contentPane.add(txtinno);
		
		txtlsmi = new JTextField();
		txtlsmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtlsmi.setBounds(357, 525, 187, 20);
		contentPane.add(txtlsmi);
		
		txtcumi = new JTextField();
		txtcumi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcumi.setBounds(357, 568, 187, 20);
		contentPane.add(txtcumi);
		
		txttrmi = new JTextField();
		txttrmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txttrmi.setBounds(357, 619, 187, 20);
		contentPane.add(txttrmi);
		
		txtdrate = new JTextField();
		txtdrate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtdrate.setBounds(357, 666, 187, 20);
		contentPane.add(txtdrate);
				
		txtexrate = new JTextField();
		txtexrate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtexrate.setBounds(357, 712, 187, 20);
		contentPane.add(txtexrate);
		
		dcpudate = new JDateChooser();
		dcpudate.setBounds(357, 271, 187, 20);
		contentPane.add(dcpudate);
		dcpudate.setDateFormatString("dd/MM/yyyy");
		dcpudate.setDate(xdate);	     
		
		dciedate = new JDateChooser();
		dciedate.setBounds(357, 418, 187, 20);
		contentPane.add(dciedate);
		dciedate.setDateFormatString("dd/MM/yyyy");
	    dciedate.setDate(xdate);
	        		
		dcrledate = new JDateChooser();
		dcrledate.setBounds(357, 467, 187, 20);
		contentPane.add(dcrledate);
		dcrledate.setDateFormatString("dd/MM/yyyy");
		dcrledate.setDate(xdate);
		
		JButton btnclr = new JButton("Clear");
		btnclr.setBackground(Color.PINK);
// clear button click event
		btnclr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnclr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnclr.setBounds(306, 767, 102, 29);
		contentPane.add(btnclr);
				
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
// save button click event
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			        {
			            
			            boolean check = true;
								            
			            String vNo = txtvehicleno.getText().trim();
			            String vModel_YOM = txtmodelyom.getText().trim();
			            String vColor = txtcolor.getText().trim();
			            String vNo_seats = txtnoseats.getText().trim();
			            String vInsuarance_no = txtinno.getText().trim();
			                
			            String vPurchase_price = txtpuprice.getText();
			            String vLst_service_milleage = txtlsmi.getText();
			            String vCurrent_milleage = txtcumi.getText();
			            String vTire_re_milleage = txttrmi.getText();
			            String vDayrate = txtdrate.getText();
			            String vExcessRate = txtexrate.getText();
			                
			            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy")  ;
			            String vPurchase_date = dateFormat.format(dcpudate.getDate());
			            String vIns_expire_date = dateFormat.format(dciedate.getDate());
			            String vRl_expire_date = dateFormat.format(dcrledate.getDate());
			            
			            Boolean availability = true;
			            
// to save both date and time 
			      //      String vPurchase_date =dcpudate.getDate() .toString();
			      //      String vIns_expire_date = dciedate.getDate().toString();
			       //     String vRl_expire_date = dcrledate.getDate().toString();
			            
			                
			                String message ="";
			               
			                if(vNo.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle number is Empty";
			                }
			                
			                
			                if(vModel_YOM.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle model is Empty";
			                }
			                if(vColor.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle color is Empty";
			                }
			                if(vNo_seats.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle number of seats is empty is Empty";
			                }
			                if(vInsuarance_no.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle insuarance number is Empty";
			                }
			                if(vPurchase_price.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle purchase price is empty";
			                }
			                if(vLst_service_milleage.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle last service milleage is Empty";
			                }
			                if(vCurrent_milleage.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle current milleage is Empty";
			                }
			                if(vTire_re_milleage.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle tire replaced milleage is Empty";
			                }
			                if(vDayrate.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle rent per day rate is Empty";
			                }
			                if(vExcessRate.isEmpty())
			                {
			                    check = false;
			                    message = "Vehicle rent per extra kilometer is Empty";
			                }
			     
			                if(check)
			                {
				                
			                    Database db = new Database();
			                    String query = "INSERT INTO vehicle (vehicle_no,mod_yom,color,no_seats,pu_date,pu_price,ins_no,ins_ex_dt,rl_ex_dt,lst_ser_km,cu_km,tr_rp_km,day_rate,ex_km_rate,Availability) VALUES ('"+vNo+"','"+vModel_YOM+"','"+vColor+"','"+vNo_seats+"','"+vPurchase_date+"',"+vPurchase_price+",'"+vInsuarance_no+"','"+vIns_expire_date+"','"+vRl_expire_date+"',"+vLst_service_milleage+","+vCurrent_milleage+","+vTire_re_milleage+","+vDayrate+","+vExcessRate+","+availability+")";
			           
			                    int rows = db.Save_Del_Update(query);

			                    if (rows>0)
			                    {
			                
			                    	JOptionPane.showMessageDialog( null, "Data Insertion Sucessful !" );
			                 
			                        clearText();
			                        
			                    }
			                    
			                    else
			                    {
		
			                        JOptionPane.showMessageDialog(null, "Data insertion failed ","Insert Error",JOptionPane.ERROR_MESSAGE);
			                        clearText();
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
		btnSave.setBounds(123, 767, 134, 29);
		contentPane.add(btnSave);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		horizontalBox.setBounds(58, 56, 519, 700);
		contentPane.add(horizontalBox);
	}
	
// Method to clean textboxes
		private void clearText()
	    {
	        txtvehicleno.setText("");
	        txtmodelyom.setText("");
	        txtcolor.setText("");
	        txtnoseats.setText("");
	        txtpuprice.setText("");
	        txtinno.setText("");
	        txtlsmi.setText("");
	        txtcumi.setText("");
	        txttrmi.setText("");
	        txtdrate.setText("");
	        txtexrate.setText("");
	        dcpudate.setDate(xdate);
	        dciedate.setDate(xdate);
	        dcrledate.setDate(xdate);
	    }
}
