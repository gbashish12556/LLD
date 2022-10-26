package com.ashishgupta.algorithms;

import com.ashishgupta.algorithms.exception.InvalidElementException;
import com.ashishgupta.algorithms.exception.InvalidNodeException;

public class DoublyLinkedList<E> {


    DoublyLinkedListNode<E> headNode;
    DoublyLinkedListNode<E> tailNode;


    public DoublyLinkedList(){

        headNode = new DoublyLinkedListNode(null);
        tailNode = new DoublyLinkedListNode(null);
        headNode.setNext(tailNode);
        tailNode.setPrevious(headNode);

    }


    private Boolean isItemExist(){

        if(headNode.getNext() != tailNode.getPrevious()){
            return true;
        }
        return false;

    }

    public DoublyLinkedListNode getLastNode(){
        if(isItemExist()){
            return tailNode.getPrevious();
        }
        return null;
    }

    public DoublyLinkedListNode getFirstNode(){
        if(isItemExist()){
            return headNode.getNext();
        }
        return null;
    }


    public void addNodeAtLast(DoublyLinkedListNode doublyLinkedListNode){
        DoublyLinkedListNode prevNode = tailNode.getPrevious();
        prevNode.setNext(doublyLinkedListNode);
        doublyLinkedListNode.setPrevious(prevNode);
        doublyLinkedListNode.setNext(tailNode);
        tailNode.setPrevious(doublyLinkedListNode);
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element){
        if(element == null){
            throw new InvalidElementException();
        }
        DoublyLinkedListNode node= new DoublyLinkedListNode(element);
        addNodeAtLast(node);
        return node;
    }

    public void detachNode(DoublyLinkedListNode node){
        if(node == null){
            throw new InvalidNodeException();
        }
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }

}
