import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String fio;
    private int age;
    private String email;
    private LocalDate data_birth;

    public Client(String fio, String email, LocalDate data_birth) {
        this.fio = fio;
        this.email = email;
        this.data_birth = data_birth;
        this.age = Period.between(data_birth, LocalDate.now()).getYears();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_birth() {
        return data_birth;
    }

    public void setData_birth(LocalDate data_birth) {
        this.data_birth = data_birth;
    }

    @Override
    public String toString() {
        return "клиент{" +
                "ФИО='" + fio + '\'' +
                ", возраст=" + age +
                ", почта='" + email + '\'' +
                ", дата рожения=" + data_birth +
                '}';
    }
}
