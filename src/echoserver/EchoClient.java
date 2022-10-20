package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {

  public static final int PORT_NUMBER = 6013;

  public static void main(String[] args) {

    String hostname;

    if (args.length == 0) {
      hostname = "127.0.0.1";
    } else {
      hostname = args[0];
    }

    //Create a connection between the client and the specified server
    try {
      Socket socket = new Socket(hostname, PORT_NUMBER);


      InputStream inStream = socket.getInputStream();
      OutputStream outStream = socket.getOutputStream();

      int nextByte;
      //Continually process bytes from the input stream until EOF
      //EOF is represented as -1
      while ((nextByte = System.in.read()) != -1) {
        outStream.write(nextByte);
        System.out.write(inStream.read());
      }

      //Final cleanup
      inStream.close();
      outStream.flush();
      socket.shutdownOutput();

    } catch (ConnectException ce) {
      System.out.println("We were unable to connect to server " + hostname);
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception!");
      System.out.println(ioe);
    }
  }

}
