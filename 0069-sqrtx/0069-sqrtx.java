class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        int s = 1, e = x;
        //s= start, e = end
        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (mid > x / mid)
                e = mid - 1; //if mid^2 > x then decrease e to mid-1

            else if (mid < x / mid)
                s = mid + 1; //if mid^2 <x then increase s to mid+1

            else
                return mid; //for perfect squares

        }
        // Here the trick is end will always be one less than start so we can return it in case of non perfect squares
        return e;

    }
}