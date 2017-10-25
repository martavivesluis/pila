package edu.upc.data;

import org.apache.log4j.Logger;

public  class Node<T>
{
    final static Logger logger= Logger.getLogger(Node.class);;
    public Node(){
        logger.info("node created");
    }
    public Node next;
    public T element;

}