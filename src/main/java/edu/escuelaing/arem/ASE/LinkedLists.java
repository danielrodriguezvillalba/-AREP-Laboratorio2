/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE;

import java.util.ArrayList;



/**
 * Clase LinkedList
 * @author 2115253
 */
public class LinkedLists {
    private Nodo head, tail;
    private int longitud;

    /**
     * Constructor de la clase LinkedList
     */
    public LinkedLists() {
        longitud = 0;
    }
    
    /**
     * Metodo que agregar un nodo nuevo al final de la LinkedLists 
     * @param dato Entero que se va a guardar dentro del nodo
     */
    public void agregarNodo( double dato ) {
        Nodo temporal = new Nodo(dato);
        if(longitud == 0){
            head = temporal;
            tail = temporal;
        }
        else{
            tail.addNext(temporal);
            tail = temporal;
        }
        longitud++;
    }
    
    /**
     * Metodo que elimina el ultimo nodo de la LinkedList 
     * @throws LinkedListException 
     */
    public void eliminarNodo() throws LinkedListException{
        if(longitud == 1){
            tail = null;
            head = null;
        }
        else if(longitud == 0){
            throw new LinkedListException("Lista vacia, no se puede eliminar nada");
        }
        else{
            
            Nodo fin = getElemento(longitud-1);
            tail = fin;
            fin.addNext(null);
        }
        longitud--;
    }
    
    /**
     * Metodo que retorna la longitud de la LinkedList
     * @return 
     */
    public int cantidad(){
        return longitud;
    }
    
    /**
     * Metodo que retorna un elemento dada su posicion en la LinkedList
     * @param pos Posicion en la que se encuenta el nodo a retonar
     * @return Nodo ubicado en la posicion dada en la LinkedList
     * @throws LinkedListException 
     */
    public Nodo getElemento( int pos ) throws LinkedListException{
        if (pos == 0){
            return head;
        }
        else if (pos < longitud){
            Nodo temp = head;
            for(int i=0; i< pos ;i++){
                temp = temp.getNext();
            }
            return temp;
        }
        else{
            throw new LinkedListException("Esta pidiendo un numero fuera de la Lista");
        }
        
    }
}