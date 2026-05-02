import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        Set<String> visitedNode = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();

        int x = 0, y = 0;
        visitedNode.add("0,0");
        int rooms = 0;

        for (int arrow : arrows) {
            int nx = x + dx[arrow] * 2;
            int ny = y + dy[arrow] * 2;
            int mx = x + dx[arrow];
            int my = y + dy[arrow];

            String edgeKey;
            if (x < nx || (x == nx && y < ny)) {
                edgeKey = x + "," + y + "," + nx + "," + ny;
            } else {
                edgeKey = nx + "," + ny + "," + x + "," + y;
            }

            if (!visitedEdge.contains(edgeKey)) {
                visitedEdge.add(edgeKey);

                if (visitedNode.contains(nx + "," + ny)) rooms++;
                if (visitedNode.contains(mx + "," + my)) rooms++;
            }

            visitedNode.add(nx + "," + ny);
            visitedNode.add(mx + "," + my);
            x = nx;
            y = ny;
        }

        return rooms;
    }
}