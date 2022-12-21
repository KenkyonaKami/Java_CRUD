
package listProductos;

import java.util.LinkedList;


public class ListaGenerica<E>{

    private final LinkedList<E> list;
    
    public ListaGenerica(){
        list = new LinkedList<>();
    }
    
    public void push(E item){
        list.addLast(item);
    }
    public E pull() {
        return list.removeFirst();
    }
    public int size() {
        return list.size();
    }
    public LinkedList<E> getList(){
        return list;
    }
    public void clearList(){
        list.clear();
    }
}
