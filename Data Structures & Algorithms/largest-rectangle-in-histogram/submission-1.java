class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<=heights.length; i++){
            while(!stack.isEmpty() && (i==heights.length || heights[stack.peek()] > heights[i])){
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1:stack.peek();
                int width = i-left-1;

                maxArea = Math.max(maxArea, (height*width));
            }

            stack.push(i);
        }

        return maxArea;
    }
}
