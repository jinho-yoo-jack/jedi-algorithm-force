package com.jedi.algo.heap;

public class MinHeap {
    private int[] heap;
    private int size;

    public void buildMinHeap(int[] arr){
        this.size = arr.length;
        this.heap = new int[arr.length +1 ];

        System.arraycopy(arr, 0, heap, 1, size);
        for(int i = size/2; i >=1; i--){
            min_heapify(i);
        }

    }

    private void min_heapify(int i){
        int left = i * 2;
        int right = left + 1;
        int smallest;

        if(left <= size && heap[left] < heap[i]){
            smallest = left;
        }else {
            smallest = i;
        }

        if(right <= size && heap[right] < heap[smallest]){
            smallest = right;
        }

        if(smallest != i){
            swap(i, smallest);
            min_heapify(smallest);
        }
    }

    private void swap(int i , int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
//        int[] heapArray = {0,2,1,3,4,16,9,10,14,8,7};
        int[] heapArray = {0,4,1,3,2,16,9,10,14,8,7};
        MinHeap h = new MinHeap();
        h.buildMinHeap(heapArray);
    }

}
