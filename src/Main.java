import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> produtos = new HashMap<>();
        produtos.put("ARROZ", "25.00");
        produtos.put("CAFE", "16.50");
        produtos.put("LEITE", "6.00");

        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(12000)) {
                System.out.println("Servidor TCP iniciado na porta 12000.");
                while (true) {
                    Socket clienteSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);

                    String produto = in.readLine();
                    String resposta = produtos.getOrDefault(produto.toUpperCase(), "Não encontrado.");
                    out.println(resposta);
                    clienteSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (DatagramSocket udpSocket = new DatagramSocket(12001)) {
                System.out.println("Servidor UDP iniciado na porta 12001.");
                byte[] buffer = new byte[1024];
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    udpSocket.receive(packet);

                    String produto = new String(packet.getData(), 0, packet.getLength()).trim();
                    String preco = produtos.getOrDefault(produto.toUpperCase(), "Não encontrado");

                    byte[] sendData = preco.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, packet.getAddress(), packet.getPort());
                    udpSocket.send(sendPacket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
