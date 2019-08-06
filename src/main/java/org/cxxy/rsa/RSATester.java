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

        System.out.println("=========== encryptTxt:\t" + ToStringUtil.toHexString(encryptTxt));

        byte[] decryptTxt = RSAUtil.decryptByPrivateKey(encryptTxt,privateKey);

        System.out.println("=========== decryptTxt:\t" + new String(decryptTxt));

    }

    @Test
    public void testSign() throws Exception {
        System.err.println("私钥加密——>公钥解密");

        String txt = "我爱我的祖国，我爱我的家";

        byte[] encryptTxt = RSAUtil.encryptByPrivateKey(txt.getBytes(),privateKey);

        System.out.println("=========== encryptTxt:\t" + ToStringUtil.toHexString(encryptTxt));

        byte[] decryptTxt = RSAUtil.decryptByPublicKey(encryptTxt,publicKey);

        System.out.println("=========== decryptTxt:\t" + new String(decryptTxt));

        //使用私钥对加密后的数据进行签名
        String signedData = RSAUtil.sign(encryptTxt,privateKey);

        System.out.println("========== singedData:\t" + signedData);

        boolean status = RSAUtil.verify(encryptTxt,publicKey,signedData);

        System.out.println("状态:\r" + status);
    }


    public static void main(String[] args) throws Exception {
        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFhCMuoQt54NAan0cvaPZeiS6xGqXtDZaJ+xVlUNIBYpsy+oXpe2mlhTtLaAHJfNLF1tNyBYgHfO3FADC/1vvEha2+ZtbecisjJ1YCkF2TJYOKlPpucBaAN0Nb03IlqS0c0m9xOA/Lqh+IbRyGkM4Vq+pLPzibYibCvLladzFpDQIDAQAB";
        String priKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIWEIy6hC3ng0BqfRy9o9l6JLrEape0Nlon7FWVQ0gFimzL6hel7aaWFO0toAcl80sXW03IFiAd87cUAML/W+8SFrb5m1t5yKyMnVgKQXZMlg4qU+m5wFoA3Q1vTciWpLRzSb3E4D8uqH4htHIaQzhWr6ks/OJtiJsK8uVp3MWkNAgMBAAECgYAgfgjF10FgtrpOUEbVndifJwlq5k5NA0qIZ8dMMb/5wFJ+tIMUUAlk06ibcENHEo6EwQQSMpBpKhj/IU270gjQ76fqbtu+TJWL+uq5Ivm7MWWylIoIbvyKoMbPfMRUsSNS/p3v8OMD5O/htGiA6kjdD+i7xx3hJOmoqa4I1DnTAQJBAL2UFIm2dmbhXrH+vroO4XrMevzJxrvewLxOvMLu8fcgjUhFTLK3x46233cDJi2PrU9h6c8rjL/OBa1W2BzikM0CQQC0S6U6hoV6BxDWobm4wmNZ5jQbah5izoG11xlZWwjY8NaVResTmyEk9n5rzIjO0n147jbXHvtsnEnjN4QZITlBAkBopKddiKD8kuQhXhtLOlGN5fbxODOBmihLCS86boiTP52cydvXPohhp2HcIJnfRlKE4egcWc6cRQ1vK+Ootgr1AkBESg6oT0GJSdnX4ePNlls5Ntdvts8Rj7RToshoLvH38ajlW1lB0NVKAc86l3sOE24Q+vFso8CJj9zwoht3xTzBAkBdQhAQOJZ16lbzqJU7lrP+aY/i7ZgCA8JyTd1VyHKm5alIWWd+P0t9oyOzZx2JIIx77OGhL5A8dnNaqss0KzQ9";


        String encryptTxt = "denDbDXcNIeGnLuKDkJHMfDRMiQZ7kwD13LtFOz%2B7sxStmmjrRNtqqHsOiSVemUZyOpW2k88r%2B8K5U5AWh7Lb6IPsmC/N9xhVJHeQ3%2BbwzXkWRH1xUC70eJKE15RakenBAnlGV0tVeRloTDtXpgOK9gWweGXnnrFdQoERwr/648=";
        encryptTxt = encryptTxt.replaceAll("%2B","+");


        byte[] decryptTxt = RSAUtil.decryptByPrivateKey(Base64Util.decode(encryptTxt),priKey);

        System.out.println("---------decryptTxt:\t" + new String(decryptTxt));
    }
}
