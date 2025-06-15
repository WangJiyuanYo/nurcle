public class _1432maxDiff {
    public int maxDiff(int num) {
        int max = num;
        String numStr = String.valueOf(num);
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                max = Integer.parseInt(numStr.replace(c, '9'));
                break;
            }
        }
        int min = numStr.length() == 1 ? 1 : num;
        for (char c : numStr.toCharArray()) {
            if (c != numStr.charAt(0) && c != '0') {
                min = Integer.parseInt(numStr.replace(c, '0'));
                break;
            }
        }
        int min1 = Integer.parseInt(numStr.replace(numStr.charAt(0), '1'));
        return max - Math.min(min, min1);
    }

    public static void main(String[] args) {
        System.out.println(new _1432maxDiff().maxDiff(123456));
    }
}
