import java.util.*;

public class Solution {
    public static void main(String[] args) {}
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (strs.length == 0) 
            return ret;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        Iterator ite = map.values().iterator();
        while (ite.hasNext()) {
            List<String> item = (List<String>)ite.next();
            Collections.sort(item);
            ret.add(item);
        }
        return ret;
    }
} 