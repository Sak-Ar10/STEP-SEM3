public class ExamHallSeatChecker {

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicate = false;
        boolean[] alreadyPrinted = new boolean[seatNumbers.length];
        
        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyPrinted[i]) continue;
            
            boolean foundDuplicateForI = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    hasDuplicate = true;
                    foundDuplicateForI = true;
                    alreadyPrinted[j] = true; 
                }
            }
            if (foundDuplicateForI) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }
        
        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}