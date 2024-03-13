import java.time.LocalDate;
import java.util.UUID;

public class bank_card {
    private Client client_bc;
    private String number_cert;
    private LocalDate expiration_date;
    private LocalDate data_issue;

    private static String generateUUIDBased16DigitNumber() {
        UUID uuid = UUID.randomUUID();
        long uuidAsLong = Math.abs(uuid.getMostSignificantBits());
        return String.format("%016d", uuidAsLong).substring(0, 16);
    }

    @Override
    public String toString() {
        return "bank_card{" +
                "client_bc=" + client_bc +
                ", number_cert='" + number_cert + '\'' +
                ", expiration_date=" + expiration_date +
                ", data_issue=" + data_issue +
                '}';
    }

    public bank_card(Client client_bc, int year, int mount, int day) {
        this.client_bc = client_bc;
        this.number_cert = generateUUIDBased16DigitNumber();
        this.data_issue = LocalDate.of(year, mount, day);
        this.expiration_date = LocalDate.of(year + 1, mount, day);
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public LocalDate getData_issue() {
        return data_issue;
    }

    public void setData_issue(LocalDate data_issue) {
        this.data_issue = data_issue;
    }

    public String getNumber_cert() {
        return number_cert;
    }

    public void setNumber_cert(String number_cert) {
        this.number_cert = number_cert;
    }

    public Client getClient_bc() {
        return client_bc;
    }

    public void setClient_bc(Client client_bc) {
        this.client_bc = client_bc;
    }
}
