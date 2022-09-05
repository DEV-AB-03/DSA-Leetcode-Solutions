class Solution {
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){return ans;}
          TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm=new TreeMap<>();
      pass(root,0,0,hm);  
        for(int k: hm.keySet()){
            List<Integer> level=new ArrayList<>();
            for(int ky: hm.get(k).keySet()){
            Collections.sort(hm.get(k).get(ky));
            for(int i=0;i<hm.get(k).get(ky).size();i++){
                level.add(hm.get(k).get(ky).get(i));
              
            }
        
            }
            ans.add(level);
        }
        return ans;
    }
public void pass(TreeNode root,int col,int level,TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm){
        if(hm.containsKey(col)){
            if( hm.get(col).containsKey(level))
           hm.get(col).get(level).add(root.val);
            else{ ArrayList<Integer> temp=new ArrayList<>();
                hm.get(col).put(level,temp);
                 hm.get(col).get(level).add(root.val);
            }
        }
        else{
         TreeMap<Integer,ArrayList<Integer>> temp=new TreeMap<>();
            ArrayList<Integer> al=new ArrayList<>();
            hm.put(col,temp);
            hm.get(col).put(level,al);
            hm.get(col).get(level).add(root.val);
        }
        if(root.left!=null){pass(root.left,col-1,level+1,hm);}
        if(root.right!=null){pass(root.right,col+1,level+1,hm);}
    }
}