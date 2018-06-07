public class Main {
    /**
     * locky luo
     * 2018.6.8
     */
    public static void main(String[] args) {
        String encrypt="476865786A776B687A72756F677A6C776B466B64736C716A24";

        int[] encryptAscii=new int[encrypt.length()/2];
        for (int i = 0; i <=encrypt.length()-2 ; i++) {
            if (i%2==0){
                encryptAscii[i/2]=(char) Integer.parseInt(encrypt.substring(i,i+2),16);
            }
        }

        char[] result=new char[encrypt.length()];
        for (int i = 0; i <127 ; i++) {
            for (int j = 0; j <encryptAscii.length ; j++) {
                for (int k = 0; k <127 ; k++) {
                    if (encryptAscii[j]==k){
                        int move=(k+i);
                        move=move<0?(127+move):move;
                        move=move>127?(move-127):move;
                        result[j]=(char)move;
                    }
                }
            }
            print(new String(result));
        }

    }

    public static void print(Object o){
        System.out.println(o);
    }
}
