class Solution {
    public int totalWaviness(int num1, int num2) {
        int num = num1;
        int first,second,third;
        int waviness = 0;
        String str;
        int i;

        while(num<=num2)
        {
            if(num/100==0)
            {
                num++;
                continue;
            }
            str = String.valueOf(num);

            for(i=1;i<str.length()-1;i++)
            {
                if(str.charAt(i-1)<str.charAt(i)&&str.charAt(i+1)<str.charAt(i))
                {
                    waviness++;
                }
                else if(str.charAt(i-1)>str.charAt(i)&&str.charAt(i+1)>str.charAt(i))
                {
                    waviness++;
                }
            }

            num++;
        }
        return waviness;
    }
}