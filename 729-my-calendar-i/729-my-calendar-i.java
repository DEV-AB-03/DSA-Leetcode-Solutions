class Interval {
    int start;
    int end;
    
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public String toString() {
        return ""+start+" "+end;
    }
}

class MyCalendar {

    List<Interval>list;
    
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(list.size() == 0){
            list.add(new Interval(start, end));
            return true;
        }
        
       // System.out.println(list);
        Interval interval = new Interval(start, end);
        return check(list, interval);
    }
    
    private boolean check(List<Interval>list, Interval interval) {
        int low = 0, high = list.size() - 1;
        
        Interval ceil = null;
        Interval floor = null;
        
        int midPosition = -1;
        
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            Interval midInterval = list.get(mid);
            
            if(midInterval.start < interval.start){
                low = mid + 1;
                ceil = midInterval;
                midPosition = mid;
            } else if(midInterval.start > interval.start){
                high = mid - 1;
                floor = midInterval;
            } else {
                return false;
            }
        }
        
        if(floor!=null && floor.start < interval.end){
            return false;
        }
        
        if(ceil == null){
            list.add(0, interval);
            return true;
        }
        
        if(ceil.end > interval.start){
            return false;
        } else {
            list.add(midPosition + 1, interval);
            return true;
        }
        
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */