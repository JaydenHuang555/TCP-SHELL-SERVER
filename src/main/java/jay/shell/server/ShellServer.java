package jay.shell.server;

import jay.util.Builder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ShellServer extends ServerSocket {

    private class Client extends Thread {
        private final Socket socket;

        private final PrintWriter writer;
        private final InputStreamReader reader;

        Client(Socket socket) throws Exception{
            this.socket = socket;
            this.writer = new PrintWriter(socket.getOutputStream());
            this.reader = new InputStreamReader(socket.getInputStream());
        }

        @Override
        public void run(){
            while(true){
                try {
                    Builder builder = new Builder();
                    char buff[] = new char[128];
                    Thread.sleep(1000);
                    if(reader.read() == Constants.START_FLAG) {
                        int c;
                        while((c = reader.read()) != Constants.END_FLAG) builder.append((char)c);
                    }

                } catch (Exception e){ }
            }
        }

    }

    public ShellServer(int port) throws IOException {
        super(port);
    }

    public void listen() throws Exception {
        System.out.printf("listening on port %d\n", getLocalPort());
        while(1 == 1) {
            System.out.println("found connection");
            new Client(accept()).start();
        }
    }

}
