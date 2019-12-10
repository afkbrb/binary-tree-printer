package com.github.afkbrb.btp;

import java.util.*;

/**
 * Class for generating random BST.
 *
 * @author afkbrb
 */
class RandomBST {

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    void printRandomBST(int n, int bound) {
        Random random = new Random(System.currentTimeMillis());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < bound; i++) {
            list.add(i);
        }
        for (int i = 0; i < bound - n; i++) {
            list.remove(random.nextInt(list.size()));
        }

        int[] randomArr = new int[n];
        int index = 0;
        for (Integer i : list) {
            randomArr[index++] = i;
        }

        // Must shuffle first.
        shuffle(randomArr);

        // System.out.println("random arr is: " + Arrays.toString(randomArr));
        Integer[] bstArr = treeToArray(arrToBST(randomArr));
        BTPrinter.printTree((Object[]) bstArr);
    }

    private void shuffle(int[] arr) {
        Random random = new Random(System.currentTimeMillis());
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int r = i + random.nextInt(N - i);
            int tmp = arr[i];
            arr[i] = arr[r];
            arr[r] = tmp;
        }
    }

    private Integer[] treeToArray(TreeNode root) {
        if (root == null) return new Integer[0];
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        list.add(root.val);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
            list.add(node.left == null ? null : node.left.val);
            list.add(node.right == null ? null : node.right.val);
        }

        // Clear the nulls at the tail.
        while (list.size() > 0) {
            if (list.get(list.size() - 1) != null) break;
            list.remove(list.size() - 1);
        }

        return list.toArray(new Integer[0]);
    }

    private TreeNode arrToBST(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) put(root, arr[i]);
        return root;
    }

    private TreeNode put(TreeNode node, int i) {
        if (node == null) return new TreeNode(i);
        if (i < node.val) node.left = put(node.left, i);
        if (i > node.val) node.right = put(node.right, i);
        return node;
    }
}
