package com.vortex.test.udp;

import com.vortex.test.udp.client.UdpClient;
import com.vortex.test.udp.server.UdpServer;

import java.net.SocketException;

public class EntryPoint {

    public static void main(String[] args) throws
                                           SocketException {
        new Thread(new LoopBackForwarder()).start();
    }
}
