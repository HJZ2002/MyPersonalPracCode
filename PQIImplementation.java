package Week13;
import java.util.PriorityQueue;
public class PQIImplementation {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		queue.offer(10);
		queue.offer(5);
		queue.offer(15);
		queue.offer(7);
		queue.offer(20);
		
		System.out.println("Elements in the priority queue\t: " + queue);
		
		int highestPriority = queue.poll();
		System.out.println("Highest-priority element\t: " + highestPriority);
		
		int peekElement = queue.peek();
		System.out.println("Peeked element\t\t\t: " + peekElement);
		
		System.out.println("Elements after removal\t\t: " + queue);
		
		//Check if the priority queue is empty
		boolean isEmpty = queue.isEmpty();
		System.out.println("Is the priority queue empty?\t: " + isEmpty);
	}
}
