import java.io.*;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        int virus, min = Integer.MAX_VALUE, count = 0, s1;
        try{
            FileReader reader = new FileReader("results.txt");
            int c;
            while ((c = reader.read()) != -1)
            {
                if(c < min){
                    min=c;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        virus = (int) (Math.random() * 100 + 1);
        //System.out.println(virus);
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Угадай число, братанчик");
        for ( s1 = 0 ; s1 != virus; ) {
            s = scanner.next();
            if(s.equals("result")){
                System.out.println("Текущая попытка: " + count + "\nЛучшая попытка: " + min);

            } else{
                s1 = Integer.parseInt(s.trim());
                if (virus > s1) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                } else if (virus < s1) {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                }
                count++;
            }
        }
        System.out.println("Емае, угадал, количество попыток: " + count);
        try {
            FileWriter writer = new FileWriter("results.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(count);
            bw.close();
        } catch (IOException e){
            System.out.println(e);
        }

    }
}
