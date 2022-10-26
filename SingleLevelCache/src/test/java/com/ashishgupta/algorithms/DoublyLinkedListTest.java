package com.ashishgupta.algorithms;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    public void testDLLAddition() {

        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);


        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNodeAtLast(node1);

        verifyDll(doublyLinkedList, ImmutableList.of(1));

        doublyLinkedList.addNodeAtLast(node2);
        verifyDll(doublyLinkedList, ImmutableList.of(1,2));

        doublyLinkedList.addNodeAtLast(node3);

        verifyDll(doublyLinkedList, ImmutableList.of(1,2,3));


    }

    @Test
    public void testDLLDetach() {

        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);


        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNodeAtLast(node1);
        doublyLinkedList.addNodeAtLast(node2);
        doublyLinkedList.addNodeAtLast(node3);

        doublyLinkedList.detachNode(node3);

        verifyDll(doublyLinkedList, ImmutableList.of(1,2));


    }

    public void verifyDll(DoublyLinkedList<Integer> doublyLinkedList, List<Integer> expectedList){

        assertEquals(doublyLinkedList.getLastNode().getData(), expectedList.get(expectedList.size()-1));

    }
}


