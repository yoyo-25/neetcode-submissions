class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        while(k>0){
            int maxFreq = 0;
            int maxFreqEle = -1001;

            for(int key : map.keySet()){
                if(maxFreq < map.get(key)){
                    maxFreq = map.get(key);
                    maxFreqEle = key;
                }
            }

            map.remove(maxFreqEle);
            list.add(maxFreqEle);
            k--;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
