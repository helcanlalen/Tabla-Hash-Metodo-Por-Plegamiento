/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Referencia de https://www.youtube.com/watch?v=1_TVkiVaFgM
 */
package tablahash;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hellen
 */
public class TablaHash {

    private NodoHash[] vectorHash;
    private int tamaño;
    private static int[] tamaños;
    private int indiceTam;
    private int ocupados;
    private float porcentajeUtil;
    private float factorUtil;

    public TablaHash() {
        this.tamaños = new int[]{23, 46, 92, 184, 368, 736, 1472};
        this.indiceTam = 0;
        this.ocupados = 0;
        this.factorUtil = 80.0f;
        this.tamaño = tamaños[indiceTam];
        this.vectorHash = new NodoHash[tamaño];
        this.porcentajeUtil = calcularPorcentajeUtil();
    }

    private float calcularPorcentajeUtil() {
        return ((this.ocupados * 100) / this.tamaño);
    }

    //Funcion hash por metodo de plegamiento
    private int plegamiento(String nombre) {
        int clave = generarClave(nombre);
        int codigo = clave % this.tamaño;
        System.out.println("Nombre: " + nombre + " su codigoAscii es: " + clave
                + " y " + clave + "%" + this.tamaño + " = " + codigo);

        if (codigo < this.tamaño) {
            return (codigo);
        } else {
            System.out.println(nombre + " se redujo a la mitad");
            return (codigo / 2);
        }
    }

    //CodePointAt(i) -> Devuelve el código ASCII en la posición 'index' pasada por parámetro.
    private int generarClave(String nombre) {
        int codigo = 0;
        for (int i = 0; i < nombre.length(); i++) {
            codigo += nombre.codePointAt(i);
        }

        return codigo;
    }

    private int reduccion(String nombre, int codigo) {
        int temporal = 0;
        boolean condicion = false;
        String newNombre = "";
        if (codigo > this.tamaño) {
            while (codigo > this.tamaño && condicion == false) {
                if (codigo > this.tamaño) {
                    newNombre = "";
                    for (int i = 0; i < nombre.length() / 2; i++) {
                        newNombre += nombre.charAt(i);
                    }
                } else {
                    condicion = true;
                }
            }
        }
        return codigo;
    }

    public void insertar(String carnet, String nombre, String email) {
        //if (getEstudiante(carnet) == null) {
            boolean insertado = false;
            int posicion = 0;
            if (this.porcentajeUtil <= 80.00f) {
                posicion = plegamiento(nombre);
                if (vectorHash[posicion] == null) {
                    vectorHash[posicion] = new NodoHash(carnet, nombre, email, ocupados + 1);
                    ocupados += 1;
                    porcentajeUtil = calcularPorcentajeUtil();
                    insertado = true;
                } else {
                //Colisiones por medio de listas
                    //Aqui agrego a la lista
                    NodoHash nuevo = new NodoHash(carnet, nombre, email, (ocupados + 1));
                    vectorHash[posicion].getListaEstudiantes().insertar(new NodoLista(nuevo));
                    ocupados += 1;
                    porcentajeUtil = calcularPorcentajeUtil();
                    insertado = true;
                }

                if (insertado == true) {
                    System.out.println("Insertado correctamente");
                } else {
                    System.out.println("No se pudo insertar el dato: " + nombre + " en la posicion " + posicion);
                }
            } else {
                System.out.println("**********************************Haciendo Rehashing -> Porcentaje de utilidad " + porcentajeUtil + "********************************************");
                rehashing();
                insertar(carnet, nombre, email);
            }
        //} else {
        //    System.out.println("Carnet ya asignado anteriormente");
        //}
    }

    public void rehashing() {
        //Aqui guardo los elementos que ya estan insertados
        NodoHash[] temporal = vectorHash;
        int tamañoTemporal = tamaño;
        if (indiceTam < tamaños.length) {
            indiceTam += 1;
            if (indiceTam == tamaños.length - 1) {
                System.out.println("AVISO: Se alcanzo el maximo del Arreglo Hash");
            }

        }
        tamaño = tamaños[indiceTam];
        vectorHash = new NodoHash[tamaño];
        ocupados = 0;
        porcentajeUtil = calcularPorcentajeUtil();

        for (int i = 0; i < tamañoTemporal; i++) {
            if (temporal[i] != null) {
                insertar(temporal[i].getCarnet(), temporal[i].getNombre(), temporal[i].getEmail());
            }
        }
        System.out.println("Rehashing Realizado Correctamente");
    }

    public NodoHash getEstudiante(String carnet) {
        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                if (vectorHash[j].getCarnet().equalsIgnoreCase(carnet)) {
                    return vectorHash[j];
                }
                if (vectorHash[j].getListaEstudiantes() != null) {
                    NodoLista aux = vectorHash[j].getListaEstudiantes().getPrimero();
                    while (aux != null) {
                        if (aux.getNodoHash().getCarnet().equalsIgnoreCase(carnet)) {
                            return aux.getNodoHash();
                        }
                        aux = aux.getSiguiente();
                    }
                }
            }
        }
        return null;
    }

    public String graficarTH() throws IOException {
        int u = vectorHash.length - 1;
        StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
        b.append("node0 [label = \"");

        for (int j = 0; j < vectorHash.length - 1; j++) {
            b.append("<f" + j + ">" + j + "|");
        }

        b.append("<f" + u + ">" + u + "\"" + ",height=2.5];\n");
        b.append("node [width = 1.5];\n");

        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                b.append("node" + vectorHash[j].hashCode() + "[label = \"{<n> " + vectorHash[j].getNombre() + "}\"];\n");
                if (vectorHash[j].getListaEstudiantes() != null) {
                    NodoLista aux = vectorHash[j].getListaEstudiantes().getPrimero();
                    while (aux != null) {
                        b.append("node" + aux.hashCode() + "[label = \"{<n> " + aux.getNodoHash().getNombre() + "}\"];\n");
                        aux = aux.getSiguiente();
                    }
                }
            } else {
            }
        }

        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                b.append("node0:f" + j + "->" + "node" + vectorHash[j].hashCode() + ":n;\n");
                if (vectorHash[j].getListaEstudiantes() != null) {
                    NodoLista aux = vectorHash[j].getListaEstudiantes().getPrimero();
                    if (aux != null) {
                        b.append("node" + vectorHash[j].hashCode() + "-> " + "node" + aux.hashCode() + ";\n");
                        while (aux.getSiguiente() != null) {
                            b.append("node" + aux.hashCode() + " -> " + "node" + aux.getSiguiente().hashCode() + ";\n");

                            aux = aux.getSiguiente();
                        }
                    }

                }
            }
        }
        b.append("\n}");
        return b.toString();
    }

    public void crearDot(String pInput, String pOutput) {
        try {

            String dotPath
                    = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = pInput;
            String fileOutputPath = pOutput;

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

        try {
            String[] cmd = new String[4];
            cmd[0] = "cmd";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = pOutput;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

}
