/**
    A collecion of quality of life methods for programming in the CSCI22 class.

	@author Enrique Gabriel Badiola
	@since 23 February 2024
    @version 1.3

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.
**/

import java.io.*;
import java.net.ConnectException;
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

    /**
     * The `checkForupdates` function checks for updates from a GitHub repository and downloads the
     * updated file if available.
     */
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
            .exceptionally(e -> {
                if (e.getCause() instanceof ConnectException) 
                    System.err.println("Error: No internet connection. Skipping update.");
                return null;
            })
            .join();
    }

    /**
     * The `writeFile` function writes the given content to a file specified by the file path.
     * 
     * @param   filePath  
     *          The `filePath` parameter in the `writeFile` method is a string that represents
     *          the path to the file where the content will be written. It should include the 
     *          file name and extension (e.g., "C:/example.txt").
     * 
     * @param   content
     *          The `content` parameter in the `writeFile` method represents the text content
     *          that you want to write to a file. It is the actual data that you want to write 
     *          into the file specified by the `filePath` parameter.
     * 
     * @throws  IOException 
     *          if the named file exists but is a directory rather than a regular file, does 
     *          not exist but cannot be created, or cannot be opened for any other reason
     */
    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
    
    /**
     * The `readFile` function reads the contents of a file specified by the `filePath` parameter
     * and returns the text as a string.
     * 
     * @param   filePath  
     *          The `filePath` parameter is a `String` that represents the path to the file that
     *          you want to read. This method reads the contents of the file located at the 
     *          specified `filePath` and returns the text content as a `String`.
     * 
     * @return  The method `readFile` returns the content of the file located at the specified
     *          `filePath` as a String.
     * 
     * @throws  IOException if an I/O error occurs reading from the stream
     * 
     * @throws  OutOfMemoryError
     *          if the file is extremely large, for example larger than {@code 2GB}
     */
    public String readFile(String filePath) throws IOException{
        String text = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return text;
    }

    /**
     * The `coordsToTitle` function sets the title of a JFrame to display the coordinates of the mouse
     * click event relative to the JFrame.
     * 
     * @param   f 
     *          The parameter `f` in the `coordsToTitle` method is a `JFrame` object.
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

    /**
     * The function `coordsToTitle` sets the title of a JFrame to display the coordinates of a mouse
     * click adjusted by specified values.
     * 
     * @param   f 
     *          The parameter `f` is a `JFrame` object, which represents a window in a Java Swing
     *          application.
     * 
     * @param   adjustForX
     *          The `adjustForX` parameter is used to adjust the x-coordinate of the mouse
     *          click position before displaying it in the title of the JFrame. It allows you to modify the
     *          x-coordinate value by adding or subtracting a specific value before showing it in the title.
     * 
     * @param   adjustForY 
     *          The `adjustForY` parameter in the `coordsToTitle` method is used to specify the amount by 
     *          which the Y coordinate should be adjusted before displaying it in the title of the JFrame.
     *          This adjustment allows you to fine-tune the displayed coordinates based on your specific
     *          requirements or layout considerations.
     */
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

    /**
     * The `coordsToCmd` function adds a mouse listener to a JFrame to print the adjusted x and y
     * coordinates when the mouse is clicked.
     * 
     * @param   f The parameter `f` in the `coordsToCmd` method is a `JFrame` object.
     */
    public void coordsToCmd(JFrame f) {
        f.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.printf("x: %s y: %s\n", x-7, y-30);
            }
        });
    }

    /**
     * The function `coordsToCmd` adds a mouse listener to a JFrame to print the adjusted x and y
     * coordinates of a mouse click event.
     * 
     * @param   f JFrame f is the Java Swing JFrame object to which the mouse listener will be added.This 
     *          method adds a mouse listener to the JFrame to capture mouse click events and convert the
     *          coordinates of the click to a command.
     * 
     * @param   adjustForX The `adjustForX` parameter is used to specify the amount by which the x-coordinate
     *          should be adjusted before displaying it. This adjustment allows you to fine-tune the displayed
     *          x-coordinate based on your requirements.
     * 
     * @param   adjustForY The `adjustForY` parameter in the `coordsToCmd` method is used to specify the amount
     *          by which the y-coordinate should be adjusted when displaying the coordinates of a mouse click
     *          event. This adjustment allows you to account for any offset or correction needed in the
     *          y-coordinate value.
     */
    public void coordsToCmd(JFrame f, int adjustForX, int adjustForY) {
        f.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.printf("x: %s y: %s\n", x-adjustForX, y-adjustForY);
            }
        });
    }

    
}