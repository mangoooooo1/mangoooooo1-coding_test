import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < N; i++){
            if(hashmap.containsKey(nums[i])) {
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            } else {
                hashmap.put(nums[i], 1);
            }
        }
        int size = hashmap.size();
        if ( N/2 >= size){
            return size;
        } else {
            return N/2;
        }
    }
}