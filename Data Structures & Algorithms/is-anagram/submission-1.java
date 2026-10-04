class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length()==t.length()){
        for (int i = 0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }

         } 
        for (int i = 0; i<s.length(); i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), 1);
            }else{
                map.replace(t.charAt(i), map.get(t.charAt(i)) - 1);
            }

        }    
        for (int i = 0; i<s.length(); i++){
        if (map.get(s.charAt(i))!=0){
            return false;
        }
         } return true;



    } return false;
}
}