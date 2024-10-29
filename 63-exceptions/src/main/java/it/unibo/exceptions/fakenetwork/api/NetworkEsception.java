package it.unibo.exceptions.fakenetwork.api;
import java.io.IOException;
public class NetworkEsception extends IOException {
    public NetworkEsception(){
        super("Network error: no response");
    }

    public NetworkEsception(String message){
        super("Network error while sending message: " + message);
    }
    
}
