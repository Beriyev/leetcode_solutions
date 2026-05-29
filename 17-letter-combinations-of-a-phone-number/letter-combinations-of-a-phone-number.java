class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> hash = new HashMap<>();
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        backtrack(digits.toCharArray(),new StringBuilder(),0,hash);
        return ans;
    }

    void backtrack(char[] digits, StringBuilder curr, int idx, HashMap<Character,String> hash)
    {
        if(idx==digits.length)
        {
            ans.add(curr.toString());
            return;
        }

        char[] letters = hash.get(digits[idx]).toCharArray();
        for(char letter : letters)
        {
            curr.append(letter);
            backtrack(digits,curr,idx+1,hash);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}