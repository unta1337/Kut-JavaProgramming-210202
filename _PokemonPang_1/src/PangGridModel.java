import java.util.Arrays;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 포켓몬팡의 모델 클래스: 게임 로직 구현
 */

public class PangGridModel {
	private Pokemon[][] gridData 
		= new Pokemon[PangUtility.NUMBEROFMONS][PangUtility.NUMBEROFMONS];
	/*
	 * 뷰 및 뷰와 통신할 때 사용하는 데이터
	 */
	private PangGridView view;
	
	public PangGridModel(PangGridView view){
		this.view = view;
	}

	public void initAssign(){
		//randomAssign();
		debugAssign();

		int[] temp = pangCheckColDir();
		if (temp != null) {
			for (int i = 0; i < 4; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		}

		System.out.println();

		temp = pangCheckRowDir();
		if (temp != null) {
			for (int i = 0; i < 4; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		}

		view.update(gridData);
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
	// 디버깅용
	private void debugAssign(){
		int[][] list = {
			{4,4,4,4,4,4,4},
			{3,0,2,2,2,0,1},
			{6,3,6,0,6,0,3},
			{6,6,5,0,2,0,5},
			{6,2,0,2,4,3,5},
			{6,2,3,3,3,5,5},
			{6,1,0,5,1,4,6},
		};
		for(int r=0; r<gridData.length; r++){
			for(int c=0; c<gridData[r].length; c++){
				gridData[r][c] = Pokemon.values()[list[r][c]];
			}
		}
		
	}
	
	private int[] pangCheckColDirWithRow(int row) {
		Pokemon target = gridData[row][0];

		int start = 0;
		int prevStart = -1;

		int count = 1;
		int prevCount = -1;

		for (int c = 1; c < gridData[row].length; c++) {
			if (gridData[row][c] == target) {
				count++;
			} else {
				prevCount = count;
				prevStart = start;

				count = 1;
				start = c;
				target = gridData[row][c];
			}
			
			if (prevCount >= 3)
				return new int[] { row, prevStart, row, prevStart + prevCount - 1 };
			else if (c == (gridData[row].length - 1) && count >= 3)
				return new int[] { row, start, row, start + count - 1 };
		}

		return null;
	}
	
	private int[] pangCheckColDir() {
		for (int r = 0; r < gridData.length; r++) {
			int[] temp = pangCheckColDirWithRow(r);

			if (temp != null)
				return temp;
		}
		
		return null;
	}

	private int[] pangCheckRowDirWithCol(int col) {
		Pokemon target = gridData[0][col];

		int start = 0;
		int prevStart = -1;

		int count = 1;
		int prevCount = -1;

		for (int r = 1; r < gridData[r].length; r++) {
			if (gridData[r][col] == target) {
				count++;
			} else {
				prevCount = count;
				prevStart = start;

				count = 1;
				start = r;
				target = gridData[r][col];
			}
			
			if (prevCount >= 3)
				return new int[] { prevStart, col, prevStart + prevCount - 1, col };
			else if (r == (gridData[r].length - 1) && count >= 3)
				return new int[] { start, col, start + count - 1, col };
		}

		return null;
	}
	
	private int[] pangCheckRowDir() {
		for (int c = 0; c < gridData[0].length; c++) {
			int[] temp = pangCheckRowDirWithCol(c);

			if (temp != null)
				return temp;
		}
		
		return null;
	}
	
	private int[] pangCheck() {
		int[] row = pangCheckColDir();
		if (row != null)
			return row;

		int[] col = pangCheckRowDir();
		if (col != null)
			return col;
		
		return null;
	}
}
