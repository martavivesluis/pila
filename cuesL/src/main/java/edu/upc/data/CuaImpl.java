package edu.upc.data;

public  class CuaImpl<T> implements Cua<T>
{
    int size;
    Node first;
    int contador;

    public CuaImpl(int len) {
        size = 0;
    }

    public int push(T t)
    {
       // this.push(t);
        if(this.size == 0) {
            Node nou = new Node<T>();
            nou.element = t;
            this.first = nou;
            size++;
            return 0;
        }else{
            Node ultim = getUltim();
            Node nou = new Node<T>();
            nou.element = t;
            nou.next = null;
            ultim.next = nou;
            size++;
            return 0;
        }

    }

    public Node getUltim()
    {
        Node actual = this.first;
        while(actual.next != null)
        {
            actual = actual.next;
        }
                return actual;
    }
    public void buidarElement(Node node)
    {
     node.element = null;
    }
    public T pop() throws PilaBuidaException
    {
        if (this.size()==0) {
            throw new PilaBuidaException();
        }
        if (this.size()==1) {
            size--;
            return (T)first.element;
        }
        else {
            Node ultim = getUltim();
            size--;
            Node actual = this.first;
            while(actual.next != ultim)
            {
                actual = actual.next;
            }
            actual.next = null;

            return (T)ultim.element;


        }

    }

    public int size()
    {

        return size;
    }

}
