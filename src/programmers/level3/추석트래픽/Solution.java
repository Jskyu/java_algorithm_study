package programmers.level3.추석트래픽;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String[] lines) {
        final long START = System.currentTimeMillis();
        try {
            List<Traffic> list = Arrays.stream(lines).map(Traffic::new).sorted(Traffic::compareTo).collect(Collectors.toList());
            long max = 1;
            while (0 <= list.size() - max) {
                LocalDateTime start = list.get(0).getFin().minusNanos(1000000);
                max = Math.max(list.stream().
                        filter(traffic -> traffic.contains(start))
                        .count(), max);
                list.remove(0);
            }

            return (int) max;
        } finally {
            long time = System.currentTimeMillis() - START;
            System.out.println("time = " + time + "ms");
        }
    }

    private static class Traffic implements Comparable<Traffic> {
        private LocalDateTime fin;
        private LocalDateTime start;

        public Traffic(String line) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            this.fin = LocalDateTime.parse(line.substring(0, 23), formatter);
            this.start = fin.minusNanos((long) ((Double.parseDouble(line.substring(24).replace("s", "")) - 0.001) * 1000000000));
        }

        public LocalDateTime getFin() {
            return fin;
        }

        public LocalDateTime getStart() {
            return start;
        }

        /*
        1. 기준 임의의 시간보다 시작 시간이 과거일 경우
        1.1. 종료 시간이 기준 임의의 시간보다 미래여야 함.

        2. 1번에 해당하지 않고 기준 임의의 시간 + 1초보다 시작 시간이 과거일 경우
        */
        public boolean contains(LocalDateTime tempTime) {
            if (this.getStart().isBefore(tempTime)) {
                return tempTime.isBefore(this.getFin()) || tempTime.isEqual(this.getFin());
            }
            tempTime = tempTime.plusSeconds(1);
            return this.getStart().isBefore(tempTime) || tempTime.isEqual(this.getStart());
        }

        @Override
        public int compareTo(Traffic o) {
            return this.getFin().compareTo(o.getFin());
        }
    }
}
