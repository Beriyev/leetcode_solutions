class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        int val;
        char app;
        
        for(String word : words)
        {
            val = 0;
            for(char c : word.toCharArray())
            {
                val+=weights[c-'a'];
            }
            val%=26;
            app = (char)('z'-val);
            sb.append(app);
        }

        return sb.toString();
    }
}