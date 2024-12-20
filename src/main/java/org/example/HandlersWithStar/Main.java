package org.example.HandlersWithStar;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    private static final int SERVER_SOCKET = 9999;
    private static final int poolSizeThreads = 64;

    public static void main(String[] args) throws InterruptedException
    {
        final var server = new Server(SERVER_SOCKET, poolSizeThreads);
         server.addHandler("GET", "/messages", ((request, responseStream) -> {
            try {
                server.responseWithoutContent(responseStream,"404", "Not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
         server.addHandler("POST", "/messages", (request, responseStream) -> server.responseWithoutContent(responseStream,
                "404", "Not found"));

        server.listen(9999);
    }
}
