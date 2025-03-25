
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 그리기 - 유효한 입력")
    void drawLineTestValid(){

        //given
        Ladder ladder = new Ladder(5,4);
        int[][] rows = ladder.getRows();

        //when
        ladder.drawLine(1,2);

        //then
        Assertions.assertThat(rows[1][2]).isEqualTo(1);
        Assertions.assertThat(rows[2][2]).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 그리기 - 유효하지 않은 x값 입력 시 예외 발생")
    void drawLintTestInvalidX(){
        // given
        Ladder ladder = new Ladder(5, 4);

        // when & then
        Assertions.assertThatThrownBy(() -> ladder.drawLine(4, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 위치가 아닙니다.");
    }

    @Test
    @DisplayName("사다리 그리기 - 유효하지 않은 Y값 입력 시 예외 발생")
    void drawLintTestInvalidY() {
        // given
        Ladder ladder = new Ladder(5, 4);

        // when & then
        Assertions.assertThatThrownBy(() -> ladder.drawLine(1, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 위치가 아닙니다.");
    }

    @Test
    @DisplayName("사다리 게임 실행 - 직진")
    void runTest_StraightDown () throws Exception {
        //given
        Ladder ladder = new Ladder(5, 4);

        //when
        int result = ladder.run(1);

        //then
        Assertions.assertThat(result).isEqualTo(1);
     }

     @Test
     @DisplayName("사다리 게임 실행 - 사다리 그려서 확인")
     void runTest_MoveLeft () throws Exception {
         //given
         Ladder ladder = new Ladder(5,4);
         ladder.drawLine(2, 1); // (2,1) → (1,1)로 이동
         ladder.drawLine(1, 2); // (1,2) → (2,2)로 이동

         //when
         int result = ladder.run(2);
         int result2 = ladder.run(3);

         //then
         Assertions.assertThat(result).isEqualTo(3);
         Assertions.assertThat(result2).isEqualTo(3);
      }

      @Test
      @DisplayName("")
      void testName () throws Exception {
          //given

          //when

          //then
       }
       


}