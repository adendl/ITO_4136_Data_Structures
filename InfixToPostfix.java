public class InfixToPostfix
{/** This class consists of two queues, infix which holds the infix expression, postfix which holds
      our postfix expression, and the stack which assists in the algoritm itself **/
    private QueueADT infix;
    private QueueADT postfix;
    private StackADT stack;

    public InfixToPostfix()
    {
        this.infix = new QueueADT();
        this.postfix = new QueueADT();
        this.stack = new StackADT();
    }

    public String convertToPostfix(String exp)
    {
        if (isValid(exp)) //check if the string is valid, call isValid method
        {
        System.out.println("Infix input is: " + exp);
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            infix.enqueue(c); //queue each character into the infix queue
        }
        stack.push('(');
        infix.enqueue(')');

            while (!stack.isEmpty())
            {
                char x = infix.dequeue();
                if (Character.isLetterOrDigit(x)) //check if is a number
                {
                    postfix.enqueue(x);
                }
                else if (x == '(') //check if is parenthesis
                {
                    stack.push(x);
                }
                else if (isOperator(x))
                {
                    int precedence1 = precedence(x);
                    int precedence2 = precedence(stack.stackTop());
                    if (precedence2 >= precedence1) //compare precedence of operators
                    {
                        postfix.enqueue(stack.pop().getData());
                    }
                    stack.push(x);
                }
                else if (x == ')')
                {
                    while (stack.stackTop() != '(')
                    {
                        postfix.enqueue(stack.pop().getData());
                    };
                    if (stack.stackTop() == '(')
                    {
                        stack.pop();
                    } 
                }
            }
         StringBuilder sb = new StringBuilder(); //build string out of queue of chars
         while (!postfix.isEmpty())
         {
             sb.append(postfix.dequeue());
         }
         return "Postfix is: " + sb.toString();
        } 
        return ""; //return invalid string if not valid expression (error message in isValid method)
    }

    public QueueADT getPostfix()
    {
        return postfix;
    }

    public QueueADT getInfix()
    {
        return infix;
    }

    public boolean isOperator(char c)
    { //check if the character is a valid operator
        switch(c)
        {
            case '+':
            case '*':
            case '/':
            case '^':
            case '%':
            case '-':
                return true;
        }
        return false;
    }

    public boolean isValid(String exp)
    {   
        //check brackets
        int parenthesis1 = 0; //initiate parenthesis counters
        int parenthesis2 = 0;
        for (int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            //check parenthesis
            if (c == '(')
            {
                parenthesis1++;
            }
            if (c == ')')
            {
                parenthesis2++;
            }
            if (String.valueOf(c).matches("[^0-9]") && !isOperator(c) && c != '(' && c != ')' && c != ' ')
            { //check if not valid character
                System.out.println("Invalid Character");
                return false;
            }
        }
        if (parenthesis1 != parenthesis2)
        { //check if the number of '(' matches number of ')'
            System.out.println("Missing Parenthesis");
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        InfixToPostfix iftp = new InfixToPostfix();
        iftp.startDemo(); //start the demo
    }

    static int precedence(char ch)
    { //calculate precedence of character argument
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }

    public void startDemo()
    {
        System.out.println("Welcome to the Infix to Postfix generator, below 4 arithmetic sample data is entered." +
        "The algorithm will then either calculate the postfix equivalent, or if an invalid string is passed" +
        "an error message will display \n\n" );
        String exp1 = convertToPostfix("(6+2)*5-8/4+(7^3*2)-5+1"); //sample data 1 - valid and good
        System.out.println(exp1);
        String exp2 = convertToPostfix("(9-2)*(3+5)-(2^3)+(2*3*5)"); //sample data 2 - valid and good
        System.out.println(exp2);
        String exp3 = convertToPostfix("(1 + 5))*5+(8-1)+1+2+3+4+5"); //sample data 3 - invalid, missing parenthesis
        System.out.println(exp3);
        String exp4 = convertToPostfix("10+20*3*5^2+2+4+8*1*2a"); //sample data 4 - invalid, contains alphabetical character
        System.out.println(exp4);
    }

}
