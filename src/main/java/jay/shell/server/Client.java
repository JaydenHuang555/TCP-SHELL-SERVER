package jay.shell.server;

import jay.util.Builder;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import jay.shell.server.Constants.InputOutputConstants;

public class Client extends Thread {
    private final Socket socket;

    private final PrintWriter writer;
    private final InputStreamReader reader;

    Client(Socket socket) throws Exception{
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream());
        this.reader = new InputStreamReader(socket.getInputStream());
    }

    public void writef(String format, Object ... args) throws Exception{
        Builder builder = new Builder();
        int ai = 0;
        for(int i = 0; i < format.length(); i++){
            char c = format.charAt(i);
            switch(c){
                case '%':
                    c = format.charAt(++i);
                    switch(c){
                        case InputOutputConstants.FLAG_CHAR:
                            builder.append((char) args[ai++]);
                        case InputOutputConstants.FLAG_STRING:
                            builder.append((String) args[ai++]);
                            break;
                        default: throw new Exception("invalid format flag");
                    }
                default:
                    builder.append(c);
            }
            writer.write(builder.toString());
        }
    }

    public String read() throws Exception {
        int c;
        Builder builder = new Builder();
        while((c = reader.read()) != InputOutputConstants.END_FLAG) builder.append((char)c);
        return builder.toString();
    }

    @Override
    public void run(){
        while(true){
            try {
                Builder builder = new Builder();
                char buff[] = new char[128];
                Thread.sleep(1000);
                if(reader.read() == InputOutputConstants.START_FLAG) {
                    String recieved = read();


                }

            } catch (Exception e){ }
        }
    }

}
