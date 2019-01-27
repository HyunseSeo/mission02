package edu.isu.cs.cs3308.structures.impl;

public class DoublyNode<E> {
  private E element;
  private DoublyNode<E> prev;
  private DoublyNode<E> next;

  public DoublyNode(E e, DoublyNode<E>p, DoublyNode<E> n){
    element = e;
    prev = p;
    next = n;
  }

  public E getElement(){return element;}
  public DoublyNode<E> getPrev(){return prev;}
  public DoublyNode<E> getNext(){return next;}
  public void setPrev(DoublyNode<E> p){prev = p;}
  public void setNext(DoublyNode<E> n){next = n;}

}
