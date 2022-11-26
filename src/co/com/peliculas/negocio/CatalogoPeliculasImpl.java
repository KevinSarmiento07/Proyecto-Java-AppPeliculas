/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.peliculas.negocio;

import co.com.peliculas.datos.AccesoDatos;
import co.com.peliculas.datos.AccesoDatosImpl;
import co.com.peliculas.domain.Pelicula;
import co.com.peliculas.exepciones.AccesoDatosEx;
import co.com.peliculas.exepciones.LecturaDatosEx;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error de acceso a datos");
        }
        
        
        
    }

    @Override
    public void listarPeliculas() {
        
        try {
            var peliculas = datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("Pelicula: " + pelicula);
                
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error de acceso datos " + ex.getMessage());
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        
        try {
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);
            
           
            } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error al buscar pelicula");
        }
        
        System.out.println("resultado = " + resultado);
        
        
    }

    @Override
    public void iniciarArchivo() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(CatalogoPeliculasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
