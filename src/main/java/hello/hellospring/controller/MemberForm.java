package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() { //setName을 통해 담긴 값을 반환해줌
        return name;
    }

    public void setName(String name) { //외부에서 호출하면 name 값이 담김
        this.name = name;
    }
}
