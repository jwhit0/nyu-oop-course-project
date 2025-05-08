package noteconnect;

import java.util.*;
import java.util.stream.Collectors;

public class NoteRepository {
    private Map<String, Note> notes = new HashMap<>();

    public void save(Note note) {
        notes.put(note.getId(), note);
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

    public void delete(Note note) {
        notes.remove(note.getId());
    }
}