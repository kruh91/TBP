package hr.foi.tbp.hibernate;

import java.sql.Types;
import org.hibernate.dialect.PostgreSQL94Dialect;
 
public class CustomPostgreSqlDialect extends PostgreSQL94Dialect {
 
    public CustomPostgreSqlDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "address");
        this.registerColumnType(25000, "customer_type");
    }
}