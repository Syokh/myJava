package binary.tree.telnet;

import binary.tree.helper.ParserString;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Exchanger;
import binary.tree.task.ReadThread;
import binary.tree.task.WriteThread;

public class ClientWorker extends Thread {

    String rootPath;
    private final Socket socket;
    private final Logger logger = Logger.getLogger(ClientWorker.class.getName());


    public ClientWorker(final Socket socket, String rootPath) {
        this.socket = socket;
        this.rootPath = rootPath;
    }

    @Override
    public void run() {

        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Start Thread.activeCount() = " + Thread.activeCount());
            // display welcome screen
            out.println(" Welcome to Telnet Server");

            boolean cancel = false;

            while (!cancel) {

                final String command = reader.readLine();

                if (command == null) continue;

                String[] st = command.split(" ");
                if (st.length != 2) out.println("Wrong command");
                else {

                    try {
                        int depth = ParserString.getInt(st[0]);
                        String mask = st[1];

                        System.out.println("Start TaskMain");
                        Exchanger exchanger = new Exchanger();

                        ReadThread readThread = new ReadThread(mask, rootPath, depth, exchanger);
                        WriteThread writeThread = new WriteThread(depth, exchanger, out);

                        readThread.start();
                        writeThread.start();


                        System.out.println("Thread.activeCount() = " + Thread.activeCount());
                        out.println("Finish");

                    } catch (NumberFormatException e) {
                        out.println("First element Not Number");

                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to close the socket", e);

            }
        }
    }

}
