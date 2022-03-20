package com.data;

import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) {
		DataDriven dataDriven = new DataDriven();
		ArrayList data = dataDriven.getData("Add Profile","testdata");
		
		data.stream().forEach(s->System.out.println(s.toString()));

	}

}
