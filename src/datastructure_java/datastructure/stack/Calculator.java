package datastructure_java.datastructure.stack;

import java.util.Stack;

public class Calculator {
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		String exp = "7*5+3";
	
		System.out.println(exp);
		System.out.println(cal.transformer(exp));
		System.out.println(cal.calculator(cal.transformer(exp)));
		
	}
	
	//스택계산기 구현
	/*
	 * 중위표기법 => 후위표기법
	 * 1. 피연산자는 바로 출력
	 * 2. 연산자가 들어오면 해당 연산자보다 우선순위가 높거나 같은 것들을 빼고 자신을 스택에 담음.
	 * 3. ( 는 무조건 스택에 담음
	 * 4. ) 를 만나면 (를 만날때까지 스택을 출력 
	 *   
	 *   ex ) 7 * 5 + 3 => 7 5 * 3 +
	 * 
	 */
	
	
	public String transformer(String exp) {
		
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		
		for(int i = 0; i < exp.length(); i++) {
			
			char ch = exp.charAt(i);
			
			//공백을 만나면 continue
			if(ch == ' ') {
				continue;
			}
			
			//규칙1. 피연산자는 그대로.
			if(this.isdigit(ch)) {
				postfix += ch;
				continue;
			}
			
			//스택이 비어있으면 무조건 넣음
			if(stack.isEmpty()) {
				stack.push(ch);
				continue;
			}
			
			
			//규칙3.(는 무조건 push
			if(ch == '(') {
				stack.push(ch);
				continue;
			}
			
			//규칙4. )를 만나면 (를 만날때까지 출력
			if(ch == ')') {
				while(!stack.isEmpty()) {
					char node = stack.peek();
					if(node == '(') {
						stack.pop(); // ( 는 저장할 필요가 없음.
						break;
					}
					postfix += stack.pop();
				}
				continue;
			}
			
			//규칙2. 연산자를 만나면 우선순위대로 진행.
			char prevOperator = stack.peek();
			
			int priority = this.compare(ch, prevOperator);
			
			if(priority <= 0) {
				postfix += stack.pop();
				stack.push(ch);
			}else {
				stack.push(ch);
			}
		} // for
		
		//반복분 종료 후 스택에 있는 걸 모두 뺀다.
		while(!stack.isEmpty()) {
			char temp = stack.pop();
			
			if(temp != '(') {
				postfix += temp;
			}
			
		}
		
		
		return postfix;
	}
	
	//숫자로 변환가능한지 확인.
	public boolean isdigit(char ch) {
		
		if(ch >= 48 && ch <= 57) {
			return true;
		}else {
			return false;
		}
			
	}
	
	//연산자의 우선순위 리턴.
	public int getPriority(char operator) {
		
		if(operator == '*' || operator == '/') {
			return 3;
		}else if(operator == '+' || operator == '-') {
			return 2;
		}else if(operator == '(') {
			return 0;
		}else {
			return -1;
		}
		
	}
	
	//우선순위 비교
	/*
	 *  1 => 앞이 우선순위가 더 높음
	 *  0 => 우선순위가 동일
	 * -1 => 뒤가 우선순위가 높음
	 *  그 외 =>( 인 경우.
	 */
	public int compare(char operator1, char operator2) {
		return this.getPriority(operator1) - this.getPriority(operator2);
	}
	
	/*
	 * 후위 표기법 계산.
	 * 1) 피연산자를 만나면 스택에 넣음.
	 * 2) 연산자를 만나면 피연산자를 모두 꺼내서 계산하고 결과를 다시 넣음
	 * 3) 반복 종료 후 스택에 남은 데이터가 결과.
	 */
	public int calculator(String postfix) {
		
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		
		for(int i = 0; i < postfix.length(); i++) {
			
			char ch = postfix.charAt(i);
			String temp = "";
			temp += ch; //숫자인 경우 저장을 위함.
			
			if(this.isdigit(ch)) {
				stack.push(Integer.parseInt(temp));
			}else {
				//연산
				
				int prev = stack.pop();
				int prePrev = stack.pop();
				
				int middle = 0;
				
				if(ch == '*') {
					middle = prePrev * prev;
				}else if(ch == '/') {
					middle = prePrev / prev;
				}else if(ch == '+') {
					middle = prePrev + prev;
				}else if(ch == '-') {
					middle = prePrev - prev;
				}
				//중간 계산값 저장.
				stack.push(middle);
			}
		}
		
		result = stack.pop();
		
		
		return result;
	}

}
