package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.impl.DoublyNode;

public class DoublyLinkedList<E> implements List<E> {

  protected DoublyNode<E> header;
  protected DoublyNode<E> trailer;
  protected int size = 0;

  public DoublyLinkedList() {
    header = new DoublyNode<>(null, null, null);
    trailer = new DoublyNode<>(null,header,null);
    header.setNext(trailer);
  }

  @Override
  public E first() {
    if(isEmpty()){
      return null;
    }

    return header.getNext().getElement();
  }

  @Override
  public E last() {
    if(isEmpty()){
      return null;
    }
    return trailer.getPrev().getElement();
  }

  @Override
  public void addLast(E element) {
    if(element == null) {
      return;
    }
    DoublyNode<E> newnode = new DoublyNode<>(element, null,null);
    newnode.setPrev(trailer.getPrev());
    newnode.setNext(trailer);
    trailer.getPrev().setNext(newnode);
    trailer.setPrev(newnode);
    size++;

    }




  @Override
  public void addFirst(E element) {
      if(element == null){
        return;
      }
      DoublyNode<E> newnode = new DoublyNode<>(element, null,null);
      newnode.setPrev(header);
      newnode.setNext(header.getNext());
      header.setNext(newnode);
      newnode.getNext().setPrev(newnode);
      size++;
  }

  @Override
  public E removeFirst() {
    if(isEmpty()){
      return null;
    }

    DoublyNode<E> temp = header.getNext();
    //System.out.println(temp.getElement() + " gggg");
    header.setNext(temp.getNext());
    temp.getNext().setPrev(header);
    temp.setNext(null);
    temp.setPrev(null);
    size--;

    return temp.getElement();
  }

  @Override
  public E removeLast() {
    if(isEmpty()){
      return null;
    }

    DoublyNode<E> temp = trailer.getPrev();
    trailer.setPrev(temp.getPrev());
    temp.getPrev().setNext(trailer);
    temp.setPrev(null);
    temp.setNext(null);
    size--;
    return temp.getElement();
  }

  @Override
  public void insert(E element, int index) {
    if(element == null || index < 0 ){
      return;
    }
    else {
      if (index == 0) {
        addFirst(element);
        return;
      } else if (index >= size()) {
        addLast(element);
        return;
      }
      DoublyNode<E> firstNode = header.getNext();
      for(int i =0; i<index-1; i++){
        firstNode = firstNode.getNext();
      }
      DoublyNode<E> newNode = new DoublyNode<>(element,null,null);
      newNode.setNext(firstNode.getNext());
      newNode.setPrev(firstNode);
      firstNode.getNext().setPrev(newNode);
      firstNode.setNext(newNode);

      size++;

    }


  }



  @Override
  public E remove(int index) {
    if(index < 0 || index >= size()){
      return null;
    }
    else{
     DoublyNode<E> temp = header.getNext();
     for(int i = 0; i<index; i++){
       temp = temp.getNext();
     }
     temp.setPrev(null);
     temp.setNext(null);

     size--;
     return temp.getElement();

    }


  }

  @Override
  public E get(int index) {
    if (index >= size() || index < 0 ) {
      return null;
    }
    DoublyNode<E> temp = header.getNext();
    for(int i = 0; i<index; i++){
      temp = temp.getNext();
    }
    return temp.getElement();
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {

    return size()==0;
  }


  @Override
  public void printList() {
    for(int i = 0; i <size(); i++)

      System.out.println(get(i));

  }
}
