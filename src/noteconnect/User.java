package noteconnect;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public class User {
	//static int totalnum;
	int ID;
	String email;
	String passwordHash;

	public User(String email, String password, int ID) {
		this.email = email;
		setPassword(password);
		//totalnum += 1;
		this.ID = ID;
	}
	public boolean validatePassword(String pw){
		
		return passwordHash.equals(hashPassword(pw));
	}
	public void setPassword(String pw) {
		passwordHash = hashPassword(pw);
	}
	
	public String hashPassword(String password) {
        try {
            // Get an instance of SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // Compute the hash
            byte[] hashedBytes = md.digest(password.getBytes());
            // Encode the hash to a readable string (Base64)
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-512 algorithm not available.", e);
        }
    }

}