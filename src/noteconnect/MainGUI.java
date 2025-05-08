package noteconnect;

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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//import NoteListGUI;
//import NoteController;
//import NoteCreationGUI;

public class MainGUI extends JFrame {

/*    private NoteController controller;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;*/
    private NoteCreationGUI creationGUI;
    private JButton createButton;
    private NoteListGUI listGUI;
    private JButton listButton;
    private NoteViewGUI viewGUI;
    private JButton viewButton;

    private NoteEditGUI editGUI;
    private JButton editButton;

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
    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        createButton = new JButton("Create note");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creationGUI = new NoteCreationGUI();
                creationGUI.show();
            }
        });
        createButton.setBounds(25, 60, 100, 29);
        contentPane.add(createButton);
  
        viewButton = new JButton("View a note");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewGUI = new NoteViewGUI();
                viewGUI.show();
            }
        });
        viewButton.setBounds(150, 60, 150, 29);
        contentPane.add(viewButton);

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editGUI = new NoteEditGUI();
              editGUI.show();
            }
        });
        editButton.setBounds(325, 60, 100, 29);
        contentPane.add(editButton);


//      createButton.addActionListener(new ActionListener() {
//          public void actionPerformed(ActionEvent e) {
//              add_new_password(txtTitle.getText(), txtPassword.getText());
//          }
//      });
//      listButton.addActionListener(new ActionListener() {
//          public void actionPerformed(ActionEvent e) {
//              delete_password(list.getSelectedIndex());
//          }
//      });

        btnExit = new JButton("Exit");
      btnExit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              System.exit(ABORT);
          }
      });
        btnExit.setBounds(175, 166, 100, 29);
        contentPane.add(btnExit);
    }
/*  void add_new_password(String t, String p) {
        add_to_list(t, p);
        FileManager fm=new FileManager();
        fm.save(lm);
    }

    void add_to_list(String t, String p){
        lm.addElement(t+":"+p);
    }

    void show_list() {
        FileManager fm=new FileManager();
        lm=fm.read();

    }

    void delete_password(int id) {
        remove_from_list(id);
        FileManager fm=new FileManager();
        fm.save(lm);

    }

    void remove_from_list(int id) {
        lm.remove(id);
    }
    // private User owner;
    // private List<User> sharedWith = new ArrayList<>();
    // private List<MediaAttachment> attachments = new ArrayList<>();

  /*  public Note(String id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt /*, User owner  {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        // this.owner = owner;
    }

    // Getters & setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // public User getOwner() { return owner; }
    // public void setOwner(User owner) { this.owner = owner; }
    // public List<User> getSharedWith() { return sharedWith; }
    // public List<MediaAttachment> getAttachments() { return attachments; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }
*/
}
