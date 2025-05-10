package noteconnect;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class NoteCreationGUI extends JFrame {
    private JPanel contentPane;
    private JLabel title;
    private JTextField titleField;
    private JLabel content;
    private JTextArea contentArea;
    private JButton saveButton;
    private JButton cancelButton;
    private JList list;
    private DefaultListModel lm;

    private NoteController controller = new NoteController();
    //TODO: WHERE IS THIS BEING INITIALIZED?? SERVICE AS WELL

    public NoteCreationGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        title = new JLabel("Enter title: ");
        contentPane.add(title);
        titleField = new JTextField();
        titleField.setBounds(27, 46, 130, 26);
        contentPane.add(titleField);
        titleField.setColumns(10);

        content = new JLabel("Enter content: ");
        contentPane.add(content);
        contentArea = new JTextArea();
        contentArea.setBounds(27, 100, 130, 75);
        contentArea.setLineWrap(true);
        contentPane.add(contentArea);
        contentArea.setColumns(10);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNote(titleField.getText(), contentArea.getText());
                dispose();
            }
        });
        saveButton.setBounds(311, 59, 117, 29);
        contentPane.add(saveButton);

        // btnDelete = new JButton("Delete");
        // btnDelete.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // delete_password(list.getSelectedIndex());
        // }
        // });
        // btnDelete.setBounds(311, 110, 117, 29);
        // contentPane.add(btnDelete);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setBounds(311, 166, 117, 29);
        contentPane.add(cancelButton);

        //show_list();
    }

    void newNote(String t, String c) {
        controller.createNote(titleField.getText(), contentArea.getText(), 1);
        //listAdd(t, c);
        //FileManager fm = new FileManager();
        //fm.save(lm);
    }
    /*
    void listAdd(String t, String c) {
        System.out.println(t + ", " + c);
        lm.addElement(t + ":" + c);
    };*/

    //void show_list() {
        ////FileManager fm = new FileManager();
        //lm = fm.read();
    //}
}
