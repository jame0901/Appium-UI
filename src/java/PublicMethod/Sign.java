package PublicMethod;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Sign {

    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";

    //以下三个密钥为仿真环境加密密钥，线上加密密钥需要申请
    private static final String usEncryptKey = "ccq0PWac";

    private static final String usAccessKey = "6ZD7qAEq";

    private static final String usAppId = "LBRU1P8T4CC";

    private final static byte[] ivs = { 1, 5, 'd', 'f', 'r', 'h', 't', 'v' };

    /**
     * DES算法，加密
     *
     * @param data
     *            待加密字符串
     * @param key
     *            加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     *             异常
     */
    public static String encode(String key, String data) throws Exception {
        return new String(encode(key, data.getBytes()));
    }

    /**
     * DES算法，加密
     *
     * @param data
     *            待加密字符串
     * @param key
     *            加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     *             异常
     */
    public static byte[] encode(String key, byte[] data) throws Exception {
        try {
            byte[] md5Key = md5GeneralKey(key.getBytes());

            DESKeySpec dks = new DESKeySpec(md5Key);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(ivs);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            byte[] bytes = cipher.doFinal(data);

            return Base64.encodeBase64(bytes);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * DES算法，解密
     *
     * @param data
     *            待解密字符串
     * @param key
     *            解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception
     *             异常
     */
    public static byte[] decode(String key, byte[] data) throws Exception {
        try {
            byte[] md5Key = md5GeneralKey(key.getBytes());
            DESKeySpec dks = new DESKeySpec(md5Key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(ivs);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 获取编码后的值
     *
     * @param key
     * @param data
     * @return
     * @throws Exception
     */
    public static String decodeValue(String key, String data) {
        byte[] datas;
        String value = null;
        try {
            if (System.getProperty("os.name") != null
                    && (System.getProperty("os.name").equalsIgnoreCase("sunos") || System
                    .getProperty("os.name").equalsIgnoreCase("linux"))) {
                datas = decode(key, Base64.decodeBase64(data));
            } else {
                datas = decode(key, Base64.decodeBase64(data));
            }

            value = new String(datas);
        } catch (Exception e) {
            value = "";
        }
        return value;
    }

    public static byte[] md5GeneralKey(byte[] password) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }

        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32-md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code.getBytes();
    }

    //参数加密
    public static String Encryption(String content , String env) {
        try {
            if (env.equals("仿真")){

                content = Sign.encode(usEncryptKey, content);

            }else if (env.equals("线上")){

            }else {
                System.out.println("不存在的环境");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //sign生成方式方法
    public static String generateSign(Map<String, String> params , String env) {
        Collection<String> keyset= params.keySet();
        List<String> paramKeyList = new ArrayList <String>(keyset);
        Collections.sort(paramKeyList);
        StringBuilder paramValueBuilder = new StringBuilder();
        for(int i=0; i<paramKeyList.size(); i++){
            paramValueBuilder.append( params.get(paramKeyList.get(i)) );
        }
        if (env.equals("仿真")){

            paramValueBuilder.append(usAccessKey);

        }else if (env.equals("线上")){

        }else {
            System.out.println("不存在的环境");
        }
        String sign = Sign.MD5(paramValueBuilder.toString()).toLowerCase();
        return sign;
    }
}
