package astron.dc;

import java.util.Map;
import java.util.HashMap;

/**
 * A wire-packable Distributed Type
 *
 * @author jjkoletar
 */
public abstract class DType {

    public static class InvalidType extends DType {
        private InvalidType() {}
        public FundamentalType getFundamentalType() {
            return FundamentalType.INVALID;
        }
    }
    public static final InvalidType INVALID_TYPE = new InvalidType();

    protected String _alias = null;
    protected int _id = -1;
    protected int _size = 0;

    /**
     * Return the fundamental type that this DType can be described as
     * @return this DType's fundamental type
     */
    public abstract FundamentalType getFundamentalType();

    /**
     * Whether or not this DType has a fixed size on the wire
     * @return {@code true} if the type has a fixed size
     */
    public boolean hasFixedSize() {
        return _size != 0;
    }

    /**
     * The size of this DType, on the wire, in bytes.
     * @return The number of bytes this type occupies on the wire, or
     *         {@code 0} if this type has a variable size that must be
     *         determined from the wire.
     */
    public int getSize() {
        return _size;
    }

    /**
     * Whether or not this DType was defined using an alias, like a typedef.
     * @return {@code true} if this type was defined using an alias
     */
    public boolean hasAlias() {
        return _alias != null;
    }

    /**
     * @return the alias of this DType, or {@code null} if this has no alias
     */
    public String getAlias() {
        return _alias;
    }

    /**
     * Set the alias of this DType
     * @param alias the alias to set
     */
    public void setAlias(final String alias) {
        _alias = alias;
    }

    /**
     * Whether or not this DType was assigned an id.
     * @return {@code true} if this type was assigned an id.
     */
    public boolean hasId() {
        return _id != -1;
    }

    /**
     * @return the id of this DType, or {@code -1} if this has no id
     */
    public int getId() {
        return _id;
    }

    /**
     * Set the id of this DType
     * @param id the id to set
     */
    public void setId(int id) {
        _id = id;
    }

}
