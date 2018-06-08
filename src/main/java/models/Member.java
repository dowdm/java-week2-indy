package models;

import java.util.Objects;

public class Member {
    private int id;
    private String name;

    public Member (String name){
        this.name= name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
