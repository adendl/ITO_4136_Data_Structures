
public class InfixToPostfix
{
    private QueueADT infix;
    private QueueADT postfix;
    private StackADT stack;

    public InfixToPostfix()
    {
        this.infix = new QueueADT();
        this.postfix = new QueueADT();
        this.stack = new StackADT();
    }

    public QueueADT getPostfix()
    {
        return postfix;
    }

    public QueueADT getInfix()
    {
        return infix;
    }

    static int precedence(char ch)
    {
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

    public String convertToPostfix(String exp)
    {
        System.out.println("Infix input is: " + exp);
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            infix.enqueue(c);
        }
        stack.push('(');
        infix.enqueue(')');

            while (!stack.isEmpty())
            {
                char x = infix.dequeue();
                if (Character.isLetterOrDigit(x))
                {
                    postfix.enqueue(x);
                }
                else if (x == '(')
                {
                    stack.push(x);
                }
                else if (x == '*' || x == '/' || x == '+' || x == '-' || x == '^')
                {
                    int precedence1 = precedence(x);
                    int precedence2 = precedence(stack.stackTop());
                    if (precedence2 >= precedence1)
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
         StringBuilder sb = new StringBuilder();
         while (!postfix.isEmpty())
         {
             sb.append(postfix.dequeue());
         }
         return "Postfix is: " + sb.toString();
    }

    public void startDemo()
    {
        String a = convertToPostfix("(6+2)*5-8/4");
        System.out.println(a);
    }



    public static void main(String[] args)
    {
        InfixToPostfix iftp = new InfixToPostfix();
        iftp.startDemo();


    }

}
