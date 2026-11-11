package Bridge;

// ==========================================
// 1. IMPLEMENTOR INTERFACE
// ==========================================
public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
    void printStatus();
}

// ==========================================
// 2. CONCRETE IMPLEMENTOR 1: TV
// ==========================================
class Tv implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a TV.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------");
    }
}

// ==========================================
// 3. CONCRETE IMPLEMENTOR 2: SMART TV (NEW)
// ==========================================
class SmartTV implements Device {
    private boolean on = false;
    private int volume = 40;
    private int channel = 10;
    private boolean internetConnected = false;
    private String currentApp = "Home Screen";

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        internetConnected = true; // Auto-connects to Wi-Fi on boot
    }

    @Override
    public void disable() {
        on = false;
        internetConnected = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    // New specific smart functionalities
    public void browseInternet(String url) {
        if (on && internetConnected) {
            System.out.println("[SmartTV] Browsing internet securely at: " + url);
            this.currentApp = "Browser - " + url;
        } else {
            System.out.println("[SmartTV] Cannot browse. TV is off or internet is disconnected.");
        }
    }

    public void launchApp(String appName) {
        if (on) {
            this.currentApp = appName;
            System.out.println("[SmartTV] Launched streaming application: " + appName);
        } else {
            System.out.println("[SmartTV] Turn on the TV first.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a SmartTV.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Internet status: " + (internetConnected ? "Connected" : "Disconnected"));
        System.out.println("| Active App/Screen: " + currentApp);
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------");
    }
}

// ==========================================
// 4. ABSTRACTION
// ==========================================
interface Remote {
    void togglePower();
    void volumeDown();
    void volumeUp();
    void channelDown();
    void channelUp();
}

class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void togglePower() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: channel down");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: channel up");
        device.setChannel(device.getChannel() + 1);
    }
}

// ==========================================
// 5. REFINED ABSTRACTION: SMART REMOTE (NEW)
// ==========================================
class SmartRemote extends BasicRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote [Voice Command Recognized]: \"" + command + "\"");

        String lowerCmd = command.toLowerCase();
        if (lowerCmd.contains("mute")) {
            device.setVolume(0);
        } else if (lowerCmd.contains("max volume")) {
            device.setVolume(100);
        } else {
            System.out.println("SmartRemote: Executing generic voice action...");
        }
    }

    // Specific shortcut methods enabled by checking dynamic runtime device type
    public void openBrowser(String url) {
        if (device instanceof SmartTV) {
            ((SmartTV) device).browseInternet(url);
        } else {
            System.out.println("SmartRemote: Attached device does not support web browsing.");
        }
    }

    public void launchStreamingApp(String appName) {
        if (device instanceof SmartTV) {
            ((SmartTV) device).launchApp(appName);
        } else {
            System.out.println("SmartRemote: Attached device does not support smart apps.");
        }
    }
}

// ==========================================
// 6. DEMO / VERIFICATION DRIVER
// ==========================================
class BridgePatternDemo {
    public static void main(String[] args) {
        System.out.println("--- Testing Standard TV with Basic Remote ---");
        Device tv = new Tv();
        BasicRemote basicRemote = new BasicRemote(tv);
        basicRemote.togglePower();
        tv.printStatus();

        System.out.println("\n--- Testing SmartTV with SmartRemote ---");
        Device smartTV = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);

        smartRemote.togglePower(); // Turns on and auto-connects to Wi-Fi
        smartRemote.voiceControl("Max Volume");
        smartRemote.openBrowser("https://refactoring.guru");
        smartRemote.launchStreamingApp("YouTube");

        smartTV.printStatus();
    }
}