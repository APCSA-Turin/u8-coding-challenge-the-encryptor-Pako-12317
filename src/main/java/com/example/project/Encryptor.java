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
        String[][] messageArray = new String [rows][determineColumns(message.length(), rows)];
        int index = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < determineColumns(message.length(), rows); c++) {
                if (index < message.length()) {
                    messageArray[r][c] = message.charAt(index++) + "";
                } else {
                    messageArray[r][c] = "=";
                }
            }
        }

        return messageArray;
    }

    public static String encryptMessage(String message, int rows) {
        int len = message.length();
        int col = determineColumns(len, rows);
        String[][] messageList = generateEncryptArray(message, rows);


        String encryptedMessage = "";
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                encryptedMessage += messageList[j][i];
            }
        }


        return encryptedMessage;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int len = encryptedMessage.length();
        int col = determineColumns(len, rows);
        String[][] messageArray = new String[rows][col];
        int index = 0;

        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                if (index < len) {
                    messageArray[j][i] = encryptedMessage.charAt(index++) + "";
                } else {
                    messageArray[j][i] = "=";
                }
            }
        }

        String decryptedMessage = "";
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < col; c++) {
                if (!messageArray[r][c].equals("=")) {
                    decryptedMessage += messageArray[r][c];
                }
            }
        }

        return decryptedMessage;
    }
}