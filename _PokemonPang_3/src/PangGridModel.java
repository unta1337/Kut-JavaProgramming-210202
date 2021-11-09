// 2020136018 김성녕

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 포켓몬팡의 모델 클래스: 게임 로직 구현
 */

public class PangGridModel {
	private Pokemon[][] gridData 
		= new Pokemon[PangUtility.NUMBEROFMONS][PangUtility.NUMBEROFMONS];
	private int gameOverCount = 60;
	private PangGridView view;
	// 전체가 아니라 일부 위치가 갱신하기 위한 위치 목록
	private List<Location> locationList = new ArrayList<>();
	
	public PangGridModel(PangGridView view){
		this.view = view;
	}

	public void initAssign(){
		randomAssign();
		removePang();
		view.update(gridData);
		findHints();
	}
	
	private void removePang() {
		int[][] checkMatrix = new int[PangUtility.GRIDSIZE][PangUtility.GRIDSIZE];
		if(checkColumn(checkMatrix)){
			for(int r=0; r<PangUtility.GRIDSIZE; r++)
				for(int c=0; c<PangUtility.GRIDSIZE; c++)
					if(checkMatrix[r][c]==2) changePokemon(r,c);
		}
		checkMatrix = new int[PangUtility.GRIDSIZE][PangUtility.GRIDSIZE];
		if(checkRow(checkMatrix)){
			for(int r=0; r<PangUtility.GRIDSIZE; r++)
				for(int c=0; c<PangUtility.GRIDSIZE; c++)
					if(checkMatrix[r][c]==2) changePokemon(r,c);
		}
	}
	
	/**
	 * 주어진 위치의 포켓몬을 바꾸어 팡을 제거함 
	 * * 현재 포켓몬과 주변 4개와 다른 포켓몬으로 교체
	 */
	private void changePokemon(int r, int c){
		Set<Pokemon> set = EnumSet.range(Pokemon.BULBASAUR,Pokemon.SQUIRTLE);
		set.remove(gridData[r][c]);
		for(var d: PangUtility.delta)
			if(Location.valid(r+d[0],c+d[1])) set.remove(gridData[r+d[0]][c+d[1]]);
		Pokemon[] list = new Pokemon[set.size()];
		set.toArray(list);
		gridData[r][c] = list[ThreadLocalRandom.current().nextInt(list.length)];
	}
	/**
	 * 행 기준으로 팡의 존재를 검사  
	 * 팡이 발견된 위치는 모두 1로 바꾸고
	 * 초기 팡 제거를 위해 포켓몬을 바꾸어야 하는 위치는 2로 바꿈
	 */
	private boolean checkRow(int[][] checkMatrix){
		boolean found = false;
		for(int r=0; r<PangUtility.GRIDSIZE; ++r){
			int c=0;
			while(c<PangUtility.GRIDSIZE-2){
				if(gridData[r][c].isNormal()){
					int count = 1;
					for(int i=c+1; i<PangUtility.GRIDSIZE; ++i){
						if(gridData[r][c]==gridData[r][i]) ++count;
						else break;
					}
					if(count>=3){
						found = true;
						for(int i=c; i<c+count; i++) checkMatrix[r][i] = 1;
						checkMatrix[r][c+2] = 2;
						if(count>=6) checkMatrix[r][c+5] = 2;
					}
					c += count;
				}
				else ++c;
			}
		}
		return found;
	}
	
	/**
	 * 열 기준으로 팡의 존재를 검사  
	 * 팡이 발견된 위치는 모두 1로 바꾸고
	 * 초기 팡 제거를 위해 포켓몬을 바꾸어야 하는 위치는 2로 바꿈
	 */
	private boolean checkColumn(int[][] checkMatrix){
		boolean found = false;
		for(int c=0; c<PangUtility.GRIDSIZE; ++c){
			int r=0;
			while(r<PangUtility.GRIDSIZE-2){
				if(gridData[r][c].isNormal()){
					int count = 1;
					for(int i=r+1; i<PangUtility.GRIDSIZE; ++i){
						if(gridData[r][c]==gridData[i][c]) ++count;
						else break;
					}
					if(count>=3){
						found = true;
						for(int i=r; i<r+count; ++i) checkMatrix[i][c] = 1;
						checkMatrix[r+2][c] = 2;
						if(count>=6) checkMatrix[r+5][c] = 2;
					}
					r += count;
				}
				else ++r;
			}
		}
		return found;
	}
	
	/**
	 * 7개 포켓몬들을 임의로 배치 
	 */
	private void randomAssign(){
		for(int r=0; r<gridData.length; r++){
			for(int c=0; c<gridData[r].length; c++){
				gridData[r][c] = Pokemon.getRandomNormalPokemon();
			}
		}
	}
	
