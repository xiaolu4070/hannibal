package com.hnb.demo.biz.nio.buffer;

import java.nio.Buffer;
import java.nio.CharBuffer;

/**
 * @author xiaolu
 * @date 2018/8/15 上午11:58
 */
public class BufferFillDrain {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return false;
        }
        String string = strings[index];
        index++;

        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        buffer.put(string);
        return true;
    }

    private static int index = 0;

    private static String[] strings = {
            "A random string value",
            "A pig",
            "What are you doing now?"
    };
}
