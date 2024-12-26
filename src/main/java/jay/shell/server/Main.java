package jay.shell.server;

public class Main {
    public static void main(String[] args) {
        try {
            new ShellServer(123);
        } catch (Exception e){
            System.err.println(e);
            System.exit(1);
        }
    }
}