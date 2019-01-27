package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> extends DoublyLinkedList<E> implements Stack<E> {


  private DoublyLinkedList<E> DLLStack = new DoublyLinkedList<E>();

  public LinkedStack(){
//    header = new DoublyNode<>(null,null,null);
//    trailer = new DoublyNode<>(null,header,null);
//    header.setNext(trailer);
  };

  @Override
  public void push(E element) {

    DLLStack.addLast(element);
  }

  @Override
  public E peek() {

    return DLLStack.last();
  }

  @Override
  public E pop() {
    return DLLStack.removeLast();
  }

  @Override
  public int size() {
    return DLLStack.size;
  }

  @Override
  public boolean isEmpty() {
    if(size()==0)
      return true;
    else{
      return false;
    }
  }

  @Override
  public void transfer(Stack to) {
    if(to == null){
      return;
    }
    int length = size();
    for(int i=0; i<length; i++) {
      E element = peek();
      to.push(element);

      pop();
    }
    isEmpty();

  }

  @Override
  public void reverse() {
    for(int i=0; i<size(); i++) {
      E element = peek();
      pop();

      DLLStack.insert(element,i);

    }
  }

  @Override
  public void merge(Stack other) {
    if(other == null){
      return;
    }
    LinkedStack<E> temp = new LinkedStack<>();
    temp = (LinkedStack<E>) other;
    temp.reverse();


    int size = temp.size();
    for(int i = 0; i< size; i++){
     E element = temp.peek();
      System.out.println(element+"gggg");
     temp.pop();


     DLLStack.insert(element,i);
     //other.push(element);
    }


    System.out.println(other.size()+"gggg");
    //temp.transfer((LinkedStack)DLLStack);
    System.out.println(DLLStack.size()+"gggg");


    //other.transfer((LinkedStack) DLLStack);

  }

  @Override
  public void printStack() {
    DLLStack.printList();

  }
}
