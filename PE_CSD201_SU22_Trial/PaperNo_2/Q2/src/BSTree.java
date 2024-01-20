/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function
         if (xOwner.charAt(0)=='A' || xPrice > 100) {
            return;
        } else {
            insert2(new Car(xOwner, xPrice));
        }

     }
void insert2(Car x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node father, child; // father la cha cua p
        father = null;
        child = root;

        while (child != null) {
            if (child.info.price == x.price) {
                return;
            }
            father = child;
            if (x.price < child.info.price) {
                child = child.left;
            } else {
                child = child.right;
            }
        }

        if (x.price < father.info.price) {
            father.left = new Node(x);
        } else {
            father.right = new Node(x);
        }

    }
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f);


    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

  void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.price >= 4&&p.info.price <= 7) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
  void f3() throws Exception
    {clear();
     loadData(7);
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
        deleteByMerging(7);


    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    } 
  public void deleteByMerging(int x) {
        Node p = findFather(x);
        if(p==null) {
            return;
        }
        //find f is father of p
        Node f=null, q=root;
        while(q!=p) {
            f=q;
            if(q.info.price>p.info.price) q=q.left;else q=q.right;}
        //1- p has no child
        if(p.left==null&&p.right==null) {
            if(f==null) root=null;
            else if(f.left==p) f.left=null;
            else f.right=null;
        }
        //2- p has the left child only
        else if(p.left!=null && p.right==null) {
            if(f==null) root=p.left;
            else if(f.left==p) f.left=p.left;
            else f.right=p.left;
        }
        //3- p has the right child only
        else if(p.left==null && p.right!=null) {
            if(f==null) root=p.right;
            else if(f.left==p) f.left=p.right;
            else f.right=p.right;
        }
        //4- p has both left and right children
        else if(p.left!=null && p.right!=null) {
            //find q is the largest node on the left child of p (q is the right 
            //child with the largest key of the left child of p)
            q=p.left; Node t=null;
            while(q.right!=null) {t=q; q=q.right;}
            //merge the right child of p into q
            Node rp=p.right; q.right=rp;
            if(f==null) root=p.left;
            else if(f.left==p) f.left=p.left;
            else f.right=p.left;
        }
    }
 
private Node findFather(int x) {
        Queue q = new Queue();
        q.enqueue(root);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.right != null && r.info.price<x) {
                return r;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        return null;
    }
//=============================================================
  void f4() throws Exception
    {clear();
     loadData(10);
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
