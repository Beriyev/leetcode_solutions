class Solution {
    public int countOfSubstrings(String word, int k) {
        return atLeast(word,k)-atLeast(word,k+1);
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

    int atLeast(String word, int k)
    {
        char[] arr = word.toCharArray();
        int left = 0;
        int right = 0;
        int count = 0;
        int conscount = 0;
        HashMap<Character,Integer> hash = new HashMap<>();
        for(right=0;right<arr.length;right++)
        {
            if(isVowel(arr[right]))
            {
                hash.put(arr[right],hash.getOrDefault(arr[right],0)+1);
            }
            else
            {
                conscount++;
            }
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
            count+=left;
        }
        return count;
    }
}