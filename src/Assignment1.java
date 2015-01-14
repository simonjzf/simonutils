import java.sql.Time;
import java.util.Scanner;


public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 假设某个停车场的费率是停车 
		 * 2 小时以内, 每半小时 30 元, 
		 * 超过 2 小时, 但未满 4 小时的部分, 每半小时 40 元, 
		 * 超过 4 小时以上的部分, 每半小时 60 元, 
		 * 未满半小时部分不计费。 
		 * 如果您从早上 10 点 23 分停到下午 3 点 20 分,请撰写程序计算共需缴交的停车费。
		 */
		
//		/**
//		 * No.1
//		 */
		
//		Time start = Time.valueOf("10:23:00");
//		Time end = Time.valueOf("15:20:00");
//		long diff = (end.getTime() - start.getTime()) / 1000 / 60 / 30;
//
//		int unitPrice;
//
//		
//		if (diff < 4) {
//			unitPrice = 30;
//		} else if (diff >= 4 && diff < 8) {
//			unitPrice = 40;
//		} else if (diff >= 8) {
//			unitPrice = 60;
//		} else {
//			unitPrice = 0;
//		}
//		System.out.println("早上 10 点 23 分停到下午 3 点 20 分，共需缴交的停车费:￥"+diff * unitPrice);
		
		
//		/**
//		 * No.2
//		 */
//		
//		Time start = Time.valueOf("10:23:00");
//		Time end = Time.valueOf("15:20:00");
//		int diff = (int)(end.getTime() - start.getTime()) / 1000 / 60 / 30;
//
//		int result=0;
//		
//		switch (diff) {
//		case 1:
//			result=30*diff;
//			break;
//		case 2:
//			result=30*diff;
//			break;
//		case 3:
//			result=30*diff;
//			break;
//		case 4:
//			result=30*diff;
//			break;
//		case 5:
//			result=30*4+40*(diff-4);
//			break;
//		case 6:
//			result=30*4+40*(diff-4);
//			break;
//		case 7:
//			result=30*4+40*(diff-4);
//			break;
//		case 8:
//			result=30*4+40*(diff-4);
//			break;
//
//		default:
//			result=30*4+40*4+60*(diff-8);
//			break;
//		}
//
//		System.out.println("早上 10 点 23 分停到下午 3 点 20 分，共需缴交的停车费:￥"+result);
		
		
		/**
		 * N0.3
		 */
		
		Scanner console = new Scanner(System.in);
		
		while (true) {
			System.out.println("输入0 退出本系统\n");
			System.out.print("请输入停车 开始时间:");
			
			String startInput = console.next();
			if(startInput.equals("0")){
				break;
			}
			System.out.print("请输入停车结束时间:");
			String endInput = console.next();
			if(startInput.equals("0")){
				break;
			}
			
			
			try {
				Time start = Time.valueOf(startInput);
				Time end = Time.valueOf(endInput);
				int diff = (int) (end.getTime() - start.getTime()) / 1000 / 60 / 30;

				int result = 0;

				switch (diff) {
				case 1:
					result = 30 * diff;
					break;
				case 2:
					result = 30 * diff;
					break;
				case 3:
					result = 30 * diff;
					break;
				case 4:
					result = 30 * diff;
					break;
				case 5:
					result = 30 * 4 + 40 * (diff - 4);
					break;
				case 6:
					result = 30 * 4 + 40 * (diff - 4);
					break;
				case 7:
					result = 30 * 4 + 40 * (diff - 4);
					break;
				case 8:
					result = 30 * 4 + 40 * (diff - 4);
					break;

				default:
					result = 30 * 4 + 40 * 4 + 60 * (diff - 8);
					break;
				}

				System.out.println("需缴交的停车费:￥" + result+"\n ----------------------");
			} catch (Exception e) {
				System.out.println("你输入的时间格式错误！");
			}

		}
		
		System.out.println("谢谢你的光临!");

	}


}
