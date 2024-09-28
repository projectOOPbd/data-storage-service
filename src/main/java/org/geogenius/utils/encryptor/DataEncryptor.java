package org.geogenius.utils.encryptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DataEncryptor {

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    public static String encrypt(String data) {
        return encoder.encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(String data) throws IllegalArgumentException {
        return new String(decoder.decode(data), StandardCharsets.UTF_8);
    }
}
