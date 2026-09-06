
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 正确统计每个数字的频次（修复每次 count 被重置为 0 的问题）
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 把所有去重后的数字拿出来放入列表
        List<Integer> list = new ArrayList<>(map.keySet());

        // 3. 核心修复：不设阈值，而是直接按出现次数从大到小排序
        list.sort((a, b) -> map.get(b) - map.get(a));

        // 4. 固定截取前 k 个数字放入结果数组（修复 output.add 报错）
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = list.get(i);
        }

        return output;
    }
}