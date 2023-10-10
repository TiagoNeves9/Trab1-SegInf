package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private List<Block> chain;

    public BlockChain() {
        this.chain = new ArrayList<>();
        Transaction genesisTransaction = new Transaction();
        Block genesisBlock = new Block(genesisTransaction);
        chain.add(genesisBlock);
    }

    public void addBlock(Block block) {
        chain.add(block);
    }

    public List<Block> getBlocks() {
        return chain;
    }

    public Block getPreviousBlock() {
        return chain.get(chain.size() - 1);
    }
/*
file vai ser tipo varias linhas disto <origem>,<destino>,<valor>,<hash>
cada linha representa um bloco
no 6.1 temos apenas de ir buscar a ultima linha calcular o hash desse bloco
para depois adicionar o novo bloco com as info recebida e o hash
 */
    public void loadFromFile(String filename) {
        BlockChain chain = new BlockChain();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int origem = Integer.parseInt(parts[0]);
                    int destino = Integer.parseInt(parts[1]);
                    float valorOperacao = Float.parseFloat(parts[2]);
                    Transaction transaction = new Transaction(origem, destino, valorOperacao);
                    String hash = parts[3];

                    String newHash = null;
                    try {
                        newHash = HashDemo.calculateHash(chain.getPreviousBlock().toString());
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    Block block = new Block(transaction, newHash);

                    chain.addBlock(block);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
