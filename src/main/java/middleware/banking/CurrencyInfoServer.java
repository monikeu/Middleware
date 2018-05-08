package middleware.banking;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CurrencyInfoServer {

    private int port = 50000;
    private Server server;

    public CurrencyInfoServer() {
        server = ServerBuilder
                .forPort(port)
                .addService(new CurrrencyInfoServiceImpl())
                .build();
    }

    private void startServer() throws IOException {
        server.start();
        System.out.println("Server started");
    }

    public static void main(String[] args) throws IOException {
        new CurrencyInfoServer().startServer();
    }


}
