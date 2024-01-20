/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Bus> sv = new BinarySearchTree();
        Bus b1 = new Bus("G", "xx", 0, 0, 0, 0);
        Bus b2 = new Bus("D", "xx", 0, 0, 0, 0);
        Bus b3 = new Bus("H", "xx", 0, 0, 0, 0);
        Bus b4 = new Bus("A", "xx", 0, 0, 0, 0);
        Bus b5 = new Bus("E", "xx", 0, 0, 0, 0);
        Bus b6 = new Bus("P", "xx", 0, 0, 0, 0);
        Bus b7 = new Bus("R", "xx", 0, 0, 0, 0);
        
        sv.insert(b1);
        sv.insert(b2);
        sv.insert(b3);
        sv.insert(b4);
        sv.insert(b5);
        sv.insert(b6);
        sv.insert(b7);
        System.out.println(sv.search(b3).getData().toString());
//        System.out.println(sv.search("Y"));
        System.out.println("preorder ");
        sv.traverse(TreeTraverseType.PRE_ORDER);
        System.out.println("in");
        sv.traverse(TreeTraverseType.IN_ORDER);
        System.out.println("pos");
        sv.traverse(TreeTraverseType.POS_ORDER);
//        BinarySearchTree<Integer> sv = new BinarySearchTree();
//        sv.insert(1);
//        sv.insert(3);
//        sv.insert(7);
//        sv.insert(8);
//        sv.insert(2);
//        sv.insert(4);
//        System.out.println(sv.search(7));
//        System.out.println("preorder ");
//        sv.traverse(TreeTraverseType.PRE_ORDER);
//        System.out.println("\ninorder ");
//        sv.traverse(TreeTraverseType.IN_ORDER);
//        System.out.println("\npostorder ");
//        sv.traverse(TreeTraverseType.POS_ORDER);
//        System.out.println("");
//        System.out.println("max, min: ");
//        System.out.println(sv.max().getData()+" ");
//        System.out.println(sv.min().getData()+ " ");
//        System.out.println("Sum: "+ sv.sum(sv.getRoot()));
//        System.out.println("AVG: "+ sv.avg());
//        System.out.println("height: "+ sv.height());
    }
}
