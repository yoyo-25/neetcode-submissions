class Solution {
    public int[] productExceptSelf(int[] nums) {
        int netProduct = 1;
        int zeroCount = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }else{
                netProduct *= nums[i];
            }
        }

        if(zeroCount > 1){
            Arrays.fill(nums, 0);
        } else if(zeroCount == 1){
            for(int i=0; i<nums.length; i++){
                if(nums[i] == 0){
                    nums[i] = netProduct;
                }else{
                    nums[i] = 0;
                }
            }
        }else{
            for(int i=0; i<nums.length; i++){
                nums[i] = (netProduct/nums[i]);
            }
        }

        return nums;
    }
}  
