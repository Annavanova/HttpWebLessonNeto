package org.example.RefactoringMultiThreading;

import java.io.IOException;

public class Main {
    private final static int PORT = 9999;
    public final static int poolSizeThreads = 64;

    public static void main(String[] args) throws IOException {
        final var server = new Server();
        server.listen(PORT);

        /*Server server = new Server(PORT, poolSizeThreads);
        server.addHandler("GET", "/messages", ((request, responseStream) -> {
            try {
                server.responseWithoutContent(responseStream,"404", "Not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));

        server.addHandler("POST", "/messages", (request, responseStream) -> server.responseWithoutContent(responseStream,
                "404", "Not found"));
//        server.addHandler("GET", "/", ((request, responseStream) -> server.defaultHandler(responseStream, "spring.png")));
        server.start();*/
    }
}
