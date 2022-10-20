package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {

  public static final int PORT_NUMBER = 6013;

  public static void main(String[] args) {
    try {

      ServerSocket sock = new ServerSocket(PORT_NUMBER);

      //Wait for a client to create a connection
      while (true) {
        Socket client = sock.accept();

        InputStream inStream = client.getInputStream();
        OutputStream outStream = client.getOutputStream();

        //Reads from the input stream to the output,
        //stopping when the stream finishes
        inStream.transferTo(outStream);

        //Finish up by closing the connections
        inStream.close();
        outStream.flush(); //Forcibly empties the internal buffer
        outStream.close();
        client.close();

      }

    } catch(IOException ioe) {
      System.out.println("Caught the following exception: ");
      System.out.println(ioe);
    }

    System.out.println("Server Works!");
  }
}
