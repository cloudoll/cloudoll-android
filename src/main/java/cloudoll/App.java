package cloudoll;

import java.util.HashMap;
import java.util.Map;

/**
 * App
 */
class App {


    protected static final String CLOUDOLL_CONFIG = "CLOUDOLL_CONFIG";

    /**
     * 自己的上下文
     */
    private static Map<String, Object> application = new HashMap<String, Object>();

    protected static void addApplication(String key, Object value) {
        synchronized (application) {
            application.put(key, value);
        }
    }

    protected static Object getApplicationValue(String key) {
        synchronized (application) {
            return application.get(key);
        }
    }

    protected static void addApplication(Map map) {
        synchronized (application) {
            application.putAll(map);
        }
    }
}
