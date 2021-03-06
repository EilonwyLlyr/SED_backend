package com.calstate.models;

import java.util.Objects;

public class Prediction {

	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	public Prediction() {
		super();
	}
	public Prediction(String t1, String t2, String t3, String t4, String t5, String t6) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getT3() {
		return t3;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getT4() {
		return t4;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	public String getT5() {
		return t5;
	}
	public void setT5(String t5) {
		this.t5 = t5;
	}
	public String getT6() {
		return t6;
	}
	public void setT6(String t6) {
		this.t6 = t6;
	}
	@Override
	public int hashCode() {
		return Objects.hash(t1, t2, t3, t4, t5, t6);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Prediction)) {
			return false;
		}
		Prediction other = (Prediction) obj;
		return Objects.equals(t1, other.t1) && Objects.equals(t2, other.t2) && Objects.equals(t3, other.t3)
				&& Objects.equals(t4, other.t4) && Objects.equals(t5, other.t5) && Objects.equals(t6, other.t6);
	}
	@Override
	public String toString() {
		return "Prediction [t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4 + ", t5=" + t5 + ", t6=" + t6 + "]";
	}
	
	
}
