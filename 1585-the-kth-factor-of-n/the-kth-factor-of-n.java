class Solution {
    public int kthFactor(int n, int k) {
        int counter = 1;
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        for(i=0;i<n;i++)
        {
            if(n%counter==0)
            {
                list.add(counter);
            }
            counter++;
        }
        return list.size()<k?-1:list.get(k-1);
    }
}