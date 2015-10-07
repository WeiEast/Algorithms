package mywork;

public class SingletonTest {
	private static String string;

	private SingletonTest(String parameterString) {
		string = parameterString;
	}

	// No.1
	// 开始写代码，使用内部静态类实现单例模式
	public static SingletonTest getInstance(String parameterString) {
		return innerStaticClass.getInstance(parameterString);
	}

	static class innerStaticClass {
		private static SingletonTest instance = new SingletonTest(string);

		private static SingletonTest getInstance(String string) {
			SingletonTest.string = string;
			return instance;
		}
	}

	// end_code
	public void getString() {
		System.out.println(string);
	}

	public static void main(String args[]) {
		SingletonTest singleton1 = SingletonTest.getInstance("hello world");
		SingletonTest singleton2 = SingletonTest.getInstance("apple");
		singleton1.getString();
		singleton2.getString();
		System.out.println(singleton1 == singleton2);
	}
}
