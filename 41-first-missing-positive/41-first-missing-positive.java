class Solution {
static int firstMissingPositive(int[] arr){
        int i=0;
        while(i<arr.length){
            // correct is the index where the ith element should actually be
            int correct = arr[i] - 1;
            if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[correct]){ /* First condition: Ignoring the negatives Second condition: If element=length of the array, just ignore it and move ahead */
                swap(arr,i,correct); // swap if not at the correct position
            }else{
                i++; // else move ahead
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if(arr[index]!=index + 1){
                return index + 1;
            }
        }

        // case 2
        return arr.length + 1;
    }

    static void swap(int[] arr, int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}