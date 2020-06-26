class FixExpression {
    private StringBuffer infix;
    private StringBuffer postfix;
    private int postfixResult;

    FixExpression(String infix){
        this.infix = new StringBuffer(infix);
        postfix = convertToPostfix();
        postfixResult = evaluatePostfix();
    }

    private StringBuffer convertToPostfix(){
        StringBuilder infixCopy = new StringBuilder(infix);
        StringBuffer postfix = new StringBuffer();
        NStack<FixCharacter> nStack = new NStack<>("processor");

        nStack.insert(new FixCharacter('('));
        infixCopy.append(')');

        while(!nStack.isEmpty()){

            FixCharacter infixChar = new FixCharacter(infixCopy.charAt(0));
            infixCopy.deleteCharAt(0);

            if(Character.isDigit(infixChar.get())){
                postfix.append(infixChar.get()).append(' ');

            } else if(infixChar.get().equals('(')){
                nStack.insert(infixChar);

            } else if(infixChar.isOperator()){
                while(nStack.peekTopNode().isOperator() &&
                        infixChar.isLesserPrecedence(nStack.peekTopNode())){
                    postfix.append(nStack.remove().get()).append(' ');
                }
                nStack.insert(infixChar);
            } else if(infixChar.get().equals(')')){
                while(nStack.peekTopNode().get() != '('){
                    postfix.append(nStack.remove().get()).append(' ');
                }
                nStack.remove();
            }
        }

        return postfix;
    }

    private int evaluatePostfix(){
        StringBuilder postfixCopy = new StringBuilder(postfix);
        NStack<Integer> nStack = new NStack<>("processor");

        postfixCopy.append(')');

        while(postfixCopy.charAt(0) != ')'){

            FixCharacter postfixChar = new FixCharacter(postfixCopy.charAt(0));
            postfixCopy.deleteCharAt(0);

            if(Character.isDigit(postfixChar.get())){
                nStack.insert(postfixChar.get() - '0');

            } else if(postfixChar.isOperator()){
                int y = nStack.remove();
                int x = nStack.remove();
                int result = calculate(x, y, postfixChar.get());
                nStack.insert(result);
            }
            // if a space is encountered, it will be pulled out
        }
        return nStack.remove();
    }

    private int calculate(Integer operand0, Integer operand1, Character operator){
        int x = operand0;
        int y = operand1;

        switch(operator){
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            case '/': return x / y;
            case '^': return (int)Math.pow(x, y);
            case '%': return x % y;
        }
        throw new RuntimeException("operator error");
    }

    void printFix(){
        System.out.printf("infix: %s%npostfix: %s%npostfix result = %d%n", infix, postfix, postfixResult);
    }

}
