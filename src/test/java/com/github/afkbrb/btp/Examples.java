package com.github.afkbrb.btp;

import org.junit.jupiter.api.Test;

public class Examples {

    @Test
    public void test01() {
        BTPrinter.printTree("1,2,3");
    }

    @Test
    public void test02() {
        BTPrinter.printTree("1,2,3,4,5,#,#,6,7,8,1,#,#,#,#,#,#,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
    }

    @Test
    public void test03() {
        BTPrinter.printRandomBST(100, 100);
    }

    @Test
    public void test04() {
        BTPrinter.printTreeLevelOrder("1,#,2,#,#,#,3,#,#,#,#,#,#,#,4");
    }

    @Test
    public void test05() {
        BTPrinter.printTree("root", 2, 333, null, null, null, new Foo(), null, new Foo(), null, "end");
    }
}
