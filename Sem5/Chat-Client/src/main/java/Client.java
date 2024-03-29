//2024.03.29
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private String name;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public Client(String address, int port){
        try {
            System.out.format("Open %s :%d ...%n", address, port);
            socket = new Socket(address, port);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input your name: ");
            sendMessage(name = scanner.nextLine());
            listenForMessagesFromServer();

        } catch (IOException e) {
        } finally {
            closeEverything();
        }
    }

    public void sendMessage(String message) throws IOException{
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void listenForMessagesFromServer() throws IOException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromServer;
                while(socket.isConnected()){
                    try {
                        messageFromServer = bufferedReader.readLine();
                        System.out.println(messageFromServer);
                    } catch (IOException e) {
                        closeEverything();
                    }
                }
            }
        }).start();
    }

    public void listenForMessagesFromClient() throws IOException{
        Scanner scanner = new Scanner(System.in);
        String messagesToServer;
        while (socket.isConnected()){
            messagesToServer = scanner.nextLine();
            if(messagesToServer == null
                || messagesToServer == ""
                || messagesToServer == "\n"
                || messagesToServer == "\r"
                || messagesToServer == "\n\r") closeEverything();

            sendMessage(messagesToServer);
        }
    }


    public void closeEverything(){
        System.out.println("Close everything...");
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
