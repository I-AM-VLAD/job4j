package ru.job4j.chapter_006.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    boolean flagExit = false;
                    boolean flagHello = false;
                    boolean flagAny = false;
                    while (!(str = in.readLine()).isEmpty()) {
                        if(str.contains("Exit")) {
                            flagExit = true;
                        }
                        if(str.contains("Hello")) {
                            flagHello = true;
                        }
                        if(!flagHello && !flagExit) {
                            flagAny = true;
                        }
                        System.out.println(str);
                    }
                    if(flagExit) {
                        out.write("HTTP/1.1 200 Завершить работу сервера\r\n\r\n".getBytes("Windows-1251"));
                        out.write("Завершить работу сервера".getBytes());
                        break;
                    }
                    if(flagHello) {
                        out.write("HTTP/1.1 200 Hello\r\n\r\n".getBytes());
                        out.write("Hello".getBytes());
                    }
                    if(flagAny) {
                        out.write("HTTP/1.1 200 Any\r\n\r\n".getBytes());
                        out.write("Any".getBytes());
                    }
                }

            }
        } catch(Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
