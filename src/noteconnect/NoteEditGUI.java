package noteconnect;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoteEditGUI extends JFrame {
    private JPanel contentPane;
    private JTextField titleField;
    private JTextArea contentArea;
    private JButton saveButton;
    private JButton cancelButton;
    private NoteController controller;
    private Note thisNote;
    
    public NoteEditGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        titleField = new JTextField(thisNote.getTitle());
        contentArea = new JTextArea(thisNote.getContent());
        saveButton = new JButton("Update and Save");

        contentArea.setLineWrap(true);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.editNote(thisNote.getId(), thisNote.getContent());
            }
        });

        saveButton.setBounds(311, 59, 117, 29);
        contentPane.add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              dispose();
          }
        });
        
        cancelButton.setBounds(311, 166, 117, 29);
        contentPane.add(cancelButton);

        titleField = new JTextField();
        titleField.setBounds(27, 46, 130, 26);
        contentPane.add(titleField);
        titleField.setColumns(10);
        contentPane.add(contentArea);
//      show_list();
    }
    public void setThisNote(Note n){
        thisNote = n;
    }


}
