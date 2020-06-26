class InfixToPostfixConverter {
    private StringBuffer infix;
    private StringBuffer postfix;

    InfixToPostfixConverter(StringBuffer infix){
        this.infix = infix;
        postfix = convertToPostfix();
    }

    private StringBuffer convertToPostfix(){
        StringBuffer infixCopy = new StringBuffer(infix);
        StringBuffer postfix = new StringBuffer();
        CStack cStack = new CStack("processor");

        cStack.insert('(');
        infixCopy.append(')');

        while(!cStack.isEmpty()){

            FixCharacter infixChar = new FixCharacter(infixCopy.charAt(0));
            infixCopy.deleteCharAt(0);

            if(Character.isDigit(infixChar.get())){
                postfix.append(infixChar.get()).append(' ');

            } else if(infixChar.get().equals('(')){
                cStack.insert(infixChar.get());

            } else if(infixChar.isOperator()){
                while(cStack.peek().isOperator() &&
                        infixChar.isLesserPrecedence(cStack.peek())){
                    postfix.append(cStack.remove()).append(' ');
                }
                cStack.insert(infixChar.get());
            } else if(infixChar.get().equals(')')){
                while(cStack.peek().get() != '('){
                    postfix.append(cStack.remove()).append(' ');
                }
                cStack.remove();
            }
        }

        return postfix;
    }

    void printFix(){
        System.out.printf("infix: %s%npostfix: %s%n", infix, postfix);
    }

}
