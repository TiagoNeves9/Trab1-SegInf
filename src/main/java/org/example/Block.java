package org.example;

public class Block {
    private Transaction transaction;
    private String hash;

    public Block(Transaction transaction){
        this.transaction = transaction;
        this.hash = "0x0";
    }

    public Block (Transaction transaction, String hash){
        this.transaction = transaction;
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
