class FixCharacter {
    private Character c;
    private int precedence;

    FixCharacter(Character c){
        this.c = c;
        setPrecedence();
    }

    Character get(){ return c; }
    private int getPrecedence(){ return precedence; }

    void set(Character c){
        this.c = c;
        setPrecedence();
    }
    private void setPrecedence(){
        if(c.equals('+') ||
                c.equals('-')){
            precedence = 1;
        } else if(c.equals('*') ||
                c.equals('/') ||
                c.equals('%')){
            precedence = 2;
        } else if(c.equals('^')){
            precedence = 3;
        } else{
            precedence = 0;
        }
    }

    boolean isOperator(){
        return precedence > 0;
    }

    boolean isLesserPrecedence(FixCharacter candidate){
        return precedence < candidate.getPrecedence();
    }

}
