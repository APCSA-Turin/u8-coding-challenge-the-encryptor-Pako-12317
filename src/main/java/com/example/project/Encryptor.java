package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen == 0) {
            return 1;
        }else{
            int i = 0;
            while(rows*i<messageLen){
                i++;
            }
            return i;
        }
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        return new String [rows][determineColumns(message.length(), rows)];
    }

    public static String encryptMessage(String message, int rows){
        return "";
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        return "";
    }
}