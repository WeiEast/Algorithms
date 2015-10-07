package mywork;

//No.1

//开始写代码，设计firsecondThreadThread类和secondThread两个线程，使其继承Thread类并且实现一个线程每次对j加2，另一个线程每次对j减1
class firstThread extends Thread {
	private ExtendsThread extendsThread;

	public firstThread(ExtendsThread extendsThread) {
		this.extendsThread = extendsThread;
	}

	@Override
	public void run() {
		extendsThread.increJ(2);
	}
}

class secondThread extends Thread {
	private ExtendsThread extendsThread;

	public secondThread(ExtendsThread extendsThread) {
		this.extendsThread = extendsThread;
	}

	@Override
	public void run() {
		extendsThread.increJ(-1);
	}
}

// end_code
public class ExtendsThread {
	public int j;

	// No.2
	// 开始写代码，给两个线程上锁
	public synchronized void increJ(int num) {
		j = j + num;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	// end_code
	public static void main(String[] args) {
		ExtendsThread extendsThread = new ExtendsThread();
		firstThread firstThread = new firstThread(extendsThread);
		secondThread secondThread = new secondThread(extendsThread);
		firstThread.start();
		secondThread.start();
	}

}