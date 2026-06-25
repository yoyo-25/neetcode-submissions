class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int prev = Integer.MIN_VALUE;
        ArrayList<List<Integer>> list = new ArrayList<>();

        for(int k=0; k<nums.length; k++){
            if(nums[k] != prev){
                int i=k+1;
                int j=nums.length-1;

                while(i<j){
                    if(nums[i]+nums[j] < -nums[k]){
                        i++;
                    }else if(nums[i]+nums[j] > -nums[k]){
                        j--;
                    }else{
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        prev = nums[k];
                        i++;
                        while(i<j && nums[i] == nums[i-1]){
                            i++;
                        }
                        j--;
                        while(i<j && nums[j] == nums[j+1]){
                            j--;
                        }
                    }
                }
            }
        }

        return list; 
    }
}
