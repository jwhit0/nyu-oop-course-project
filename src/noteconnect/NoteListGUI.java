package noteconnect;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.parser.Element;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;

public class NoteListGUI extends JFrame {
    private JPanel contentPane;
    private JTextField titleField;
    private JTextField searchField;
    private JButton searchButton;
    private JList list;
    private DefaultListModel notesList;
    private Object[] interimList;
    private ArrayList<String> titlesList = new ArrayList<String>();
    private JButton viewButton;
    private JButton cancelButton;
    private NoteViewGUI view;
    private NoteController controller;
    private JLabel title;
    private JLabel content;
    
    public NoteListGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                interimList = notesList.toArray();
                for (Object o : interimList) {
                    titlesList.add(o.toString());
                }
                search(titleField.getText());
            }
        });

        searchButton.setBounds(311, 50, 120, 30);
        contentPane.add(searchButton);

        JButton viewButton = new JButton("view note");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //controller = new NoteController(null);
                //Note n = controller.createNote("HI", "bye", 0);
                //Note n = list.getSelectedValue();
                //view.setController();
                //view.setThisNote(n);
                String str = list.getSelectedValue().toString();
                System.out.println(str);
                String[] spl = str.split(":");
                //System.out.println(spl[1] + spl[0]);
                view = new NoteViewGUI();
                if (spl.length > 1) {
                    view.setTitle(spl[0]);
                    view.setContent(spl[1]);
                }
                else {
                    view.setContent(str);
                }
                view.show();
                dispose();
            }
        });
        viewButton.setBounds(311, 100, 120, 30);
        contentPane.add(viewButton);


        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        cancelButton.setBounds(311, 150, 120, 30);
        contentPane.add(cancelButton);

        titleField = new JTextField();
        titleField.setBounds(25, 50, 130, 26);
        contentPane.add(titleField);
        titleField.setColumns(10);

        list = new JList();
		list.setBounds(25, 100, 250, 150);
		contentPane.add((list));
		notesList = new DefaultListModel();
		
		show_list();
		list.setModel(notesList);
    }

    void search(String filter) {
        for (String s : titlesList) {
            if (!s.startsWith(filter)) {
                if (notesList.contains(s)) {
                    notesList.removeElement(s);
                }
            } else {
                if (!notesList.contains(s)) {
                    notesList.addElement(s);
                }
            }
        }
    }

    public void setController() {
        controller = MainGUI.controller;
    }

    void show_list() {
        FileManager fm=new FileManager();
        notesList=fm.read();

        //Map<String, Note> testMap = controller.getService().getRepo().getMap();
        //Collection <Note> testList = testMap.values();
        //System.out.println(testMap);
        //System.out.println(testList);
        //List<Note> values = new ArrayList<Note>(controller.getService().getRepo().getMap().values());
        //System.out.println(values);
        /*FileWriter fw;
        try {
            fw = new FileWriter("test.txt");
            for(int i=0; i<values.size(); i++) {
                String item=(String) values.get(i).getTitle();
                fw.write(item);
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        //FileWriter fw=new FileWriter("test.txt");
        //for (Note n : values) {
            //System.out.println(n.getTitle())
            //titlesList.addElement(n.getTitle());
			//String item=(String) n.getTitle();
			//fw.write(item);
			//fw.write("\n");
        //}
		//fw.close();


        //for (Element e : notesList) {
            
        //}
        //titlesList = Arrays.asList(model.toArray());

    }

}
