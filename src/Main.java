import java.time.LocalDate;
import java.util.Random;


public class Main {
    public static boolean isLeapYear(int got){
        return (got % 4 == 0 && got % 100 != 0) || got % 400 == 0;
    }

    public static boolean osnova(int day, int month, int year){
        if (1 <= day && day <= 31 && 1950 <= year && year <= 2300 && 1 <= month && month <= 12) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                return true;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day <= 30) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == 2) {
                if (isLeapYear(year)) {
                    if (day <= 29) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (day <= 28) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public static String generateRandomWord(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < length; i++) {
                char randomChar = (char) (random.nextInt(32) + 'а'); // Генерация случайной буквы от 'a' до 'z'
                sb.append(randomChar);
            }
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int l = 5 + (int)(Math.random() * 20);
        for (int i = 0; i < l; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a'); // Генерация случайной буквы от 'a' до 'z'
            sb.append(randomChar);
        }
        sb.append(".sfedu.ru");
        return sb.toString();
    }

    public static void main(String[] args) {
        int randomNumberClient = 5 + (int)(Math.random() * 15);
        Client[] clients = new Client[randomNumberClient];
        clients[0] = new Client("Руденко Константин Дмитриевич",
                "korudenko@sfedu.ru",
                LocalDate.of(2000, 10, 1));
        for (int i = 1; i < clients.length - 1; i++){
            int randomNumberInRange = 3 + (int)(Math.random() * 20);

            int year = 1950 + (int)(Math.random() * 2010);
            int mount = 1 + (int)(Math.random() * 12);
            int day = 1 + (int)(Math.random() * 31);
            System.out.println(day);
            System.out.println(mount);
            System.out.println(year);
            System.out.println(!osnova(day, mount, year));
            while (osnova(day, mount, year)){
                day = 1 + (int)(Math.random() * 31);
            }
            clients[i] = new Client(generateRandomWord(randomNumberInRange),
                    generateRandomEmail(),
                    LocalDate.of(year, mount, day));
        }
    }
}