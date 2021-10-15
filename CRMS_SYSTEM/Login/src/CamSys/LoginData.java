package CamSys;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class LoginData {

	    private String userName = "";
	    private static String userID = "";
	    private static String uIDD="";
	    
	    
	    public void setUserName(String uName)
	    {
	        userName = uName;
	    }
	    public void setUserID(String uID)
	    {
	        userID = uID;
	    }
	    
	    public void setUserIDX(String uIDD)
	    {
	        uIDD = logS.userIDD;
	    }
	    
	    public String getUserName()
	    {
	        return userName;
	    }
	    public static String getUserID()
	    {
	        return userID;
	    }
	    
	    public void flushData()
	    {
	        userName = "";
	        userID = "";
	    }
	       
	    public static String getUserIDD()
	    {
	        return uIDD;
	    }
	    
	    //encryption initialization
	    private static final String UNICODE_FORMAT = "UTF8";
	    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	    private static KeySpec ks;
	    private static SecretKeyFactory skf;
	    private static Cipher cipher;
	    static byte[] arrayBytes;
	    private static String myEncryptionKey;
	    private static String myEncryptionScheme;
	    static SecretKey key;

	    public static void TrippleDes() throws Exception {
	        myEncryptionKey = "ThisIsSpartaThisIsSparta";
	        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
	        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
	        ks = new DESedeKeySpec(arrayBytes);
	        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
	        cipher = Cipher.getInstance(myEncryptionScheme);
	        key = skf.generateSecret(ks);
	    }
	    
	    public static String encrypt(String unencryptedString) {
	        String encryptedString = null;
	   
	        try {
	        	 TrippleDes();
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
	            byte[] encryptedText = cipher.doFinal(plainText);
	            encryptedString = new String(Base64.encodeBase64(encryptedText));
	       //     System.out.println(encryptedString);
	         //   System.out.println(encryptedText);
	            
	            
	            
	        } catch (Exception e) {
	          //  e.printStackTrace();
	        	 javax.swing.JOptionPane.showMessageDialog(null, 
                         e.getMessage(), 
                         "SQL Exception", 
                         javax.swing.JOptionPane.WARNING_MESSAGE);	
	        }
	        return encryptedString;
	    }


	/*    public static String decrypt(String encryptedString) {
	        String decryptedText=null;
	        try {
	        	TrippleDes();
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            byte[] encryptedStringX=encryptedString.getBytes();
	            byte[] encryptedText = Base64.decodeBase64(encryptedStringX);
	            byte[] plainText = cipher.doFinal(encryptedText);
	            decryptedText= new String(plainText);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return decryptedText;
	    }
	    
	*/    

	    
	}



