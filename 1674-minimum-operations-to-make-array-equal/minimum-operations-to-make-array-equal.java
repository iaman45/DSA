class Solution {
    public int minOperations(int n) {
        if(n==1) return 0;
        int n1 = 1;
        int n2 = (2*(n-1))+1;
        int avg = (n1+n2)/2;
        int i=0;
        int j=n-1;
        int count=0;
        int[] arr = new int[n];
        for(int x=0;x<n;x++)
        {
            arr[x] = (2*x)+1;
        }
        while(arr[i]!=avg && arr[j]!=avg && i<j)
        {
            arr[i] +=1;
            arr[j] -=1;
            count++;
            if(arr[i]==avg && arr[j]==avg)
            {
                i++;
                j--;
            }
        }
        return count;
    }
}