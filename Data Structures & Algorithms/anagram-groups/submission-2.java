class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<String> newStrs = new ArrayList<>();
        ArrayList<List<String>> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            newStrs.add(strs[i]);
        }

        int i=0;

        while(i<newStrs.size()){
            for(int k=0; k<newStrs.get(i).length(); k++){
                map.put(newStrs.get(i).charAt(k), map.getOrDefault(newStrs.get(i).charAt(k),0)+1);
            }
            int j=i+1;
            HashMap<Character, Integer> compareMap = new HashMap<>();
            ArrayList<String> subList = new ArrayList<>();
            subList.add(newStrs.get(i));
            while(j<newStrs.size()){
                for(int k=0; k<newStrs.get(j).length(); k++){
                    compareMap.put(newStrs.get(j).charAt(k), compareMap.getOrDefault(newStrs.get(j).charAt(k),0)+1);
                }
                if(map.equals(compareMap)){
                    subList.add(newStrs.get(j));
                    newStrs.remove(j);
                    compareMap.clear();
                }else{
                    compareMap.clear();
                    j++;
                }
            }
            list.add(subList);
            map.clear();
            i++;
        }

        return list;
    }
}
