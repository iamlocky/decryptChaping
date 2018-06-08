

public class Main {
    /**
     * locky luo
     * 2018.6.8
     */
    public static void main(String[] args) {
        String encrypted = "476865786A776B687A72756F677A6C776B466B64736C716A24";
        decryptCaesar(hex2Decimal(encrypted), null);
    }

    public static int[] hex2Decimal(String encrypted) {
        int[] encryptAscii = new int[encrypted.length() / 2];
        for (int i = 0; i <= encrypted.length() - 2; i++) {
            if (i % 2 == 0) {
                encryptAscii[i / 2] = Integer.parseInt(encrypted.substring(i, i + 2), 16);
            }
        }
        return encryptAscii;
    }

    public static void decryptCaesar(int[] encryptAscii, Integer key) {
        char[] result = new char[encryptAscii.length];
        if (key == null) {//无位移密码，暴力破解
            for (int i = 32; i < 127; i++) {
                boolean flag = true;
                for (int j = 0; j < encryptAscii.length && flag; j++) {
                    int move = (encryptAscii[j] + i);
                    move = move % 127;
                    if (move < 33 || move > 126) {
                        flag = false;
                        continue;
                    }
                    result[j] = (char) move;
                }
                if (flag) {
                    print(new String(result));
                }
            }
        } else {
            for (int j = 0; j < encryptAscii.length; j++) {
                int move = (encryptAscii[j] + key);
                move = move % 127;
                result[j] = (char) move;
            }
            print(new String(result));
        }
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
