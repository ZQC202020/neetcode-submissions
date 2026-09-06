
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Key 存排序后的特征字符串，Value 存该分组下的所有单词
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 1. 将字符串转成字符数组并排序，生成统一的 Key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            // 2. 如果字典里还没有这个分组，先建一个空列表
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            // 3. 把原单词塞入对应的抽屉中
            map.get(sortedKey).add(s);
        }

        // 4. 一键打包所有分组返回
        return new ArrayList<>(map.values());
    }
}