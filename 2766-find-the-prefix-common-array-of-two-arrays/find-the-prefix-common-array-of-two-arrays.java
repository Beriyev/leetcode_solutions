class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int counter = 0;
        int[] C = new int[A.length];
        HashSet<Integer> set = new HashSet<>();
        int i,j;
        for(i=0;i<C.length;i++)
        {
            set.add(A[i]);
            counter = 0;
            for(j=0;j<=i;j++)
            {
                if(set.contains(B[j]))
                {
                    counter++;
                }
            }
            C[i] = counter;
        }
        return C;
    }
}