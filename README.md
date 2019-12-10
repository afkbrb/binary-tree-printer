# binary-tree-printer

Print binary tree in extremely small area.

## About

When I was practicing algorithms on [leetcode](https://leetcode.com/) the other day, I found that leetcode provides a user-friendly tree-visualizer, which can convert a [leetcode-style level order array](https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation) to a binary tree and then display it. One amazing thing about the tree-visualizer is that it can adjust the position of each node so that the tree won't take too much space.

The tree-visualizer did help me a lot when I'was trying to solve some tree-related problems. But then I thought, why not write one by myself? So that's how this project began.

## What can it do?

- convert a level order array (leetcode-style or typical) to a binary tree
- print a binary tree in extremely small area by calculating the position of each node dynamically
- print any Classes in addition to Integer

## Usage

This project has been released to maven repository, simply add dependency as below:

```xml
<dependency>
    <groupId>com.github.afkbrb</groupId>
    <artifactId>binary-tree-printer</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Example

Print random BST.

```java
BTPrinter.printRandomBST(100, 100);
```

```
                              38                                  
                              / \                                 
                             /   \                                
                            /     \                               
                           /       \                              
                          /         \                             
                         /           \                            
                        /             \                           
                       /               \                          
                      /                 \                         
                     /                   \                        
                    /                     \                       
                   /                       \                      
                  /                         \                     
                 /                           \                    
                /                             \                   
               /                               \                  
              28                               82                 
             / \                               / \                
            /   \                             /   \               
           /     \                           /     \              
          /       \                         /       \             
         5        31                       /         \            
        / \       / \                     /           \           
       /   \     30 36                   /             \          
      /     \   /   / \                 /               \         
     /       \ 29  33 37               /                 \        
    /         \   / \                 /                   \       
   /           \ 32 35               65                   95      
  1            14   /               / \                   / \     
 / \           / \ 34              /   \                 94 97    
0   2         /   \               /     \               /   / \   
     \       12   24             /       \             93  96 98  
      3     / \   / \           /         \           /         \ 
       \   9  13 16 25         /           \         84         99
        4 / \   / \   \       /             \       / \           
         7  10 15 23  26     59             74     83 86          
        / \   \   /     \   / \             / \       / \         
       6   8  11 22     27 56 60           73 76     85 91        
                /         / \   \         /   / \       / \       
               20        /   \  61       67  75 79     88 92      
              / \       40   58   \     / \     / \   / \         
             18 21     / \   /    62   66 72   78 80 87 89        
            / \       39 54 57      \     /   /     \     \       
           17 19         / \        64   69  77     81    90      
                        50 55       /   / \                       
                       / \         63  68 70                      
                      /   \                 \                     
                     /     \                71                    
                    47     53                                     
                   / \     /                                      
                  /   \   52                                      
                 42   49 /                                        
                / \   / 51                                        
               41 43 48                                           
                    \                                             
                    46                                            
                    /                                             
                   45                                             
                  /                                               
                 44     
```

Print tree from leetcode-style level order array, '#' means a path terminator where no node exists below.

```java
BTPrinter.printTree("1,2,3,4,5,#,#,6,7,8,1,#,#,#,#,#,#,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
```

```
        1              
       / \             
      2   3            
     / \               
    /   \              
   4     5             
  / \   / \            
 6   7 8   1           
          / \          
         /   \         
        /     \        
       /       \       
      /         \      
     2           3     
    / \         / \    
   /   \       /   \   
  4     5     6     7  
 / \   / \   / \   / \ 
8   9 10 11 12 13 14 15
```

Print tree from typical level order array.

```java
BTPrinter.printTreeLevelOrder("1,#,2,#,#,#,3,#,#,#,#,#,#,#,4");
```

```
1      
 \     
  2    
   \   
    3  
     \ 
      4
```

Print objects.

```java
BTPrinter.printTree("root", 2, 333, null, null, null, new Foo(), null, new Foo(), null, "end");
```

```
           root                     
            / \                     
           2  333                   
                \                   
com.github.afkbrb.btp.Foo@646d64ab  
                  \                 
   com.github.afkbrb.btp.Foo@59e5ddf
                    \               
                    end  
```

Notice that we can override Foo's `toString` method, so that the output won't be that ugly.

For more examples, see [Example](/src/test/java/com/github/afkbrb/btp/Examples.java) and [Test](/src/test/java/com/github/afkbrb/btp/BTPrinterTests.java).

## API

|Method|Description|
|-|-|
|printTree(String s)|Print a tree from a leetcode-style level order expression. '#' means a path terminator where no node exists below.|
|printTreeLevelOrder(String s)|Print a tree from a typical level order expression. '#' means null.|
|printTree(Object... objs)|Print a tree from a leetcode-style level order array. Notice that you can input instances with different types at the same time, the algorithm will always work. The value of each tree node will equal to the String value of the corresponding obj, i.e. String.valueOf(obj). **A null object means a path terminator where no node exists below.**|
|printTreeLevelOrder(Object... objs)|Print a tree from a typical level order array. Notice that you can input instances of different Classes at the same time, the algorithm will always work. The value of each tree node will equal to the String value of the corresponding obj, i.e. String.valueOf(obj).|
|printRandomBST(int n, int bound)|Print a random binary search tree. `n` is the node count of the BST, `bound` is the bound of the val of a tree node. Both `n` and `bound` must be positve, and `n` shouldn't be larger than `bound`.| 

## License

[The Unlicense](LICENSE)

Feel free to use it.

## Contribute

Issues and PRs are welcomed!

Stars are welcomed, too 😄!