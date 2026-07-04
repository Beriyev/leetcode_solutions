class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeast(word,k) - atLeast(word,k+1);
    }

    long atLeast(String word, int k)
    {
        int left;
        int right;
        int conscount = 0;
        HashMap<Character,Integer> hash = new HashMap<>();
        int i;
        left = 0;
        right = 0;
        char[] arr = word.toCharArray();
        long ans = 0;

        for(right=0;right<arr.length;right++)
        {
            if(isVowel(arr[right]))
            {
                hash.put(arr[right],hash.getOrDefault(arr[right],0)+1);
            }
            else
            conscount++;
            while(hash.size()==5&&conscount>=k)
            {
                if(isVowel(arr[left]))
                {
                    hash.put(arr[left],hash.get(arr[left])-1);
                    if(hash.get(arr[left])==0)
                    {
                        hash.remove(arr[left]);
                    }
                    left++;
                }
                else
                {
                    conscount--;
                    left++;
                }
            }
            ans+=left;
        }
        return ans;      
    }

    boolean isVowel(char c)
    {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}