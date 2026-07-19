class TimeMap {
    class Pair{
        int timestamp;
        String value;

        public Pair(int t, String v){
            this.timestamp = t;
            this.value = v;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(timestamp, value);

        if(map.containsKey(key)){
            map.get(key).add(p);
        }else{
            List<Pair> list = new ArrayList<>();
            list.add(p);
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        int l = 0;
        int r = map.get(key).size()-1;

        while(l<=r){
            int mid = (l+r)/2;

            if(map.get(key).get(mid).timestamp > timestamp) r = mid-1;
            if(map.get(key).get(mid).timestamp < timestamp) l = mid+1;
            if(map.get(key).get(mid).timestamp == timestamp) return map.get(key).get(mid).value;
        }

        if(r>=0) return map.get(key).get(r).value;
        
        return "";
    }
}
