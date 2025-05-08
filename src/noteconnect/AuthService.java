package noteconnect;

import java.util.*;
import java.io.*;


public class AuthService {
	private UserRepository userRepo;
	public User currentUser;

	public AuthService() {
		userRepo = new UserRepository();
	}
	
	public User register(String email, String password) {
		User u = new User(email, password, (userRepo.totalnum+1));
		userRepo.save(u);
		System.out.println(userRepo.totalnum);
		return u;
	}
	
	public boolean login(String email, String password) {
		User cur = userRepo.findByEmail(email);
		if(cur != null) {
			if(cur.validatePassword(cur.hashPassword(password))) {
				currentUser = cur;
				return true;
			}
			
			else {
				System.out.print("wrong password");
				return false;
			}
			
		}
		else
			return false;
	}
	
	public void logout() {
		currentUser = null;
	}

}
