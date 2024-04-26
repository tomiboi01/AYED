package prac1;
import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Secuence<T>{
     List<T> data;

    public Queue(){
        data = new ArrayList<T>();
    }
    
    public void enqueue(T dato) {
        data.add(dato);
        }
       
    public T dequeue(){
        if (!isEmpty())
            return data.remove(0);
        return null;
    }
    public T head() {
        if (!isEmpty())
            return data.get(0);
        else return null;
        } 

        @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.size()==0;
    }

    @Override
    public String toString() {
        String str = "[";
        for(T d: data)
        str = str + d +", ";
        str = str.substring(0, str.length()-2)+"]";
        return str;
    }
}


