/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpjlaboratoriofinal;

import co.com.peliculas.negocio.CatalogoPeliculas;
import co.com.peliculas.negocio.CatalogoPeliculasImpl;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        String nombreArchivo;
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        
        while(opcion!=0){
            
            System.out.println("Elige una opcion \n"
                    + "1. Iniciar Catalogo de peliculas \n"
                    + "2. Agregar Pelicula \n"
                    + "3. Listar Pelicula \n"
                    + "4. Buscar Pelicula \n"
                    + "0. Salir ");
            
            opcion = Integer.parseInt(s.nextLine());
            
            switch(opcion){
                case 1:
                    
                    catalogoPeliculas.iniciarArchivo();
                    break;
                    
                case 2: 
                    
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = s.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    
                    break;
                
                case 3:
                    catalogoPeliculas.listarPeliculas();
                    System.out.println("");
                    break;
                    
                case 4:
                    System.out.println("Digite la pelicula que desea buscar");
                    var buscar = s.nextLine();
                    catalogoPeliculas.buscarPelicula(buscar);
                    
                    break;
                    
                case 0: 
                    System.out.println("Gracias.");
                    break;
                    
                default: 
                    System.out.println("Opcion invalida");
            }
        }
        
    }
}
