package Level2_L6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Scanner scanner = new Scanner(System.in);


    public ServerApp() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started. Waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            System.out.println("Enter your message or /end to exit");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void messagesReadAndSend() throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        String clientMessage = in.readUTF();

                        if (clientMessage.equals("/end")) closeConnection();

                        System.out.println("Client's response: " + clientMessage);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        String serverInput = scanner.nextLine();

                        if (serverInput.equals("/end")) closeConnection();

                        out.writeUTF(serverInput);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    void closeConnection() {

        System.out.println("Session closed");

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    public static void main(String[] args) {

        ServerApp server = new ServerApp();

        try {

            server.messagesReadAndSend();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}




