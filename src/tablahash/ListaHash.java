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
public class ListaHash {

    private NodoLista primero;
    private NodoLista ultimo;
    private int size;

    public ListaHash() {
        this.primero = null;
        this.ultimo = null;
        size = 0;
    }

    public NodoLista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insertar(NodoLista nuevo) {
        if (getPrimero() == null) {
            setPrimero(nuevo);
            setUltimo(nuevo);
            setSize(getSize() + 1);
        } else {
            getUltimo().setSiguiente(nuevo);
            nuevo.setAnterior(getUltimo());
            setUltimo(nuevo);
            setSize(getSize() + 1);
        }
    }
}
