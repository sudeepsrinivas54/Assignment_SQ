import java.util.Iterator;
import java.util.NoSuchElementException;


import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
     private Item[] items; 
     private int N;
     public RandomizedQueue() {
         items = (Item[]) new Object[1];
         N = 0;
     }   
     
     public boolean isEmpty() {
         return N == 0;
     }   
     
     public int size() {
         return N;
     }
     
     public void enqueue(Item item) {
         if (item == null) {
               throw new NullPointerException(); 
         }
         if(N == items.length) {
             resize (N*2);
         }
         items[N++] = item;
     }   
     
     private Item[] resize(int n) {
         Item[] temp = (Item[]) new Object[n];
         for (int i = 0; i < N; i++) {
             temp[i] = items[i];
         }
         items = temp;
         return items;
     }
     
     public Item dequeue() {
         if (size() == 0) {
             throw new NoSuchElementException();             
         }
         int randomInt = StdRandom.uniform(0, N);
         Item item = items[randomInt];
         for(int i = randomInt; i < N - 1 ; i++) {
             items[i] = items[i+1];
         }
         N--;
         return item;
     } 
     
     public Item sample() {
    	 if (size() == 0) {
             throw new NoSuchElementException();             
         }
         return items[StdRandom.uniform(0, N)];
     }     
     
     public Iterator<Item> iterator() {
         return new ListIterator<Item>();
     }        
     
     private class ListIterator<Item> implements Iterator<Item>{
         private int n = N;
         private int n2 = N;
         private Item[] tempItems = (Item[]) items;
         private int temp[] = new int[n];
         private int pointer = 0;
         private int random; 
         private boolean tmp2[]=new boolean[N];
         ListIterator() {
             for (int i = 0; i < temp.length; i++) {
                 temp[i] = -1;
             }
         }
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return n2 != 0;
        }

        @Override
        public Item next() {     
        	if (!hasNext())
                throw new NoSuchElementException();
            random = StdRandom.uniform(0, n);
            for(int i = 0; i < temp.length; i++) {
                if(random == temp[i]) {
                    return next();
                }
            }
            temp[pointer++] = random;
            Item item = tempItems[random];
            n2--;
            return item;
        }
        
        public void remove() {
            throw new UnsupportedOperationException(); 
        }
         
     }
     
     public static void main(String[] args) {
    	 
     }
}
