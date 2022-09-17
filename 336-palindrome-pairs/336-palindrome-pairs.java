class Solution {
	public List<List<Integer>> palindromePairs(String[] words) {

		List<List<Integer>> result = new ArrayList<>();
		HashSet<String> duplicate = new HashSet<>();

		Trie trie = new Trie(words);
		for(int j=0;j<words.length;j++){
			String word = words[j];

			TreeNode node = trie.reverseRoot;
			for(int i=0;i<word.length();i++){
				int index = word.charAt(i)-'a';
				if(node==null) 
					break;
				node = node.nodes[index];
			}
			if(node!=null) 
				for(Integer candidateIndex : node.words){
					String candidate = words[candidateIndex];
					if(word.equals(candidate)) 
						continue;
					if(duplicate.contains(j+","+candidateIndex))
						continue;
					if(isPalindrome(0,candidate.length()-1-word.length(),candidate)){
						ArrayList<Integer> ans = new ArrayList<>();
						ans.add(j);
						ans.add(candidateIndex);
						result.add(ans);
						duplicate.add(j+","+candidateIndex);
					}
				}

			node = trie.normalRoot;
			for(int i=word.length()-1;i>=0;i--){
				int index = word.charAt(i)-'a';
				if(node==null) 
					break;
				node = node.nodes[index];
			}
			if(node!=null) 
				for(Integer candidateIndex : node.words){
					String candidate = words[candidateIndex];
					if(word.equals(candidate)) 
						continue;
					if(duplicate.contains(candidateIndex+","+j))
						continue;
					if(isPalindrome(word.length(),candidate.length()-1,candidate)){
						ArrayList<Integer> ans = new ArrayList<>();
						ans.add(candidateIndex);
						ans.add(j);
						result.add(ans);
						duplicate.add(candidateIndex+","+j);
					}
				}

		}
		return result;
	}

	public boolean isPalindrome(int start,int end,String word){
		while(start<end){
			if(word.charAt(start)!=word.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}


}

class Trie{

	TreeNode reverseRoot;

	TreeNode normalRoot;

	public Trie(String[] words){
		reverseRoot = new TreeNode();
		for(int j=0;j<words.length;j++){
			String word = words[j];
			reverseRoot.words.add(j);
			TreeNode node = reverseRoot;
			for(int i=word.length()-1;i>=0;i--){
				int index = word.charAt(i)-'a';
				if(node.nodes[index]==null)
					node.nodes[index] = new TreeNode();
				node = node.nodes[index];
				node.words.add(j);
			}
		}

		normalRoot = new TreeNode();
		for(int j=0;j<words.length;j++){
			String word = words[j];
			normalRoot.words.add(j);
			TreeNode node = normalRoot;
			for(int i=0;i<word.length();i++){
				int index = word.charAt(i)-'a';
				if(node.nodes[index]==null)
					node.nodes[index] = new TreeNode();
				node = node.nodes[index];
				node.words.add(j);
			}
		}      
	}
}

class TreeNode{

	ArrayList<Integer> words;
	TreeNode[] nodes;

	public TreeNode(){
		nodes = new TreeNode[26];
		words = new ArrayList<>();
	}

}