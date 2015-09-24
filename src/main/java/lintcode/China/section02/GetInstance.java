package lintcode.China.section02;

public class GetInstance {
	public static GetInstance getInstance() {
		return Type.INSTANCE.getInstance();
	}

	public enum Type {
		INSTANCE;

		private GetInstance getInstance = new GetInstance();

		GetInstance getInstance() {
			return new GetInstance();
		}
	}

}
