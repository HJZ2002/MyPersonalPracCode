package Prac;

public class battery {
	private int level;
	private final int maxlevel = 100;
	
	public battery() {
		level = 0;
	}
	public void charge() {
        if (level < maxlevel) {
            System.out.println("Charging...");
            level += 10;
            if (level > maxlevel) {
                level = maxlevel;
            }
        } else {
            System.out.println("Battery is fully charged.");
        }
    }
	public void unplugcharger() {
		System.out.println(" Now unplugging the charger");
	}
	
	public void checkBattery() {
        if (level >= maxlevel) {
            System.out.println("Battery is at 100%.");
        } else if (level > 0) {
            System.out.println("Battery is at " + level + "%.");
            level--;
        } else {
            System.out.println("Battery is empty.");
        }
    }

    public int getLevel() {
        return level;
    }
}
