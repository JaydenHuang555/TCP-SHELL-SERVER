package jay.shell.server;

import jay.util.Builder;
import jay.util.collection.OrderedList;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ShellServer extends ServerSocket {

    private static ShellServer instance;

    public final static ShellServer getInstance() throws Exception{
        return instance == null ? (instance = new ShellServer(Constants.PORT)) : instance;
    }

    private final OrderedList<Client> clients = new OrderedList<>();

    private ShellServer(int port) throws IOException {
        super(port);
    }

    public void listen() throws Exception {
        System.out.printf("listening on port %d\n", getLocalPort());
        while(1 == 1) {
            System.out.println("found connection");
            Client client = new Client(accept());
            client.writef("server got client");
            client.start();
        }
    }

}
