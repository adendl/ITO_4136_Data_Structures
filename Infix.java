public class Infix
{
    private QueueADT queue;

    public Infix()
    {
        this.queue = new QueueADT();
    }

    public QueueADT getQueue()
    {
        return queue;
    }


    public static void main(String[] args)
    {
        Infix inf = new Infix();

        for (int i = 0; i < 10; i++)
        {
            inf.getQueue().enqueue();
        }
        inf.getQueue().print();
        inf.getQueue().dequeue();
        inf.getQueue().print();
        inf.getQueue().enqueue();
        inf.getQueue().print();


    }

}
