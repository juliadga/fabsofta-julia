package br.univille.projetofabsoftebooksjulia.entity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
@Entity
public class User {
    @Name
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 1000, nullable = false)
    private String name;
    private String email;
    private int age;
    private String password;
    private List<Book> books = new ArrayList<>();
    private List<PaymentMethod> paymentMethods = new ArrayList<>();
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Book> getBooks() {
        return books;
    }
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }
}