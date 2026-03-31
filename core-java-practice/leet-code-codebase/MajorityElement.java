import java.util.*;
class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count=0;
        int element=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }
            else if(element==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==element){
                    count++;
                }      
        }
        if(count>nums.length/2){
            return element;
        }
        return -1;

    }
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

       
        int result = majorityElement(nums);

        System.out.println("Majority Element: " + result);

        
    }
   
}
