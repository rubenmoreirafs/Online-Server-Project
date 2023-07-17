import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebServer implements Runnable {

    ServerSocket serverSocket;
    Socket socket;
    BufferedReader in;
    DataOutputStream out;


    private final int port = 5555;

    public void createConnection() {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /*public void startServer() {

        try {


            //Input and Output of information

            // Reading client input

            String filePath = "res/download.png";
            byte[] imageBytes = Files.readAllBytes(Paths.get(filePath));
            String headerImage = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: image/png\r\n" +
            "Content-Length: " + imageBytes.length + " \r\n" +
            "\r\n";
            byte[] buffer = headerImage.getBytes();
            out.write(buffer);
            out.write(imageBytes);

            socket.close();

        } catch (IOException ex) {
            System.out.println("error");
        }
    }*/

    /*public void closeServer(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public void run() {
        createConnection();
        while(true) {
            System.out.println("WAITING FOR CONNECTION");
            try {
                socket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new DataOutputStream(socket.getOutputStream());
                Thread requestThread = new Thread(new RequestHandler(in, out));
                requestThread.start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("CONNECTED");
        }
    }
}
