import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String star = "*";
        String result = "";

        for (int i = 0; i < n; i++){
            result += star;
            System.out.println(result);
        }
    }
}