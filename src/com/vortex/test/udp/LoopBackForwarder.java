package com.vortex.test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class LoopBackForwarder implements Runnable {

    private final DatagramSocket listener = new DatagramSocket(6663);
    private final DatagramSocket forwarder = new DatagramSocket(1234);

    public LoopBackForwarder() throws
                               SocketException {
    }


    @Override
    public void run() {

        byte[] message = new byte[1024];
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(message, message.length);
                listener.receive(packet);
                System.out.println("Received: " + new String(message));
                DatagramPacket packetToSend = new DatagramPacket(packet.getData(), packet.getData().length, InetAddress.getByName("127.0.0.1"), 1337);
                forwarder.send(packetToSend);
                System.out.println("Sent: " + new String(message));
            } catch (Exception ex) {
                //ignored;
            }
        }

    }
}
