import java.math.*;
import java.util.*;
import java.util.Random;
import java.io.*;
import java.lang.*;
public class leaky_bucket{
public static void main(String args[]){
int drop=0,mini,i,orate,bsize,nsec,premain=0;
int packet[]= new int[100];
Scanner s=new Scanner(System.in);
System.out.println("enter the bucket size");
bsize=s.nextInt();
System.out.println("enter the output rate");
orate=s.nextInt();
System.out.println("enter the number of seconds to simulate");
nsec=s.nextInt();
Random rand=new Random();
for(i=0;i<nsec;i++)
packet[i]=(rand.nextInt(1000));
System.out.println("seconds | packets recieved | packets sent | packets left | packets dropped");
System.out.println("----------------------------------------------------------------------------");
for(i=0;i<nsec;i++){
premain+=packet[i];
if(premain>bsize){
drop=premain-bsize;
premain=bsize;
System.out.print(i+1+" \t\t");
System.out.print(packet[i]+" \t\t");
mini=Math.min(premain,orate);
System.out.print(mini+" \t\t");
premain=premain-mini;
System.out.print(premain+" \t\t");
System.out.print(drop+" \t\t");
System.out.println(" \t\t");
drop=0;
}
}
while(premain!=0){
if(premain>bsize){
drop=premain-bsize;
}
mini=Math.min(premain,orate);
System.out.print(" \t\t"+premain+" \t\t"+mini);
premain=premain-mini;
System.out.println(" \t\t"+premain+" \t\t"+drop);
drop=0;
}
}
}
