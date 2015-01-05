package astron.object;

import astron.connection.AstronClientRepository;
import astron.dc.DClass;

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
