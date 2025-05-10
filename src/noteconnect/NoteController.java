package noteconnect;

import java.io.IOException;

public class NoteController {
    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    public void createNote(String title, String content, int userId) throws IOException {
        service.createNote(title, content, userId);
    }

    public void saveNote(Note note) throws IOException {
        service.saveNote(note);
    }

    public void searchNotes(String query) {
        service.searchByTitle(query);
    }

    public void viewNote(String id) {
        service.getNoteById(id);
    }

    public void editNote(String id, String content) throws IOException {
        service.updateNote(id, content);
    }

    public void deleteNote(String id) throws IOException {
        service.deleteNote(id);
    }

    public void sendNoteTo(String id, int userId) throws IOException {
         service.sendNote(id, userId);
    }
    
    public void downloadNote(String id) {
        service.downloadContent(id);
    }
}
