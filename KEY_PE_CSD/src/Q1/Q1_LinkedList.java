/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author Admin
 */
public class Q1_LinkedList {
    //replace thang lon thu n

    int MaxAgeN(int n) {
        Node p = head;
        int max = -1;
        if (n == 1) {
            max = p.info.type;
            while (p.next != null) {
                if (p.next.info.type > max) {
                    max = p.next.info.type;
                }
                p = p.next;
            }
        } else {
            p = head;
            int maxN = MaxAgeN(n - 1);
            while (p != null) {
                if (p.info.type < maxN) {
                    max = p.info.type;
                }
                p = p.next;
            }
            p = head;
            while (p.next != null) {
                if (p.next.info.type > max && p.next.info.type < maxN) {
                    max = p.next.info.type;
                }
                p = p.next;
            }
        }
        return max;
    }

    void max1() {
        int max = MaxAgeN(2);//edit here
        Node p = head;
        while (p != null) {
            if (max == p.info.type) {
                p.info.place = "YY"; //edit here
                break;
            }
            p = p.next;
        }
    }

    ---------------------------------
    void addLast(Castor x) {//You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void addLast(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        Car x = new Car(xOwner, xPrice);
        addLast(x);
    }

    ---------------------
    void addFirst(Castor x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

//---------------
    void addFirst(Castor x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    ---------------------
    void addAfter(Node p, Castor x) {
        Node p1 = new Node(x);
        if (isEmpty()) {
            return;
        }
        p1.next = p.next;
        p.next = p1;
        if (p == tail) {
            tail = p1;
        }
    }

    ------------------
    void insert(Castor x, int index) {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            if (index == 0) {
                this.addFirst(x);
                break;
            }
            if (count == index - 1) {
                this.addAfter(p, x);
                break;
            }
            count++;
            p = p.next;
        }
    }

    ------------------

    int max() {
        Node p = head;
        int max = head.info.depth;
        while (p != null) {
            if (max < p.info.depth) {
                max = p.info.depth;
            }
            p = p.next;
        }
        return max;
    }

    -----------------------------
//sort 

    void sort(int startIndex, int endIndex) {
        int count = 0, m = 0;
        Castor tmp;
        Node p = head, i;
        while (p.next != null) {
            if (count == startIndex) {
                for (; p != null; p = p.next) {
                    int n = 0;
                    for (i = p.next; i != null; i = i.next) {
                        if (p.info.type > i.info.type) {
                            tmp = p.info;
                            p.info = i.info;
                            i.info = tmp;
                        }
                        n++;
                        if (m + n == endIndex - startIndex) {
                            break;
                        }
                    }
                    if (m + 1 == endIndex - startIndex) {
                        break;
                    }
                    m++;
                }
                break;
            }
            count++;
            p = p.next;
        }
    }

    ---------------------------------
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

    void dele(int xPrice) {
        int j = 0;
        Node p = head;
        while (p != null) {
            if (p.info.price < xPrice) {
                break;
            }
            p = p.next;
        }
        if (p != null) {
            dele(p);
        }
    }

    ---------------------  
    void sortByPrice() {
        Node pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.price > pj.info.price) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

//xoa tu duoi len theo gia tri va so luong xoa
    int size() {
        int size = 0;
        Node p = head;
        while (p.next != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
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

    public void removeTwoLastNodeCondition() {
        int c = 0;
        int sz = size();
        for (int i = sz - 1; i >= 0; i--) {
            Node p = getNode(i);
            if (p.info.price == 5) {
                c++;
                dele(p);
                if (c >= 1) {
                    break;
                }
            }
        }
    }

    -----------------------------//repalce 
    void Replace() {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.wing < 6) {
                count++;
                if (count == 2) {
                    p.info.rate = 99;
                }
            }
            p = p.next;
        }
    }

    --------------------//get tail (index last)
    int indexLast() {
        int index1 = 0;
        Node p = head;
        while (p.next != null) {
            index1++;
            p = p.next;
        }
        return index1;
    }

    ----------------------------
    int MaxAgeN() {
        Node p = head;

        int index = 0;

        int max = p.info.wing;
        while (p.next != null) {
            if (p.next.info.wing > max) {
                max = p.next.info.wing;
            }
            p = p.next;
        }
        Node p1 = head;
        while (p1.next != null) {
            index++;
            if (p1.info.wing == max) {
                break;
            }
            p1 = p1.next;
        }

        return index;
    }

    int getIndex(int rate) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.rate == rate) {
                break;
            }
            indexRes++;
            p = p.next;
        }

        return indexRes;
    }

    void sortFirstKElements(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info.rate > pj.next.info.rate) {
                    Bird temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }

}
