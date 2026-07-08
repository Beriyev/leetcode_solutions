class MyCalendar {
    List<Integer[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer[] arr = new Integer[2];
        for(Integer[] times : list)
        {
            if(startTime>=times[0] && startTime<times[1])
            {
                return false;
            }
            if(startTime<times[0] && endTime>=times[1])
            {
                return false;
            }
            if(startTime<times[0] && endTime>times[0])
            {
                return false;
            }
        }
        arr[0] = startTime;
        arr[1] = endTime;
        list.add(arr);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */