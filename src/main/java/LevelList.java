import java.util.ArrayList;
import java.util.LinkedList;

import util.AssortedMethods;
import util.TreeNode;

/**
 * @author kchung
 */
public class LevelList {
	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = findLevelLinkList(root);
		printResult(list);
	}

	private static void printResult(ArrayList<LinkedList<TreeNode>> list) {
		for(LinkedList<TreeNode> levelList: list){
			for(TreeNode n: levelList){
				System.out.print(n.data + ", ");
			}
			System.out.println();
		}
	}

	private static ArrayList<LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		findLevelList(root, 0, list);
		return list;
	}

	private static void findLevelList(TreeNode root, int level, ArrayList<LinkedList<TreeNode>> list){
		if(root == null){
			return;
		}

		LinkedList<TreeNode> levelList;

		if(level >= list.size()){
			levelList =new LinkedList<TreeNode>();
			list.add(level, levelList);
		} else{
			levelList = list.get(level);
		}

		levelList.add(root);

		findLevelList(root.left, level + 1, list);
		findLevelList(root.right, level+1, list);
	}
}

