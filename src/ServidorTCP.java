import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o produto (TCP): ");
        String produto = sc.nextLine();

        try (Socket socket = new Socket("Localhost", 12000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(produto);
            System.out.println("Preço: " + in.readLine());
        } catch (IOException e) {
            System.err.println("Erro ao iniciar TCP.");
        }

    }
}