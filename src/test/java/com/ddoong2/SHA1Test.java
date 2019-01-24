package com.ddoong2;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SHA1Test {

    @Test
    public void test_이름이_다르지만_내용이_같으면_SHA1_결과는_같다() throws IOException, NoSuchAlgorithmException {
        String content1;
        String content2;

        try (InputStream test1 = ClassLoader.getSystemResourceAsStream("same/test1.txt");
             InputStream test2 = ClassLoader.getSystemResourceAsStream("same/test2.txt")) {

            content1 = SHA1.encryptSHA1(test1);
            content2 = SHA1.encryptSHA1(test2);
        }

        assertEquals(content1, content2);
    }

    @Test
    public void test_이름은_같지만_내용이_같다면_SHA1_결과는_다르다() throws IOException, NoSuchAlgorithmException {
        String content1;
        String content2;

        try (InputStream test1 = ClassLoader.getSystemResourceAsStream("same/test1.txt");
             InputStream test2 = ClassLoader.getSystemResourceAsStream("diff/test1.txt")) {

            content1 = SHA1.encryptSHA1(test1);
            content2 = SHA1.encryptSHA1(test2);
        }

        assertNotEquals(content1, content2);
    }
}