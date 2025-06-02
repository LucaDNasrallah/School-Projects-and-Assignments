import java.io.FileWriter;
import java.io.IOException;

class MinimumWageException extends RuntimeException {
    public MinimumWageException(String message) {
        super(message);
    }

    public void logError(String employeeData) {
        try (FileWriter writer = new FileWriter("payRollError.txt", true)) {
            writer.write(employeeData + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to payRollError.txt: " + e.getMessage());
        }
    }
}
