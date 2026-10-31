class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];

        int first=BS(nums,target,true);//first occurence
        int last=BS(nums,target,false);//last occurence
        res[0]=first;
        res[1]=last;
        return res;
    }
    public int BS(int[] nums,int target,boolean isFirst){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans=mid;
                if(isFirst){////if isFirst is true it means we need to find first occurenece hence for increasing ordered array we have to search in left side whether there exist an target element and whether it has any previous same target element if target equals mid element 
                    end=mid-1;
                }
                else{////if isFirst is false it means we need to find last occurenece hence for increasing ordered array we have to search in right side whether there exist an target element and whether it has any succeding same target element if target equals mid element 
                    start=mid+1;
                }
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}