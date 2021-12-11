import javafx.scene.image.Image;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 포켓몽 열거형: 게임맵에 등장하는 포켓몬들
 * 이상해 ~ 꼬부기: 기본적으로 등장하는 7개 포켓몽
 * 망나뇽 ~ 잠맘보: 특수 아이템 포켓몽
 */
public enum Pokemon {
	BULBASAUR("./image/bulbasaur.png"), 	// 이상해
	CHARMANDER("./image/charmander.png"), 	// 피아리
	CYNDAQUIL("./image/cyndaquil.png"), 	// 브케인 
	EEVEE("./image/eevee.png"),				// 이브이 
	JIGGLYPUFF("./image/jigglypuff.png"),	// 푸린 
	PIKACHU("./image/pikachu.png"), 		// 피카추 
	SQUIRTLE("./image/squirtle.png"), 		// 꼬부기
	POKEBALL("./image/pokeball.png"),		// 체크 용도 
	DRAGONITE("./image/dragonite.png"), 	// 망나뇽  특수 아이템 
	DUSKULL("./image/duskull.png"), 		// 해골  특수 아이템
	SNORLAX("./image/snorlax.png"), 		// 잠맘보  특수 아이템
	JOKER("./image/joker.png"); 			// 조커  준 특수 아이템, 준 특수 아이템 취급으로 자연 생성되지는 않지만 특수 포켓몬으로 분류되지도 않음.
	private Image image;
	private Pokemon(String fileName){
		this.image = new Image(fileName);
	}
	public Image getImage(){
		return image;
	}
	public boolean isNormal() {
		return this.ordinal()<PangUtility.NUMBEROFMONS;
	}
	public boolean isSpecial() {
		return switch(this) {
			case DRAGONITE, DUSKULL, SNORLAX -> true;
			default -> false;
		};
	}
	public static Pokemon getRandomNormalPokemon() {
		return Pokemon.values()[ThreadLocalRandom.current().nextInt(PangUtility.NUMBEROFMONS)];
	}
}
