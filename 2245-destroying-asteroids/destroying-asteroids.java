class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long massLong = mass;
        Arrays.sort(asteroids);
        int i;
        for(i=0;i<asteroids.length;i++)
        {
            if(massLong>=asteroids[i])
            {
                massLong = massLong+asteroids[i];
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}