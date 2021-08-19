package test2;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List list = new ArrayList();

		list.add("test");

		list.add(7);

		for(String s: list)

		System.out.println(s);
	}

}
