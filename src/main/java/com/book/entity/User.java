package com.book.entity;

import com.book.annotation.UniqueUsername;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "Логин должен состоять как минимум из трех символов")
    @Column(unique = true)
    @UniqueUsername(message = "Выбранное имя пользователя уже существует!")
    private String name;

    @Size(min = 4, message = "Пароль должен состоять как минимум из четырех символов")
    private String password;

    @Size(min = 3, message = "Никнейм должен состоять как минимум из трех символов")
    private String nickName;

    @Email(message = "Неверно введен email")
    private String email;

    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Blog> blogs;

    @ManyToMany
    private List<Book> books;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
