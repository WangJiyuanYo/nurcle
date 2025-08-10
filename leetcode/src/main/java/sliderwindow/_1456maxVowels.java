package sliderwindow;

public class _1456maxVowels {

    public int maxVowels(String s, int k) {
        int ans = 0;
        char[] array = s.toCharArray();
        int vowel = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            }
            if (i < k - 1) {
                continue;
            }
            ans = Math.max(vowel, ans);
            char out = array[i - k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _1456maxVowels().maxVowels("abciiidef", 3));
    }
}
