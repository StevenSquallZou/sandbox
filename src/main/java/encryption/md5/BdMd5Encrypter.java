package encryption.md5;


import lombok.extern.slf4j.Slf4j;


/**
 * Works for small file
 * May NOT work for big file
 */
@Slf4j
public class BdMd5Encrypter {

    public static void main(String[] args) {
        String realMd5 = "3C5AD62FEA3F15D03ADB36BC1EEB7EC4"; // eb1c50b7blf11bc01fc83ba3b370fb53
//        String realMd5 = "9938F4BD59AC51C754EB0CDCFD08429A"; // 588f14a01g933952fc2b07fddd40c133
//        String realMd5 = "16E38EF86ED38EF0EF44A83C3393C3C3"; // 6ff0cb979v48431732b086a466ef65d3

        String encMd5 = encryptMd5(realMd5);

        log.info("Result: {}", encMd5);
    }


    public static String encryptMd5(String realMd5) {
        String temp = realMd5.substring(8, 16) + realMd5.substring(0, 8) + realMd5.substring(24, 32) + realMd5.substring(16, 24);
        StringBuilder res = new StringBuilder();
        char[] chars = temp.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            res.append(Integer.toHexString(Character.digit(c, 16) ^ 15 & i));
        }

        res.replace(9, 10, "" + (char) (Character.digit(res.charAt(9), 16) + 'g'));

        return res.toString();
    }

}
