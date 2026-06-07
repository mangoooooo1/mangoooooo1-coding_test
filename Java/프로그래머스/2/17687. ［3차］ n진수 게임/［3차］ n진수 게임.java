class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder stream = new StringBuilder();
        int num = 0;
        while (stream.length() < t * m + p) {
            stream.append(toBase(num, n));
            num++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(stream.charAt(i));
        }

        return answer.toString().toUpperCase();
    }

    private String toBase(int num, int base) {
        if (num == 0) return "0";

        String digits = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(digits.charAt(num % base)); 
            num /= base;
        }

        return sb.reverse().toString();
    }
}