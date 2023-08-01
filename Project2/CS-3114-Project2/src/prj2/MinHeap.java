package prj2;

/**
 * In this class, we implement the d-ary min-heap data structure
 * 
 * @Andrew_Hanner
 *
 */
public class MinHeap {
    // The parameter d in the d-ary min-heap
    private int d;
    private int size;


    // The array representation of your min-heap (It is not required to use this)
    private HeapNode[] nodes;

    /**
     * Constructor
     * 
     * @param n:
     *            maximum number of elements in the min-heap at each time
     * @param d:
     *            parameter d in the d-ary min-heap
     */
    public MinHeap(int n, int d) {
        this.d = d;
        size = 0;
        nodes = new HeapNode[n+1];
    }


    /**
     * This method inserts a new element with "id" and "value" into the min-heap
     * 
     * @param id
     * @param value
     */
    public void insert(int id, int value) {
        if(size>=nodes.length) {
            return;
        }
        nodes[size] = new HeapNode(id,value);
        int temp = size;
        size++;
        while(temp > 0 && nodes[temp].getValue() < nodes[getParent(temp)].getValue()) {
            swap(temp,getParent(temp));
            temp = getParent(temp);
        }
        
    }


    /**
     * This method extracts the min value of the heap
     * 
     * @return an array consisting of two integer elements: id of the minimum
     *         element and the value of the minimum element
     * 
     *         So for example, if the minimum element has id = 5 and value = 1,
     *         you should return the array [5, 1]
     */
    public int[] extractMin() {
        int[] min = {-1,-1};
        if (size<= 0) {
            return min;
        }
        min[0] = nodes[0].getId();
        min[1] = nodes[0].getValue();
        swap(0,size-1);
        nodes[size-1] = null;
        size--;
        System.out.println(toString());
        heapifyDown(0);
        
        
        return min;
    }


    /**
     * This method takes an id and a new value newValue for the corresponding
     * node, and updates the data structure accordingly
     * 
     * @param id
     * @param newValue
     */
    public void decreaseKey(int id, int newValue) {
        int temp = -1;
        for (int i = 0; i < size; i++) {
            if (nodes[i].getId() == id) {
                temp = i;
            }
        }
        if (newValue >= nodes[temp].getValue()) {
            return;
        }
        nodes[temp].setValue(newValue);
        while(temp > 0 && nodes[temp].getValue() < nodes[getParent(temp)].getValue()) {
            swap(temp,getParent(temp));
            temp = getParent(temp);
        }
        
    }


    /**
     * This method returns the array representation of heap
     * 
     * @return the array representation of heap
     */
    public int[] getHeap() {
        int [] heap = new int[size];
        for (int i = 0; i < size; i++) {
            if(nodes[i] != null) {
                heap[i] = nodes[i].getValue();
            }    
        }
        return heap;
    }


    /**
     * the toString method that returns a string with the values of the heap in
     * the array representation.
     * This method can help you find the issues of your code when you want to
     * debug.
     * 
     * @return string form of the array representation of heap
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nodes.length; i++) {
            if (nodes[i] != null) {
                sb.append(nodes[i].getValue());
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    
    private int getParent(int pos) {
        if(pos <= 0) {
            return -1;
        }
        return (pos-1)/d;
    }
    
    private void swap(int pos1, int pos2) {
        HeapNode temp = nodes[pos1];
        nodes[pos1] = nodes[pos2];
        nodes[pos2] = temp;
    }
    
    private int[] getChild(int pos) {
        int[] kids = new int[d];
        for (int i = 1; i<=d ; i++) {
            if ((d*pos)+i >= size) {
                kids[i-1] = -1; 
            }else {
                kids[i-1] = (d*pos)+i;
            }
            
        }
        return kids;
    }
    

    
    private void heapifyDown(int pos) {
        int[] kids = getChild(pos);
        if(kids[0] == -1) {
            return;
        }
        int min = pos;
        for (int i = 0; i < d;i++) {
            if(nodes[min].getValue() > nodes[kids[i]].getValue()) {
                min = kids[i];
            }
        }
        swap(pos,min);
        heapifyDown(min);
        
    }
    

}
