package assignment2;

/**
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to think the extra credit question. 
 * The deadline of this assignment is 09/21/2018 23:59 PST.
 * Please feel free to contact Amanda and Zane for any questions.
 */


class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
	    // scores: 2/2
    		//write your code here
    	this.name=name;
    	this.age = age;
    	this.gender = gender;
    	this.salary = salary;
    }

    public String getName() {
    		//write your code here
    	return this.name;
    }

    public void setName(String name) {
    		//write your code here
    	this.name = name;
    }
    public void raiseSalary(double byPercent) {
    	this.salary = this.salary*(1+byPercent);
    }
}

enum Gender {
    MALE,
    FEMALE;
}


public class assignment {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
	    // scores: 2/2
        //write your code here
    	double tax;
    	if(employee.salary <= 8900) {
    		tax = employee.salary*0.062;
    	} else {
    		tax = 106800*0.062;
    	}
    	System.out.println(tax);
    	return tax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
	    // scores: 2/2
        //write your code here
    	double rate;
    	if(employee.age<35) {
    		rate = employee.salary * 0.03;
    	}else if(employee.age>=35&&employee.age<=50) {
    		rate = employee.salary * 0.04;
    	}else if(employee.age>=50&&employee.age<=60) {
    		rate = employee.salary * 0.05;
    	}else {
    		rate = employee.salary * 0.06;
    	}
    	System.out.println(rate);
    	return rate;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public static void sortSalary(Employee e1, Employee e2, Employee e3) {
	    // scores: 2/2
        //write your code here
    	String[] str=new String [3];
    	if(e1.salary<=e2.salary) {
    		if(e2.salary<=e3.salary) {
    			str[0]=e1.name;
    			str[1]=e2.name;
    			str[2]=e3.name;
    		}else {
    			if(e1.salary<=e3.salary) {
        			str[0]=e1.name;
        			str[1]=e3.name;
        			str[2]=e2.name;
    			}else {
        			str[0]=e3.name;
        			str[1]=e1.name;
        			str[2]=e2.name;
    			}
    		}
    	}else {
    		if(e2.salary<=e3.salary) {
    			if(e3.salary<=e1.salary) {
        			str[0]=e2.name;
        			str[1]=e3.name;
        			str[2]=e1.name;
    			}else {
        			str[0]=e2.name;
        			str[1]=e1.name;
        			str[2]=e3.name;
    			}
    		}else {
    			str[0]=e3.name;
    			str[1]=e2.name;
    			str[2]=e1.name;
    		}
    	}
		System.out.print(str[0]+" "+str[1]+" "+str[2]+"\n");

    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public static void tripleSalary(Employee employee) {
	    // scores: 2/2
	    // We'd better not modify the employee data in this funtion. 
	    // In stead we'd better write a function in `Employee` class called `public void raiseSalary(double byPercent)`.
    // Then in `tripleSalary` we just call `employee.raiseSalary(percent);`
        //write your code here
    	employee.salary = employee.salary*3;
    }


    //Extra credit
	
	// Great job!

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     The function swap() is to swap two objects not two values. Thus, this function just swap two references, which point to the value, but not the value of the objects.
     and this function just swap the parameter, so the function only affect the references of each object, but won't affect the reference of the argument.
     If the function want to swap the value, the function can swap all attributes of each object.
    
    
    
        /*we can replace swap() function with codes below to get the wanted answer. 
         ****** The changes of the codes***********
   
	      String tempName = a.name;
	      a.name = b.name;
	      b.name = tempName;
	      
	      int tempAge = a.age;
	      a.age = b.age;
	      b.age = tempAge;
	      
	      Gender tempGender = a.gender;
	      a.gender = b.gender;
	      b.gender = tempGender;
	      
	      double tempSalary = a.salary;
	      a.salary = b.salary;
	      b.salary = tempSalary;
	 
	     * **************************
         */
    
    
    
  
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
//        Employee c = new Employee("Johny", 60, Gender.MALE, 8000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
//        sortSalary(a,b,c);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }    
    public static void swap(Employee x , Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }



}

// Total scores: 10/10
