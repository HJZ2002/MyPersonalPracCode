package Module12ndyear;

public class testcase {

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enque(14);
		q.enque(24);
		q.enque(46);
		q.enque(16);
		q.dequeue();
		System.out.println(q.display());
	}

}
