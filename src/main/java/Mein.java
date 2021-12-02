import com.sun.jdi.Value;

public class Mein {
    public static void main(String[] args) {
        String s1 = "Васе 0x00000010 лет";
        char[] s2 = s1.toCharArray();
        for(int i = 0; i< s2.length; i++){
            if( s2[i] == '0' && s2[i+1] == 'x'){
                StringBuilder ss = null;
                System.out.println("find");



            }
        }

    }
}
