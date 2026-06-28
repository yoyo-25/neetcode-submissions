class Solution {
    public int func(String op, int a, int b){
        int result = 0;

        switch(op){
            case "+":
                result = a+b;
                break;

            case "-":
                result = a-b;
                break;
            
            case "*":
                result = a*b;
                break;

            case "/":
                result = a/b;
                break;
        }

        return result;
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int ans = 0;

        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-")|| tokens[i].equals("*") || tokens[i].equals("/")){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());

                ans = func(tokens[i], a, b);
                stack.push(Integer.toString(ans));
            }else{
                stack.push(tokens[i]);
            }
        }

        return Integer.valueOf(stack.peek());
    }
}
