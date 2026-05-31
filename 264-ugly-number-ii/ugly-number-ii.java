class Solution {
    public int nthUglyNumber(int n) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int curr = 1;
        int i = 1;
        int a,b,c;
        int[] arr = new int[n];
        arr[0] = 1;

        while(i<n)
        {
            a = arr[n1]*2;
            b = arr[n2]*3;
            c = arr[n3]*5;
            curr = Math.min(a,Math.min(b,c));
            if(curr==a)
            {
                n1++;
            }
            if(curr==b)
            {
                n2++;
            }
            if(curr==c)
            {
                n3++;
            }
            arr[i] = curr;
            i++;
        }
        return curr;
    }
}