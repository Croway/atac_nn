package com.croway.atacnn;

import org.springframework.beans.BeanUtils;

public class Test {
	
	public static void main(String[] args) {
		Test t = new Test();
		A t1 = t.new A();
		t1.setA("PROVA A");
		B t2 = t.new B();
		t2.setC("PROVA C");
		t1.setB(t2);
		
		C t3 = t.new C();
		BeanUtils.copyProperties(t1, t3);
	}

	class A {
		String a;
		B b;

		/**
		 * @return the a
		 */
		public String getA() {
			return a;
		}

		/**
		 * @param a
		 *            the a to set
		 */
		public void setA(String a) {
			this.a = a;
		}

		/**
		 * @return the b
		 */
		public B getB() {
			return b;
		}

		/**
		 * @param b
		 *            the b to set
		 */
		public void setB(B b) {
			this.b = b;
		}

	}

	class B {
		String c;

		/**
		 * @return the c
		 */
		public String getC() {
			return c;
		}

		/**
		 * @param c
		 *            the c to set
		 */
		public void setC(String c) {
			this.c = c;
		}

	}

	class C {
		String a;
		D b;

		/**
		 * @return the a
		 */
		public String getA() {
			return a;
		}

		/**
		 * @param a
		 *            the a to set
		 */
		public void setA(String a) {
			this.a = a;
		}

		/**
		 * @return the b
		 */
		public D getB() {
			return b;
		}

		/**
		 * @param b
		 *            the b to set
		 */
		public void setB(D b) {
			this.b = b;
		}

	}

	class D {
		String c;

		/**
		 * @return the c
		 */
		public String getC() {
			return c;
		}

		/**
		 * @param c
		 *            the c to set
		 */
		public void setC(String c) {
			this.c = c;
		}

	}
}
