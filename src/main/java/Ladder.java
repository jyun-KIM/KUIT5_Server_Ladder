public class Ladder {

    private final int[][] rows;
    private final int row;
    private final int numberOfPerson;

    public Ladder(int row, int numberOfPerson) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        rows = new int[numberOfPerson][row];

    }

    //TODO: 사다리 라인 생성
    public void drawLine(int x, int y){
        if (row <= y || numberOfPerson <= (x +1)  ){
            throw new IllegalArgumentException("유효한 위치가 아닙니다.");
        }else {
            rows[x][y] = 1;
            rows[x+1][y] = 1; //무조건 오른쪽으로 생성
        }
    }

    //TODO: 게임 실행
    public int run(int ladderNum){
        int result = 0;

        return result;
    }

    public int[][] getRows() {
        return rows;
    }

}
