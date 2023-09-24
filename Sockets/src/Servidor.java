import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            //o socket serve como comunicação entre duas máquinas

            //criar um novo servidor na porta escolhida
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ativo ouvindo a porta 12345.");

            //vai esperar o cliente aceitar esse socket
            Socket cliente1 = servidor.accept();
            System.out.println("Cliente 1 conectado!");

            Socket cliente2 = servidor.accept();
            System.out.println("Cliente 2 conectado!");

            ServidorThread servidor1 = new ServidorThread(cliente1, cliente2);
            servidor1.start();

            ServidorThread servidor2 = new ServidorThread(cliente2, cliente1);
            servidor2.start();

        } catch (IOException e) {
            e.printStackTrace(); //pode lançar a exceção também no psvm para não fazer try/catch
        }
    }
}