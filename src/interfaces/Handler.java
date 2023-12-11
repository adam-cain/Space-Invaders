package interfaces;

public interface Handler<T> {
    Handler<T> getNext();
    void setNext(Handler<T> next);
    void handleRequest(T input);
}