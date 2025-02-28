package com.payby.terminal.demo.utils;

/**
 * Created by benxer on 2019/10/3.
 */

import android.content.Context;
import android.util.Log;

import com.bitphare.utility.sign.oa.KeyReader;
import com.payby.terminal.demo.store.RSACache;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Enumeration;


public class SignUtil {

    private static final String CHARSET_ENCODING = "UTF-8";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    private static final char[] DIGITS_LOWER;
    private static final char[] DIGITS_UPPER;

    static {
        DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }


    /**
     * 签名
     * @param srcData
     * @param key
     * @return
     */
    public static String sign(String srcData, PrivateKey key){
        if(null == srcData || null == key){
            return "";
        }
        return signToHex(srcData, key);
    }

    private static String signToHex(String srcData, PrivateKey key) {
        // 进行签名服务
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(key);
            signature.update(srcData.getBytes(CHARSET_ENCODING));
            byte[] signedData = signature.sign();
            return encodeHexString(signedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static PrivateKey readPrivatePath(Context context, String privateKeyPath) {
        if (null == context || null == privateKeyPath) {
            return null;
        }
        try {
            InputStream stream = context.getAssets().open(privateKeyPath);
            String keyPairPem = IOUtils.toString(stream, StandardCharsets.US_ASCII);
            Pair<PrivateKey, PublicKey> keyPair = KeyReader.readKeyPair(keyPairPem);
            return keyPair.getLeft();
        } catch (IOException var3) {
            throw new ContextedRuntimeException(var3);
        }
    }

    public static PublicKey readPublicPath(Context context, String privateKeyPath) {
        if (null == context || null == privateKeyPath) {
            return null;
        }
        try {
            InputStream stream = context.getAssets().open(privateKeyPath);
            String keyPairPem = IOUtils.toString(stream, StandardCharsets.US_ASCII);
            Pair<PrivateKey, PublicKey> keyPair = KeyReader.readKeyPair(keyPairPem);
            return keyPair.getRight();
        } catch (IOException var3) {
            throw new ContextedRuntimeException(var3);
        }
    }

    public static PrivateKey readPrivate(String privateKey) {
        if (null == privateKey) {
            return null;
        }
        Pair<PrivateKey, PublicKey> keyPair = KeyReader.readKeyPair(privateKey);
        return keyPair.getLeft();
    }

    public static PublicKey readPubkey(String pukey){
        if (null == pukey) {
            return null;
        }
        Pair<PrivateKey, PublicKey> keyPair = KeyReader.readKeyPair(pukey);
        return keyPair.getRight();
    }

    public static String encodeHexString(byte[] data) {
        return new String(encodeHex(data));
    }

    private static char[] encodeHex(byte[] data) {
        return encodeHex(data, true);
    }

    private static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    private static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for(int var5 = 0; i < l; ++i) {
            out[var5++] = toDigits[(240 & data[i]) >>> 4];
            out[var5++] = toDigits[15 & data[i]];
        }

        return out;
    }

    /**
     * 读取私钥
     * @param
     * @return
     */
    private static PrivateKey readPrivate(Context context, String privateKeyPath, String privateKeyPwd){
        if(null == context || null == privateKeyPath || null == privateKeyPwd){
            return null;
        }
        InputStream stream = null;
        try {
            // 获取JKS 服务器私有证书的私钥，取得标准的JKS的 KeyStore实例
            KeyStore store = KeyStore.getInstance("JKS");
            stream = context.getAssets().open(privateKeyPath);
            // jks文件密码，根据实际情况修改
            store.load(stream, privateKeyPwd.toCharArray());
            // 获取jks证书别名
            Enumeration en = store.aliases();
            String pName = null;
            while (en.hasMoreElements()) {
                String n = (String) en.nextElement();
                if (store.isKeyEntry(n)) {
                    pName = n;
                }
            }
            // 获取证书的私钥
            PrivateKey key = (PrivateKey) store.getKey(pName,
                    privateKeyPwd.toCharArray());
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stream != null){
                try {
                    stream.close();
                } catch (IOException e) {}
            }
        }
        return null;
    }

    public static String signature(String srcData) {
        if(null == srcData){
            return "";
        }
        String privateKey = RSACache.getPrivateKey();
        if(null == privateKey){
            return "";
        }
        return sign(srcData, readPrivate(privateKey));
    }
}

