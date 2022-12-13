package datastructure_java.datastructure.stack;

public class ArrayStackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(10);
		
		System.out.println(stack.top());

	}

}
