class Solution {
    public boolean checkPowersOfThree(int n) {
        String bool = Integer.toString(n,3);
        for(char c : bool.toCharArray())
        {
            if(c=='2')
            {
                return false;
            }
        }
        return true;
    }
}