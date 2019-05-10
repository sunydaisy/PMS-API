package com.ocreatech.pms.learnTest;

public enum DayEnum {
	MONDAY("星期一"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+1);
		}
		
	}, 
	TUESDAY("星期二"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+2);
			
		}
		
	}, 
	WEDNESDAY("星期三"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+3);
			
		}
		
	}, 
	THURSDAY("星期四"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+4);
		}
		
	}, 
	FRIDAY("星期五"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+5);
			
		}
		
	}, 
	SATURDAY("星期六"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+6);
			
		}
		
	}, 
	SUNDAY("星期七"){

		@Override
		public void getInfo() {
			System.out.println(this.desc+7);
			
		}
		
	};
	
	protected String desc;
	
	private DayEnum(String desc) {
		this.desc = desc;
	}
	
	public abstract void getInfo();
}
