package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    @DisplayName("오른쪽 방향 위치 이동 확인")
    void testMoveRightDirection() {
        Node node = Node.from(RIGHT);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("방향 없음(NONE) 위치 이동 확인")
    void testMoveNoneDirection() {
        Node node = Node.from(NONE);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 방향 위치 이동 확인")
    void testMoveLeftDirection() {
        Node node = Node.from(LEFT);

        Position position = Position.from(1);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(0);
    }

}