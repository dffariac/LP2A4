import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//Uma thread é uma linha de execução dentro de um programa que permite a execução simultânea de tarefas
public class ClienteThread extends Thread {
    private Socket cliente;

    public ClienteThread(Socket cliente){
        this.cliente = cliente;
    }

    // O InputStreamReader é usado para converter bytes em caracteres e o BufferedReader é usado para ler esses caracteres, linha por linha
    @Override
    public void run(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(cliente.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String readingLine;

            // Loop para ler linhas de texto enquanto elas não forem nulas
            while ((readingLine = reader.readLine()) != null){
                System.out.println("Usuário: " + readingLine);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Em caso de erro de entrada/saída, imprime o erro
        }
    }
}
