package noteconnect;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;

public class NoteRepository {
    private Map<String, Note> notes = new HashMap<>();
    private final FileManager fileManager;
    //private String counter = "1";

    public NoteRepository(FileManager fileManager) {
        this.fileManager = fileManager;
        
        DefaultListModel<String> model = fileManager.read();
        System.out.println(model);
        for (int i = 0; i < model.size(); i++) {
            //System.out.println(model.getElementAt(i));
            //System.out.println(model.getElementAt(i).getClass());
            String noteString = model.getElementAt(i);
            String[] split = noteString.split(":");
            Note n = new Note(counter, split[0], split[1]);
            counter += "1";
            //Note n = model.getElementAt(i);
            notes.put(n.getId(), n);
        }
    }

    public void save(Note note) throws IOException {
        notes.put(note.getId(), note);
        DefaultListModel<Note> model = new DefaultListModel<>();
        notes.values().forEach(model::addElement);
        fileManager.save(model);
    }

    public void delete(Note note) throws IOException {
        notes.remove(note.getId());
        DefaultListModel<Note> model = new DefaultListModel<>();
        notes.values().forEach(model::addElement);
        fileManager.save(model);
    }

    public Note findById(String id) {
        return notes.get(id);
    }

    public List<Note> findByTitle(String title) {
        return notes.values().stream()
                .filter(n -> n.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    /*public List<Note> findAll() {
        return new ArrayList<>(notes.values());
    }*/

    //public List<Note> findByOwner(User owner) {
    // }

    // public List<Note> findSharedWith(User user) {
    // }

    /*public void delete(Note note) {
        notes.remove(note.getId());
    }*/
}