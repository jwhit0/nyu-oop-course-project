package noteconnect;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class NoteViewGUI extends JFrame {
    private JPanel contentPane;
    private Note thisNote;
    private JLabel noteTitle;
    private JLabel noteContent;
    private JButton editButton;
    private JButton deleteButton;
    private JButton sendButton;

    private JLabel titleLbl;
    private JLabel contLabel;
    private String title;
    private String content;
    private JButton downloadButton;
    private JButton cancelButton;
    private NoteController controller;
    
    public NoteViewGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        title = "hi";
        content = "bye";

        titleLbl = new JLabel("Title: ");
        contentPane.add(titleLbl);
        System.out.println("TITLE: " + title);
        System.out.println("CONTENT: " + content);
        noteTitle = new JLabel(title);
        System.out.println(noteTitle.getText());
        noteTitle.setSize(10,10);
        noteTitle.setLocation(25,50);

        contentPane.add(noteTitle);

        contLabel = new JLabel("Content: ");
        contentPane.add(contLabel);

        noteContent = new JLabel();
        noteContent.setText("<html><p style=\"width:100px\">"+ content +"</p></html>");
        System.out.println(noteContent.getText());
        noteContent.setSize(10,10);
        noteTitle.setLocation(25,100);

        contentPane.add(noteContent);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteNote(title + ":" + content);
                dispose();
            }
        });

        downloadButton = new JButton("Download");
        downloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteButton.setBounds(311, 110, 117, 29);
        contentPane.add(deleteButton);

        editButton = new JButton("Edit Note");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NoteEditGUI edit = new NoteEditGUI();
                edit.setThisNote(thisNote);
                edit.show();
            }
        });

        editButton.setBounds(311, 59, 117, 29);

        contentPane.add(editButton);
        contentPane.add(editButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              dispose();
          }
      });
        cancelButton.setBounds(311, 166, 117, 29);
        contentPane.add(cancelButton);

        noteTitle.setVisible(true);
        noteContent.setVisible(true);
        setVisible(true);
    }

    public void deleteNote(String note) {
        FileManager fm=new FileManager();
        DefaultListModel notesList=fm.read();
        fm.delete(notesList, note);
        return;
    }

    public void setTitle(String t) {
        this.title = t;
    }
    public void setContent(String c) {
        this.content = c;
    }
    public void setThisNote(Note n){
        thisNote = n;
    }
    public setController() {
        controller = MainGUI.controller;
    }
}
