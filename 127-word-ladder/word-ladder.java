class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> invalid = new HashSet<>();
        if(endWord.equals(beginWord))
        {
            return 0;
        }
        int steps = 1;
        int i,j;

        LinkedList<String> queue = new LinkedList<>();

        invalid.add(beginWord);
        queue.add(beginWord);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(i=0;i<size;i++)
            {
                String curr = queue.poll();
                if(curr.equals(endWord))
                {
                    return steps;
                }
                for(String word : wordList)
                {
                    char[] currArray = curr.toCharArray();
                    char[] wordArray = word.toCharArray();
                    int letters = 0;
                    for(j=0;j<wordArray.length;j++)
                    {
                        if(currArray[j]!=wordArray[j])
                        {
                            letters++;
                        }
                    }
                    if(letters==1 && !invalid.contains(word))
                    {
                        queue.add(word);
                        invalid.add(word);
                    }
                }
            }
            steps++;
        }

        return 0;
    }
}