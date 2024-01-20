/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xTitle, int xPrice, int xType) {
    //You should write here appropriate statements to complete this function.
    if (xTitle.charAt(0) == 'B') {
            return;
        }

        Book b = new Book(xTitle, xPrice, xType);
        if (isEmpty()) {
            head = tail = new Node(b);
        } else {
            Node node = new Node(b);
            tail.next = node;
            tail = node;
        }

   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Book x, y, z;
     x = new Book("X",1,2);
     y = new Book("Y",2,3);
     z = new Book("Z",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      addPosition(1, new Node(x));
      addPosition(3, new Node(y));
      addPosition(4, new Node(z));

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

  void addPosition(int pos, Node x) {
        int size = size();        

        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        Node node = new Node(x.info, p.next);
        p.next = node;
    }
    
    int size() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      dele(getNodef3(getPriceF3()));
 
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }  
  void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;//q is not found
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }
  public Node getNodef3(int k) {
        Node p = head;
        while (p != null) {
            if(p.info.price < k){
                return p;
            }
            p = p.next;
        }
        return p;
    }
public int getPriceF3(){
    Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            if (count == 3) {
                return p.info.price;
            }
            p = p.next;
        }
    return -1;
}
//==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     
      sortFirstKElements(4);
      reverse();
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
public void reverse() {
        int n = size();
        for(int i=n-3,j=n-1; i<j; i++,j--) {
            Node pi=get(i), pj=get(j);
            Book temp=pi.info; pi.info=pj.info; pj.info=temp;
        }
    }

Node get(int i) {
        Node p=head; int count=0;
        while(p!=null && count<i) {count++; p = p.next;}
        return p;
    }
  void sortFirstKElements(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info.price > pj.next.info.price) {
                    Book temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }
 }

