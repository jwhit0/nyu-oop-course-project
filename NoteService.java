package noteconnect;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NoteService {
    private final NoteRepository repo;
    private final UserRepository userRepo;

    public NoteService(NoteRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public Note createNote(String title, String content, int userId) throws IOException {
        User owner = userRepo.findById(userId);
        Note note = new Note(
                UUID.randomUUID().toString(),
                title,
                content,
                LocalDateTime.now(),
                LocalDateTime.now(),
                owner
        );
        repo.save(note);
        return note;
    }

    public void saveNote(Note note) throws IOException {
        note.setUpdatedAt(LocalDateTime.now());
        repo.save(note);
    }

    public List<Note> searchByTitle(String title) {
        return repo.findByTitle(title);
    }

    public Note getNoteById(String id) {
        return repo.findById(id);
    }

    public Note updateNote(String id, String newContent) throws IOException {
        Note note = repo.findById(id);
        if (note != null) {
            note.setContent(newContent);
            note.setUpdatedAt(LocalDateTime.now());
            repo.save(note);
        }
        return note;
    }

    public void deleteNote(String id) throws IOException {
        Note note = repo.findById(id);
        if (note != null) {
            repo.delete(note);
        }
    }

    public void sendNote(String noteId, int toUserId) throws IOException {
        Note note = repo.findById(noteId);
        if (note != null) {
            User user = userRepo.findById(toUserId);
            note.shareWith(user);
            repo.save(note);
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