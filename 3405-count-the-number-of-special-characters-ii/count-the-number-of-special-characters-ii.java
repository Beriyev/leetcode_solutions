class Solution {

    class Pair
    {
        int idx;
        char c;

        Pair(int idx, char c)
        {
            this.idx = idx;
            this.c = c;
        }
    }

    public int numberOfSpecialChars(String word) {
        int count = 0;
        char[] arr = word.toCharArray();
        int all = 1;
        HashMap<Character,Pair> hash = new HashMap<>();
        HashSet<Character> explored = new HashSet<>();
        int i,j;
        for(i=0;i<arr.length;i++)
        {
            if(Character.isUpperCase(arr[i])&&!hash.containsKey(arr[i]))
            {
                hash.put(arr[i],new Pair(i,arr[i]));
            }
        }
        for(i=0;i<arr.length;i++)
        {
            if(Character.isLowerCase(arr[i])&&hash.containsKey(Character.toUpperCase(arr[i]))&&!explored.contains(arr[i]))
            {
                all = 1;
                for(j=i;j<arr.length;j++)
                {
                    if(arr[i]==arr[j])
                    {
                        if(j>hash.get(Character.toUpperCase(arr[i])).idx)
                        {
                            all = 0;
                            break;
                        }
                    }
                }
                if(all==1)
                {
                    count++;
                }
                explored.add(arr[i]);
            }
        }
        return count;
    }
}