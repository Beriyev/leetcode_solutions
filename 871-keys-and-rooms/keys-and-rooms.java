class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<Integer> roomsVisited = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
         
        for(int key : rooms.get(0))
        {
            queue.add(key);
        }
        visited.add(0);
        roomsVisited.add(0);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int curr = queue.poll();
                if(visited.contains(curr))
                {
                    continue;
                }
                visited.add(curr);
                roomsVisited.add(curr);
                for(int key : rooms.get(curr))
                {
                    if(!visited.contains(key))
                    {
                        queue.add(key);
                    }
                }
            }
        }
        if(roomsVisited.size()==rooms.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}