
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        // 1. 标记数组：记录哪些单词已经被归入某个组了
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue; // 已经被前面归类的单词直接跳过
            }

            // 为当前单词创建属于它的一整组
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            int j = i + 1;
            while (j < strs.length) {
                // 只有未被访问且长度相同的单词才需要比对
                if (!visited[j] && strs[i].length() == strs[j].length()) {
                    // 2. count 必须在每次对比具体的 (i, j) 时重新创建清零
                    int[] count = new int[26];
                    for (int k = 0; k < strs[i].length(); k++) {
                        count[strs[i].charAt(k) - 'a']++; // 3. 必须减 'a' 转成 0~25 下标
                        count[strs[j].charAt(k) - 'a']--;
                    }

                    // 4. 不能直接写 count == 0，必须检查 26 位是否全为 0
                    boolean isMatch = true;
                    for (int val : count) {
                        if (val != 0) {
                            isMatch = false;
                            break;
                        }
                    }

                    // 5. 匹配成功，将 strs[j] 加入该组，并标记为已访问
                    if (isMatch) {
                        group.add(strs[j]);
                        visited[j] = true;
                    }
                }
                j++;
            }

            // 把整理好的一组放入大列表中
            list.add(group);
        }

        return list;
    }
}