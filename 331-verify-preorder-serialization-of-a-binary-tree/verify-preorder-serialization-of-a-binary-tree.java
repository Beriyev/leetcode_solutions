class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int i;
        ArrayList<String> list = new ArrayList<>();
        for(i=0;i<arr.length;i++)
        {
            list.add(arr[i]);
            while(list.size()>=3&&list.get(list.size()-1).equals("#")&&list.get(list.size()-2).equals("#")&&!list.get(list.size()-3).equals("#"))
            {
                list.remove(list.size()-1);
                list.remove(list.size()-1);
                list.remove(list.size()-1);
                list.add("#");
            }
        }
        if(list.size()==1&&list.get(0).equals("#"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}