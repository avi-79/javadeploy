package com.springmvc.etg;

import org.springframework.stereotype.Component;

@Component
public class Add implements AddInterface {

	@Override
	public int add(int x, int y) {
		return x+y;
	}

}
