package com.test.question.q22_2;

public class Barista {

	
		public Espresso makeEspresso(int bean) {
			
			Espresso e1 = new Espresso();
			e1.setBean(bean);
			
			Coffee.espresso ++;
			Coffee.bean += bean;
			Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
			
			return e1;
		}
		
		public Espresso[] makeEspresso(int bean, int count) {
			
			Espresso e2[] = new Espresso[count];
			for(int i=0; i<count; i++) {
				e2[i] = new Espresso();
				e2[i].setBean(bean);
			}
			
			Coffee.espresso += count;
			Coffee.bean += bean * count;
			Coffee.beanTotalPrice += Coffee.beanUnitPrice * (bean * count);
			
			return e2;
		}
		
		public Latte makeLatte(int bean, int milk) {
			
			Latte l1 = new Latte();
			l1.setBean(bean);
			l1.setMilk(milk);
			Coffee.latte ++;
			Coffee.bean += bean;
			Coffee.milk += milk;
			Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
			Coffee.milkTotalPrice += Coffee.milkUnitPrice * milk;
			
			return l1;
		}
		
		public Latte[] makeLatte(int bean, int milk, int count) {
			
			Latte[] l2 = new Latte[count];
			
			for(int i=0; i<count; i++) {
				l2[i] = new Latte();
				l2[i].setBean(bean);
				l2[i].setMilk(milk);
			}
			
			Coffee.latte += count;
			Coffee.bean += bean * count;
			Coffee.milk += milk * count;
			Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean * count;
			Coffee.milkTotalPrice += Coffee.milkUnitPrice * milk * count;
			
			return l2;
			
		}
		
		
		public Americano makeAmericano(int bean, int water, int ice) {
			
			Americano a1 = new Americano();
			a1.setBean(bean);
			a1.setWater(water);
			a1.setIce(ice);
			
			Coffee.americano ++;
			Coffee.bean += bean;
			Coffee.water += water;
			Coffee.ice += ice;
			Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
			Coffee.waterTotalPrice += Coffee.waterUnitPrice * water;
			Coffee.iceTotalPrice += Coffee.iceUnitPrice * ice;
			
			return a1;
			
		}		
		
		public Americano[] makeAmericano(int bean, int water, int ice, int count) {
			
			Americano[] a2 = new Americano[count];
			for(int i=0; i<count; i++) {
				a2[i] = new Americano();
				a2[i].setBean(bean);
				a2[i].setWater(water);
				a2[i].setIce(ice);
			}
			
			Coffee.americano += count;
			Coffee.bean += bean * count;
			Coffee.water += water * count;
			Coffee.ice += ice * count;
			Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean * count;
			Coffee.waterTotalPrice += Coffee.waterUnitPrice * water * count;
			Coffee.iceTotalPrice += Coffee.iceUnitPrice * ice * count;			
			
			return a2;
			
		}
		
		public void result() {
	
			System.out.println("============================");
			System.out.println("?????? ??????");
			System.out.println("============================");
			System.out.println();
			System.out.println();
			System.out.println("--------------------");
			System.out.println("?????? ?????????");
			System.out.println("--------------------");
			System.out.printf("???????????????: %d\n", Coffee.espresso);
			System.out.printf("???????????????: %d\n", Coffee.americano);
			System.out.printf("??????: %d\n", Coffee.latte);
			System.out.println();
			System.out.println();
			System.out.println("--------------------");
			System.out.println("????????? ?????????");
			System.out.println("--------------------");
			System.out.printf("??????: %dg\n", Coffee.bean);
			System.out.printf("???: %,dml\n", Coffee.water);
			System.out.printf("??????: %d???\n", Coffee.ice);
			System.out.printf("??????: %,dml\n", Coffee.milk);
			System.out.println("--------------------");
			System.out.println("?????????");
			System.out.println("--------------------");
			System.out.printf("??????: %,d???\n", Coffee.beanTotalPrice); 
			System.out.printf("???: %,.0f???\n", Coffee.waterTotalPrice);
			System.out.printf("??????: %,d???\n", Coffee.iceTotalPrice);
			System.out.printf("??????: %,d???", Coffee.milkTotalPrice); 
			
			
		}
		
	
}//Barista
