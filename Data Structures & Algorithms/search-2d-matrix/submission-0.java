class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length-1;
        int targetArr = -1;

        while(l<=r){
            int mid = (l+r)/2;

            if(matrix[mid][matrix[mid].length-1] < target){
                l = mid+1;
            } else if(matrix[mid][0] > target){
                r = mid-1;
            } else{
                targetArr = mid;
                break;
            }
            
        }

        if(targetArr == -1) return false;

        l = 0;
        r = matrix[targetArr].length-1;

        while(l<=r){
            int mid = (l+r)/2;

            if(matrix[targetArr][mid] < target) l = mid+1;
            if(matrix[targetArr][mid] > target) r = mid-1;
            if(matrix[targetArr][mid] == target) return true;
        }

        return false;
    }
}
