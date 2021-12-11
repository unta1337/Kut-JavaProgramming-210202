import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 명예의 전당 레코드
 */
public class HallOfFameData implements Serializable {
	private static final long serialVersionUID = 2807927863838072448L;
	private int rank;
	private String name;
	private LocalDateTime gameDate;
	private int score;
	public HallOfFameData(){}
	public HallOfFameData(String name, LocalDateTime gameDate, int score) {
		this.name = name;
		this.gameDate = gameDate;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public String getGameDate() {
		return String.format("%d년 %d월 %d일 %d시 %d분", 
			gameDate.getYear(), gameDate.getMonth().getValue(), gameDate.getDayOfMonth(), 
			gameDate.getHour(), gameDate.getMinute());
	}
	public LocalDateTime getDate(){
		return gameDate;
	}
	public int getRank() {
		return rank;
	}
	public int getScore() {
		return score;
	}
	public String getGameScore(){
		return String.format("%,d", score);
	}
	public void setRank(int rank){
		this.rank = rank;
	}
}

