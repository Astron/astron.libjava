package astron.object;

import java.util.HashMap;
import java.util.Map;

import astron.connection.AstronClientRepository;
import astron.dc.DClass;

public final class ObjectFactory {
	
	private final AstronClientRepository cr;
	
	private final Map<Integer, IDistributedObject> doId2do = new HashMap<Integer, IDistributedObject>();
	
	public ObjectFactory(AstronClientRepository cr) {
		this.cr = cr;
	}
	
	public IDistributedObject requestObject(int doId, String name) {
		// First, we need to get the DClass
		DClass dclass = this.cr.getDcFile().getDClass(name);
		
		// Now, we can load in the object
		try {
			
			// Look up the class
			Class<?> doclass = Class.forName(this.cr.getDcFile().lookupImport(dclass));
			
			IDistributedObject dobject;
			
			try {
				
				// Cast the class as a IDistributedObject
				dobject = (IDistributedObject) doclass.newInstance();

				// Set some needed variables
				dobject.setCR(this.cr);
				dobject.setDoId(doId);
				dobject.setDClass(dclass);
				
				// Add it to the doId2do
				this.doId2do.put(doId, dobject);
				
				// We are done, return the new IDistributedObject
				return dobject;
				
			} catch (InstantiationException e) { e.printStackTrace();
			} catch (IllegalAccessException e) { e.printStackTrace(); }
		
		} catch (ClassNotFoundException e) { e.printStackTrace(); }
	
		return null;
	}
	
}
