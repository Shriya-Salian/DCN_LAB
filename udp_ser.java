import java.io.*;
import java.net.*;

class udpser{
     public static void main(String args[]) throws Exception{
     DatagramSocket serversocket = new DatagramSocket(9876);
     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
     byte[] recieveData = new byte[1024];
     byte[] sendData =  new byte[1024];
     DatagramPacket recievePacket =new DatagramPacket(recieveData,recieveData.length);
     serversocket.receive(recievePacket);
     String sentence =new String(recievePacket.getData());
     System.out.println("RECIEVED");
     System.out.println(sentence);
     InetAddress IPaddress = recievePacket.getAddress();
     int Port = recievePacket.getPort();
     System.out.println("Enter the message");
     String Data = br.readLine();
     sendData =Data.getBytes();
     DatagramPacket sendPacket = new DatagramPacket ( sendData, sendData.length, IPaddress,Port);
     serversocket.send(sendPacket);
     serversocket.close(); 
     }
     }
