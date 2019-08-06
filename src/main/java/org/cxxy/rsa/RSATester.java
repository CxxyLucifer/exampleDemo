package org.cxxy.rsa;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;



/**
 * 甲方构建密钥对儿，将公钥公布给乙方，将私钥保留。
 * 甲方使用私钥加密数据，然后用私钥对加密后的数据签名，发送给乙方签名以及加密后的数据；乙方使用公钥、签名来验证待解密数据是否有效，如果有效使用公钥对数据解密。
 * 乙方使用公钥加密数据，向甲方发送经过加密后的数据；甲方获得加密数据，通过私钥解密。
 */
public class RSATester {
    private String publicKey;
    private String privateKey;

    @Before
    public void setUp() throws Exception {
        Map<String, Object> keyMap=RSAUtil.genKeyPair();

        publicKey = RSAUtil.getPublicKey(keyMap);
        privateKey = RSAUtil.getPrivateKey(keyMap);

        System.err.println("====== 公钥:\t" + publicKey);
        System.err.println("====== 私钥:\t" + privateKey);
    }


    @Test
    public void test() throws Exception {
        System.err.println("公钥加密——>私钥解密");

        String txt = "aijia123456";

        byte[] encryptTxt = RSAUtil.encryptByPublicKey(txt.getBytes(),publicKey);

        System.out.println("=========== encryptTxt:\t" + ToStringUtils.toHexString(encryptTxt));

        byte[] decryptTxt = RSAUtil.decryptByPrivateKey(encryptTxt,privateKey);

        System.out.println("=========== decryptTxt:\t" + new String(decryptTxt));

    }

    @Test
    public void testSign() throws Exception {
        System.err.println("私钥加密——>公钥解密");

        String txt = "我爱我的祖国，我爱我的家";

        byte[] encryptTxt = RSAUtil.encryptByPrivateKey(txt.getBytes(),privateKey);

        System.out.println("=========== encryptTxt:\t" + ToStringUtils.toHexString(encryptTxt));

        byte[] decryptTxt = RSAUtil.decryptByPublicKey(encryptTxt,publicKey);

        System.out.println("=========== decryptTxt:\t" + new String(decryptTxt));

        //使用私钥对加密后的数据进行签名
        String signedData = RSAUtil.sign(encryptTxt,privateKey);

        System.out.println("========== singedData:\t" + signedData);

        boolean status = RSAUtil.verify(encryptTxt,publicKey,signedData);

        System.out.println("状态:\r" + status);
    }
}
