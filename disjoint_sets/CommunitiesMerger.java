package disjoint_sets;

import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/merging-communities/problem
 * <p>
 * People connect with each other in a social network.
 * A connection between Person i and Person j is represented as M i j.
 * When two persons belonging to different communities connect,
 * the net effect is the merge the communities which i and j belong to.
 * At the beginning, there are n people representing n communities.
 * Suppose person 1 and 2 connected and later 2 and 3 connected,
 * then 1,2, and 3 will belong to the same community.
 * There are two types of queries:
 * 1) M i j => communities containing persons i and j are merged if they belong to different communities.
 * 2) Q i   => print the size of the community to which person i belongs.
 */
public class CommunitiesMerger {

    private final int[] parent;
    private final int[] size;

    public CommunitiesMerger(final int numOfPeople) {
        parent = new int[numOfPeople];
        size = new int[numOfPeople];
        for (int i = 0; i < numOfPeople; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int root(final int i) {
        int id = i;
        while (id != parent[id]) {
            parent[id] = parent[parent[id]];   // path compression to the root
            id = parent[id];
        }
        return id;
    }

    /**
     * Merges communities containing persons i and j if they belong to different communities
     *
     * @param i - person id
     * @param j - person id
     */
    public void merge(final int i, final int j) {
        int ithRoot = root(i);
        int jthRoot = root(j);
        if (ithRoot == jthRoot) {
            return;
        }
        // smaller component connects to larger to flatten component trees
        if (size[ithRoot] < size[jthRoot]) {
            parent[ithRoot] = jthRoot;
            size[jthRoot] += size[ithRoot];
        } else {
            parent[jthRoot] = ithRoot;
            size[ithRoot] += size[jthRoot];
        }
    }

    public int getCommunitySize(final int i) {
        return size[root(i)];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfPeople = scanner.nextInt();
        int numOfQueries = scanner.nextInt();

        // numOfPeople + 1 because people id's start from 1 to numOfPeople inclusive
        CommunitiesMerger communitiesMerger = new CommunitiesMerger(numOfPeople + 1);
        for (int q = 0; q < numOfQueries; q++) {
            String cmd = scanner.next();
            if ("M".equals(cmd)) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                communitiesMerger.merge(i, j);
            } else if ("Q".equals(cmd)) {
                int i = scanner.nextInt();
                System.out.println(communitiesMerger.getCommunitySize(i));
            }
        }
    }
}
