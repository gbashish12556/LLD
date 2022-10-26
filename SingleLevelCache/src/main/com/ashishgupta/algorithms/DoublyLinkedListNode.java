package main.com.ashishgupta.algorithms;

import javax.lang.model.element.Element;


public class DoublyLinkedListNode<E> {


    public void setNext(DoublyLinkedListNode<E> next) {
        this.next = next;
    }

    public void setPrevious(DoublyLinkedListNode<E> previous) {
        this.previous = previous;
    }

    private DoublyLinkedListNode<E> next;
    private DoublyLinkedListNode<E> previous;
    private E data;

    public DoublyLinkedListNode(E element){

        this.next = null;
        this.previous = null;
        this.data = element;

    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    public DoublyLinkedListNode<E> getPrevious() {
        return previous;
    }

    public E getData() {
        return data;
    }



}
