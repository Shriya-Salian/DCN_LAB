import java.io.*;
import java.net.*;
class udpcli{
    public static void main(String args[])throws Exception{
    BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
    DatagramSocket clientSocket = new DatagramSocket();
    InetAddress IPaddress = InetAddress.getByName("localhost");
    byte[] sendData  = new byte[1024];
    byte[] recieveData = new byte[1024];
    String sentence = "hello server";
    sendData = sentence.getBytes();
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPaddress, 9876);
    clientSocket.send(sendPacket);
    DatagramPacket recievePacket= new DatagramPacket(recieveData,recieveData.length);
    clientSocket.receive(recievePacket);
    String modifiedsentence = new String(recievePacket.getData());
    System.out.println("FROM SERVER");
    System.out.println(modifiedsentence);
    clientSocket.close();
    }
    }
