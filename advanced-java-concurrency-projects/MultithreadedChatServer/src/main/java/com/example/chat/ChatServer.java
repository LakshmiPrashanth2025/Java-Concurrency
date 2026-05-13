package com.example.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static final Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Chat Server Started");

        while(true) {
            Socket socket = serverSocket.accept();
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {

        private Socket socket;
        private PrintWriter out;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clients) {
                    clients.add(out);
                }

                String message;

                while((message = in.readLine()) != null) {
                    broadcast(message);
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        private void broadcast(String message) {
            synchronized (clients) {
                for(PrintWriter client : clients) {
                    client.println(message);
                }
            }
        }
    }
}