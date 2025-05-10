package noteconnect;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;

public class NoteRepository {
    private Map<String, Note> notes = new HashMap<>();
    private final FileManager fileManager;

    public NoteRepository(FileManager fileManager) throws IOException {
        this.fileManager = fileManager;
        
        DefaultListModel<Note> model = fileManager.read();
        for (int i = 0; i < model.size(); i++) {
            Note n = model.getElementAt(i);
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

    /*public void save(Note note) {
        notes.put(note.getId(), note);
    }*/

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