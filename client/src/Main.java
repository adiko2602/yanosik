import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        try {
            Socket clientSocket = new Socket("localhost", 1234);
            System.out.println("Client created on port: 1234");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.print("Enter user id: ");
            String userInput = userInputScanner.nextLine();

            out.println(userInput);
            String line;

            while((line = in.readLine()) != null) {
                System.out.println(line);
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}