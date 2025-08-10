import java.util.HashSet;
import java.util.Set;

public class _3136WordIsValid {

    private Set<Character> set = new HashSet<>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean a = false;
        boolean d = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (set.contains(c)) {
                a = true;
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                d = true;
            }else if(c >= '0' && c<='9'){
               continue;
            }else {
                return false;
            }
        }
        return a && d;
    }

    public static void main(String[] args) {
//        System.out.println(new _3136WordIsValid().isValid("a3$e"));
        System.out.println(Character.isDigit('%'));
    }
}
