import java.util.ArrayList;

public class WordReversalInString {
    public static void main(String[] args){
        System.out.println("Hello");
        String input = "I am a man'";
        char[] cArray = input.toCharArray();
        reverse(cArray);
    }

    private static  String reverse (char[] nameParts){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> al = new ArrayList<>();
        System.out.println("NP : " + new String(nameParts));
        for (int i=0;i<nameParts.length;i++){
            if (nameParts[i] == ' '){
                al.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append(nameParts[i]);
            }
            if (i == nameParts.length-1){
                al.add(sb.toString());
            }
        }
        System.out.println("SB " + sb.toString());
        System.out.println("AL " + al);

        ArrayList<String> out = new ArrayList<>();
        //int j = 0;
        for (int i=al.size()-1;i>=0;i--){
            out.add(al.get(i));
        }
        System.out.println("OUT AL " + out);

        return null;
    }
}
