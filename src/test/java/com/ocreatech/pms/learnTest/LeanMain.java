package com.ocreatech.pms.learnTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class LeanMain {

	public static void main(String[] args) {
		/**
		 *  枚举类一些常用方法
		 */
		DayEnum day1 = DayEnum.MONDAY;
		DayEnum day5 = DayEnum.FRIDAY;
		System.out.println(day5.compareTo(day1));
        System.out.println(day1.ordinal());
        System.out.println(day1.name());
        System.out.println(DayEnum.values());
        for(DayEnum day: DayEnum.values()) {
        	day.getInfo();
        }
        
        /**
         *  抽象类实例化
         */
        AbstactTest test = new AbstactTest() {
			
			@Override
			public void getInfo() {
				System.out.println("测试");
			}
		};
		test.getInfo();
		
		/**
		 *  Stream  可对int、double、long等基本数据类型做一些统计
		 */
		List<Integer> numList = Arrays.asList(2,5,23,242,4,23,45);
		IntSummaryStatistics statistics = numList.stream().mapToInt(e-> e).summaryStatistics();
		System.out.println(statistics.getSum());
		System.out.println(statistics.getMax());
		System.out.println(statistics.getAverage());
		
		/**
		 * java8 Date/Time api  学习链接 https://www.cnblogs.com/chenpi/p/5970172.html
		 * java8  中我们可以使用LocalDate 、LocalTime 、LocalDateTime来表示日期和时间，拥有极为方便的API满足业务需求，并且和数据库的字段可直接对应。
		 */
		Date date = new Date();
		System.out.println(date);
		// 获取当前日期
		LocalDate now = LocalDate.now();
		System.out.println("获取当前日期-----"+now);
		// 根据参数生成日期
		System.out.println("根据年月日生成日期-----"+LocalDate.of(2019, 1, 24));
		// 获取当前月份的第一天
		System.out.println("获取当前月份的第一天-----"+now.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println("获取当前月份的第一天-----"+LocalDate.of(now.getYear(), now.getMonth(), 1));
		// 获取指定月份的第一天
		System.out.println("获取指定月份的第一天-----"+now.with(Month.JULY).with(TemporalAdjusters.firstDayOfMonth()));
		// 获取当前月份的最后一天
		System.out.println("获取当前月份的最后一天-----"+now.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println("获取当前月份的最后一天-----"+LocalDate.of(now.getYear(), now.getMonth().plus(1), 1).minusDays(1));
		// 当前时间是一年中的第几天
		System.out.println("当天所在这一年的第几天（从1开始)-----"+now.getDayOfYear());
		// 当天是星期几
		System.out.println("当天是星期几-----"+now.getDayOfWeek());
		System.out.println("当天是星期几-----"+now.getDayOfWeek().getValue());
		// 获取上周一的日期
		System.out.println("获取上周一的日期-----"+now.minusWeeks(1).with(DayOfWeek.MONDAY));
		// 获取上周日的日期
		System.out.println("获取上周日的日期-----"+now.minusWeeks(1).with(DayOfWeek.SUNDAY));
		// 获取当前时间
		System.out.println("获取当前时间-----"+LocalTime.now());
		// 获取当前日期+时间
		System.out.println("获取当前日期+时间-----"+LocalDateTime.now());
		// 格式化时间
		System.out.println("格式化时间-----"+LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		// 将字符串转换为时间
		System.out.println("将字符串转换为时间-----"+LocalDateTime.parse("2007-12-03T10:15:30"));
		System.out.println("将字符串转换为时间-----"+LocalDateTime.parse("2007-12-03T10:15:30", DateTimeFormatter.ISO_DATE_TIME));
		
		
		/**
		 * java8 Optional
		 * 学习链接：http://www.cnblogs.com/zhangboyu/p/7580262.html
		 */
		String a = "adbdd132232";
		String b = null;
		String c = "null";
		String d = "";
		Optional<String> aOp = Optional.ofNullable(a);
		Optional<String> bOp = Optional.ofNullable(b);
		Optional<String> cOp = Optional.ofNullable(c);
		Optional<String> dOp = Optional.ofNullable(d);
		String a1 = new String("adbdd132232");
		String b1 = null;
		String c1 = "null";
		String d1 = "";
		Optional<String> a1Op = Optional.ofNullable(a1);
		Optional<String> b1Op = Optional.ofNullable(b1);
		Optional<String> d1Op = Optional.ofNullable(d1);
		if(a1Op.equals(aOp)) {
			System.out.println("a1Op=aOp");
		}
		if(aOp.orElse("").equals(a1)) {
			System.out.println("a=a1");
		}
		if(aOp.orElse("") == a1) {
			System.out.println("a==a1");
		}
		if(bOp.orElse("").equals(b1Op.orElse(""))) {
			System.out.println("b=b1");
		}
		if(bOp.orElse("").equals(d1Op.orElse(""))) {
			System.out.println("b=d1");
		}
		if(cOp.orElse("").equals(c1)) {
			System.out.println("c=c1");
		}
		if(dOp.orElse("").equals(d1)) {
			System.out.println("d=d1");
		}
		System.out.println(bOp.map(String::getBytes));
		System.out.println(dOp.filter(e -> "".equals(e)));
		/**
		 *  链式调用
		 */
		AddressOP ad = new AddressOP();
		ad.setName("name");
		House hourse = new House();
		hourse.setSize("3");
		ad.setHourse(hourse);
		// 以前的写法，为了处理空指针
		String size = "";
		if(ad != null) {
			House hs = ad.getHourse();
			if(hs != null) {
				size = hs.getSize();
			}
		}
		System.out.println(size);
		// 现在的写法
		size = Optional.ofNullable(ad).map(AddressOP::getHourse).map(House::getSize).orElse("defalut");
		System.out.println(size);
		// 以前的写法
		if (ad != null && ad.getHourse() != null) {
			size = ad.getHourse().getSize();
		}
		// 现在的写法
		ad = null;
		size = Optional.ofNullable(ad).map(AddressOP::getHourse).map(House::getSize).orElse(null);
	}

}
