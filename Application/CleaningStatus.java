


/*
public class CleaningStatus {
<<<<<<< Updated upstream
    
}
=======
    private String cleaningStatus;

    // Constructor
    public CleaningStatus() {
        this.cleaningStatus = "Dirty"; // Default status is dirty
    }

    // Set the cleaning status to "Offline"
    public void setOffline() {
        this.cleaningStatus = "Offline";
    }

    // Set the cleaning status to "Dirty"
    public void setDirty() {
        this.cleaningStatus = "Dirty";
    }

    // Set the cleaning status to "Clean"
    public void setClean() {
        this.cleaningStatus = "Clean";
    }

    // Set the cleaning status based on an integer value
    public void setCleaningStatus(int cleaningStatus) {
        switch (cleaningStatus) {
            case 0:
                setOffline();
                break;
            case 1:
                setDirty();
                break;
            case 2:
                setClean();
                break;
            default:
                System.out.println("Invalid cleaning status code");
        }
    }

    // Get the current cleaning status
    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public static void main(String[] args) {
        // Example usage
        CleaningStatus status = new CleaningStatus();
        System.out.println("Initial status: " + status.getCleaningStatus());

        status.setClean();
        System.out.println("After setting to clean: " + status.getCleaningStatus());

        status.setOffline();
        System.out.println("After setting to offline: " + status.getCleaningStatus());

        status.setCleaningStatus(1); // Set to dirty using the numeric code
        System.out.println("After setting to dirty: " + status.getCleaningStatus());
    }
}
*/
>>>>>>> Stashed changes
