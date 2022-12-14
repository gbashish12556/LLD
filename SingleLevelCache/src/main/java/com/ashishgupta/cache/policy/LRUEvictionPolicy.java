package com.ashishgupta.cache.policy;

import com.ashishgupta.algorithms.DoublyLinkedListNode;
import com.ashishgupta.algorithms.DoublyLinkedList;

import java.util.HashMap;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private HashMap<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        dll = new DoublyLinkedList<Key>();
        mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            DoublyLinkedListNode<Key> node = mapper.get(key);
            dll.detachNode(node);
        }

        DoublyLinkedListNode<Key> node = dll.addElementAtLast(key);
        mapper.put(key,node);
    }

    @Override
    public Key evictKey() {

        DoublyLinkedListNode<Key> firstNode = dll.getFirstNode();

        if(firstNode == null){
            return null;
        }

        firstNode.getPrevious().setNext(firstNode.getNext());
        firstNode.getNext().setPrevious(firstNode.getPrevious());

        return firstNode.getData();
    }
}
