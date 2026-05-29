class Solution {

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        char[] arr = digits.toCharArray();
        char[] done = new char[3*digits.length()];
        HashMap<Character,String> hash = new HashMap<>();
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        backtrack(arr, new StringBuilder(),0,hash);
        return list;
    }

    void backtrack(char[] digits, StringBuilder curr, int idx, HashMap<Character,String> hash)
    {
        if(idx==digits.length)
        {
            list.add(curr.toString());
            return;
        }
        String letters = hash.get(digits[idx]);
        for(char c : letters.toCharArray())
        {
            curr.append(c);
            backtrack(digits,curr,idx+1,hash);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}