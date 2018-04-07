package cn.ucaner.datastructure.BinarySearchTree;

/**
* @Package：cn.ucaner.datastructure.BinarySearchTree   
* @ClassName：TreeNode   
* @Description：   <p> Node节点</p>
* @Author： - Jason   
* @CreatTime：2018年4月7日 下午8:41:02   
* @Modify By：   
* @ModifyTime：  2018年4月7日
* @Modify marker：   
* @version    V1.0
 */
public class TreeNode {

	public int data;//结点的数据项  
	public TreeNode left; //结点指向左孩子的引用  
	public TreeNode right;//结点指向右孩子的引用
	
	public TreeNode(int data){
		this.data = data;//构造方法，初始化结点数据项 
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";//便于输出数据
	}
	
}
