/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xTitle, int xPrice, int xType) {
    //You should insert here statements to complete this function

    if (xTitle.charAt(0) == 'B')
            return;
        Book b = new Book(xTitle, xPrice, xType);
        Node q = new Node(b);
        if (isEmpty()) {
            root = q;
            return;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.info.price == xPrice) 
                return;
            
            f = p;
            if (p.info.price > xPrice) 
                p = p.left;
            else
                p = p.right;
        }
        
        if (f.info.price > xPrice) 
            f.left = q;
        else
            f.right = q;

   }

//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
//=============================================================
 void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

     breadth_2(root, f);

    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  

 void breadth_2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.type < 7) fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
//=============================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

      System.out.println(preOrder_3(root, f));
    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  void deleByCopy(int xPrice) {
        if (root == null) {
                return;
            }
            Node f, p; // f will be the father of p
            p = root;
            f = null;
            while (p != null) {
                if (p.info.price == xPrice) {
                    break;//Found key x
                }
                if (xPrice < p.info.price) {
                    f = p;
                    p = p.left;
                } else {
                    f = p;
                    p = p.right;
                }
            }
            if (p == null) {
                return;
            }
            if (p.left == null && p.right == null) // p is a leaf node
            {
                if (f == null) // The tree is one node
                {
                    root = null;
                } else {
                    if (f.left == p) {
                        f.left = null;
                    } else {
                        f.right = null;
                    }
                }
                return;
            }

            if (p.left != null && p.right == null) // p has only left child
            {
                if (f == null) // p is a root
                {
                    root = p.left;
                } else {
                    if (f.left == p) // p is a left child
                    {
                        f.left = p.left;
                    } else {
                        f.right = p.left;
                    }
                }
                return;
            }

            if (p.left == null && p.right != null) // p has only right child
            {
                if (f == null) // p is a root
                {
                    root = p.right;
                } else {
                    if (f.left == p) // p is aleft child
                    {
                        f.left = p.right;
                    } else {
                        f.right = p.right;
                    }
                }
                return;
            }

            if (p.left != null && p.right != null) // p has both left and right children
            {
                Node q, fr, rp; // p's key will be replaced by rp's one
                fr = null;
                q = p.left;
                rp = q;
                while (rp.right != null) {
                    fr = rp;
                    rp = rp.right; // Find the right most node on the left sub-tree
                }
                p.info = rp.info;
                if (fr == null) // rp is just a left son of p 
                {
                    p.left = rp.left;
                } else {
                    fr.right = rp.left;
                }
            }

        }
  int count = 0;
int preOrder_3(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return -1;
      if (p.left != null && p.right != null) {
           count++;
           System.out.println(count);
           if(count == 3){
               deleByCopy(p.info.price);
           }
        }
      preOrder_3(p.left,f);
      preOrder_3(p.right,f);
      return -1;
     }
//=============================================================
 void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
 

     
    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  

 }
