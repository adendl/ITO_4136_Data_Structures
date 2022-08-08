public class StackADT
{

    public class StackNode
    {
        private String data;
        private StackNode nextNode;

        public StackNode()
        {
        }

        public StackNode(String data)
        {
            this.data = data;
            this.nextNode = null;
        }

        public String getData()
        {
            return data;
        }

        public StackNode getNextNode()
        {
            return nextNode;
        }

        public void setData(String data)
        {
            this.data = data;
        }

        public void setNextNode(StackNode nextNode)
        {
            this.nextNode = nextNode;
        }
    }

    private StackNode root;
    private int size;

    public StackADT()
    {
        this.size = 0;
    }


    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true
        }
        else return false;
    }

    public void push(String val)
    {
        StackNode node = new StackNode();
        node.setData(val);
        if (this.root == null)
        {
            node.setNextNode(null);
        }
        else
        {
            node.setNextNode(root);
        }
        root = node;
        size++;
    }

    public StackNode pop()
    {
        if (!isEmpty())
        {
            StackNode prevNode = root;
            root = root.getNextNode();
            size--;
            return prevNode;
        }
        else
        {
            System.out.println("The stack is empty");
            return null;
        }
    }

    public String stackTop()
    {
        if (!isEmpty())
        {
            return root.getData();
        }
        else
        {
            System.out.println("The stack is empty");
        }
        return null;
    }

    public void print()
    {
        System.out.println("The stack has the following elements:");
        if (root != null)
        {
            StackNode node = root;
            for (int i = 0; i < size; i++)
            {
                System.out.println(node.getData());
                node = node.getNextNode();
            }
        }
        else
            System.out.println("The stack is empty");
    }

    public static void main(String[] args)
    {
        StackADT sadt = new StackADT();
        sadt.pop();
        sadt.print();
    }






}
