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

package Component;

import Model.Cell;
import Model.GameTable;

import java.util.Scanner;

public class PlayerMove {
    int[][] gameMaket = new int[][]{
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    public void make(GameTable gameTable) {

        while (true) {
            final Cell cell = getUserinput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, 'X');
                return;
            } else {
                System.out.println("Ячейка занята");
            }
        }
    }

    private Cell getUserinput() {
        String step = new Scanner(System.in).nextLine();
        while (true) {
            if (step.length() == 1) {
                int userStep = Integer.parseInt(step);
                if (userStep != 0) {
                    for (int i = 0; i < gameMaket.length; i++) {
                        for (int j = 0; j < gameMaket[i].length; j++) {
                            if (userStep == gameMaket[i][j]) {
                                return new Cell(i, j);
                            }
                        }

                    }
                } else System.out.println("Введите число от 1 до 9");
            } else System.out.println("Введите число от 1 до 9");
        }
    }


}
