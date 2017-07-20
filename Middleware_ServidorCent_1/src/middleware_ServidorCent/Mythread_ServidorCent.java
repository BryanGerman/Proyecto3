package middleware_ServidorCent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.clientes;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.contadorClientes;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.contadorServidores;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.servidores;

/**
 *
 * @author Bryan German
 */
public class Mythread_ServidorCent implements Runnable {

    int puertoServidores;

    public Mythread_ServidorCent(int puertoServidores) {
        this.puertoServidores = puertoServidores;

    }

    @Override
    public void run() {
        while (true) {
            try {
                ServerSocket socketServidores = new ServerSocket(puertoServidores);
                while (true) {
                    
                    String inputLine = "";
                    Socket servidorEsclavo = socketServidores.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(servidorEsclavo.getInputStream()));
                    PrintWriter out = new PrintWriter(servidorEsclavo.getOutputStream(), true);
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("SERVIDORES CONECTADOS");
                    contadorServidores++;
                    servidores.add(servidorEsclavo.getInetAddress());
                    System.out.println(servidores.toString());
                    inputLine = in.readLine();
                    System.out.println(inputLine);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
