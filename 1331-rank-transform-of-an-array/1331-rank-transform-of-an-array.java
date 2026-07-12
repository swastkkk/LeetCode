class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums =Arrays.copyOf(arr,arr.length);
        Arrays.sort(nums);
        Map<Integer, Integer> rank = new HashMap<>();
        int count=1;
        for (int x : nums) {
            if (!rank.containsKey(x)) {
                rank.put(x, count);
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
}