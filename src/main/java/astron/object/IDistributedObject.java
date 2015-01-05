package main.java.astron.object;

import main.java.astron.connection.AstronClientRepository;
import main.java.astron.dc.DClass;

public interface IDistributedObject {

    public void setDoId(int doId);
    public int getDoId();

    public void setCR(AstronClientRepository cr);
    public AstronClientRepository getCR();

    public void setDClass(DClass dclass);
    public DClass getDClass();

    public void sendUpdate(String fieldName, Object... args);
    public void sendUpdate(String fieldName);

}
