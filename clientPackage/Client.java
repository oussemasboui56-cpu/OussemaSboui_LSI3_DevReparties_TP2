package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Opération: ");
        String operation = sc.nextLine();
        
        // Envoyer l'opération
        pw.println(operation);
        
        // Recevoir le résultat
        String resultat = br.readLine();
        System.out.println("Résultat: " + resultat);
        
        socket.close();
        sc.close();
    }
}
