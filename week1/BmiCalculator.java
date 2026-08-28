public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person   | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-2d| %-10.2f | %-11.2f | %-5.2f | %s\n", 
                              i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (Math.random() * (1.95 - 1.50));
            weights[i] = 50.0 + (Math.random() * (100.0 - 50.0)); 
        }
        
        printWellnessReport(heights, weights);
    }
}