	boolean findHints(){
		List<Location> hintLocs = getHintLocations();
		return !hintLocs.isEmpty();
	}
	
	private List<Location> getHintLocations(){
		List<Location> hintLocs = new ArrayList<>();
		for(int r=0; r<PangUtility.GRIDSIZE; r++){
			for(int c=0; c<PangUtility.GRIDSIZE; c++){
				if(leftEquals(r,c)||rightEquals(r,c)||upEquals(r,c)||downEquals(r,c)){
					hintLocs.add(new Location(r,c));
				}
			}
		}
		return hintLocs;
	}
	
	/**
	 * 팡이 있는 곳에 포켓몬을 포켓몬공으로 바꾸세요.
	 * checkRow, checkColumn의 결과를 활용하면 쉽게 구현 가능
	 */
	public boolean checkAndMark(){
		int[][] checkMatrix = new int[gridData.length][gridData[0].length];
		boolean checked = false;
		
		checkRow(checkMatrix);
		checkColumn(checkMatrix);
		
		for (int r = 0; r < gridData.length; r++) {
			for (int c = 0; c < gridData[r].length; c++) {
				if (checkMatrix[r][c] >= 1) {
					gridData[r][c] = Pokemon.POKEBALL;
					checked = true;
				}
			}
		}
		
		return checked;
	}
	
	/*
	 * 팡 위치 위에 있는 포켓몬들을 아래로 내려 포켓볼들이 맨 위에 위치하도록 함
	 * 열 단위로 작업하면 편리하게 구현 가능
	 */
	public void pushUpMarked(){
		view.update(gridData);

		for (int c = 0; c < gridData.length; c++) {
			for (int r = gridData.length - 1; r > 0; r--) {
				for (int rr = gridData.length - 1; rr > 0; rr--) {
					if (gridData[rr][c] == Pokemon.POKEBALL) {
						Pokemon temp  = gridData[rr][c];
						gridData[rr][c] = gridData[rr - 1][c];
						gridData[rr - 1][c] = temp;
					}
				}
			}
		}

		//view.update(gridData);
	}
	/**
	 * 포켓몬공이 있는 위치를 새로운 랜덤 포켓몬으로 교체함
	 * 포켓몬공은 모두 위로 이동한 후에 사용되는 메소드
	 */
	public void replaceMarked(){
		// 볼 있는 위치만 교체 
		for(int c=0; c<PangUtility.GRIDSIZE; c++){
			for(int r=0; r<PangUtility.GRIDSIZE; r++){
				if(gridData[r][c]==Pokemon.POKEBALL) 
					gridData[r][c] = Pokemon.getRandomNormalPokemon();
				else break;
			}
		}
		view.update(gridData);
	}
	/**
	 * 사용자가 클릭한 두 개의 셀이 인접한 셀이고 교환하였을 때 팡이 되는지?
	 */
	public boolean isValidSwap(Location srcLoc, Location destLoc) {
		return isValidSwapRec(srcLoc, destLoc, 0);
	}
	public boolean isValidSwapRec(Location srcLoc, Location destLoc, int depth){
		if (depth == 2)
			return false;

		int rowDir = destLoc.r() - srcLoc.r();
		int colDir = destLoc.c() - srcLoc.c();

		boolean rowCondition = Math.abs(rowDir) == 1;
		boolean colCondition = Math.abs(colDir) == 1;
		
		if (!(rowCondition || colCondition))
			return false;
		
		Pokemon target = gridData[srcLoc.r()][srcLoc.c()];
		
		if (target == Pokemon.POKEBALL)
			return false;

		// 행방향 체크.
		int count = 1;

		int y;

		if (rowDir == 0 || rowDir == -1) {
			y = destLoc.r() - 1;
			while (y >= 0 && gridData[y--][destLoc.c()] == target) count++;
		}

		if (rowDir == 0 || rowDir == 1) {
			y = destLoc.r() + 1;
			while (y < gridData.length && gridData[y++][destLoc.c()] == target) count++;
		}
		
		if (count >= 3) {
			return true;
		}

		// 열방향 체크.
		count = 1;
		
		int x;

		if (colDir == 0 || colDir == -1) {
			x = destLoc.c() - 1;
			while (x >= 0 && gridData[destLoc.r()][x--] == target) count++;
		}

		if (colDir == 0 | colDir == 1) {
			x = destLoc.c() + 1;
			while (x < gridData[destLoc.r()].length && gridData[destLoc.r()][x++] == target) count++;
		}
		
		if (count >= 3) {
			return true;
		}
		
		return isValidSwapRec(destLoc, srcLoc, depth + 1);
	}
	/**
	 * 사용자가 선택한 두 개의 셀을 실제 교환함
	 */
	public void swap(Location srcLoc, Location destLoc){
		Pokemon tmp = gridData[srcLoc.r()][srcLoc.c()];
		gridData[srcLoc.r()][srcLoc.c()] = gridData[destLoc.r()][destLoc.c()];
		gridData[destLoc.r()][destLoc.c()] = tmp;
		locationList.clear();
		locationList.add(srcLoc);
		locationList.add(destLoc);
		view.update(gridData, locationList);
	}
	
