package com.meng.coding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelope
{

	public static void main(String[] args)
	{
		RussianDollEnvelope rde = new RussianDollEnvelope();
		int[][] envs = {{1,15},{7,18},{7,6},{7,100},{2,200},{17,30},{17,45},
				{3,5},{7,8},{3,6},{3,10},{7,20},{17,3},{17,45}};
		System.out.println(rde.maxEnvelopes(envs));
	}
	
	static class Env {
        int w;
        int h;
        Env(int w, int h) {
            this.w = w;
            this.h = h;
        }
        @Override
        public String toString(){
        	return w + " " +h;
        }
    }
	
	
    public int maxEnvelopes(int[][] envelopes) {
    	
        List<Env> list = new ArrayList<>();
        for (int[] env : envelopes) {
            list.add(new Env(env[0], env[1]));
        }
        list.sort(Comparator.comparing((Env env) -> env.w).thenComparing((Env env) -> -env.h));
        System.out.println(list);
        List<Env> target = new ArrayList<>();
        for (Env env : list) {
        	if (target.isEmpty()) {
        		target.add(env);
        	} else {
        		Env last = target.get(target.size() - 1);
        		if (env.w > last.w && env.h > last.h) {
        			target.add(env);
        		} else if(env.h < last.h){
        			int idx = binarySearch(target, env);
        			if (idx >= 0) {
        				target.set(idx, env);
        			}
        		} 
        	}       	
        }
        return target.size();
    }

	private int binarySearch(List<Env> target, Env env)
	{
		int start = 0, end = target.size() - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (target.get(mid).h > env.h) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return target.get(start).h > env.h ? start : end;
	}

}
