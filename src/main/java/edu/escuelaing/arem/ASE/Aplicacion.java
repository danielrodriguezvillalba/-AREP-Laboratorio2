/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE;

/**
 * Clase que maneja las operaciones generales
 * @author 2115253
 */
public class Aplicacion {
    LinkedLists lista ;

    /**
     * Constructor de la clase aplicación 
     */
    public Aplicacion() {
        lista = new LinkedLists();
    }
    
    /**
     * Metodo con el que se agregan elementos en la ultima posicion de la LinkedList
     * @param dato 
     */
    public void agregarElemento( double dato ) {
        lista.agregarNodo(dato);
    }
    
    /**
     * Metodo con el que se elimina el ultimo elemento de la LinkedList
     * @throws LinkedListException 
     */
    public void eliminarElemento( ) throws LinkedListException{
        lista.eliminarNodo();
    }
    
    /**
     * Metodo que calcula la media de los valores alojados en la LinkedList
     * @return Valor Double que representa la media de los valores de la LinkedList
     * @throws LinkedListException 
     */
    public double media() throws LinkedListException{
        double med = 0;
        if(lista.cantidad() == 0){
            throw new LinkedListException("Lista vacia para sacar la media");
        }
        else{
            for(int i=0 ;i<lista.cantidad() ; i++){
                med += lista.getElemento(i).getDato();
            }
        }
        med = med/lista.cantidad();
        return med;
    }
    
    /**
     * Metodo que calcula la desviaciòn estandar de los valores alojados en la LinkedList
     * @return Valor Double que representa la desviaciín estandar de los valores de la LinkedList
     * @throws LinkedListException 
     */
    public double desviacionEstandar() throws LinkedListException{
        double med = media();
        double desvEst = 0;
        for(int i=0 ;i<lista.cantidad() ; i++){
            desvEst += Math.pow(Math.abs(lista.getElemento(i).getDato()-med),2);
        }
        desvEst = desvEst/(lista.cantidad()-1);
        desvEst = Math.pow(desvEst,0.5);
        System.out.println("Dato " + desvEst);
        return desvEst;
    }
}
