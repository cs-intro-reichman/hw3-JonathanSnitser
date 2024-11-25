// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(sqrt(25)); //my test
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1++;
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1--;
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = x1;
		if (x1 > 0) {
			if (x2 > 0) {
				for (int i = 1; i < x2; i++) {
					sum = plus(sum , x1);
				}
			}
			if (x2 < 0) {
				for (int i = 1; i > x2; i--) {
					sum = minus(sum , x1);
				}
			}
		} else if (x1 < 0) {
			if (x2 > 0) {
				for (int i = 1; i < x2; i++) {
					sum = plus(sum , x1);
				}
			}
			if (x2 < 0) {
				for (int i = 1; i > x2; i--) {
					sum = minus(sum , x1);
				}
		}
		}
		if (x2 == 0 || x1 == 0) {
			sum = 0;
		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = x;
		if (n == 0) {
			return 1;
		}
		if (x < 0) {
			for (int i = 1; i < n; i++){
				pow = times(pow , x);
			}
		} else {
			for (int i = 1; i < n; i++){
				pow = times(pow , x);
			}
		}

		return pow;
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i = 0;
		if (x1 == 0) {
			i = 0;
		}
		if (x1 > 0) {
			if (x2 > 0){
				while (x1 > 0) {
					if (minus(x1 , x2) >= x2) {
						x1 = minus(x1 , x2);
						i++;
					}else if ( minus(x1 , x2) < x2 && minus(x1 , x2) >= 0) {
						i++;
						x1 = minus(x1 , x2);
					} else {
						x1 = minus(x1 , x2);
					}
				}
			}
			if (x2 < 0){
				while (x1 > 0) {
					if (minus(x1 , x2) >= x2) {
						x1 = minus(x1 , x2);
						i++;
					}else if ( minus(x1 , x2) < x2 && minus(x1 , x2) >= 0) {
						i++;
						x1 = minus(x1 , x2);
					} else {
						x1 = minus(x1 , x2);
					}
				i = times (i , -1);
				}
				
			}
		} else if (x1 < 0) {
			if (x2 > 0){
				x1 = times(x1 , -1);
				while (x1 > 0) {
					if (minus(x1 , x2) >= x2) {
						x1 = minus(x1 , x2);
						i++;
					}else if ( minus(x1 , x2) < x2 && minus(x1 , x2) >= 0) {
						i++;
						x1 = minus(x1 , x2);
					} else {
						x1 = minus(x1 , x2);
					}
				}
				i = times(i , -1);
			}
			if (x2 < 0){
				while (x1 < 0) {
					if (minus(x1 , x2) <= x2) {
						x1 = minus(x1 , x2);
						i++;
					}else if ( minus(x1 , x2) > x2 && minus(x1 , x2) <= 0) {
						i++;
						x1 = minus(x1 , x2);
					} else {
						x1 = minus(x1 , x2);
					}
				} 
			}
		}
		return i;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int sum = 0;
		while (sum < x1) {
			sum = plus(sum , x2);
			if (sum == x1) {
				break;
			}
		}
		if (sum == x1) {
			return 0;
		} else {
			sum = minus(x1 , minus(sum , x2)); 
			return sum;
		}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int num = 1;
		if (x == 0) return 0;
		while (times(num , num) < x){
			num++;
			if (times(num , num) > x) {
				return minus(num , 1);
			}
		}
		return num; 
	}	  	  
}