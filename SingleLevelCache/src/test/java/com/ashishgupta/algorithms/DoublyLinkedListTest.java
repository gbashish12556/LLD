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
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node5 = new DoublyLinkedListNode(5);


        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNodeAtLast(node1);

        verifyDll(doublyLinkedList, ImmutableList.of(1));


    }

    public void verifyDll(DoublyLinkedList<Integer> doublyLinkedList, List<Integer> expectedList){

        assertEquals(doublyLinkedList.getLastNode().getData(), expectedList.get(expectedList.size()-1));

    }
}


