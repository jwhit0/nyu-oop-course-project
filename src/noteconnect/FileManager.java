package noteconnect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class FileManager {
	private String filename="data.txt";
	
	DefaultListModel read() {
		DefaultListModel notesListModel =new DefaultListModel();
		Scanner myscanner;
		try {
			myscanner = new Scanner(new File(filename));
			while(myscanner.hasNext()) {
/*              String line = myscanner.nextLine();
                String title = line.split(":")[1];
                notesListModel.addElement(title);*/

				notesListModel.addElement(myscanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notesListModel;
	}
	
	void save(DefaultListModel notesList){
		FileWriter fw;
		try {
			fw=new FileWriter(filename);
			for(int i=0; i<notesList.size(); i++) {
				String item=(String) notesList.getElementAt(i);
				fw.write(item);
				fw.write("\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}