package com.payby.terminal.demo.utils;



import com.payby.terminal.demo.store.RSACache;

import  org.apache.commons.lang3.tuple.Pair;
import io.bitexpress.openapi.client.sign.sc.KeyMakerScImpl;

public class RSAManager {
    private RSAManager() {}

    public static void generateRSAKeys () {
        try {
            KeyMakerScImpl keyMakerSc = new KeyMakerScImpl();
            Pair<String, String> keyPair = keyMakerSc.makePemPair();
            String privateKey  = keyPair.getLeft();
            String publicKey = keyPair.getRight();
            System.out.println("public key: " + publicKey);
            System.out.println("private key: " + privateKey);
            RSACache.saveRSAKeys(publicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
