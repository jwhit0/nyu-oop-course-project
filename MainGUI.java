package noteconnect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import NoteListGUI;
//import NoteController;
//import NoteCreationGUI;

public class MainGUI extends JFrame {

    public static NoteController controller;
/*    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;*/
    private NoteCreationGUI creationGUI;
    private JButton createButton;
    private NoteListGUI listGUI;
    private JButton listButton;
    private JPanel cardContainer;
    private JMenuBar menuBar;
    private JMenu notesMenu;
    private JMenuItem newNoteItem;
    private JMenuItem listNotesItem;
    private JPanel contentPane;
    private JTextField txtTitle;
    private JTextField txtPassword;
    private JButton btnExit;
    private JList list;
    private DefaultListModel lm;
    private FileManager fm = new FileManager();
    public MainGUI() {
        //controller = new NoteController(new NoteService(new NoteRepository(fm), new UserRepository()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        createButton = new JButton("Create note");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creationGUI = new NoteCreationGUI();
                creationGUI.setController();
                creationGUI.show();
            }
        });
        createButton.setBounds(175, 60, 100, 29);
        contentPane.add(createButton);
  
        listButton = new JButton("View all notes");
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listGUI = new NoteListGUI();
                listGUI.setController();
                listGUI.show();
            }
        });
        listButton.setBounds(150, 100, 150, 29);
        contentPane.add(listButton);

        btnExit = new JButton("Exit");
      btnExit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              System.exit(ABORT);
          }
      });
        btnExit.setBounds(175, 166, 100, 29);
        contentPane.add(btnExit);
    }
    void show_list() {
        FileManager fm=new FileManager();
        lm=fm.read();
    }
  /*void add_new_password(String t, String p) {
        add_to_list(t, p);
        FileManager fm=new FileManager();
        fm.save(lm);
    }

    void add_to_list(String t, String p){
        lm.addElement(t+":"+p);
    }


    void delete_password(int id) {
        remove_from_list(id);
        FileManager fm=new FileManager();
        fm.save(lm);

    }

    void remove_from_list(int id) {5
        lm.remove(id);
    }*/
}
