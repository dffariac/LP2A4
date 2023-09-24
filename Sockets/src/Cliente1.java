import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            Socket cliente1 = new Socket("localhost", 12345);

            ClienteThread clienteThread = new ClienteThread(cliente1);
            clienteThread.start();
            PrintStream saida = new PrintStream(cliente1.getOutputStream());

            while (true){
                String mensagem = scan.nextLine();
                saida.println(mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
