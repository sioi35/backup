package com.test.question.q22;

public class Packer { // 포장 직원

	private static int pencilCount;
	private static int eraserCount;
	private static int ballPointPenCount;
	private static int rulerCount;
	
	public void packing(Pencil pencil) {
		
		System.out.printf("포장 전 검수 : %s\n", pencil.info());
		pencilCount++;
		System.out.println("포장을 완료했습니다.");
	
	}
	
	public void packing(Eraser eraser) {
		
		System.out.printf("포장 전 검수 : %s\n", eraser.info());
		eraserCount++;
		System.out.println("포장을 완료했습니다.");
	
	}
	
	public void packing(BallPointPen ballPointPen) {
		
		System.out.printf("포장 전 검수 : %s\n", ballPointPen.info());
		ballPointPenCount++;
		System.out.println("포장을 완료했습니다.");
	
	}
	
	public void packing(Ruler ruler) {
		
		System.out.printf("포장 전 검수 : %s\n", ruler.info());
		rulerCount++;
		System.out.println("포장을 완료했습니다.");
	
	}
	
	
	public void countPacking(int type) {
		
		System.out.println("=====================");
		System.out.println("포장 결과");
		System.out.println("=====================");
		
		if (type == 0) {
			System.out.printf("연필 %d회\n", pencilCount);
			System.out.printf("지우개 %d회\n", eraserCount);
			System.out.printf("볼펜 %d회\n", ballPointPenCount);
			System.out.printf("자 %d회\n", rulerCount);
		} else if (type == 1) {
			System.out.printf("연필 %d회\n", pencilCount);
		}else if(type == 2) {
			System.out.printf("지우개 %d회\n", eraserCount);
		}else if(type == 3) {
			System.out.printf("볼펜 %d회\n", ballPointPenCount);
		}else if(type == 4) {
			System.out.printf("자 %d회\n", rulerCount);
		}
		System.out.println();
	}
	
}
