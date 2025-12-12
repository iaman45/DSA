import java.util.*;
class Solution {
    public String frequencySort(String s) {
        if(s.length()<=2) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> charList = new ArrayList<>(map.keySet());

        Collections.sort(charList,new Comparator<Character>(){
            public int compare(Character a, Character b)
            {
                return map.get(b) - map.get(a);
            }
        });
        StringBuilder ans = new StringBuilder();
        for(char c: charList)
        {
            int freq = map.get(c);
            for(int i=1;i<=freq;i++)
            {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}