package com.ocreatech.pms.learnTest.mian;

import org.springframework.beans.BeanUtils;

import com.ocreatech.pms.learnTest.model.Education;
import com.ocreatech.pms.learnTest.model.Person;

public class BeanUtilLearn {

	public static void main(String[] args) {
		/**
		 * copyPropertity()   总结--不会进行深度拷贝
		 */
		Education edu = new Education();
		edu.setSchool("安徽大学");
		edu.setDiploma("本科");
        Person person = new Person("小青","18",edu);
        Person person1 = new Person();
        BeanUtils.copyProperties(person, person1);
        person1.getEducation().setDiploma("研究生");
        System.out.println("-------"+person);
        System.out.println("-------"+person1);
        
        /**
         * clone，深度拷贝
         */
        Person person2 = person.clone(); 
        person2.getEducation().setDiploma("高中");
        System.out.println("-------"+person);
        System.out.println("-------"+person2);
	}

}
