package noteconnect;

import java.util.*;
import java.io.*;

public class UserRepository {
	int totalnum;

	public UserRepository() {
		//generate num
		try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"))) {
            String firstLine = reader.readLine();
            totalnum= (firstLine != null) ? Integer.parseInt(firstLine) : 0;
        } catch (IOException | NumberFormatException e) {
            totalnum = 0; // Default to 0 if the file does not exist or the number is invalid
        }

	}
	public void save(User user){
		
		
		int currentCount = totalnum;
        int newCount = currentCount + 1;
        totalnum +=1;

        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt" + ".tmp"))) {

            // Write the updated count to the temporary file
            writer.write(String.valueOf(newCount));
            writer.newLine();

            // Copy existing user data
            String line;
            reader.readLine(); // Skip the first line (old user count)
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Append the new user data
            writer.write(user.ID + "," + user.email + "," +user.passwordHash);
            writer.newLine();

        } catch (IOException e) {
        	//if file did not exist
        	try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt", true))) {
               //String hashedPassword = user.hashPassword;//(password);
               writer.write("1");
               writer.newLine();
        		writer.write(user.ID + "," + user.email + "," +user.passwordHash);
               writer.newLine();
               System.out.println("User registered successfully.");
             return;
           } catch (IOException e1) {
               System.err.println("Error writing to file: " + e.getMessage());
           }
        	
            //System.err.println("Error updating user data: " + e.getMessage());
            //return;
        }

        // Replace the original file with the updated temporary file
        File originalFile = new File("UserInfo.txt");
        File tempFile = new File("UserInfo.txt" + ".tmp");
        if (tempFile.renameTo(originalFile)) {
            System.out.println("User registered successfully.");
        } else {
            System.err.println("Error replacing the original file.");
        }
		
	}
	public User findById(int id) {
		String ID = Integer.toString(id);
		try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"))) {
        reader.readLine(); // Skip the first line (user count)
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String storedUserId = parts[0];
                String storedHashedPassword = parts[2];
                String storedEmail = parts[1];
                
                if (storedUserId.equals(ID)) {
                    return new User(storedEmail, storedHashedPassword, Integer.parseInt(storedUserId));
                }
                
            }
        }
    } catch (IOException e) {
        System.out.println("no existing file, need to register");
        return null;
    }
	return null;
	}
	public User findByEmail(String email) {
		try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"))) {
            reader.readLine(); // Skip the first line (user count)
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String storedUserId = parts[0];
                    String storedHashedPassword = parts[2];
                    String storedEmail = parts[1];
                    
                    if (storedEmail.equals(email)) {
                        return new User(storedEmail, storedHashedPassword, Integer.parseInt(storedUserId));
                    }
                    
                }
            }
        } catch (IOException e) {
            System.out.println("no existing file, need to register");
            return null;
        }
		return null;
	}

}
