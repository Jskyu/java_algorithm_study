package programmers.level2.주차요금계산;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, ParkingInfo> parkingMap = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String number = split[1];
            String state = split[2];

            if (state.equals("OUT")) {
                parkingMap.get(number).setOut(time);
            } else {
                if (parkingMap.containsKey(number)) {
                    parkingMap.get(number).update(time);
                } else {
                    parkingMap.put(number, new ParkingInfo(time));
                }
            }
        }

        return parkingMap.keySet().stream()
                .sorted()
                .mapToInt(key -> parkingMap.get(key).getPay(fees[0],fees[1],fees[2],fees[3]))
                .toArray();
    }

    static class ParkingInfo {
        int in;
        int out = convert("23:59");
        int time = 0;

        public ParkingInfo(String in) {
            setIn(in);
            setOut("23:59");
        }

        public int getPay(int baseTime, int baseFee, int perTime, int perFee) {
            int parkingTime = out - in + time;

            if (baseTime < parkingTime) {
                parkingTime = parkingTime - baseTime;
                baseFee += (parkingTime / perTime) * perFee;
                if (parkingTime % perTime > 0) {
                    baseFee += perFee;
                }
            }
            return baseFee;
        }

        public void update(String in) {
            time += (this.out - this.in);
            setIn(in);
            setOut("23:59");
        }

        private void setIn(String time) {
            this.in = convert(time);
        }

        public void setOut(String time) {
            out = convert(time);
        }
    }

    private static int convert(String time) {
        String[] inSplit = time.split(":");
        LocalDateTime inTime = LocalDateTime.of(1999, 12, 31, Integer.parseInt(inSplit[0]), Integer.parseInt(inSplit[1]));
        return (inTime.getHour() * 60) + inTime.getMinute();
    }
}
