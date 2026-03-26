import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP {
    public void iniciar(int porta) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o produto: ");
        String produto = sc.nextLine();;

        try (Socket socket = new Socket("Localhost", 12000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(produto);
            System.out.println("Preço recebido: " + in.readLine());
        } catch (IOException e) {
            System.err.println("Erro ao iniciar TCP.");
        }

    }
}