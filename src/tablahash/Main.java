/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Hellen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        TablaHash miTabla = new TablaHash();
        miTabla.insertar("201325674", "Hellen", "hellen@gmail.com");
        miTabla.insertar("201325674", "Candelario", "hellen@gmail.com");
        miTabla.insertar("201325674", "Cony", "hellen@gmail.com");
        miTabla.insertar("201325674", "Aroldo", "hellen@gmail.com");
        miTabla.insertar("201325674", "Lidia", "hellen@gmail.com");
        miTabla.insertar("201325674", "Alexandra", "hellen@gmail.com");
        miTabla.insertar("201325674", "Jeanneth", "hellen@gmail.com");
        miTabla.insertar("201325674", "Sandra", "hellen@gmail.com");
        miTabla.insertar("201325674", "Eunice", "hellen@gmail.com");
        miTabla.insertar("201325674", "Lacan", "hellen@gmail.com");
        miTabla.insertar("201325674", "Hernandez", "hellen@gmail.com");
        miTabla.insertar("201325674", "Rafael", "hellen@gmail.com");
        miTabla.insertar("201325674", "Josue", "hellen@gmail.com");
        miTabla.insertar("201325674", "Carlos", "hellen@gmail.com");
        miTabla.insertar("201325674", "Paola", "hellen@gmail.com");
        miTabla.insertar("201325674", "Breynner", "hellen@gmail.com");
        miTabla.insertar("201325674", "Mabilia", "hellen@gmail.com");
        miTabla.insertar("201325674", "Lucio", "hellen@gmail.com");
        miTabla.insertar("201325674", "nelleH", "hellen@gmail.com");
        miTabla.insertar("201325674", "Pablo", "hellen@gmail.com");
        miTabla.insertar("201325674", "Gabriela", "hellen@gmail.com");
        miTabla.insertar("201325674", "Javier", "hellen@gmail.com");
        miTabla.insertar("201325674", "David", "hellen@gmail.com");
        miTabla.insertar("201325674", "Monica", "hellen@gmail.com");
        miTabla.insertar("201325674", "Guisella", "hellen@gmail.com");
        miTabla.insertar("201325674", "Rosa", "hellen@gmail.com");
        miTabla.insertar("201325674", "Mirtala", "hellen@gmail.com");
        miTabla.insertar("201325674", "Jeimmin", "hellen@gmail.com");
        miTabla.insertar("201325674", "Alfredo", "hellen@gmail.com");
        miTabla.insertar("201325674", "Pamela", "hellen@gmail.com");
        miTabla.insertar("201325674", "Daphne", "hellen@gmail.com");
        miTabla.insertar("201325674", "Carmen", "hellen@gmail.com");
        miTabla.insertar("201325674", "Maria", "hellen@gmail.com");
        miTabla.insertar("201325674", "Blanca", "hellen@gmail.com");
        miTabla.insertar("201325674", "Sara", "hellen@gmail.com");
        miTabla.insertar("201325674", "Julio", "hellen@gmail.com");
        miTabla.insertar("201325674", "Mary", "hellen@gmail.com");
        miTabla.insertar("201325674", "Lesvia", "hellen@gmail.com");
        miTabla.insertar("201325674", "Irma", "hellen@gmail.com");
        miTabla.insertar("201325674", "Lucky", "hellen@gmail.com");
        miTabla.insertar("201325674", "Maribel", "hellen@gmail.com");
        miTabla.insertar("201325674", "Herbert", "hellen@gmail.com");
        miTabla.insertar("201325674", "Gilberto", "hellen@gmail.com");
        miTabla.insertar("201325674", "Leticia", "hellen@gmail.com");
        miTabla.insertar("201325674", "Alexa", "hellen@gmail.com");


        String tempFolder = System.getProperty("java.io.tmpdir");
        FileWriter f = new FileWriter(tempFolder + "TablaHash.txt");
        f.write(miTabla.graficarTH());
        f.close();
        miTabla.crearDot(tempFolder + "TablaHash.txt", tempFolder + "TablaHash.jpg");

    }

}
