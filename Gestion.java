import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Gestion<T>{

    private TreeSet<T> listElementos;


    //CONSTRUCTOR
    public Gestion() {
        this.listElementos = new TreeSet<>();
    }


    //AGREGAR ELEMENTO AL TREESET
    public void agregar(T elemento){

        if(!listElementos.add(elemento)){

            throw new IllegalArgumentException("El elemento ya existe");
        }
    }

    //ELIMINAR ELEMENTO
    public void eliminar(T elemento){

        if(!listElementos.remove(elemento)){

            throw new NoSuchElementException("Ese elemento no existe");

        }
    }

    public T buscar(T elemento){

        for (T t : listElementos) {
            if(t.equals(elemento)){

                return t;
            }
        }

        throw new NoSuchElementException("El elemento no fue encontrado");
    }


    public TreeSet<T> getListaElementos(){

        return listElementos;
    }





}
