package myTestProject;

import java.util.ArrayList;
import java.util.List;

class TestClassNames {

	public static void main(String[] args) {
		new $dollarClass();
		new smallCharClass();
		new _UnderscoreClass();
		
		List<String> illegalClassNames = new ArrayList<String>();
		illegalClassNames.add("First number name: 1ClassName");
		
		System.out.println("\nForbidden names for Class:");
		System.out.println(illegalClassNames.toString());
	}
}

class $dollarClass {
	public $dollarClass() {
		System.out.println("This is " + this.getClass().getName());
	}
};
class smallCharClass {
	public smallCharClass() {
		System.out.println("This is " + this.getClass().getName());
	}
};
class _UnderscoreClass {
	public _UnderscoreClass() {
		System.out.println("This is " + this.getClass().getName());
	}
};