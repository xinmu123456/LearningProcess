package com.IOTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NIOTest {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 1234));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean flag = false;
        while (true) {

            if (selector.select() == 0)
                continue;

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey key : selectionKeys) {

                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel) (key.channel())).accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端链接: " + socketChannel.getRemoteAddress());
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()){

                    SocketChannel channel = (SocketChannel) (key.channel());
                    buffer.clear();
                    if (channel.read(buffer) <= 0) {
                        continue;
                    }
                    buffer.flip();
                    byte[] bytes = new byte[buffer.limit()];
                    buffer.get(bytes);
                    System.out.println(channel.getRemoteAddress() + "数据来了" + new String(bytes));
                    buffer.clear();
                    buffer.put((new String(bytes) + "\n").getBytes());
                    buffer.flip();
                    channel.write(buffer);
                }

            }
            selectionKeys.clear();
        }



    }

}
