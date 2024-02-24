/**
    A collecion of quality of life methods for programming in the CSCI22 class.

	@author Enrique Gabriel Badiola
	@since 23 February 2024
    @version 1.1

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.
**/

import java.io.*;
import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;

/**
 * This Java class extends JFrame and allows for displaying the coordinates of mouse clicks in the
 * JFrame title.
 */
public class CSCI22_Tools extends JFrame {
    
    /**
     * The `public CSCI22_Tools()` constructor in the `CSCI22_Tools` class checks
     * for objects when instantiated.
     */
    public CSCI22_Tools() {
        checkForupdates();
    }

    private void checkForupdates() {
        String githubRawURL = "https://raw.githubusercontent.com/skyant83/CSCI22/public/CSCI22_Tools.java";
        String localFilePath = "CSCI22_Tools.java";

        HttpClient client = HttpClient.newHttpClient();

        System.out.println("Checking for updates...");

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(githubRawURL))
            .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(githubContent -> {
                try {
                    String localContent = readFile(localFilePath).trim();
                    String ghc = githubContent.trim();
			
                    if (!ghc.equals(localContent)) {
                        
                        System.out.println("Update Found. Downloading...");
                        writeFile(localFilePath, ghc);
                        System.out.println("File updated successfully.");
                    } else {
                        System.out.println("File is already up to date.");
                    }
                } catch (IOException e) {
                    System.err.println("Error updating file: " + e.getMessage());
                }
            })
            .join();
    }

    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
    
    public String readFile(String filePath) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return text;
    }

    /**
     * The `coordsToTitle` function sets the title of a frame to display the x and y coordinates of the
     * mouse click event adjusted by -7 and -30 respectively.
     */
    public void coordsToTitle(JFrame f) {
        f.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                f.setTitle(String.format("x: %s, y: %s", x-7, y-30));
            }
        });
    }

    public void coordsToTitle(JFrame f, int adjustForX, int adjustForY) {
        f.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                f.setTitle(String.format("x: %s, y: %s", x-adjustForX, y-adjustForY));
            }
        });
    }
}