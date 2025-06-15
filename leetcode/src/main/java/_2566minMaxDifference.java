public class _2566minMaxDifference {
    //一种贪心策略的算法.如果，最大值为第一个非9的数字全部替换成9；最小值则为第一个数字全部改为0；
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int max = num;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                max = Integer.parseInt(s.replace(c, '9'));
                break;
            }
        }
        int min = Integer.parseInt(s.replace(s.charAt(0), '0'));
        return max - min;
    }

    public static void main(String[] args) {
        int i = new _2566minMaxDifference().minMaxDifference(11891);
        System.out.println(i);
    }
}
