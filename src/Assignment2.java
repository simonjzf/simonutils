import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author simon.jia
 *
 */
public class Assignment2 {

	/**
	 * 宾果(Bingo)游戏
		游戏准备		
		1) 建立一个5 X 5 的2维数组		
		2) 以随机数生成24 个(1~50) 不可重复的整数
		
		游戏开始		
		1) 玩家每按一次Enter 键, 计算机会随机产生一个1~99的不重复整数		
		2) 如果数组中有这个随机数, 把数字用() 包起来		
		3) 把计算机曾经产生的数字打印出来
		
		游戏结束		
		1) 中奖的样式有多种多样，BINGO可以是垂直分布、水平分布或对角线分布		
		2) 超过30回合,游戏自动结束			 
		
		Sample Output
				
		請輸入Enter
		第28次 : 20
		 23   25   37   29   26 
		(45) (49) (40) (20) (27) 
		 09   05   44   31   13 
		 47   32   30   07   24 
		 38   03   33   12   10
		 		
		你中奖了

	 * 
	 */
	public static void main(String[] args) {
		
		boolean flag = true;
		int count=0;
		
		while (flag){			
		count++;
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("尝试次数 = "+count+"\n");
		
		//获取不存在重复整数、区间为[1-50]、5*5、二维数组
		int[][] initial =getRandomIntNoRepeat(5,5,50);
		if (initial==null){
			return;
		}
		
		//获取不存在重复整数、区间为[1-99]、大小为30、一维数组
		int[] boult = getRandomIntNoRepeat(30,50);
		if(boult==null){
			return;
		}
		
		Scanner scan = new Scanner(System.in);		
		List<Integer> listValuable = new ArrayList<Integer>();
		
		for (int i = 0; i < boult.length; i++) {
			
//			System.out.print("請輸入Enter");
//			if(scan.nextLine().equals("")){
//				System.out.println("第"+(i+1)+"次:"+boult[i]+"\n");
				
				for (int r = 0; r < initial.length; r++) {
					for (int c = 0; c < initial.length; c++) {
						
						if(initial[r][c]==boult[i]){
							
							//保存命中随机数
							listValuable.add(boult[i]);
							
							//当命中数>=5时，且符合垂直、水平或对角线分布时，输出结果
							if(listValuable.size()>=5&&isWin(initial,listValuable)){								
								displayResult(initial,listValuable);
								System.out.println("\n恭喜你中奖了");
								flag=false;
								return;
							}
							
						}
						
					}			
				}
//			}
		}		
		
		displayResult(initial,listValuable);
		System.out.println("\n非常遗憾，你未中奖！\n");
		
		}
	}
	/**
	 * 
	 * @param initial
	 * @param listValuable
	 * @return 是否为垂直分布、水平分布或对角线分布
	 */
	private static boolean isWin(int[][] initial,List<Integer> listValuable){
		
		List<Integer> rowList = new ArrayList<Integer>();
		List<Integer> colList = new ArrayList<Integer>();
		List<Integer> diagonalAList = new ArrayList<Integer>();
		List<Integer> diagonalBList = new ArrayList<Integer>();
		
		//是否水平分布 或 垂直分布
		for (int i = 0; i < initial.length; i++) {
			for (int j = 0; j < initial.length; j++) {
				rowList.add(initial[i][j]);
				colList.add(initial[j][i]);
			}
//			if(rowList.containsAll(listValuable)||colList.containsAll(listValuable)){
			if(listValuable.containsAll(rowList)||listValuable.containsAll(colList)){
				return true;
			}else{
				rowList.clear();	
				colList.clear();
			}			
		}
		
		//是否对角线分布
		for (int i = 0; i < initial.length; i++) {
			for (int j = 0; j < initial.length; j++) {
				if(i==j){
					diagonalAList.add(initial[i][j]);
				}
				if(i+j==initial.length-1){
					diagonalBList.add(initial[i][j]);
				}
			}
		}
		
//		if(diagonalAList.containsAll(listValuable)||diagonalBList.containsAll(listValuable)){
		if(listValuable.containsAll(diagonalAList)||listValuable.containsAll(diagonalBList)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param initial
	 * @param listValuable
	 */
	private static void displayResult(int[][] initial,List<Integer> listValuable){
		System.out.println("\n");
		for (int i = 0; i < initial.length; i++) {
			for (int j = 0; j < initial.length; j++) {
				
				if(listValuable.contains(initial[i][j])){
					System.out.print("(");
					System.out.printf("%02d",initial[i][j]);
					System.out.print(")\t");
				}else{
					System.out.print(" ");
					System.out.printf("%02d",initial[i][j]);
					System.out.print(" \t");
				}
				
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @param maxInt
	 * @return 区间范围在[1- maxInt]的，不重复的 二维数组
	 */
	private static int[][] getRandomIntNoRepeat(int row,int col,int maxInt){
		if(row*col>maxInt){
			System.out.println("区间 [1-"+maxInt+"],不能产生 "+row+"*"+col+"，且包含不重复整数的二维数组！");
			return null;
		}
		int[] sourceInt = new int[maxInt];
		
		//创建区间范围在[1-maxInt] 的一维数组为源数组
		for (int i = 0; i < sourceInt.length; i++) {
			sourceInt[i]=i+1;
		}
		
//		Random random = new Random();
		SecureRandom random = new SecureRandom();
		int[][] res = new int[row][col];
		
		//保存不重复整数、区间范围在[1- maxInt] 二维数组
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				int temp = random.nextInt(maxInt);	//产生随机数
				res[i][j]=sourceInt[temp];			//将数组下标等于随机数的数组元素，赋给二维数组
				sourceInt[temp]=0;					//将已经赋值的源数组元素标识为0
				
				//当发现赋值的二维数组存在重复值时，重新获取直至不再重复
				while(res[i][j]==0){
					temp = random.nextInt(maxInt);
					res[i][j]=sourceInt[temp];
					sourceInt[temp]=0;
				}
//				System.out.print(" ");
//				System.out.printf("%02d",res[i][j]);
//				System.out.print(" \t");
			}
//			System.out.println();
		}
		
		return res ;
	}
	
	/**
	 * 
	 * @param size
	 * @param maxInt
	 * @return 区间范围在[1-maxInt]的， 不重复的一维数组
	 */
	private static int[] getRandomIntNoRepeat(int size,int maxInt){
		if(size>maxInt){
			System.out.println("区间 [1-"+maxInt+"],不能产生大小为"+size+"，且包含不重复整数的一维数组！");
			return null;
		}
		int[] sourceInt = new int[maxInt];
		for (int i = 0; i < sourceInt.length; i++) {
			sourceInt[i]=i+1;
		}
		
		SecureRandom random = new SecureRandom();
		int[] res = new int[size];
		
		for (int i = 0; i < size; i++) {
			int temp = random.nextInt(maxInt);
			res[i]=sourceInt[temp];
			sourceInt[temp]=0;
			
			while(res[i]==0){
				temp = random.nextInt(maxInt);
				res[i]=sourceInt[temp];
				sourceInt[temp]=0;
			}
			System.out.print(" ");
			System.out.printf("%02d",res[i]);
			System.out.print("");
		}
		
		return res ;
	}

}
