package org.example;

import java.time.LocalDate;

public class Member {
    private String memberName;

    private Integer memberAge;

    private String email;

    private LocalDate birthday;

    public Member(){}

    public Member(String memberName, Integer memberAge, String email, LocalDate birthday) {
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.email = email;
        this.birthday = birthday;
    }


    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(Integer memberAge) {
        this.memberAge = memberAge;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
