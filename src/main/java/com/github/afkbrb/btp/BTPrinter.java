package com.github.afkbrb.btp;

import java.util.*;

/**
 * Printer for printing a binary tree within extremely small area.
 *
 * @author afkbrb
 */
public class BTPrinter {

    private static RandomBST randomBST;

    /**
     * Print a tree from a leetcode-style level order expression.
     * '#' means a path terminator where no node exists below.
     * <p>
     * For example, if the input string is "1,#,2,3", you'll get the output below:
     * <pre>
     * 1
     *  \
     *   2
     *  /
     * 3
     * </pre>
     * <p>
     * What's leetcode-style level order expression?
     * <p>
     * See:
     * - https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation
     *
     * @param s the string value to be parsed.
     */
    public static void printTree(String s) {
        if (s == null || s.length() == 0) return;
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) if ("#".equals(split[i])) split[i] = null;
        printTree((Object[]) split);
    }

    /**
     * Print a tree from a typical level order expression.
     * '#' means null.
     * <p>
     * For example, if the input string is "1,#,2,#,#,3", you'll get the output below:
     * <pre>
     * 1
     *  \
     *   2
     *  /
     * 3
     * </pre>
     *
     * @param s the string value to be parsed.
     */
    public static void printTreeLevelOrder(String s) {
        if (s == null || s.length() == 0) return;
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) if ("#".equals(split[i])) split[i] = null;
        printTreeLevelOrder((Object[]) split);
    }

    /**
     * Print a tree from a leetcode-style level order array.
     * <p>
     * What's leetcode-style level order array?
     * <p>
     * See:
     * - https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation
     *
     * @param objs the objects you want to print.
     *             Notice that you can input instances with different types at the same time, the algorithm will always work.
     *             The value of each tree node will equal to the String value of the corresponding obj, i.e. String.valueOf(obj).
     *             A null object means a path terminator where no node exists below.
     */
    public static void printTree(Object... objs) {
        TreeNode root = buildTree(objs);
        printTree(root);
    }

    /**
     * Print a tree from a typical level order array.
     *
     * @param objs the objects you want to print.
     *             Notice that you can input instances of different Classes at the same time, the algorithm will always work.
     *             The value of each tree node will equal to the String value of the corresponding obj, i.e. String.valueOf(obj).
     */
    public static void printTreeLevelOrder(Object... objs) {
        TreeNode root = buildTreeLevelOrder(objs);
        printTree(root);
    }

    /**
     * Print a random binary search tree.
     *
     * @param n the node count of the BST, must be a positive integer, cannot be larger than bound.
     * @param bound bound of the val of a tree node, must be a positive integer, cannot be smaller than n.
     */
    public static void printRandomBST(int n, int bound) {
        if (n <= 0) throw new IllegalArgumentException("node count must be positive");
        if (bound <= 0) throw new IllegalArgumentException("bound must be positive");
        if (n > bound) throw new IllegalArgumentException("node count cannot be larger than bound");
        if (randomBST == null) randomBST = new RandomBST();
        randomBST.printRandomBST(n, bound);
    }

    /**
     * Given the root of a tree, print it.
     */
    private static void printTree(TreeNode root) {
        calcDisToParent(root);
        char[][] map = getMap(root);
        printMap(map);
    }

    /**
     * Build a binary tree from a leetcode-style level order array.
     */
    private static TreeNode buildTree(Object... objs) {
        if (objs == null || objs.length == 0 || objs[0] == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(objs[i++], false); // The root node is taken as a right node.
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (i >= objs.length) break;
            if (objs[i++] != null) {
                node.left = new TreeNode(objs[i - 1], true);
                q.offer(node.left);
            }
            if (i >= objs.length) break;
            if (objs[i++] != null) {
                node.right = new TreeNode(objs[i - 1], false);
                q.offer(node.right);
            }
        }

        return root;
    }

    /**
     * Build a binary tree from a typical level order array.
     */
    private static TreeNode buildTreeLevelOrder(Object... objs) {
        if (objs == null || objs.length == 0 || objs[0] == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(objs[i++], false);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (i >= objs.length) break;
            if (node == null) {
                i += 2;
                q.offer(null);
                q.offer(null);
            } else {
                node.left = objs[i] == null ? null : new TreeNode(objs[i], true);
                q.offer(node.left);
                i++;
                if (i >= objs.length) break;
                node.right = objs[i] == null ? null : new TreeNode(objs[i], false);
                q.offer(node.right);
                i++;
            }
        }
        return root;
    }

    /**
     * Calculate the distance to the parent for each node, which is the key of this algorithm.
     */
    private static void calcDisToParent(TreeNode node) {
        if (node == null) return;

        calcDisToParent(node.left);
        calcDisToParent(node.right);

        // When calculating the child's distance to the current node,
        // we must make sure that the left tree won't collide with the right tree.
        int max = 0;
        int min = Math.min(node.left == null ? 0 : node.left.rightList.size(), node.right == null ? 0 : node.right.leftList.size());
        for (int i = 0; i < min; i++) {
            max = Math.max(max, node.left.rightList.get(i) + node.right.leftList.get(i));
        }
        // 2 * dis + 1 > max
        // 2 * dis >= max
        // dis >= (max + 1) / 2
        int dis = Math.max((max + 1) / 2, 1);
        if (node.left != null) node.left.disToParent = dis;
        if (node.right != null) node.right.disToParent = dis;

        // Update the leftList and rightList of the current node.
        calcLeftList(node);
        calcRightList(node);
    }

    /**
     * Calculate the right border's relative distance to the joint of the current node.
     */
    private static void calcRightList(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        if (node.left != null && node.right == null) {
            int disToParent = node.left.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                node.rightList.add(-i);
            }
            node.left.rightList.forEach(d -> {
                node.rightList.add(d - disToParent - 1);
            });
        } else if (node.left == null) { // node.left == null && node.right != null.
            int disToParent = node.right.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                node.rightList.add(i);
            }
            node.right.rightList.forEach(d -> {
                node.rightList.add(d + disToParent + 1);
            });
        } else { // node.left != null && node.right != null.
            int disToParent = node.right.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                node.rightList.add(i);
            }
            node.right.rightList.forEach(d -> {
                node.rightList.add(d + disToParent + 1);
            });
            if (node.left.rightList.size() > node.right.rightList.size()) {
                for (int i = node.right.rightList.size(); i < node.left.rightList.size(); i++) {
                    node.rightList.add(node.left.rightList.get(i) - disToParent - 1);
                }
            }
        }
    }

    /**
     * Calculate the left border's relative distance to the joint of the current node.
     */
    private static void calcLeftList(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        if (node.left != null && node.right == null) {
            int disToParent = node.left.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                node.leftList.add(i);
            }
            node.left.leftList.forEach(d -> {
                node.leftList.add(d + disToParent + 1);
            });
        } else if (node.left == null) { // node.left == null && node.right != null.
            int disToParent = node.right.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                node.leftList.add(-i);
            }
            node.right.leftList.forEach(d -> {
                node.leftList.add(d - disToParent - 1);
            });
        } else { // node.left != null && node.right != null.
            int disToParent = node.left.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                node.leftList.add(i);
            }
            node.left.leftList.forEach(d -> {
                node.leftList.add(d + disToParent + 1);
            });
            if (node.right.leftList.size() > node.left.leftList.size()) {
                for (int i = node.left.leftList.size(); i < node.right.leftList.size(); i++) {
                    node.leftList.add(node.right.leftList.get(i) - disToParent - 1);
                }
            }
        }
    }


    /**
     * Create a 2d table for printing the tree.
     */
    private static char[][] getMap(TreeNode node) {
        if (node == null) return null;
        int leftWidth = 0, rightWidth = 0;
        for (int w : node.leftList) {
            leftWidth = Math.max(leftWidth, w);
        }
        for (int w : node.rightList) {
            rightWidth = Math.max(rightWidth, w);
        }
        int width = leftWidth + rightWidth + 1;
        int height = node.leftList.size(); // rightList.size() is also the same.
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = ' '; // Fill the map with space first.
            }
        }
        fillMap(map, node, leftWidth, 0);

        return map;
    }

    /**
     * Fill the map with node's val, '/' and '\'.
     */
    private static void fillMap(char[][] map, TreeNode node, int x, int y) {
        if (node == null) return;
        String s = String.valueOf(node.val);
        for (int i = 0; i < s.length(); i++) {
            map[y][x - node.leftList.get(0) + i] = s.charAt(i); // Fill the map with node's val.
        }
        if (node.left != null) {
            // '/'
            int disToParent = node.left.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                map[y + i][x - i] = '/';
            }
            fillMap(map, node.left, x - disToParent - 1, y + disToParent + 1);
        }
        if (node.right != null) {
            // '\'
            int disToParent = node.right.disToParent;
            for (int i = 1; i <= disToParent; i++) {
                map[y + i][x + i] = '\\';
            }
            fillMap(map, node.right, x + disToParent + 1, y + disToParent + 1);
        }
    }

    /**
     * Print the map to terminal.
     */
    private static void printMap(char[][] map) {
        if (map == null || map.length == 0 || map[0] == null || map[0].length == 0) return;
        int h = map.length;
        int w = map[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
