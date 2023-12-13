package interfaces;

public interface Handler<T> {
    Handler<T> getNext();
    void setNext(Handler<T> next);
    boolean handleRequest(T input); // Now returns a boolean
}