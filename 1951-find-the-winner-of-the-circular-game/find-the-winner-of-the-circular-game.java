class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;
        int x = 1;
        while(counter<n)
        {
            list.add(x++);
            counter++;
        }
        counter = 0;
        int i = 0;

        while(list.size()>1)
        {
            counter = 0;
            i = (i+k-1)%list.size();
            list.remove(i);
        }
        return list.get(0);
    }
}