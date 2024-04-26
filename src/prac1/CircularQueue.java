package prac1;

public class CircularQueue<T> extends Queue<T>{


    public T shift(){
        if (!isEmpty())
        {
            T aux = (T)head();
            enqueue(dequeue());
            return aux;
        }
        return null;
    }



}
