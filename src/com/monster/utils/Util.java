package utils;

public class Util {
    
    public static void print(Object... words) {
        String content = "";
        for (int i = 0; i < words.length; i++) {
            content = content + words[i].toString() + " ";
        }
        System.out.println(content);
    }

    public String wrap(Object... words) {
        String sum = "";
        for (int i = 0; i < words.length; i++) {
            sum = words[i].toString();
        }
        return sum;
    }
}