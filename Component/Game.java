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

import Model.GameTable;

import java.util.Random;

public class Game {
    private final DataPrinter dataprinter;
    private final ComputerMove computerMove;
    private final PlayerMove playerMove;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;

    public Game(DataPrinter dataprinter,
                ComputerMove computerMove,
                PlayerMove playerMove,
                WinnerVerifier winnerVerifier,
                CellVerifier drowVerifier) {
        this.dataprinter = dataprinter;
        this.computerMove = computerMove;
        this.playerMove = playerMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = drowVerifier;
    }

    public void play() {
        System.out.println("Введите число от 1 до 9, число соответствует ячейке");
        dataprinter.printTableMapping();
        final GameTable gameTable = new GameTable();
        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataprinter.printTableGame(gameTable);
        }
        while (true) {
            playerMove.make(gameTable);
            dataprinter.printTableGame(gameTable);
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("Вы победили!");
                break;
            }
            if (cellVerifier.CellsFilled(gameTable)) {
                System.out.println("Ничья");
                break;
            }
            computerMove.make(gameTable);
            dataprinter.printTableGame(gameTable);
            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("Машины победили!");
                break;
            }
            if (cellVerifier.CellsFilled(gameTable)) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра Завершена!");
    }
}
