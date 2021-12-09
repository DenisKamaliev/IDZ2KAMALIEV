public class StringProcessor {
    public String doStringByN (int N, String s) throws IllegalArgumentException {
        StringBuilder s1 = new StringBuilder();
        if (N == 0) {
            return s1.toString();
        }
        if (N < 0){
            throw new IllegalArgumentException ("N can not been below zero");
        }
        s1.append(String.valueOf(s).repeat(N));
            return s1.toString();

    }
    public int stringInString (String s1, String s2) throws IllegalArgumentException {
        if (s1 == null || s1 == "" || s2 == null || s2 == ""){
            throw new IllegalArgumentException ("Ошибка, некорректные строки!");
        }
        return (s1.length() - s1.replace(s2, "").length()) / s2.length();
    }
    public  String buildString (String s){
        String string;
        string = (s.replace("1", "один"));
        string = (string.replace("2", "два"));
        string = (string.replace("3", "три"));
        return string;
    }
    public StringBuilder deleteSecond (StringBuilder s){
        for(int i = 1; i<s.length(); i+=1){
            s.deleteCharAt(i);
        }
        return s;
    }
    public String reverse (String s){
        char[] arr = s.toCharArray();
        String result = "";
        String[] words = s.split("(\\s)+");
        int j = 1;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] == ' ') {
                result = result + arr[i];
            }
            else {
                result= result + words[words.length - j];
                while(arr[i] != ' ')
                {
                    i++;
                }
                result = result + arr[i];
                j++;

            }

        }
        return result;
    }


}
