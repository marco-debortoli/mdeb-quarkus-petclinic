package org.quarkus.samples.petclinic.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.quarkus.samples.petclinic.model.Person;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@Table(name = "users")
@UserDefinition 
public class User extends Person {
    @Username 
    public String username;
    @Password 
    public String password;
    @Roles 
    public String role;

    /**
     * Adds a new user in the database
     * @param username the user name
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role the comma-separated roles
     */
    public static void add(String firstName, String lastName, String username, String password, String role) { 
        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persist();
    }
}
