class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colours = new int[n+1];
        int i;
        LinkedList<Integer> queue = new LinkedList<>();

        for(i=1;i<=n;i++)
        {
            if(colours[i]==0)
            {
                queue.offer(i);
                colours[i] = 1;

                while(!queue.isEmpty())
                {
                    int ele = queue.poll();
                    for(int[] dislike : dislikes)
                    {
                        if(ele==dislike[0])
                        {
                            if(colours[dislike[1]]==colours[ele])
                            {
                                return false;
                            }
                            if(colours[dislike[1]]==0)
                            {
                                if(colours[ele]==1)
                                {
                                    colours[dislike[1]] = 2;
                                }
                                else
                                {
                                    colours[dislike[1]] = 1;
                                }
                                queue.offer(dislike[1]);
                            }
                        }
                        else if(ele==dislike[1])
                        {
                            if(colours[dislike[0]]==colours[ele])
                            {
                                return false;
                            }
                            if(colours[dislike[0]]==0)
                            {
                                if(colours[ele]==1)
                                {
                                    colours[dislike[0]] = 2;
                                }
                                else
                                {
                                    colours[dislike[0]] = 1;
                                }
                                queue.offer(dislike[0]);
                            }
                        }
                    }
                }
            }
        }
            
        return true;
    }
}