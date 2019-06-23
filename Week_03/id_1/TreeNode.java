package id_1;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  10:09
 * @描述
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val=val;}

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
