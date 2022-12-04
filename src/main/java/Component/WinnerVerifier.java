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

import Component.keypad.Sign;
import Model.Cell;
import Model.GameTable;

import static Component.keypad.Sign.O;
import static Component.keypad.Sign.X;

public class WinnerVerifier {
    public boolean isComputerWin(GameTable gameTable) {
        return winner(O, gameTable);
    }

    public boolean isUserWin(GameTable gameTable) {
        return winner(X, gameTable);
    }

    private boolean winner(Sign x, GameTable gameTable) {

        for (int i = 0; i < 3; i++) {
            if (x == gameTable.getSign(new Cell(0, i)) &&
                    x == gameTable.getSign(new Cell(1, i)) &&
                    x == gameTable.getSign(new Cell(2, i))) return true;
            if (x == gameTable.getSign(new Cell(i, 0)) &&
                    x == gameTable.getSign(new Cell(i, 1)) &&
                    x == gameTable.getSign(new Cell(i, 2))) return true;
        }
        if (x == gameTable.getSign(new Cell(0, 0)) &&
                x == gameTable.getSign(new Cell(1, 1)) &&
                x == gameTable.getSign(new Cell(2, 2))) return true;
        else return x == gameTable.getSign(new Cell(0, 2)) &&
                x == gameTable.getSign(new Cell(1, 1)) &&
                x == gameTable.getSign(new Cell(2, 0));
    }
}
