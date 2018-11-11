/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

/**
 *
 * @author Hellen
 */
public class NodoLista {
    private NodoLista siguiente;
    private NodoLista anterior;
    private NodoHash nodoHash;
    
    public NodoLista(NodoHash nuevo){
        siguiente=null;
        anterior=null;
        this.nodoHash=nuevo;
    }
    
    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLista anterior) {
        this.anterior = anterior;
    }

    public NodoHash getNodoHash() {
        return nodoHash;
    }

    public void setNodoHash(NodoHash nodoHash) {
        this.nodoHash = nodoHash;
    }
}
