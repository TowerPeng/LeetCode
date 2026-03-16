package com.towerpeng.concept.situation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 1G文件中查询某个无符号整型
 *
 * @Author: 彭涛
 * @Date: 2026/3/16 9:27
 */
public class FindUnsignedIntegerByBuffer {

    public static boolean isExist(String filePath,int target) throws IOException {
        try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(filePath))){
            byte [] buffer = new byte[512*1024*1024];
            int byteRead;
            while((byteRead = br.read(buffer)) != -1){
                for (int i = 0; i < byteRead; i+=4) {
                    int num = (buffer[i] & 0xff)|
                            (buffer[i+1] & 0xff)<<8|
                            (buffer[i+2] & 0xff)<<16|
                            (buffer[i+3] & 0xff)<<24;
                    if(num==target){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isExist("D:\\test.txt", 1));
    }
}
