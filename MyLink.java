package com.igeek.linkedlist;

import java.util.Iterator;

/**  
* @typename MyLink  
* @author NFUE  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2019年5月10日 上午9:11:07    
* @Company https://github.com/cptbaker233
*    
*/
class Node<T> {
    private Node<T> previous;
    private T value;
    private Node<T> next;
    
    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node() {
        super();
    }

    public Node(Node<T> previous, T value, Node<T> next) {
        super();
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public Node<T> next(){
        return next;
    }
    
    public T nextValue() {
        return next.getValue();
    }
    
    public Node<T> prev() {
        return previous;
    }
    
    public T prevValue() {
        return previous.getValue();
    }
}

public class MyLink<T> implements Iterable<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    
    public int size() {
        return size;
    }
    
    public void add(T ele) {
        addLast(ele);
    }
    public void add(int index, T ele) {
        if (index == 0) {
            addFirst(ele);
            return;
        } else if (index == size) {
            addLast(ele);
        } else {
            Node<T> rd = peek(index);
            Node<T> ld = rd.prev();
            Node<T> nd = new Node<T>(ld, ele, rd);
            ld.setNext(nd);
            rd.setPrevious(nd);
            if (ld == tail) {
                tail = nd;
            }
            size ++;
        }
        
    }
    public void addLast(T ele) {
        if (size == 0) {
            Node<T> nd = new Node<T>(null, ele, null);
            head = nd;
            tail = nd;
            size ++;
        } else if (size == 1) {
            Node<T> nd = new Node<T>(head, ele, head);
            head.setNext(nd);
            head.setPrevious(nd);
            tail = nd;
            size ++;
        } else {
            Node<T> nd = new Node<T>(tail, ele, head);
            tail.setNext(nd);
            head.setPrevious(nd);
            tail = nd;
            size ++;
        }
    }
    
    public void addFirst(T ele) {
        if (size == 0) {
            Node<T> nd = new Node<T>(null, ele, null);
            head = nd;
            tail = nd;
            size ++;
        } else if (size == 1) {
            Node<T> nd = new Node<T>(head, ele, head);
            head.setNext(nd);
            head.setPrevious(nd);
            head = nd;
            size ++;
        } else {
            Node<T> nd = new Node<T>(tail, ele, head);
            tail.setNext(nd);
            head.setPrevious(nd);
            head = nd;
            size ++;
        }
    }
    
    public T getFirst() {
        return peekFirst().getValue();
    }
    private Node<T> peekFirst(){
        return head;
    }
    public T getLast() {
        return peekLast().getValue();
    }
    private Node<T> peekLast(){
        return tail;
    }
    
    public T get(int index) {
        return peek(index).getValue();
    }
    private Node<T> peek(int index){
        Node<T> nd = head;
        for (int i = 0; i < index; i ++) {
            nd = nd.next();
        }
        return nd;
    }
    
    public int indexOf(T ele) {
        int index = 0;
        Node<T> nd = head;
        while (!nd.getValue().equals(ele)) {
            index ++;
            nd = nd.next();
        }
        return index;
    }
    public int LastIndexOf(T ele) {
        int index = size - 1;
        Node<T> nd = tail;
        while (!nd.getValue().equals(ele)) {
            index --;
            nd = nd.prev();
        }
        return index;
    }

    public T remove(int index) {
        if (index == size - 1) {
            return removeLast();
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node<T> nd = peek(index);
            if (nd == head) {
                return removeFirst();
            }
            if (nd == tail) {
                return removeLast();
            }
            nd.next().setPrevious(nd.prev());
            nd.prev().setNext(nd.next());
            size --;
            nd.setNext(null);
            nd.setPrevious(null);
            return nd.getValue();
        }
    }
    public T removeFirst() {
        if (size == 1) {
            head = null;
            tail = null;
            size --;
            return null;
        }
        Node<T> nd = head;
        nd.next().setPrevious(nd.prev());
        nd.prev().setNext(nd.next());
        head = nd.next();
        nd.setNext(null);
        nd.setPrevious(null);
        size --;
        return nd.getValue();
    }
    public T removeLast() {
        if (size == 1) {
            head = null;
            tail = null;
            size --;
            return null;
        }
        Node<T> nd = tail;
        nd.next().setPrevious(nd.prev());
        nd.prev().setNext(nd.next());
        tail = nd.prev();
        nd.setNext(null);
        nd.setPrevious(null);
        size --;
        return nd.getValue();
    }
    
    public void set(int index, T ele) {
        Node<T> nd = peek(index);
        nd.setValue(ele);
    }
    
    @Override
    public String toString() {
        String res = "[ " + head.getValue() + ", ";
        Node<T> nd= head;
        while ((nd = nd.next()) != tail) {
            res += nd.getValue() + ", ";
        }
        res += nd.getValue() + " ]";
        return res;
    }
    
    @Override
    public Iterator<T> iterator() {
        class It implements Iterator<T> {
            private int now = 0;
            private Node<T> nd = head;
            @Override
            public boolean hasNext() {
                if (now < size) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                now ++;
                nd = nd.next();
                return nd.prevValue();
            }
        }
        return new It();
    }
}
