/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder s = new StringBuilder();
    int i = 0;
    public void encode(TreeNode root){
        if(root == null){
            s.append("null,");
            return;
        }

        s.append(root.val);
        s.append(",");
        encode(root.left);
        encode(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encode(root);
        // System.out.println(s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        TreeNode root = decode(nodes);
        return root;
    }

    public TreeNode decode(String[] nodes){
        if(i >= nodes.length) return null;
        if(nodes[i].equals("null")){
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[i++]));
        root.left = decode(nodes);
        root.right = decode(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));