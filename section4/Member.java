//회원 객체
//hello/hello_spring/domain/Member.java

package hello.hello_spring.domain;

public class Member {

    private Long id;
    private String name;

    public Long getId() { //getter, setter 만들기
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
