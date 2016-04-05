package petit;
import java.util.HashMap;

public class State {
    public static HashMap<String,Integer> state ;

    State() {
	state = new HashMap<String,Integer>();
    }

    public static int lookupVar(String id) {
	return state.get(id);
    }
    public static void updateVar(String id, Integer v) {
	state.put(id,v);
    }
}
