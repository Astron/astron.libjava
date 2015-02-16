package astron.object;

import astron.client.AstronClientRepository;
import astron.dc.Class;

/**
 * @author chandler14362
 */
public interface IDistributedObject {

    public void setDoId(final int doId);
    public int getDoId();

    public void setCR(final AstronClientRepository cr);
    public AstronClientRepository getCR();

    public void setDClass(final Class dclass);
    public Class getDClass();

    public void sendUpdate(final String fieldName, final Object... args);
    public void sendUpdate(final String fieldName);

    public void sendUpdate(final int fieldId, final Object... args);
    public void sendUpdate(final int fieldId);

}
