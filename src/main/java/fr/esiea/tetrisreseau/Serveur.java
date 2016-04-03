package fr.esiea.tetrisreseau;


import java.io.IOException;
import java.net.ServerSocket;
import java.io.OutputStream;
import java.net.Socket;

public class Serveur
{
    private static String message = "Hello I'm a new player";
    private static int port;
    private static ServerSocket socket;

    public static void main(String[] args)
    {
        try
        {
            port   = (args.length == 1) ? Integer.parseInt(args[0]) : 8080;
            socket = new ServerSocket(port);

            while (true)
            {
                Socket client       = socket.accept();
                OutputStream output = client.getOutputStream();

                output.write(message.getBytes());
                client.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}