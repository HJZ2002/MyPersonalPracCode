package Module12ndyear;
import javax.swing.*;
public class Queue {
	private int num[];
	private int front,rear,capacity,size;
	
	public Queue() {
		capacity = 5;
		num = new int[capacity];
		front = rear = -1;
	}
	// setting up the constructor
	public Queue(int capacity) {
		this.capacity = capacity;
		num = new int[capacity];
		front = rear = -1;
	}
	//returning the queue if its empty
	public boolean isEmpty() {
		return rear == -1;
	}
	public boolean isFull() {
		return (rear == capacity - 1);
	}
	private void errorMessage(String message) {
		JOptionPane.showMessageDialog(null, message,"is now Full", JOptionPane.ERROR_MESSAGE);
	}
	public void enque(int data) {
		if(isFull()) {
			errorMessage("Queue is full");
		} else {
			num[++rear] = data;
			front = 0;
		}
	}
	//returning the queue to remove the value of the queue
	public int dequeue() {
		int val = 0;
		if(isEmpty()) {
			errorMessage("Queue is empty");
			front = -1;
		} else {
			val = num[front];
			for(int i = 0; i<rear; i++) {
				num[i] = num[i + 1];
			}
			rear--;
		}
		return val;
	}
	//setting up the display elements of the queue
	public String display() {
		String hold ="";
		if(!isEmpty()) {
			for(int i = front; i<= rear; i++) {
				hold+=num[i] + " ";
			}
		}else {
			hold = "Queue is empty";
		}
		return hold;
	}
	public String display2() {
		String hold ="head<-";
		if(!isEmpty()) {
			for(int i = front; i<= rear; i++) {
				hold+=num[i] + " ";
			}
		} else {
			hold = "Queue is empty";
		}
		return hold+"<-rear";
	}
	public String display3() {
		String hold ="";
		if(!isEmpty()) {
			for(int i = front;i<=rear;i++) {
				hold=num[i]+ " "+hold;
			}
		}else {
			hold = "Queue is empty";
		}
		return "rear->"+hold+"->hold";
	}
	public int peek() {
		if(isEmpty()) {
			return -1;
		}else {
			return num[front];
		}
	}
	
	public int last() {
		if(isEmpty()) {
			return -1;
		}else {
			return num[rear];
		}
	}
    public int frontValue() { 
    	return num[front]; 
    	
    }
    public int rearValue() { return num[rear]; 
    }
    
    public int getCurrentSize() { 
    	return capacity-(capacity - (rear+1));
    }
    public int getCapacity(){ 
    	return capacity; 
    }

}