	private boolean equals(Pokemon... list){
		if(list.length<=1) throw new IllegalArgumentException();
		Pokemon p = list[0];
		for(int i=1; i<list.length; i++)
			if(p!=list[i]) return false;
		return true;
	}
	/*
	 *  1) x@xx
	 *  2) 	 x
	 * 		x@
	 *  	 x
	 *  3) 	 x
	 *  	 x
	 *  	x@
	 *  4) 	x@
	 *  	 x
	 *  	 x
	 */
	private boolean rightEquals(Location loc){
		return rightEquals(loc.r(), loc.c());
	}
	private boolean rightEquals(int r, int c){		
		return 
			((Location.valid(r, c+3) // <x>@xx
				&&equals(gridData[r][c],gridData[r][c+2],gridData[r][c+3]))||
			(Location.valid(r-1, c+1)&&Location.valid(r+1, c+1)
				&&equals(gridData[r][c],gridData[r-1][c+1],gridData[r+1][c+1]))||
			(Location.valid(r-2,c+1)
				&&equals(gridData[r][c],gridData[r-1][c+1],gridData[r-2][c+1]))||
			(Location.valid(r+2, c+1)
				&&equals(gridData[r][c],gridData[r+1][c+1],gridData[r+2][c+1])));
	}
	/*
	 *  1) xx@x
	 *  2) 	x
	 * 		@x
	 *  	x
	 *  3) 	x
	 *  	x
	 *  	@x
	 *  4) 	@x
	 *  	x
	 *  	x
	 */
	private boolean leftEquals(Location loc){
		return leftEquals(loc.r(), loc.c());
	}
	private boolean leftEquals(int r, int c){		
		return ((Location.valid(r, c-3)
				&&equals(gridData[r][c],gridData[r][c-2],gridData[r][c-3]))||
			(Location.valid(r-1, c-1)&&Location.valid(r+1, c-1)
				&&equals(gridData[r][c],gridData[r-1][c-1],gridData[r+1][c-1]))||
			(Location.valid(r-2, c-1)
				&&equals(gridData[r][c],gridData[r-1][c-1],gridData[r-2][c-1]))||
			(Location.valid(r+2, c-1)
				&&equals(gridData[r][c],gridData[r+1][c-1],gridData[r+2][c-1])));
	}
	/*
	 *  1) 	x
	 *  	x
	 *  	@
	 *  	x
	 *  2) 	x@x
	 * 		 x
	 *  3) 	xx@
	 *  	  x
	 *  4) 	@xx
	 *  	x
	 */
	private boolean upEquals(Location loc){
		return upEquals(loc.r(), loc.c());
	}
	private boolean upEquals(int r, int c){		
		return ((Location.valid(r-3, c)
				&&equals(gridData[r][c],gridData[r-2][c],gridData[r-3][c]))||
			(Location.valid(r-1, c-1)&&Location.valid(r-1, c+1)
				&&equals(gridData[r][c],gridData[r-1][c-1],gridData[r-1][c+1]))||	
			(Location.valid(r-1, c-2)
				&&equals(gridData[r][c],gridData[r-1][c-1],gridData[r-1][c-2]))||
			(Location.valid(r-1, c+2)
				&&equals(gridData[r][c],gridData[r-1][c+1],gridData[r-1][c+2])));
		
	}
	/*
	 *  1) 	x
	 *  	@
	 *  	x
	 *  	x
	 *  2) 	 x
	 * 		x@x
	 *  3) 	  x
	 *  	xx@
	 *  4) 	x
	 *  	@xx
	 */
	private boolean downEquals(Location loc){
		return downEquals(loc.r(), loc.c());
	}
	private boolean downEquals(int r, int c){		
		return ((Location.valid(r+3, c)
				&&equals(gridData[r][c],gridData[r+2][c],gridData[r+3][c]))||
			(Location.valid(r+1, c-1)&&Location.valid(r+1, c+1)
				&&equals(gridData[r][c],gridData[r+1][c-1],gridData[r+1][c+1]))||		
			(Location.valid(r+1, c-2)
				&&equals(gridData[r][c],gridData[r+1][c-1],gridData[r+1][c-2]))||
			(Location.valid(r+1, c+2)
				&&equals(gridData[r][c],gridData[r+1][c+1],gridData[r+1][c+2])));
	}
	
	public void updateGameTime(){
		--gameOverCount;
		view.updateTime(gameOverCount+"");
	}
	
	public boolean isGameOver(){
		return gameOverCount==0;
	}
}
