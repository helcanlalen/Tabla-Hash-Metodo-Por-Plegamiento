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
public class NodoHash {

    private String carnet;
    private String nombre;
    private String email;
    private ListaHash listaEstudiantes;
    //Este Id es para graficar
    private int id;

    public NodoHash(String carnet, String nombre, String email, int id) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.email = email;
        this.id = id;
        listaEstudiantes = new ListaHash();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ListaHash getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ListaHash listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
