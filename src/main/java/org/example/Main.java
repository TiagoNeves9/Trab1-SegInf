package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 5 || !args[0].equals("addblock")){
            String commands = "Please use the following method: <operation> <origin> <destiny> <value> <filename>";
            System.out.println(commands);
            System.exit(1);
        }

        String origin = args[1];
        String destiny = args[2];
        String value = args[3];
        String filename = args[4];

    }
}