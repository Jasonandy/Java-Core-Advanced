package cn.ucaner.datastructure.BinarySearchTree;

/**
* @Package：cn.ucaner.datastructure.BinarySearchTree   
* @ClassName：BinarySearchTree   
* @Description：   <p> 树集合了数组（查找速度快）和链表（插入、删除速度快）的优点 </br> CSDN {@link https://blog.csdn.net/a19881029/article/details/24379339} </p>
* 		二叉树是一种特殊的树，即：树中的每个节点最多只能有两个子节点
* 		二叉搜索树是一种特殊的二叉树，即：节点的左子节点的值都小于这个节点的值，节点的右子节点的值都大于等于这个节点的值
*   	Tips:如果树中允许存在重复数据，处理起来比较麻烦，故实现中不允许树中存在重复数据，即节点的右子节点的值必须大于节点的值.
*   	搜索二叉树有一个特点，即如果使用中序遍历遍历搜索二叉树，将得到包含搜索二叉树中所有节点值的升序排序结果
* @Author： - Jason   
* @CreatTime：2018年4月7日 下午8:37:11   
* @Modify By：   
* @ModifyTime：  2018年4月7日
* @Modify marker：   
* @version    V1.0
 */
public class BinarySearchTree {

	private TreeNode root;//定义树的根结点  
	

	/**
	* BinarySearchTree.   根据已知序列构建二叉搜索树
	* @param input
	 */
	public BinarySearchTree(int[] input) {
		createBinarySearchTree(input);
	}

	/**
	 * @Description: 根据已知序列构建二叉搜索树
	 * @param input void
	 * @Autor:Jason - jasonandy@hotmail.com
	 */
	public void createBinarySearchTree(int[] input) {
		if (input != null) {
			for (int i = 0; i < input.length; i++) {
				root = insert(input[i], root);
			}
		}
	}

	/**
	 * @Description: 二叉搜索树的搜索算法，递归算法 
	 * @param target 目标值
	 * @param root   二叉搜索树的根结点
	 * @return TreeNode
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public TreeNode search(int target, TreeNode root) {
		TreeNode result = null;
		if (root != null) { // 递归终止条件
			if (target == root.data) { // 递归终止条件
				result = root;
				return result;
			} else if (target < root.data) { // 目标值小于根结点值，从左子树查找
				result = search(target, root.left);
			} else { // 目标值大于根结点值，从右子树查找
				result = search(target, root.right);
			}
		}
		return result;
	}

	/**
	 * @Description: 二叉搜索树的插入操作 
	 * @param target
	 * @param node
	 * @return TreeNode
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public TreeNode insert(int target, TreeNode node) {
		if (search(target, node) == null) {
			if (node == null) {
				return new TreeNode(target);
			} else {
				if (target < node.data) {
					node.left = insert(target, node.left);
				} else {
					node.right = insert(target, node.right);
				}
			}
		}
		return node;
	}

	/**
	 * @Description: 删除搜索二叉树的制定结点
	 * @param target
	 * @param node
	 * @return TreeNode
	 * @Autor: jason - jasonandy@hotmail.com
	 */
	public TreeNode remove(int target, TreeNode node) {
		TreeNode tmp = null;
		if (node != null) {
			if (target < node.data) { // 从左子树删除
				node.left = remove(target, node.left);
			} else if (target > node.data) { // 从右子树删除
				node.right = remove(target, node.right);
			} else if (node.left != null && node.right != null) { // 找到待删除结点，且其左右子树不为空
				// 找到以待删除结点右子树的中序遍历第一个结点(最小结点)
				tmp = node.right;
				while (tmp.left != null) {
					tmp = tmp.left;
				}

				// 用最小结点补位待删除结点
				node.data = tmp.data;

				// 删除待删除结点右子树上补位结点
				node.right = remove(node.data, node.right);
			} else {
				if (node.left == null) {
					node = node.right;
				} else {
					node = node.left;
				}
			}
		}
		return node;
	}

	/**
	 * @Description: 中序遍历二叉搜索树，递归算法，升序排序
	 * @param node void
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(root.data + " ");
			inOrder(node.right);
		}
	}

	/**
	 * @Description:  打印二叉搜索树
	 * @param node void
	 * @Autor:jason - jasonandy@hotmail.com
	 */
	public void printTree(TreeNode node) {
		if (node != null) {
			System.out.print(node.data);
			if (node.left != null || node.right != null) {
				System.out.print("(");
				printTree(node.left);
				System.out.print(",");
				printTree(node.right);
				System.out.print(")");
			}
		}
	}

	/**
	 * @Description: 访问二叉搜索树的根结点
	 * @return TreeNode
	 * @Autor:Jason - jasonandy@hotmail.com
	 */
	public TreeNode getRoot() {
		return root;
	}
}
