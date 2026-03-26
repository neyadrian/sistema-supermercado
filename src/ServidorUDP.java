import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ServidorUDP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o produto (UDP): ");
        String produto = sc.nextLine();

        try (DatagramSocket clienteSocket = new DatagramSocket()) {
            clienteSocket.setSoTimeout(2000);

            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = produto.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 12001);
            clienteSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clienteSocket.receive(receivePacket);
            String resposta = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Preço: " + resposta);

        } catch (SocketTimeoutException e) {
            System.out.println("Resposta não recebida.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
