class Solution {
    public int maxArea(int[] heights) {
        int maxVol = 0;
        int left = 0;
        int right = heights.length-1;
        maxVol = (right-left)*Math.min(heights[right], heights[left]);

        while(left<right){
            if(heights[right] >= heights[left]){
                left++;
                maxVol = Math.max(maxVol, ((right-left)*Math.min(heights[right],heights[left])));
            }else if(heights[right] <= heights[left]){
                right--;
                maxVol = Math.max(maxVol, ((right-left)*Math.min(heights[right],heights[left])));
            }
        }

        return maxVol;
    }
}
