public class Assignment3 {

	/**
	 * @param args
	 * 有一对兔子，从出生后
	 * 第3个月起每个月都生一对兔子，
	 * 小兔子长到第三个月后每个月又生一对兔子，
	 * 假如兔子都不死，
	 * 问每个月的兔子对数为多少？ 
	 * 
	 */
	public static void main(String[] args) {

		for (int i = 1; i < 11; i++) {
			System.out.println("第" + i + "个月兔子总数为" + fun(i));
		}
	}

	private static int fun(int n) {

		if (n == 1 || n == 2)
			return 1;
		else
			return fun(n - 1) + fun(n - 2);
	}
	
}