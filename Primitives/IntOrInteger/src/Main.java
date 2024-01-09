public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

//        for (int i = 0; i < 65536; i++) {
//            char c = (char) i;
//            System.out.println(i + " - " + c);
//        }

        //Russian alphabet
        for (int i = 1040; i < 1104; i++) {
            char r = (char) i;
            System.out.println(i + " - " + r);

        }
        System.out.println("1105 - " + (char) 1105); // ё
        System.out.println("1025 - " + (char) 1025); // Ё





    }
}
