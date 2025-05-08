package noteconnect;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NoteService {
    private final NoteRepository repo;
    // private final UserRepository userRepo;

    public NoteService(NoteRepository repo /*, UserRepository userRepo */) {
        this.repo = repo;
        // this.userRepo = userRepo;
    }

    public Note createNote(String title, String content /*, String userId */) {
        // TODO: find user by ID
        // User owner = userRepo.findById(userId);
        Note note = new Note(
                UUID.randomUUID().toString(),
                title,
                content,
                LocalDateTime.now(),
                LocalDateTime.now()
                // , owner
        );
        repo.save(note);
        return note;
    }

    public void saveNote(Note note) {
        note.setUpdatedAt(LocalDateTime.now());
        repo.save(note);
    }

    public List<Note> searchByTitle(String title) {
        return repo.findByTitle(title);
    }

    public Note getNoteById(String id) {
        return repo.findById(id);
    }

    public Note updateNote(String id, String newContent) {
        Note note = repo.findById(id);
        if (note != null) {
            note.setContent(newContent);
            note.setUpdatedAt(LocalDateTime.now());
            repo.save(note);
        }
        return note;
    }

    public void deleteNote(String id) {
        Note note = repo.findById(id);
        if (note != null) {
            repo.delete(note);
        }
    }

    public void sendNote(String noteId /*, String toUserId */) {
        Note note = repo.findById(noteId);
        if (note != null) {
            // TODO:
            // User user = userRepo.findById(toUserId);
            // note.shareWith(user);
            // repo.save(note);
        }
    }

    public byte[] downloadContent(String id) {
        Note note = repo.findById(id);
        if (note != null) {
            return note.getContent().getBytes();
        } else {
            return new byte[0];
        }      
    }
}