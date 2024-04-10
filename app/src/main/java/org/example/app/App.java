package org.example.app;

import org.example.lib.Builder;

public class App {
    public static void main(String[] args) {
        var builder = new Builder();
        builder.executorService();
        System.out.println("Everything is fine ✅");
    }
}
