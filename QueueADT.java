public class QueueADT
{
    private StackADT stack1; //this class consists of two stacksADT
    private StackADT stack2;

    public QueueADT()
    {
        this.stack1 = new StackADT();
        this.stack2 = new StackADT();
    }

    public QueueADT(StackADT stack1, StackADT stack2)
    {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public StackADT getStack1()
    {
        return stack1;
    }

    public StackADT getStack2()
    {
        return stack2;
    }

    /**stack 1 and 2 are reverse of eachother, this way we can convert a stack which is
    first in last out to a queue which is first in first out**/
    public void enqueue(char theChar)
    { 
        while (!getStack1().isEmpty())
        {
            getStack2().push(getStack1().pop().getData()); //adding the popped value from stack1 to stack2
        }
        getStack1().push(theChar); //adding the inputted character to stack 1 (our queue) 
              
        while (!getStack2().isEmpty())
        {
            getStack1().push(getStack2().pop().getData()); //adding popped value form stack 2 to stack 1
        }
    }

    /** here we remove the first element from stack1, which is reverse of stack2**/
    public char dequeue()
    {
        if (getStack1().isEmpty())
        {
            System.out.println("The queue is empty");
        }
        char dequeued = getStack1().stackTop();
        getStack1().pop();
        return dequeued;
    }

    public boolean isEmpty()
    {
        if (getStack1().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public void print()
    {
        getStack1().print();
    }

    public char queueFront()
    {
        if (getStack1().isEmpty())
        {
            System.out.println("The queue is empty");
        }
        return getStack1().stackTop();
    }



}
