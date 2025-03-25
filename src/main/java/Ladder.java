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
        int run_x = ladderNum;
        int run_y = 0;

        while(run_y < row-1 ){
            if (run_x < row && rows[run_x][run_y] == 1 && rows[run_x][run_y] == 1){
                run_x -= 1;
            }
            if (rows[run_x][run_y] == 1 && rows[run_x + 1][run_y] == 1){
                run_x += 1;
            }
            run_y+=1;
        }
//TODO: 예외 처리해야함
        return run_x;
    }

    public int[][] getRows() {
        return rows;
    }

}
