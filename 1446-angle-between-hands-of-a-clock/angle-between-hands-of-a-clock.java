class Solution {
    public double angleClock(int hour, int minutes) {
        double hourd = hour;
        double minutesd = minutes;
        double angle = Math.abs(((30*hourd)+30*(minutesd/60))-minutesd*6);
        return Math.min(angle,360-angle);
    }
}