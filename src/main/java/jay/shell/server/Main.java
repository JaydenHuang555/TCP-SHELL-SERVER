package jay.shell.server;

public class Main {
    public static void main(String[] args) {
        try {
            ShellServer.getInstance();
        } catch (Exception e){
            System.err.println(e);
            System.exit(1);
        }
    }
}