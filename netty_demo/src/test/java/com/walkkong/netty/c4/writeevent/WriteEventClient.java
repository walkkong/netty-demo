package com.walkkong.netty.c4.writeevent;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liyanan
 * @date 2022/06/02 20:38
 **/
@Slf4j
public class WriteEventClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8080));
        int readCount = 0;
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
            readCount += sc.read(byteBuffer);
            byteBuffer.clear();
            log.info("{}", readCount);
        }
    }
}
