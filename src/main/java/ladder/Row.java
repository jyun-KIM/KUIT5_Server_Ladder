package ladder;

public class Row {
    private final int[] row;

    public Row(GreaterThanOne numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
    }

    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = Direction.RIGHT.getValue();
        row[startPosition + 1] = Direction.LEFT.getValue();
    }

    public int nextPosition(int position) {
        validatePosition(position);

        if (isRight(position)) {
            return position + 1;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.LEFT.getValue();
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT.getValue();
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == Direction.LEFT.getValue() || row[startPosition + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }
}