package persistence;

public class LeilaoDAOException extends Exception {

    
    public LeilaoDAOException() {
    }
    
    public LeilaoDAOException(String msg) { 
        super(msg);
    }

    public LeilaoDAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}