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

    addLast(element);
  }

  @Override
  public E peek() {

    return last();
  }

  @Override
  public E pop() {
    return removeLast();
  }

  @Override
  public int size() {
    return size;
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

      insert(element,i);

    }
  }

  @Override
  public void merge(Stack other) {
    if(other == null){
      return;
    }

    int size = other.size();
    for(int i = 0; i <size; i++){
     E element = ((DoublyLinkedList<E>)other).get(i);
     push(element);
    }
  }

  @Override
  public void printStack() {
    for(int i=size()-1 ; i>=0; i--)

      System.out.println(get(i));



  }
}
