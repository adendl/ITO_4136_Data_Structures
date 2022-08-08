import java.util.*;

public class QueueADT
{

    private StackADT stack1;
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

    public void enqueue()
    {
        while (!getStack1().isEmpty())
        {
            getStack2().push(getStack1().pop().getData());
        }
        Random rnd = new Random();
        String val = String.valueOf(rnd.nextInt(10));
        getStack1().push(val);
        System.out.println ("value added " + val);
        
        while (!getStack2().isEmpty())
        {
            getStack1().push(getStack2().pop().getData());
        }
    }

    public String dequeue()
    {
        if (getStack1().isEmpty())
        {
            System.out.println("The queue is empty");
        }

        String dequeued = getStack1().stackTop();
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

    public String queueFront()
    {
        if (getStack1().isEmpty())
        {
            System.out.println("The queue is empty");
        }
        return getStack1().stackTop();
    }



}
