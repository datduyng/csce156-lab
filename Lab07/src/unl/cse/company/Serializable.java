package unl.cse.company;

import java.io.File;
import java.io.IOException;

public interface Serializable {
	
	public void serializeToJSON(Serializable jsonSerializable, File file) throws IOException;

}
