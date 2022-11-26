/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.peliculas.datos;

import co.com.peliculas.domain.Pelicula;
import co.com.peliculas.exepciones.*;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface AccesoDatos {
    
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx ;
    
    public void escribir(Pelicula pelicula,String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
}
