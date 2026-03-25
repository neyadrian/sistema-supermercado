import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp {
    public static void main(String[] args) throws IOException {

        String alimento;
        double preco = 8.10;

        try {
            ServerSocket servidor = new ServerSocket(12000);

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                System.out.println("Alimento: ");

            }
        }

    }
}