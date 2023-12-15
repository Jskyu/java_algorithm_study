package programmers.level2.쿼드압축_후_개수_세기;

/*
테스트 1 〉	통과 (1.14ms, 78MB)
테스트 2 〉	통과 (0.95ms, 75.3MB)
테스트 3 〉	통과 (1.54ms, 75.8MB)
테스트 4 〉	통과 (0.75ms, 77.8MB)
테스트 5 〉	통과 (31.48ms, 119MB)
테스트 6 〉	통과 (29.48ms, 130MB)
테스트 7 〉	통과 (21.42ms, 125MB)
테스트 8 〉	통과 (25.56ms, 121MB)
테스트 9 〉	통과 (27.70ms, 112MB)
테스트 10 〉	통과 (37.27ms, 139MB)
테스트 11 〉	통과 (0.67ms, 75.9MB)
테스트 12 〉	통과 (0.69ms, 77.2MB)
테스트 13 〉	통과 (30.69ms, 112MB)
테스트 14 〉	통과 (60.55ms, 157MB)
테스트 15 〉	통과 (48.21ms, 157MB)
테스트 16 〉	통과 (29.10ms, 123MB)
 */
class SolutionByQuadTree {

    public int[] solution(int[][] arr) {
        Node head = init(0, 0, arr.length, arr);
        QuadTree quad = new QuadTree(head, arr.length);
        int[] result = quad.getCount();
        return result;
    }

    private Node init(int y, int x, int size, int[][] arr) {
        Node node = new Node(size);

        if (size == 1) {
            node.setValue(arr[y][x]);
            return node;
        }
        int nextSize = size / 2;
        node.setChild(init(y, x, nextSize, arr), 0);
        node.setChild(init(y, x + nextSize, nextSize, arr), 1);
        node.setChild(init(y + nextSize, x, nextSize, arr), 2);
        node.setChild(init(y + nextSize, x + nextSize, nextSize, arr), 3);
        node.press();

        return node;
    }

    static class QuadTree {
        Node head;
        int totalSize;
        int[] count = {0, 0};

        public QuadTree(Node head, int totalSize) {
            this.head = head;
            this.totalSize = totalSize;
        }

        public int[] getCount() {
            if (head.value != -1) {
                count[head.value]++;
            } else {
                count = head.getCount(count);
            }
            return count;
        }
    }

    static class Node {
        Node[] child = null;
        int value = -1;
        int size;

        public Node(int size) {
            this.size = size;
        }

        public void setChild(Node node, int index) {
            if (child == null) {
                child = new Node[4];
            }
            child[index] = node;
        }
        public void setValue(int value) {
            this.value = value;
        }

        public void press() {
            if (check()) {
                this.value = this.child[0].value;
            }
        }

        private boolean check() {
            int value = -1;
            for (Node node : child) {
                if (value == -1) {
                    value = node.value;
                } else if (node.value != value) {
                    return false;
                }
            }
            return true;
        }

        public int[] getCount(int[] count) {
            if (this.value != -1) {
                count[this.value]++;
            } else {
                for (Node node : child) {
                    node.getCount(count);
                }
            }
            return count;
        }
    }

}
