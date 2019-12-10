package com.github.afkbrb.btp;

import org.junit.jupiter.api.Test;

public class BTPrinterTests {

    @Test
    public void randomTest() {
        System.out.println("=== random test begin ===");
        System.out.println("printRandomBST(1, 10)");
        BTPrinter.printRandomBST(1, 10);
        System.out.println("printRandomBST(10, 10)");
        BTPrinter.printRandomBST(10, 10);
        System.out.println("printRandomBST(100, 100)");
        BTPrinter.printRandomBST(100, 100);
        System.out.println("printRandomBST(233, 233)");
        BTPrinter.printRandomBST(233, 233);
        System.out.println("printRandomBST(666, 1000)");
        BTPrinter.printRandomBST(666, 1000);
        System.out.println("=== random test end ===");
    }

    @Test
    public void printTreeStringTest() {
        System.out.println("=== printTreeStringTest begin ====");
        System.out.println("printTree((String)null): ");
        BTPrinter.printTree((String) null);
        System.out.println("printTree(\"\")");
        BTPrinter.printTree("");
        System.out.println("printTree((\"1\")");
        BTPrinter.printTree(("1"));
        System.out.println("printTree(\"11\")");
        BTPrinter.printTree("11");
        System.out.println("printTree(\"111\")");
        BTPrinter.printTree("111");
        System.out.println("printTree(\"abcdefghijklmn\")");
        BTPrinter.printTree("abcdefghijklmn");
        System.out.println("printTree(\"aaaa,bbbb,cccccc\")");
        BTPrinter.printTree("aaaa,bbbb,cccccc");
        System.out.println("printTree(\"1,#,2,#,#,3,4\")");
        BTPrinter.printTree("1,#,2,#,#,3,4");
        System.out.println("printTree(\"1,2,3,4,5,#,#,6,7,8,1,#,#,#,#,#,#,2,3,4,5,6,7,8,9,10,11,12,13,14,15\")");
        BTPrinter.printTree("1,2,3,4,5,#,#,6,7,8,1,#,#,#,#,#,#,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
        System.out.println("===== printTreeStringTest end ======");
    }

    @Test
    public void printTreeArrayTest() {
        System.out.println("=== printTreeArrayTest begin ===");
        System.out.println("printTree()");
        BTPrinter.printTree();
        System.out.println("printTree((Object) \"\")");
        BTPrinter.printTree((Object) "");
        System.out.println("((Object) \"this is an object\")");
        BTPrinter.printTree((Object) "this is an object");
        System.out.println("printTree(\"root\", \"left-child-with-long-name\", \"right-child-with-long-name\")");
        BTPrinter.printTree("root", "left-child-with-long-name", "right-child-with-long-name");
        System.out.println("printTree(\"object1\", 2, 333, null, null, null, new Foo(), null, new Foo(), null, \"end\")");
        BTPrinter.printTree("root", 2, 333, null, null, null, new Foo(), null, new Foo(), null, "end");
        System.out.println("printTree(1, 2, 3, 4, 5, null, null, 6, 7, 8, 1, null, null, null, null, null, null, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)");
        BTPrinter.printTree(1, 2, 3, 4, 5, null, null, 6, 7, 8, 1, null, null, null, null, null, null, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("=== printTreeArrayTest end ===");
    }

    @Test
    public void printTreeLevelOrderStringTest() {
        System.out.println("=== printTreeLevelOrderStringTest begin ===");
        System.out.println("printTreeLevelOrder((String) null)");
        BTPrinter.printTreeLevelOrder((String) null);
        System.out.println("printTreeLevelOrder(\"\")");
        BTPrinter.printTreeLevelOrder("");
        System.out.println("printTreeLevelOrder(\"1,2,3\")");
        BTPrinter.printTreeLevelOrder("1,2,3");
        System.out.println("printTreeLevelOrder(\"root,left-child-with-long-name,right-child-with-long-name\")");
        BTPrinter.printTreeLevelOrder("root,left-child-with-long-name,right-child-with-long-name");
        System.out.println("printTreeLevelOrder(\"1,2,3,#,#,4\")");
        BTPrinter.printTreeLevelOrder("1,2,3,#,#,4");
        System.out.println("printTreeLevelOrder(\"1,#,#,2,3\")");
        BTPrinter.printTreeLevelOrder("1,#,#,2,3");
        System.out.println("printTreeLevelOrder(\"1,#,2,#,#,#,3,#,#,#,#,#,#,#,4\")");
        BTPrinter.printTreeLevelOrder("1,#,2,#,#,#,3,#,#,#,#,#,#,#,4");
        System.out.println("=== printTreeLevelOrderStringTest end ===");
    }

    @Test
    public void printTreeLevelOrderArrayTest() {
        System.out.println("=== printTreeLevelOrderArrayTest begin ===");
        System.out.println("printTreeLevelOrder((Object) null)");
        BTPrinter.printTreeLevelOrder((Object) null);
        System.out.println("printTreeLevelOrder((Object) \"\")");
        BTPrinter.printTreeLevelOrder((Object) "");
        System.out.println("printTreeLevelOrder((Object) \"this is an object\")");
        BTPrinter.printTreeLevelOrder((Object) "this is an object");
        System.out.println("printTreeLevelOrder(new Foo())");
        BTPrinter.printTreeLevelOrder(new Foo());
        System.out.println("printTreeLevelOrder(\"root\", \"left-child-with-long-name\", \"right-child-with-long-name\")");
        BTPrinter.printTreeLevelOrder("root", "left-child-with-long-name", "right-child-with-long-name");
        System.out.println("printTreeLevelOrder(1, null, \"second node\", null, null, null, new Foo(), null, null, null, null, null, null, null, 4)");
        BTPrinter.printTreeLevelOrder(1, null, "second node", null, null, null, new Foo(), null, null, null, null, null, null, null, 4);
        System.out.println("=== printTreeLevelOrderArrayTest end ===");
    }
}
