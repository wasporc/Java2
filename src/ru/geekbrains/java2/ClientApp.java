package ru.geekbrains.java2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientApp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            AtomicBoolean isClose = new AtomicBoolean();
            isClose.set(false);
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if ("-exit".equals(message)){
                            isClose.set(true);
                            System.out.println("Time out for login. Please press enter to close command line...");
                            break;
                        }
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("SWW7", e);
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    if (isClose.get()){
                        System.out.println("Connect closed");
                        scanner.close();
                        break;
                    }
                    System.out.println("...");
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    throw new RuntimeException("SWW6", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW10", e);
        }
    }
}
