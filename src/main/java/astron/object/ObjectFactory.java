package astron.object;

import java.util.HashMap;
import java.util.Map;

import astron.client.AstronClientRepository;

/**
 * @author chandler14362
 */
public final class ObjectFactory {

    private final AstronClientRepository _cr;

    private final Map<Integer, IDistributedObject> _doId2do = new HashMap<Integer, IDistributedObject>();

    public ObjectFactory(final AstronClientRepository cr) {
        _cr = cr;
    }

    public IDistributedObject getDo(final int doId) {
        return _doId2do.get(doId);
    }

    public IDistributedObject requestObject(final int doId, final String name) {
        return null;
        /* TODO
        // First, we need to get the DClass
        DClass dclass = _cr.getDcFile().getDClass(name);

        // Now, we can load in the object
        try {

            // Look up the class
            Class<?> doclass = Class.forName(_cr.getDcFile().lookupImport(dclass));

            IDistributedObject dobject;

            try {

                // Cast the class as a IDistributedObject
                dobject = (IDistributedObject) doclass.newInstance();

                // Set some needed variables
                dobject.setCR(_cr);
                dobject.setDoId(doId);
                dobject.setDClass(dclass);

                // Add it to the doId2do
                _doId2do.put(doId, dobject);

                // We are done, return the new IDistributedObject
                return dobject;

            } catch (InstantiationException e) {

                e.printStackTrace();

            } catch (IllegalAccessException e) {

                e.printStackTrace();

            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return null;
        */
    }

}
