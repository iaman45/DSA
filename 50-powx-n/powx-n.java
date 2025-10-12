class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long k = n;
        if(k < 0) k = -1 * k;

        while(k > 0) {
            if(k % 2 == 0) {
                x = x * x;
                k = k/2;
            } else {
                ans = ans * x;
                k = k - 1;
            }
        }

        if(n < 0) {
            return 1.0/ans;
        }

        return ans;
    }
} 