package Level2_L6;


import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ClientApp {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Scanner scanner = new Scanner(System.in);


    public ClientApp() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void messagesReadAndSend() throws IOException {

        System.out.println("Enter your message or /end to exit");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String serverMessage = in.readUTF();

                        if(serverMessage.equals("/end")) closeConnection();

                        System.out.println("Server's message: " + serverMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true) {

                        String clientInput = scanner.nextLine();

                        if (clientInput.equals("/end")) closeConnection();

                        out.writeUTF(clientInput);

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

        ClientApp client = new ClientApp();

        try {

            client.messagesReadAndSend();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}