package modelo;

/**
 * Clase que describe a objetos de la clase pila que pueden contener 
 * objetos de la clase T
 * 
 * @author MLBC
 * @version 2008
 */
public class Pila<T>
{
    private T       tope;
    private Pila<T> base;
    public Pila()
    {
        tope = null;
        base = null;
    }
    public boolean vacia()
    {
        return tope == null;
    }
    public void push(T d)
    {
        if(vacia())
        {
            tope = d;
            base = new Pila<T>();
        }
        else
        {
            Pila<T> aux = new Pila<T>();
            aux.tope    = tope;
            aux.base    = base;
            tope        = d;
            base        = aux;
        }
    }
    public T pop()
    {
        T res;
        if(vacia()) 
            res = null;
        else
        {
            res     = tope;
            tope    = base.tope;
            base    = base.base;
        }
        return res;
    }
    public T top()
    {
        return tope;
    }  
}
