package middleware_ServidorCent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.clientes;
import static middleware_ServidorCent.Aplicacion_Middleware_ServidorCent.contadorClientes;

public class Mythread_ClienteCent implements Runnable {

    BufferedReader in;
    String direccionServidorEsc;
    int puertoClientes;
    //String direccion;
    public Mythread_ClienteCent(int puertoClientes) {
        this.puertoClientes = puertoClientes;
        //this.direccion = direccion;
    }

    @Override
    public void run() {

        
        try {
            Socket cliente = new Socket("172.31.103.92",puertoClientes);

            while (true) {

                BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String inputLine="";
                String outLine="";
                //System.out.println("CLIENTES CONECTADOS");
                while(true){
                outLine =  stdIn.readLine();
                out.println(outLine);
                }
                
                
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
