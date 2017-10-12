package edu.upc.data;

public  class CuaImpl<T> implements Cua<T>
{
    int size;
    Node first;

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

    public Node getUltim(){
        Node actual = this.first;
        while(actual.next != null){
            actual = actual.next;
        }
        return actual;
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
        if (this.size()==2) {
            Node ultim = getUltim();
            return (T)ultim.element;
        }
        return null;

    }

    public int size()
    {

        return size;
    }

}
