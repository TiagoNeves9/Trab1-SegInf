package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 5 || !args[0].equals("addblock")){
            String commands = "Please use the following method: <operation> <origin> <destiny> <value> <filename>";
            System.out.println(commands);
            System.exit(1);
        }
        String filename = args[4];
        Block block = Block.getLastBlockFromFile(filename);
        try {
            Integer origin = Integer.parseInt(args[1]);
            Integer destiny = Integer.parseInt(args[2]);
            Float value = Float.parseFloat(args[3]);
            assert block != null;
            String hash = HashDemo.calculateHash(block.toString());
            Transaction transaction = new Transaction(origin, destiny, value);
            String newBlock = new Block(transaction, hash).toString();
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            writer.println(newBlock);
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}