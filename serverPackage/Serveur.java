package serverPackage;
import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) throws IOException {
        
        ServerSocket socketServeur = new ServerSocket(1234);
        System.out.println("Serveur en attente...");
        
        Socket socket = socketServeur.accept();
        System.out.println("Client connecté");
        
        
        InputStream is = socket.getInputStream();
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        
        
        String operation = br.readLine();
        System.out.println("Opération reçue: " + operation);
        
        String resultat = calculer(operation);
        
        
        pw.println(resultat);
        
        
        socket.close();
        socketServeur.close();
    }
    
    private static String calculer(String operation) {
        try {
            String[] parties = operation.split(" ");
            double a = Double.parseDouble(parties[0]);
            String op = parties[1];
            double b = Double.parseDouble(parties[2]);
            
            if (op.equals("+")) return String.valueOf(a + b);
            if (op.equals("-")) return String.valueOf(a - b);
            if (op.equals("*")) return String.valueOf(a * b);
            if (op.equals("/")) return String.valueOf(a / b);
            
            return "Opérateur invalide";
        } catch (Exception e) {
            return "Erreur: " + e.getMessage();
        }
    }
}