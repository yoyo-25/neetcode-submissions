class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = nums1.length;

        while(l<=r){
            int mid1 = (l+r)/2;
            int mid2 = ((nums1.length + nums2.length +1)/2) - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int r1 = (mid1 == nums1.length) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == nums2.length) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if((nums1.length + nums2.length)%2 == 1) return (double) Math.max(l1, l2);
                else return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            }else{
                if(l1 > r2) r = mid1-1;
                else l = mid1+1;
            }
        }

        return 0.0;
    }
}
