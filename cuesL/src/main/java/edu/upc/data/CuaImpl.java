package edu.upc.data;


import org.apache.log4j.Logger;

public  class CuaImpl<T> implements Cua<T>
{
    int size;
    Node first;
    int contador;
    final static Logger logger= Logger.getLogger(CuaImpl.class);

    public CuaImpl(int len) {
        size = 0;
    }

    public int push(T t)
    {
        logger.info("doing a push");
       // this.push(t);
        if(this.size == 0) {
            logger.info("of an empty stack");
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
        if(this.first == null){

            logger.warn("getUltim of an empty stack");
        }
        int i =0;
        while(actual.next != null)
        {
            i++;
            logger.info("avançant la stack "+ i +"posicions");
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
            logger.error("pila buida !");
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
            while(actual.next != ultim) //buscant Penultim
            {
                actual = actual.next;
            }
            actual.next = null;

            logger.info("doing a pop of"+ ultim.element);
            return (T)ultim.element;


        }

    }

    public int size()
    {

        return size;
    }

}
