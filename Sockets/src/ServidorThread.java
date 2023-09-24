import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServidorThread extends Thread {
    private Socket socket1;
    private Socket socket2;


    public ServidorThread(Socket socket1, Socket socket2) {
        this.socket1 = socket1;
        this.socket2 = socket2;
    }

    @Override
    public void run(){
        try{
            //Input: entrada, Output: saída
            InputStreamReader inputStreamReader = new InputStreamReader(socket1.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            //Aqui o PrintStream é utilizado para gravar registros em arquivos de saída.
            PrintStream output = new PrintStream(socket2.getOutputStream());

            String readingLine;

            while ((readingLine = reader.readLine()) != null){
                output.println(readingLine);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
