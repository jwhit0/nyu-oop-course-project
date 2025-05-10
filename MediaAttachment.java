package noteconnect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MediaAttachment {
	private String id; // Unique identifier for the media attachment
    private String filename; // Name of the file
    private long size; // Size of the file in bytes
    private String mimeType; // MIME type of the file (e.g., "image/png", "application/pdf")
    private String filePath;

    // Constructor
    public MediaAttachment(String id, String filename, long size, String mimeType) {
        this.id = id;
        this.filename = filename;
        this.size = size;
        this.mimeType = mimeType;
    }
    
    /**
    * Fetches an InputStream to read the content of the file.
    * @return InputStream representing the content of the file.
    * @throws IOException if the file cannot be read.
    */
    public InputStream getStream() throws IOException {
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists() || !file.isFile()) {
            throw new IOException("File not found: " + filePath);
        }

        return new FileInputStream(file); // Return a stream to read the file
    }
}