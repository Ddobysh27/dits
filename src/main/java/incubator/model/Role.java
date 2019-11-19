package incubator.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Column
    private int user;
    @Column
    private int tutor;
    @Column
    private int admin;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", user=" + user +
                ", tutor=" + tutor +
                ", admin=" + admin +
                '}';
    }

    public Role(int user, int tutor, int admin) {
        this.user = user;
        this.tutor = tutor;
        this.admin = admin;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTutor() {
        return tutor;
    }

    public void setTutor(int tutor) {
        this.tutor = tutor;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
