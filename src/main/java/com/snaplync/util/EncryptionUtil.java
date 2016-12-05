/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.apache.commons.codec.digest.DigestUtils
 */
package com.snaplync.util;

import java.util.UUID;
import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtil {
    public static String getRandomString() {
        return UUID.randomUUID().toString();
    }

    public static String getEncryptedPassword(String password, String salt) {
        return DigestUtils.md5Hex((String)(password + salt));
    }

    public static boolean isPasswordValid(String passwordHash, String salt, String plainPassword) {
        if (DigestUtils.md5Hex((String)(plainPassword + salt)).equals(passwordHash)) {
            return true;
        }
        return false;
    }
}
