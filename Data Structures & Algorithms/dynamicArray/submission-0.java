class DynamicArray {
    int capacity;
    int[] arr;
    int length;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.length = 0;
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.length == this.capacity){
            this.resize();
        }
        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        if (this.length > 0) length--;
        return this.arr[this.length];
    }

    private void resize() {
        this.capacity = 2 * this.capacity;
        int[] newArr = new int[this.capacity];
        for (int i = 0; i < this.arr.length; i++){
            newArr[i] = this.arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
