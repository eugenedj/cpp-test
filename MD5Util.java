import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    private static String salt ="hellokitty";

    public static String string2MD5(String inStr) {
        return string2MD5(inStr, 32);
    }

    /**
     * @param length 加密后长度, 当前仅支持16, 32
     */
    private static String string2MD5WithSalt(String inStr, String salt, int length) {
        String value = inStr + salt;
        String hexValue = DigestUtils.sha256Hex(value);
        return length == 32 ? hexValue : hexValue.substring(8, 24);
    }
    /**
     * @param length 加密后长度, 当前仅支持16, 32
     */
    public static String string2MD5(String inStr, int length) {
        return string2MD5WithSalt(inStr, salt, length);
    }


}
