// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> s=new Stack<TreeNode>();
    

    public BSTIterator(TreeNode root) {
        while(root!=null){
            s.push(root);
            root=root.left;
        }
        
        
    }
    
    public int next() {
        TreeNode temp=s.pop();
        int res=temp.val;
        if(temp.right!=null){
           temp=temp.right;
            while(temp!=null){
                s.push(temp);
                temp=temp.left;
            }
        }
        return res;
        
    }
    
    public boolean hasNext() {
        if(s.size()>0){
            return true;
        }
        else{
            return false;
        }
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        int len1=0;
        int len2=0;
        ListNode cur=null;
        cur=headA;
        while(cur!=null){
            cur=cur.next;
            len1++;
        }
        cur=headB;
        while(cur!=null){
            cur=cur.next;
            len2++;
        }
        int len3=Math.abs(len1-len2);
        if(len1>len2){
            while(len3!=0){
                headA=headA.next;
                len3--;
            }
        }else{
              while(len3!=0){
                headB=headB.next;
                len3--;
            }
            
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
        
    }
}