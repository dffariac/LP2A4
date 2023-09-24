import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            //Um socket é como uma porta virtual que permite que computadores diferentes conversem através da internet ou de uma rede local.
            Socket cliente2 = new Socket("localhost", 12345);

            ClienteThread clienteThread = new ClienteThread(cliente2);
            clienteThread.start();
            PrintStream saida = new PrintStream(cliente2.getOutputStream());

            while (true){
                String mensagem = scan.nextLine();
                saida.println(mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
