//Justin Butler 10/24/2021
/*
Runtime: 7 ms
Memory Usage: 40.5 MB
*/
class Solution {
    //HashMap will count the value of the node as its key, and the frequency of it as its value.
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int[] findMode(TreeNode root) {
        hm.put(root.val, 1);
        mapElements(root);
        int max = 0; //max = largest frequency
        int maxNode = root.val; //maxNode = value at that specific frequency (temp set to root)
        PriorityQueue<Integer> out = new PriorityQueue<Integer>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet())
        {
            if(entry.getValue() >= max){
                maxNode = entry.getKey();
                if(max == entry.getValue()){
                     out.add(maxNode);
                }
                else{
                    out.clear();
                    out.add(maxNode);
                }
                max = entry.getValue();
            }
        }
        return(out.stream().map(String::valueOf).mapToInt(Integer::parseInt).toArray());
    }
    //Helper method to iterate over all elements and add them to the hashmap
    public void mapElements(TreeNode root)
    {
        if(root.left !=null)
        {
            if(hm.containsKey(root.left.val))
            {
                hm.put(root.left.val, hm.get(root.left.val)+1); 
            }
            else{
                hm.put(root.left.val, 1);
            }
           mapElements(root.left);
        if(root.right !=null)
        {
           if(hm.containsKey(root.right.val))
           {
                hm.put(root.right.val, hm.get(root.right.val)+1); 
            }
            else{
                hm.put(root.right.val, 1);
            }
           mapElements(root.right);
        }
        if(hm.containsKey(root.val))
        {
         hm.put(root.val, hm.get(root.val)+1);   
        }
        else
        {
            hm.put(root.val, 1);
        }
        return;
    }
}
