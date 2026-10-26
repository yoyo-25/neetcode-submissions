class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;

        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        for(int i=0; i<hand.length; i++){
            tmap.put(hand[i], tmap.getOrDefault(hand[i], 0)+1);
        }

        while(!tmap.isEmpty()){
            int min = tmap.firstKey();
            int freq = tmap.get(min);

            if(freq == 1){
                tmap.remove(min);
            }else{
                tmap.put(min, freq-1);
            }
            
            int i=1;
            while(i<groupSize){
                if(tmap.containsKey(min+i)){
                    freq = tmap.get(min+i);

                    if(freq == 1){
                        tmap.remove(min+i);
                    }else{
                        tmap.put(min+i, freq-1);
                    }

                    i++;

                }else if(!tmap.containsKey(min+i) || tmap.isEmpty()){
                    return false;
                }
            }
        }

        return true;
    }
}
