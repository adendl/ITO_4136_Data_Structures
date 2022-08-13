public class StackADT
{
    public class StackNode
    { // inner class that represents an individual node
        private char data;
        private StackNode nextNode;

        public StackNode()
        {
        }

        public StackNode(char data)
        {
            this.data = data;
            this.nextNode = null;
        }

        public char getData()
        {
            return data;
        }

        public StackNode getNextNode()
        {
            return nextNode;
        }

        public void setData(char data)
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

    public StackNode getRoot()
    {
        return root;
    }

    public int getSize()
    {
        return size;
    }


    public boolean isEmpty()
    { // checks the size of list, this is incremented and decremented by the push & pop methods
        if (size == 0)
        {
            return true;
        }
        else return false;
    }

    public StackNode pop()
    {
        if (!isEmpty())
        { // only pop if the list is not empty
            StackNode prevNode = root;
            root = root.getNextNode();
            size--; //decrement size of the list
            return prevNode;
        }
        else
        {
            System.out.println("The stack is empty");
            return null;
        }
    }

    public void print()
    {
        System.out.println("The stack has the following elements:");
        if (root != null)
        {
            StackNode node = root;
            for (int i = 0; i < size; i++)
            { //traverse through the list, printing each element in the list
                System.out.print(node.getData() + " ");
                node = node.getNextNode();
            }
            System.out.println();
        }
    }

    public void push(char val)
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
        size++; //increment size of the list
    }


    public char stackTop()
    {
        if (!isEmpty())
        {
            return root.getData();
        }
        else
        {
            return ' ';
        }
    }

}
