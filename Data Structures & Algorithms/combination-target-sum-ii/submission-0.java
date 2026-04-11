class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    void backtrack(int[] a, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < a.length; i++) {

            // 🔹 Skip duplicates
            if (i > start && a[i] == a[i - 1]) continue;

            // 🔹 Stop if element exceeds target
            if (a[i] > target) break;

            temp.add(a[i]);
            backtrack(a, target - a[i], i + 1, res, temp); // i+1 → use once
            temp.remove(temp.size() - 1);
        }
    }
}