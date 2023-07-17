import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestHandler implements Runnable{

    BufferedReader in;
    DataOutputStream out;

    public RequestHandler(BufferedReader in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }


    @Override
    public void run() {
        try {
            String line = in.readLine();
            System.out.println(line);
            if(line.equals("GET /index.html HTTP/1.1") || line.equals("GET / HTTP/1.1")) {
                System.out.println("SENDING TEXT HTML CRL");

                        String htmlPath = "www/index.html";
                        byte[] htmlBuffer = Files.readAllBytes(Paths.get(htmlPath));

                        String response = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + htmlBuffer.length + " \r\n" +
                        "\r\n";
                out.write(response.getBytes());
                out.write(htmlBuffer);

            }
            if(line.equals("GET /res/download.png HTTP/1.1")) {
                System.out.println("SENDING IMAGE CRL");
                    String imgPath = "res/download.png";
                    byte[] imgBuffer = Files.readAllBytes(Paths.get(imgPath));

                    String response = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: image/png\r\n" +
                            "Content-Length: " + imgBuffer.length + " \r\n" +
                            "\r\n";
                    out.write(response.getBytes());
                    out.write(imgBuffer);
            }
            if(line.equals("GET /favicon.ico HTTP/1.1")) {
                System.out.println("SENDING ICON CRL");
                    String iconPath = "res/download.png";
                    byte[] iconBuffer = Files.readAllBytes(Paths.get(iconPath));

                    String response = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: image/png\r\n" +
                            "Content-Length: " + iconBuffer.length + " \r\n" +
                            "\r\n";
                out.write(response.getBytes());
                out.write(iconBuffer);
            }
            if(line.equals("GET /stylesheet.css HTTP/1.1")) {
                System.out.println("SENDING PAGE WITH STYLE CRL");
                    String stylePath = "www/stylesheet.css";
                    byte[] styleBuffer = Files.readAllBytes(Paths.get(stylePath));

                    String response = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: text/css; charset=UTF-8\r\n" +
                            "Content-Length: " + styleBuffer.length + " \r\n" +
                            "\r\n";
                out.write(response.getBytes());
                out.write(styleBuffer);
            }
            if(line.equals("GET /team.html HTTP/1.1")) {
                System.out.println("SENDING TEAM PAGE CRL");
                    String teamPath = "www/team.html";
                    byte[] teamBuffer = Files.readAllBytes(Paths.get(teamPath));

                    String response = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: " + teamBuffer.length + " \r\n" +
                            "\r\n";
                out.write(response.getBytes());
                out.write(teamBuffer);
            }
            if(line.equals("GET /res/manuel.jpg HTTP/1.1")) {
                System.out.println("SENDING ICON CRL");
                String manuelPath = "res/manuel.jpg";
                byte[] manuelBuffer = Files.readAllBytes(Paths.get(manuelPath));

                String response = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: image/jpg\r\n" +
                        "Content-Length: " + manuelBuffer.length + " \r\n" +
                        "\r\n";
                out.write(response.getBytes());
                out.write(manuelBuffer);
            }
            if(line.equals("GET /res/ruben.jpg HTTP/1.1")) {
                System.out.println("SENDING ICON CRL");
                String rubenPath = "res/ruben.jpg";
                byte[] rubenBuffer = Files.readAllBytes(Paths.get(rubenPath));

                String response = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: image/jpg\r\n" +
                        "Content-Length: " + rubenBuffer.length + " \r\n" +
                        "\r\n";
                out.write(response.getBytes());
                out.write(rubenBuffer);
            }
            if(line.equals("GET /res/stole.jpg HTTP/1.1")) {
                System.out.println("SENDING ICON CRL");
                String stolePath = "res/stole.jpg";
                byte[] stoleBuffer = Files.readAllBytes(Paths.get(stolePath));

                String response = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: image/jpg\r\n" +
                        "Content-Length: " + stoleBuffer.length + " \r\n" +
                        "\r\n";
                out.write(response.getBytes());
                out.write(stoleBuffer);
            }


            out.close();
            in.close();





        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
