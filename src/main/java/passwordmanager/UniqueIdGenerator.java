package passwordmanager;

import java.util.UUID;

public class UniqueIdGenerator {
    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
