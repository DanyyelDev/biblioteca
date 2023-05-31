/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.biblioteca;

import co.edu.unipiloto.patterns.payaraweb.model.Libro.Libro;
import co.edu.unipiloto.patterns.payaraweb.model.Revista.Revista;
import co.edu.unipiloto.patterns.payaraweb.model.solicitud.TypeSolicitud;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author USUARIO
 */
public class Biblioteca {
    private String nombre;
    private List<Libro> listLibros;
    private List<Revista> listRevistas;

    //Constructor
    public Biblioteca() {
        this.nombre = "Biblioteca UPC";
        this.listLibros = new List<Libro>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Libro> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Libro libro) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Libro> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Libro> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Libro get(int index) {
                return null;
            }

            @Override
            public Libro set(int index, Libro element) {
                return null;
            }

            @Override
            public void add(int index, Libro element) {

            }

            @Override
            public Libro remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Libro> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Libro> listIterator(int index) {
                return null;
            }

            @Override
            public List<Libro> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        this.listRevistas = new List<Revista>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Revista> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Revista revista) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Revista> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Revista> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Revista get(int index) {
                return null;
            }

            @Override
            public Revista set(int index, Revista element) {
                return null;
            }

            @Override
            public void add(int index, Revista element) {

            }

            @Override
            public Revista remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Revista> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Revista> listIterator(int index) {
                return null;
            }

            @Override
            public List<Revista> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }

    public void insertLibro(Libro libro){
        this.listLibros.add(libro);
    }

    public void deleteLibro(Libro libro){
        this.listLibros.remove(libro);
    }

    public void insertRevista(Revista revista){
        this.listRevistas.add(revista);
    }

    public void deleteRevista(Revista revista){
        this.listRevistas.remove(revista);
    }

    //Metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getListLibros(){ return listLibros; }

    public List<Revista> getListRevista(){ return listRevistas; }

    
}
