package harish.queue;

public class Queue {

    int front;
    int rear;
    int maxSize;
    int nItems;
    int queueArray[];


    public Queue(int maxSize) {
        queueArray = new int[maxSize];
        this.maxSize = maxSize;
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int i) {
        if(rear == maxSize -1 ) {
            if(front == 0)
                System.out.println("Queue is full");
            else
                rear = -1;
        }
            queueArray[++rear] = i;
            nItems++;
    }

    public int peek() {
        return queueArray[front];
    }

    public void remove() {
        System.out.println("We removed :" + queueArray[front++]);
        if(nItems == 0) {
            front = 0;
            rear = -1;
        }
        nItems--;
    }

    public boolean isEmpty() {
        if (nItems == 0) {
            return  true;
        }
        return false;
    }

    public boolean isFull() {
        return maxSize == nItems;
    }

    @Override
    public String toString() {
        String queueElements = "";
        for (int q = front ; q<=rear;q++) {
            queueElements = queueElements + queueArray[q] + " " ;
        }
        return queueElements;
    }
}
