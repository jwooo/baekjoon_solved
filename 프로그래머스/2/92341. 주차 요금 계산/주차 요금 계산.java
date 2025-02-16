import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, Car> parkingCars = getParkingCars(records);
        List<Car> cars = new ArrayList<>();
        
        for (String key : parkingCars.keySet()) {
            Car car = parkingCars.get(key);
            
            if (car.isLowerThan(defaultTime)) car.setFee(defaultFee);
            else {
                Integer overTime = car.getFullParkingTime() - defaultTime;
                Integer feeByTime = overTime % unitTime == 0 
                    ? overTime / unitTime 
                    : overTime / unitTime + 1;
                
                car.setFee(defaultFee + feeByTime * unitFee);
            }
            
            cars.add(car);
        }
        
        Collections.sort(cars, Comparator.comparing(Car::getNumber));
        return cars.stream().mapToInt(Car::getFee).toArray();
    }
    
    private Integer extractTime(String strTime) {
        String[] times = strTime.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
    
    private Map<String, Car> getParkingCars(String[] records) {
        Map<String, Car> parkingCars = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            Integer eventTime = extractTime(record[0]);
            String number = record[1];
            String event = record[2];
            
            if (event.equals("IN")) {
                if (!parkingCars.containsKey(number)) parkingCars.put(number, Car.of(number, eventTime));
                else {
                    Car parkingCar = parkingCars.get(number);
                    parkingCar.in(eventTime);
                }
            } else {
                Car parkingCar = parkingCars.get(number);
                parkingCar.out(eventTime);
            }
        }
        
        for (String key : parkingCars.keySet()) {
            Car car = parkingCars.get(key);
            
            if (!car.isOut()) car.out(extractTime("23:59"));
        }
        
        return parkingCars;
    }
    
    static class Car {
        private String number;
        private int parkingTime;
        private int fullParkingTime;
        private int fee;
        private boolean out;
        
        private Car(String number, int parkingTime) {
            this.number = number;
            this.parkingTime = parkingTime;
            this.fullParkingTime = 0;
            this.fee = 0;
            this.out = false;
        }
        
        public static Car of(String number, int parkingTime) {
            return new Car(number, parkingTime);
        }
        
        public boolean isLowerThan(int time) {
            return this.fullParkingTime <= time;
        }
        
        public void in(int time) {
            this.parkingTime = time;
            this.out = false;
        }
        
        public void out(int time) {
            this.fullParkingTime += time - this.parkingTime;
            this.parkingTime = 0;
            this.out = true;
        }
        
        public String getNumber() {
            return this.number;
        }
        
        public int getFullParkingTime() {
            return this.fullParkingTime;
        }
        
        public int getFee() {
            return this.fee;
        }
        
        public boolean isOut() {
            return this.out;
        }
        
        public void setFee(int fee) {
            this.fee = fee;
        }
    }
}