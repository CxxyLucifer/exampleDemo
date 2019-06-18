package org.cxxy;

import static org.junit.Assert.*;

import org.cxxy.util.RSACoder;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * 甲方构建密钥对儿，将公钥公布给乙方，将私钥保留。
 * 甲方使用私钥加密数据，然后用私钥对加密后的数据签名，发送给乙方签名以及加密后的数据；乙方使用公钥、签名来验证待解密数据是否有效，如果有效使用公钥对数据解密。
 * 乙方使用公钥加密数据，向甲方发送经过加密后的数据；甲方获得加密数据，通过私钥解密。
 */
public class RSACoderTest {
    private String publicKey;
    private String privateKey;

    @Before
    public void setUp() throws Exception {
        Map<String, Object> keyMap = RSACoder.initKey();

        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);

        System.err.println("公钥: " + publicKey);
        System.err.println("私钥: " + privateKey);
    }

    @Test
    public void test() throws Exception {

        System.err.println("公钥加密——私钥解密");

        String inputStr = "abc";

        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);

        String outputStr = new String(decodedData);

        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

        assertEquals(inputStr, outputStr);

    }

    @Test
    public void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");

        String inputStr = "sign";

        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);

        System.out.println(new String(encodedData));

        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);

        String outputStr = new String(decodedData);

        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

        assertEquals(inputStr, outputStr);

        System.err.println("私钥签名——公钥验证签名");

        // 产生签名
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);

        // 验证签名
        boolean status = RSACoder.verify(encodedData, publicKey, sign);

        System.err.println("状态:\r" + status);

        assertTrue(status);

    }

}
