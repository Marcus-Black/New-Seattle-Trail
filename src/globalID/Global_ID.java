package globalID;
import java.util.*;

public class Global_ID {
	public Object obj;	
	public static int globalIDNum = 1;
	public ArrayList<Global_ID> AllObjects = new ArrayList<>();
	public ArrayList<Global_ID> EntityObjects = new ArrayList<>();
	public ArrayList<Global_ID> EventObjects = new ArrayList<>();

	public Global_ID(Object obj) {	
		this.obj = obj;
		AllObjects.add(this);
		if(obj.getClass().isInstance(EntityObjects))
			EntityObjects.add(this);
	}
	
	public void printInfo(ArrayList<Global_ID> input) {
		for(Global_ID object: input)
			System.out.println(object.obj.toString()+"\n");
	}
	
	public int getGlobalID() {
		return this.globalIDNum;
	}

}
