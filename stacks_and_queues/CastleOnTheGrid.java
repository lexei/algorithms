package stacks_and_queues;

import java.util.*;
import java.util.function.Function;

/**
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 * <p>
 * You are given a square grid with some cells open (.) and some blocked (X).
 * Your playing piece can move along any row or column until it reaches the edge
 * of the grid or a blocked cell. Given a grid, a start and a goal, determine the minimum
 * number of moves to get to the goal.
 */
public class CastleOnTheGrid {

    private static final char OPENED_CELL = '.';

    private static class Position {

        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * Computes minimum number of moves to get from start to goal
     *
     * @param grid   - square grid with some cells open (.) and some blocked (X)
     * @param startX - x coordinate of the start
     * @param startY - y coordinate of the start
     * @param goalX  - x coordinate of the goal
     * @param goalY  - y coordinate of the goal
     * @return minimum number of moves from start to goal
     */
    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {

        Position start = new Position(startX, startY);
        Position goal = new Position(goalX, goalY);

        Queue<Position> queue = new ArrayDeque<>();
        queue.add(start);

        Map<Position, Integer> distTo = new HashMap<>();
        distTo.put(start, 0);

        while (!queue.isEmpty()) {

            Position cell = queue.remove();
            if (cell.equals(goal)) {
                break;
            }

            // explore neighbors
            for (Position neighborCell : getNeighbors(cell, grid)) {
                if (!distTo.containsKey(neighborCell)) {
                    queue.add(neighborCell);
                    distTo.put(neighborCell, distTo.get(cell) + 1);
                }
            }
        }

        return distTo.get(goal);
    }

    private static List<Position> getNeighbors(Position position, List<String> grid) {
        List<Position> neighbors = new ArrayList<>();
        neighbors.addAll(getNeighbors(position, grid, pos -> new Position(pos.x, pos.y - 1)));
        neighbors.addAll(getNeighbors(position, grid, pos -> new Position(pos.x, pos.y + 1)));
        neighbors.addAll(getNeighbors(position, grid, pos -> new Position(pos.x - 1, pos.y)));
        neighbors.addAll(getNeighbors(position, grid, pos -> new Position(pos.x + 1, pos.y)));
        return neighbors;
    }

    private static List<Position> getNeighbors(Position startPosition, List<String> grid,
                                               Function<Position, Position> updatePosition) {
        List<Position> neighbors = new ArrayList<>();
        Position pos = updatePosition.apply(startPosition);
        while (isValid(pos, grid)) {
            neighbors.add(pos);
            pos = updatePosition.apply(pos);
        }
        return neighbors;
    }

    private static boolean isValid(Position position, List<String> grid) {
        if (position.x < 0 || position.x >= grid.size()) {
            return false;
        }
        if (position.y < 0 || position.y >= grid.size()) {
            return false;
        }
        return grid.get(position.x).charAt(position.y) == OPENED_CELL;
    }
}
