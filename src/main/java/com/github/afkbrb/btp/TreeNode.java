package com.github.afkbrb.btp;

import java.util.ArrayList;
import java.util.List;

/**
 * Typical tree node with ext field for easier implementation of the print algorithm.
 *
 * @author afkbrb
 */
class TreeNode {

    String val;
    TreeNode left;
    TreeNode right;

    /**
     * The calculation of disToParent is the key for the print algorithm.
     * Once we know the current node's distance to its parent,
     * we know how many '/' or '\' we should print between them.
     * <p>
     * For root node 1, disToParent is 0.
     * For node 2, disToParent is 1.
     * For node 4, disToParent is 2.
     * <p>
     * <pre>
     *        1
     *       / \
     *      2   3
     *     / \
     *    /   \
     *   4     5
     *  / \   / \
     * 6   7 8   9
     * </pre>
     */
    int disToParent;

    /**
     * The leftList maintain the left border's relative distance to the joint of the current node,
     * while the rightList maintain the other.
     * <p>
     * It is guaranteed that size of these two list is always the same,
     * which is also the height of the tree ('/' and '\' included).
     * <p>
     * Take the tree blow for example:
     * <pre>
     *       111
     *       / \
     *     222  3
     *     / \
     *    /   \
     *  4444 55555
     *  / \   / \
     * 6   7 8   9
     * </pre>
     * <p>
     * Both listList.size() and rightList.size() is 8.
     * leftList = [1,1,3,3,4,6,6,7]
     * rightList = [1,1,2,-1,0,3,2,3]
     */
    List<Integer> leftList, rightList;

    /**
     * Instantiate a new TreeNode.
     * <p>
     * When we connect a parent node with it's child, we must know where the joint is.
     * If the length of the val is odd, then the joint (1,2,...val.length) must be the mid.
     * If even, for a left node, joint is len /2, for a right node, joint is len / 2 + 1.
     * <p>
     * Take val 1234 for example, if the current node is a left node, then joint is 2.
     * Otherwise, joint is 3.
     * <p>
     * @param obj of which the val of the TreeNode represents for.
     *            You can put whatever into the TreeNode,
     *            the val of the TreeNode will equal to String.valueOf(obj).
     * @param left is this TreeNode a left node or right node?
     */
    TreeNode(Object obj, boolean left) {
        val = String.valueOf(obj);
        disToParent = 0;
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();

        // Calc joint, and add the corresponding border info into the list.
        int len = String.valueOf(val).length();
        int joint = len % 2 == 1 ? (len + 1) / 2 : (left ? len / 2 : len / 2 + 1);
        leftList.add(joint - 1);
        rightList.add(len - joint);
    }

}
