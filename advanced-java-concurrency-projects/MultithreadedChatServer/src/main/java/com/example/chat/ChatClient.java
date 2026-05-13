package com.example.chat;

import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        new Thread(() -> {
            try {
                String response;
                while((response = in.readLine()) != null) {
                    System.out.println("Message: " + response);
                }
            } catch(Exception e){}
        }).start();

        out.println("Hello from Client");
    }
}