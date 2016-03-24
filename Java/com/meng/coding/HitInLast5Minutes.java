package com.meng.coding;

import java.util.Date;

public class HitInLast5Minutes {
	
	class HitCount{
		int count;
		long time;
	}

	public static void main(String[] args) throws InterruptedException {
		HitInLast5Minutes h = new HitInLast5Minutes();
		h.hit();
		h.hit();
		h.hit();
		Thread.sleep(1000);
		h.hit();
		h.hit();
		System.out.println(h.getHits());

	}
	
	private HitCount[] buffer;
	
	public HitInLast5Minutes(){
		buffer = new HitCount[300];
		for (int i = 0; i < 300; i++) { //can not use for each to initialize the array!!!
			buffer[i] = new HitCount();
		}
	}
	
	public void hit(){
		long now = new Date().getTime()/1000;
		int idx = (int) (now % 300);
		if (buffer[idx].time != now) {
			buffer[idx].count = 1;
		} else {
			buffer[idx].count++;
		}
		buffer[idx].time = now;
	}
	
	public int getHits() {
		long now = new Date().getTime()/1000;
		int hits = 0;
		for (int i = 0; i < 300; i++) {
			if (buffer[i].time > now - 300) {
				hits += buffer[i].count;
			}
		}
		return hits;
	}

}
