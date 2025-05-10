package noteconnect;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Note {
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User owner;
    private List<User> sharedWith = new ArrayList<>();
    private List<MediaAttachment> attachments = new ArrayList<>();

    public Note(String id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, User owner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
    }

    // Getters & setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public List<User> getSharedWith() { return sharedWith; }
    public List<MediaAttachment> getAttachments() { return attachments; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

    public void addMedia(MediaAttachment m) {
        attachments.add(m);
    }

    public void removeMedia(MediaAttachment m) {
        attachments.remove(m);
    }

    public void shareWith(User user) {
        sharedWith.add(user);
    }
}