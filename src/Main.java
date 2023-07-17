public class Main {
    public static void main(String[] args) {

        Thread webServerThread = new Thread(new WebServer());
        webServerThread.start();
    }
}