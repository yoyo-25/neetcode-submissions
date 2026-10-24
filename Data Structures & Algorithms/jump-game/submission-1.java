class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int crntReach = 0;

        for(int i=0; i<nums.length-1; i++){
            if(maxReach >= i){
                crntReach = i+nums[i];

                maxReach = Math.max(maxReach, crntReach);
            }
        }

        if(maxReach >= nums.length-1) return true;

        return false;
    }
}
