class FreqStack {

    List<Stack<Integer>> stl=null;
    Map<Integer, Integer> mp =null;
    public FreqStack() {
        stl=new ArrayList<>();
        mp=new HashMap<>();
    }
    
    public void push(int x) {
        mp.put(x, mp.getOrDefault(x,0)+1);
        int f=mp.get(x);
        if(f-1>=stl.size())
            stl.add(new Stack<Integer>());
        stl.get(f-1).push(x);
    }
    
    public int pop() {
        int size=stl.size();
        int x=stl.get(size-1).pop();
        if(stl.get(size-1).empty())
            stl.remove(size-1);
        mp.put(x,mp.get(x)-1);
        if(mp.get(x)==0)
            mp.remove(x);
        return x;
    }
}