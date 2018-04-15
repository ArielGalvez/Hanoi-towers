package modelo;
import java.util.ArrayList;

import VistaYControlador.ImagenDisco;

public class Modelo {

    /**
     * @param args
     */
    private static int cantMovimientos=0;;
    private static int cantDiscos=1;
    private static String mensaje="";
    private static Pila<Integer> a=new Pila<Integer>();
    private static Pila<Integer> b=new Pila<Integer>();
    private static Pila<Integer> c=new Pila<Integer>();
    public Pila<Integer> getPA(){
    	return a;
    }
    public Pila<Integer> getPB(){
    	return b;
    }
    public Pila<Integer> getPC(){
    	return c;
    }
    public int getCantMovimientos(){
    	return cantMovimientos;
    }
    public int getCantMovOptimo(){
    	return (int)(Math.pow(2, cantDiscos-1)-1);
    }
    public int getCantDicos(){
    	return cantDiscos;
    }
    
    public Modelo(int cant){
        //cantMovimientos = 0;
        //cantDiscos = 1;
        a.push(100);
        b.push(100);
        c.push(100);
        int disco=cant;
        while(cantDiscos<=cant){
            a.push(disco);
            disco--;
            cantDiscos++;
        }
        //b.push(10);
        //c.push(10);
    }
    
    public void moverDeA(Pila<Integer> p1, Pila<Integer> p2){
        if(p1.top() < p2.top()){
            p2.push(p1.pop());
            cantMovimientos++;
        }
        else
            mensaje = "El disco es mas grande que donde desea poner";
    }
   
    public void printA(){
        System.out.println("torre A"); 
        Pila <Integer> aux=new Pila<Integer>();
        Pila <Integer> aux2=new Pila<Integer>();
        while(!a.vacia()){
            int aA=a.pop();
            System.out.print(aA+" ");
            aux.push(aA);
        }
        while(!aux.vacia()){
            aux2.push(aux.pop());
        }
        a=aux2;
        System.out.println();
    }
    public void printB(){
        System.out.println("torre B"); 
        Pila <Integer> auxB=new Pila<Integer>();
        Pila <Integer> aux2B=new Pila<Integer>();
        while(!b.vacia()){
            int aB=b.pop();
            System.out.print(aB+" ");
            auxB.push(aB);
        }
        while(!auxB.vacia()){
            aux2B.push(auxB.pop());
        }
        b=aux2B;
        System.out.println();
    }
    public void printC(){
        System.out.println("torre C"); 
        Pila <Integer> auxC=new Pila<Integer>();
        Pila <Integer> aux2C=new Pila<Integer>();
        while(!c.vacia()){
            int aC=c.pop();
            System.out.print(aC+" ");
            auxC.push(aC);
        }
        while(!auxC.vacia()){
            aux2C.push(auxC.pop());
        }
        c=aux2C;
        System.out.println();
    }
    /**/
    
    public ArrayList<Integer> getA(){
    	ArrayList<Integer> arrayA= new ArrayList<Integer>();
        Pila <Integer> aux=new Pila<Integer>();
        Pila <Integer> aux2=new Pila<Integer>();
        while(!a.vacia()){
            int aA=a.pop();
            arrayA.add(aA);
            aux.push(aA);
        }
        while(!aux.vacia()){
            aux2.push(aux.pop());
        }
        a=aux2;
        return arrayA;
    }
    public ArrayList<Integer> getB(){
    	ArrayList<Integer> arrayB= new ArrayList<Integer>(); 
        Pila <Integer> auxB=new Pila<Integer>();
        Pila <Integer> aux2B=new Pila<Integer>();
        while(!b.vacia()){
            int aB=b.pop();
            arrayB.add(aB);
            auxB.push(aB);
        }
        while(!auxB.vacia()){
            aux2B.push(auxB.pop());
        }
        b=aux2B;
        return arrayB;
    }
    public ArrayList<Integer> getC(){
    	ArrayList<Integer> arrayC= new ArrayList<Integer>(); 
        Pila <Integer> auxC=new Pila<Integer>();
        Pila <Integer> aux2C=new Pila<Integer>();
        while(!c.vacia()){
            int aC=c.pop();
            arrayC.add(aC);
            auxC.push(aC);
        }
        while(!auxC.vacia()){
            aux2C.push(auxC.pop());
        }
        c=aux2C;
        return arrayC;
    }
    
    public void print(ArrayList<Integer> a){
		for(int i=a.size()-1;i>=0;i--){
			int referencia=a.get(i);
			System.out.println(referencia+" ");
		}
    }
    public void algoritmoHanoi(int n, char origen, char temporal, char destino) {
        if (n == 0) {
            return;
        }
        algoritmoHanoi(n - 1, origen, destino, temporal);
        System.out.println(" Mover de la torre " + origen + " a la torre " + destino + ".");
        algoritmoHanoi(n - 1, temporal, origen, destino);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Modelo m= new Modelo(5);
        m.printA();
        m.printB();
        m.printC();
        /*m.moverDeA(a,b);
        m.moverDeA(a,c);
        m.moverDeA(b,c);
        m.moverDeA(b,c);
        System.out.println();
        m.printA();
        m.printB();
        m.printC();*/
        System.out.println();
        m.print(m.getA());
        System.out.println();
        m.print(m.getB());
        System.out.println();
        m.print(m.getC());
        m.algoritmoHanoi(4,'A','B','C');
    }
}
