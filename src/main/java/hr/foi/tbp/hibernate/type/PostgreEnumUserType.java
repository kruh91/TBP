package hr.foi.tbp.hibernate.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public abstract class PostgreEnumUserType<E extends Enum<E>> implements UserType {

	private Class<E> enumClass;

	public PostgreEnumUserType(Class<E> enumClass){
	    super();
	    this.enumClass = enumClass;
	}

	@Override
	public Class<E> returnedClass() {
	    return enumClass;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
	    return x==y;
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
	    return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
	    String name = rs.getString(names[0]);
	    return rs.wasNull() ? null: Enum.valueOf(enumClass,name);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
	    if (value == null) {
	        st.setNull(index, Types.OTHER);
	    }
	    else {
	    	st.setObject(index,((Enum<E>) value), Types.OTHER);
	    }
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
	    return value;
	}

	@Override
	public boolean isMutable() {
	    return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@SuppressWarnings("unchecked")
	@Override
	public Serializable disassemble(Object value) throws HibernateException {
	    return (Enum<E>) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
	    return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
	    return original;
	}
}
