class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = height[0];
        int maxRight = height[height.length-1];
        int vol = 0;

        while (left < right){
            if(maxLeft <= maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                vol += maxLeft-height[left];
            }else{
                right--;
                maxRight = Math.max(maxRight, height[right]);
                vol += maxRight-height[right];
            }
        }

        return vol;
    }
}
