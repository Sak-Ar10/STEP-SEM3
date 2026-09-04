public class ATMPinValidator {
    public void checkPinLength(String pin) {
        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN must be exactly 4 digits.");
        }
    }
}