class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> current,List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            current.add(nums[i]);

            backTrack(nums, current, result, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}