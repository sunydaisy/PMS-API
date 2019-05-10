package com.ocreatech.pms.learnTest;

public interface Food {
	
	enum Vegetables implements Food {
		TOMATO,SALARY,POTATO
	}

	
	enum Meat implements Food {
		BEEF,MUTTON
	}
	
	enum Drinks implements Food {
		ORINGIN_JUICE,COCONUT_JUICE
	}
}
