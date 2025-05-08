package noteconnect;

public class NoteController {
    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    public void createNote(String title, String content, int userId) {
        service.createNote(title, content, userId);
    }

    public void saveNote(Note note) {
        service.saveNote(note);
    }

    public void searchNotes(String query) {
        service.searchByTitle(query);
    }

    public void viewNote(String id) {
        service.getNoteById(id);
    }

    public void editNote(String id, String content) {
        service.updateNote(id, content);
    }

    public void deleteNote(String id) {
        service.deleteNote(id);
    }

    public void sendNoteTo(String id, int userId) {
         service.sendNote(id, userId);
    }
    
    public void downloadNote(String id) {
        service.downloadContent(id);
    }
}
