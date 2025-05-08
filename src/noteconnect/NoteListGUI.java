package noteconnect;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class NoteListGUI extends JFrame {
    private JPanel contentPane;
    private JTextField titleField;
    private JTextField searchField;
    private JButton searchButton;
    private DefaultListModel notesList;
    private JButton viewButton;
    private JButton cancelButton;
    //private NoteController controller;
    
    public NoteListGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        searchButton = new JButton("Search");
//      btnAdd.addActionListener(new ActionListener() {
//          public void actionPerformed(ActionEvent e) {
//              add_new_password(txtTitle.getText(), txtPassword.getText());
//          }
//      });
        searchButton.setBounds(311, 59, 117, 29);
        contentPane.add(searchButton);

        //btnDelete = new JButton("Delete");
//      btnDelete.addActionListener(new ActionListener() {
//          public void actionPerformed(ActionEvent e) {
//              delete_password(list.getSelectedIndex());
//          }
//      });
//        btnDelete.setBounds(311, 110, 117, 29);
  //      contentPane.add(btnDelete);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              System.exit(ABORT);
          }
      });
        cancelButton.setBounds(311, 166, 117, 29);
        contentPane.add(cancelButton);

        titleField = new JTextField();
        titleField.setBounds(27, 46, 130, 26);
        contentPane.add(titleField);
        titleField.setColumns(10);

//      show_list();
    }


}
