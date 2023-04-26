package exercise;

class SafetyList {
    // BEGIN
    private int[] num = new int[0];
    private int length = 0;

    public synchronized void add(int number) {
        int[] data = new int[length + 1];
        data[length] = number;
        num = data;
        length++;
    }

    public int get (int index) {
        return num[index];
    }

    public int getSize() {
        return length;
    }
    // END
}
