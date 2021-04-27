/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ej11_ismael;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author ismae
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException, IOException {
        ServicioFicheroTSV tsv= new ServicioFicheroTSV();
        ServicioFicheroXML xml= new ServicioFicheroXML();
        ArrayList<App> lista = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            lista.add(new App());
        }
        for (App app : lista) {
            System.out.println(app.toString());
        }
        crearDirectorio("./appstsv");
        crearDirectorio("./appsxml");
        crearDirectorio("./appsjson");
        crearDirectorio("./copias");
        crearDirectorio("./aplicaciones");
//        xml.generarFicheroXML("./appsxml/aplicaciones.xml", lista);
        tsv.generarFichero("./appstsv/aplicaciones.tsv", lista);
        ServicioFicheroJSON.escribirJSON("./appsjson/aplicaciones.json", lista);
    }

    public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }
}
