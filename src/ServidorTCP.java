import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public void iniciar(int porta) throws IOException {

        ObjectOutputStream saida;
        ObjectInputStream entrada;
        boolean sair = false;
        String alimento = "";

        try {
            ServerSocket servidor = new ServerSocket(12000);
            Socket conexao;
            while (!sair) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                saida = new ObjectOutputStream(conexao.getOutputStream());
                entrada = new ObjectInputStream(conexao.getInputStream());

                saida.writeObject("Conexão estabelecida!");

                do {
                    try {
                        alimento = (String) entrada.readObject();
                    }

                } while (!alimento.equals("sair"));
            }
        }

    }
}