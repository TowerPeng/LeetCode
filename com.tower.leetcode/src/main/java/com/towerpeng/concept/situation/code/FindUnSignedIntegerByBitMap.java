package com.towerpeng.concept.situation.code;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: 彭涛
 * @Date: 2026/3/16 9:35
 */
public class FindUnSignedIntegerByBitMap {

    private static final int BIT_MAP_SIZE = 1<<29;

    private final byte[] bitmap = new byte[BIT_MAP_SIZE];

    public void build(String filePath) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))){
            byte[] buffer = new byte[4];
            while(bufferedInputStream.read(buffer) != -1){
                int num = (buffer[0] & 0xff)
                        | (buffer[1] & 0xff) << 8
                        | (buffer[2] & 0xff) << 16
                        | (buffer[3] & 0xff) << 24;
                int index = num/8;
                int offset = num%8;
                bitmap[index] |= (byte) (1 << offset);
            }
        }
    }

    public boolean query(int num){
        int index = num/8;
        int offset = num%8;
        return (bitmap[index] & (1 << offset)) != 0;
    }

    public static void main(String[] args) throws IOException {
        FindUnSignedIntegerByBitMap findUnSignedIntegerByBitMap = new FindUnSignedIntegerByBitMap();
        findUnSignedIntegerByBitMap.build("D:\\1G.txt");
        System.out.println(findUnSignedIntegerByBitMap.query(123456));
    }


}
