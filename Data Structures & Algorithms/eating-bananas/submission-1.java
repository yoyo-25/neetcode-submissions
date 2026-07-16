class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int pile : piles){
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;
        int minSpeed = Integer.MAX_VALUE;
        
        while(l<=r){
            int mid = (l+r)/2;
            int tempTime = h;

            for(int pile : piles){
                tempTime -= ((pile+mid-1)/mid);
            }

            if(tempTime < 0) l = mid+1;
            if(tempTime >= 0){
                r = mid-1;
                minSpeed = Math.min(minSpeed, mid);
            }
            
        }

        return minSpeed;
    }
}
