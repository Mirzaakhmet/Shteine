package LAB3.Problem5;

public class Task5 {
	public static void main(String[] args) {
		DragonLaunch dlaunch = new DragonLaunch();
		dlaunch.kidnap(new Person(Gender.B));
		dlaunch.kidnap(new Person(Gender.B));
		dlaunch.kidnap(new Person(Gender.G));
		dlaunch.kidnap(new Person(Gender.G));
		Person p = new Person(Gender.B);
		Person p1 = new Person(Gender.G);
		System.out.println(p.getGender());
		System.out.println(p.toString());
		System.out.println(p1.toString());
		System.out.println(dlaunch.willDragonEatOrNot());
	}
}
