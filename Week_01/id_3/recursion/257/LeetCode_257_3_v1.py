class Solution:
    def binaryTreePaths(self, root):
        results = []
        if not root:
            return results
        path_stack = []
        self.dfs(root, path_stack, results)
        return results

    def dfs(self, node, path_stack, results):
        path_stack.append(str(node.val))
        if not node.left and not node.right:
            results.append('->'.join(path_stack))
            path_stack.pop()
            return
        if node.left:
            self.dfs(node.left, path_stack, results)
        if node.right:
            self.dfs(node.right, path_stack, results)

        path_stack.pop()
