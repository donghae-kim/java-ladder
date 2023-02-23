package model;

import util.Generator;
import model.type.Status;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LINE_SIZE = 2;
    private static final int NUMBER_FOR_RETRY = 1;
    private final List<Status> points = new ArrayList<>();

    public Line(int personCount, Generator generator) {
        for (int column = 0; column < personCount - 1; column++) {
            points.add(Status.findStatus(generator.generate()));
            column = checkColumn(column);
        }
    }

    private int checkColumn(int column) {
        if (points.size() >= MINIMUM_LINE_SIZE && validateRetryLineMake(column)) {
            return column - NUMBER_FOR_RETRY;
        }
        return column;
    }

    private boolean validateRetryLineMake(int column) {
        if (validateConnectLine(column) && validateTrueLine(column)) {
            points.remove(column);
            return true;
        }
        return false;
    }

    private boolean validateConnectLine(int column) {
        int leftLadderLine = column - 1;
        return points.get(column).equals(points.get(leftLadderLine));
    }

    private boolean validateTrueLine(int index) {
        return points.get(index).getStatus();
    }

    public boolean getLine(int column) {
        return points.get(column).getStatus();
    }
}
