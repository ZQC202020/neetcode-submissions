class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tS= new HashMap<>();
        for(int i = 0; i <nums.length; i++){
            int compliant = target-nums[i];
            if(tS.containsKey(compliant)){
                return new int[]{tS.get(compliant), i};
            }
            tS.put(nums[i],i);
        }
        return new int[]{};
    }
}
