interface Buffer {
    // place int value into Buffer
    void blockingPut(int value) throws InterruptedException;

    // return int value from Buffer
    int blockingGet() throws InterruptedException;
}