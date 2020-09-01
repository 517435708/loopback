package com.vortex.test.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpClient implements Runnable {

    private final DatagramSocket socket = new DatagramSocket(1337);

    public UdpClient() throws
                       SocketException {
    }

    @Override
    public void run() {

        byte[] message = new byte[1024];
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(message, message.length);
                socket.receive(packet);
                System.out.println(new String(message));
            } catch (Exception ex) {
                //ignored;
            }
        }

    }
}
