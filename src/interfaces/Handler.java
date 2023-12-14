package interfaces;

/**
 * An interface representing a generic handler in the chain of responsibility pattern.
 * This interface is generic and can be used to handle various types of requests.
 *
 * @param <T> The type of request the handler is responsible for.
 */
public interface Handler<T> {

    /**
     * Gets the next handler in the chain.
     *
     * @return The next handler.
     */
    Handler<T> getNext();

    /**
     * Sets the next handler in the chain.
     *
     * @param next The handler to be set as the next in the chain.
     */
    void setNext(Handler<T> next);

    /**
     * Handles the given request.
     * Implementing classes should provide the logic to handle the specific type of request.
     *
     * @param input The request to be handled.
     * @return true if the request was handled, false otherwise.
     */
    boolean handleRequest(T input); // Now returns a boolean
}
