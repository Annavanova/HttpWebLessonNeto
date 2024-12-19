package org.example.RefactoringMultiThreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.RefactoringMultiThreading.Main.poolSizeThreads;


public class Server{

    ExecutorService executorService = Executors.newFixedThreadPool(poolSizeThreads);

    public void listen(int port) {

        try (final var serverSocket = new ServerSocket(port)) {

            while (true) {
                final var socket = serverSocket.accept();
                System.out.println(socket);
                HendlerSocket hendlerSocket = new HendlerSocket(socket);
                executorService.submit(hendlerSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
