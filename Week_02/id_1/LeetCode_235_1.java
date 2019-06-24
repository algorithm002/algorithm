package week02;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/11  12:56
 * @描述 LeetCode : 235. 二叉搜索树的最近公共祖先        https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorBinarySearchTree235 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);

        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);
        System.out.println(new LowestCommonAncestorBinarySearchTree235().lowestCommonAncestor3(node, node.left, node.right).toString());
    }

    /**
     * Method 1 : 利用二叉搜索树 的特性；父节点的右节点 大于 父节点。左节点 小于 父节点 ，以此类推。
     * 当两个传入的两个节点的 最小值 都要比父节点 大 的话，只需要从 右节点 中查找即可
     * 当两个传入的两个节点的 最大值 都要比父节点 小 的话，只需要从 左节点 中查找即可
     * 时间复杂度 ： O(logN) ;
     * 空间复杂度 ： O(1)    没有额外的空间开销；
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (Math.min(p.val, q.val) > root.val) return lowestCommonAncestor(root.right, p, q);
        if (Math.max(p.val, q.val) < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    /**
     * Method 2: 也可以不利用二叉搜索树的特性， 从左、右子树中都找一遍，比较费时
     *          也就是二叉树 的 最近公共祖先
     *  时间复杂度 ： O(N)    ;
     *  空间复杂度 : O(2N)   ;
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        final TreeNode left = lowestCommonAncestor2(root.left, p, q);
        final TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     *  Method 3 : 利用二叉树的特性 ； 不使用 递归    实现 ；
     *              还是分两边的情况处理 : 同时在 左边 或者 同时在右边 ，
     *                  同时在左边 ： root.val - p.val > 0     ;       root.val - q.val > 0       ;   root=root.left
     *                  同时在右边 ： root.val - p.val < 0     ;       root.val - q.val < 0       ;   root=root.right
     *                  它们 结果的乘积 一定是 大于 0
     *              不然的话直接返回当前的root了
     *  时间复杂度 : O(logN)     每次都是进行二分 ;
     *  空间复杂度 ： O(1)    ;   没有额外的空间开销
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val-p.val) * (root.val- q.val)>0){
            root=root.val>q.val ? root.left : root.right;
        }
        return root;
    }



    }
