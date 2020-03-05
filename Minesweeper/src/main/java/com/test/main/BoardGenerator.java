package com.test.main;

import java.util.ArrayList;
import java.util.List;

public class BoardGenerator {
	private static List<Integer> getMinePos(int mines, int cells){
		List<Integer> list=new ArrayList<Integer>(mines);
		for(int i=0;i<mines;i++) {
			int random = (int) Math.round(Math.random() * cells + 1);
			if(list.contains(random))
				i--;
			else
				list.add(random);
		}
		
		return list;
	}
	
	public static List<List<Integer>> getBoard(int mines, int x,int y){
		List<Integer> minePos=getMinePos(mines, x*y);
		List<List<Integer>> cellsList=new ArrayList<List<Integer>>(x);
		for(int i=0;i<x;i++) {
			List<Integer> temp=new ArrayList<Integer>(y);
			for(int j=0;j<y;j++) {
				if(minePos.contains((i)*x + j+1)) {
					temp.add(-1);
				}
				else {
					temp.add(0);
				}
			}
			cellsList.add(temp);
		}
		
		for(int i=0;i<x;i++) {
			System.out.println(cellsList.get(i));
		}
		System.out.println("**************");
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(cellsList.get(i).get(j)==-1) {
					for(int k=i-1;k<=i+1;++k) {
						for(int l=j-1;l<=j+1;++l) {
							if((k>=0 && k<x && l>=0 && l<y) && cellsList.get(k).get(l)!=-1 && !(k==i && l==j))
								cellsList.get(k).set(l,cellsList.get(k).get(l)+1);
						}
					}
				}
			}
		}
		
		for(int i=0;i<=x-1;i++) {
			System.out.println(cellsList.get(i));
		}
		
		return cellsList;
		
	}
	
}
