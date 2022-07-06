/*
 * Copyright [2022] [KrauseV]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacVersionEin {


    public static class ZeroPlusGame {
        public static char[] display = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        public static boolean player = true;
        public static boolean comp = true;
        public static boolean players = false;

        //  public static void main(String[] args) {
        //    Play();
        // }


        public static void Play() {
            //System.out.println("Игра Крестики-Нолики\n");

            MenuPlay();
            Display();
            Playrs();
        }

        private static void MenuPlay() {
            System.out.println("""
                    1 - Игарть вдвоем
                    2 - Играть с компьютером
                    3 - Выход""");
            int x = new Scanner(System.in).nextInt();
            switch (x) {
                case 1 -> {
                    comp = false;
                    player = false;
                    players = true;
                    System.out.println("Игрок против Игрока");

                }
                case 2 -> {
                    comp = true;
                    player = true;
                    players = false;
                    System.out.println("Игрок против Компьютера");
                }
                case 3 -> {
                    System.out.println("Досвидания");
                    System.exit(1);
                }
            }
        }

        private static void Playrs() {
            if (player || players) Player('X');
            else {
                if (comp) CompStep();
                if (!players) Player('O');
            }
        }

        private static void CompStep() {

            Random random = new Random();
            int step = random.nextInt(display.length - 1);
            step += 1;
            char player2 = 'O';

            if (display[4] != ' ')
                while (!CorrectStep(String.valueOf(step))) {
                    step = random.nextInt(display.length - 1);
                    step += 1;
                }

            for (int i = 0; i < display.length - 2; i++) {
                if (display[i] == display[i + 1] && display[i] == 'O' && CorrectStep(String.valueOf(i + 2))) {
                    step = i + 2;
                    Display(String.valueOf(step), player2);
                }
            }
            for (int i = step; i < display.length - 3; i++) {
                if (display[i] == display[i + 2] && display[+1] == 'O' && CorrectStep(String.valueOf(i + 1))) {
                    step = i + 1;
                    player = true;
                    Display(String.valueOf(step), player2);
                }
            }
            if (CorrectStep(String.valueOf(step))) {
                player = true;
                Display(String.valueOf(step), player2);
            }

            player = true;
            Display(String.valueOf(5), player2);
        }

        private static void Player(char play) {
            System.out.println("Ходит " + (play == 'X' ? "Первый" : "Второй") + " игрок");
            String step;
            step = new Scanner(System.in).nextLine();

            while (!CorrectStep(step)) {
                Display();
                step = new Scanner(System.in).nextLine();
                CorrectStep(step);

            }
            if (comp) player = false;
            if (!comp) {
                if (!players) players = true;
                else players = false;
            }
            Display(step, play);

        }

        private static boolean CorrectStep(String step) {
            if (step.equalsIgnoreCase("E")) {
                System.out.println("Досвидания!");
                System.exit(1);
            }
            if (step.length() > 1) return false;

            else {
                char ch = step.charAt(0);

                if (!Character.isDigit(ch) || ch == '0') return false;
                if (display[Integer.parseInt(step) - 1] != ' ') {
                    System.out.println("Этот ход уже сделан, попробуй еще раз!");
                    return false;
                }
                return display[Integer.parseInt(step) - 1] == ' ';

            }
        }

        private static void Display() {
            System.out.println("Введите число от 1 до 9, число соответствует ячейке");
            System.out.println("-------------");
            System.out.println("| 7 | 8 | 9 |");
            System.out.println("-------------");
            System.out.println("| 4 | 5 | 6 |");
            System.out.println("-------------");
            System.out.println("| 1 | 2 | 3 |");
            System.out.println("-------------");

        }

        private static void Display(String step, char player) {
            System.out.println("""
                    -------------
                    | 7 | 8 | 9 |
                    -------------
                    | 4 | 5 | 6 |
                    -------------
                    | 1 | 2 | 3 |
                    -------------""");
            int index = Integer.parseInt(step);
            display[index - 1] = player;
            System.out.println("-------------");
            System.out.println("| " + display[6] + " | " + display[7] + " | " + display[8] + " |");
            System.out.println("-------------");
            System.out.println("| " + display[3] + " | " + display[4] + " | " + display[5] + " |");
            System.out.println("-------------");
            System.out.println("| " + display[0] + " | " + display[1] + " | " + display[2] + " |");
            System.out.println("-------------");
            if (Player1Win() == 'X') {
                System.out.println("Победа Первого Игрока");
                System.exit(123);
            } else if (Player1Win() == 'O') {
                if (comp) System.out.println("Победа Компьютера");
                else System.out.println("Победа Второго Игрока");
                System.exit(123);
            }
            if (Draw()) {
                System.out.println("Ничья");
                System.exit(123);
            }
            Playrs();
        }

        private static boolean Draw() {
            for (char c : display) {
                if (c == ' ') return false;
            }
            return true;
        }


        private static char Player1Win() {

            for (int j = 0; j <= display.length - 2; j += 3) {
                if (display[j] == display[j + 1] && display[j] == display[j + 2]) {
                    if (display[j] == 'X') return 'X';
                    else if (display[j] == 'O') return 'O';
                    else return ' ';
                }
            }
            for (int j = 0; j < 3; j++) {
                if (display[j] == display[j + 3] && display[j] == display[j + 6]) {
                    if (display[j] == 'X') return 'X';
                    else if (display[j] == 'O') return 'O';
                }
            }
            if (display[4] == display[2] && display[4] == display[6]) {
                if (display[4] == 'X') return 'X';
                else if (display[4] == 'O') return 'O';
            }
            if (display[4] == display[0] && display[4] == display[8]) {
                if (display[4] == 'X') return 'X';
                else if (display[4] == 'O') return 'O';
            }
            return ' ';
        }
    }
}


