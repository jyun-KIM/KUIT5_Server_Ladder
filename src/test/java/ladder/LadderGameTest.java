package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladder = new LadderGame(numberOfRow, numberOfPerson);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderGame ladder = new LadderGame(GreaterThanOne.from(2), numberOfPerson);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladder.run(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderGame ladder = new LadderGame(row, numberOfPerson);

        ladder.drawLine(Position.from(0),Position.from(0));
        ladder.drawLine(Position.from(1),Position.from(1));
        ladder.drawLine(Position.from(2),Position.from(0));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladder.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladder.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladder.run(position)).isEqualTo(0);
    }
}
