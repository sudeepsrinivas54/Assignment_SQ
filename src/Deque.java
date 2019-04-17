import java.util.Iterator;
import java.util.NoSuchElementException;


//Adding a comment and raising pull request
public class Deque<Item> implements Iterable<Item> {
   private Node first;
   private Node last;
   private Node lastSecond;
   private int size;
   private class Node {
      Item item;
      Node next;
   }
   
   public Deque() {
      first = null;
      last = null;
      lastSecond = null;
      size = 0;
   } 
   
   public boolean isEmpty() {
       return size==0;
   }   
   
   public int size() {
       return size;
   }         
   
   public void addFirst(Item item) {
       if (item == null) {
           throw new NullPointerException(); 
       }
       Node oldFirst = first;
       first = new Node();
       first.item = item;
       first.next = oldFirst;
       if (last == null) {
           last = first;
       }
       size++;
   }   
   
   public void addLast(Item item) {
       if (item == null) {
           throw new NullPointerException(); 
       }
       lastSecond = last;
       last = new Node();
       last.item = item;
       if (lastSecond != null) {
    	   lastSecond.next = last;
       }
       if (first == null){
           first = last;
       }
       size++;
   }    
   
   public Item removeFirst() {
       if (isEmpty()) {
           throw new NoSuchElementException(); 
       }
       Item item = first.item;
       if (last == first) {
         last = first = first.next;
       }
       else {
          first = first.next;
       }
       size--;
       return item;
   }   
   
   public Item removeLast() {
       if (isEmpty()) {
           throw new NoSuchElementException(); 
       }
       Item item = last.item;
       Node temp = first;
       size--;
       if(first == last) {
           first = last = null;
           return item;
       }
       last = lastSecond;
       last.next = null;
       return item;
   }      
   
   public Iterator<Item> iterator() {
       return new ListIterator();
   }      
   
   private class ListIterator implements Iterator {
    private Node current = first;
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return current != null;
    }

    @Override
    public Item next() {
        // TODO Auto-generated method stub
        if (!hasNext())
            throw new NoSuchElementException(); 
        Item item = current.item;
        current = current.next;
        return item;
    }
    
    public void remove() {
        throw new UnsupportedOperationException(); 
    }
       
   }
   
   public static void main(String[] args) {
       
   }   
}
