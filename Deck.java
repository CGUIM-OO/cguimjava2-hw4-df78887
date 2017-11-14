import java.util.ArrayList;
import java.util.Random;

public class Deck{
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed;
	public Deck(int nDeck){
		cards=new ArrayList<Card>();//存放Card
		usedCard=new ArrayList<Card>();//存放發出過的Card
		for(int d=0;d<nDeck;d++)//產生Card
		{
			for(Card.Suit s:Card.Suit.values())
	        {
	        	for(int j=1;j<14;j++)
	        	{
	        		Card card=new Card(s,j);
	        		cards.add(card);
	        	}
	        }
		}
		shuffle();//一開始洗牌
	}
	public void printDeck(){
		for(int i=0;i<cards.size();i++)
		{
			
			Card card = new Card (cards.get(i).getSuit(),cards.get(i).getRank());
			//將每一張card的數值實體化
			card.printCard();
			//使用printCard將實體化後的card顯示在螢幕上
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	public void shuffle(){//洗牌
		Random rnd = new Random();
		int j = rnd.nextInt(52);
		for(int i=0;i<52;i++)
		{
			Card tmp = cards.get(i);//設一個變數存放原來的Card
			cards.set(i,cards.get(j));//將原來的Card設為隨機產生ArrayList位置的Card
			cards.set(j,tmp);//將隨機產生ArrayList位置的Card設為原來的Card
		}
		if(!usedCard.isEmpty())//重設usedCard跟nUsed
		{
			usedCard.clear();
			nUsed =0;
		}
	}
	public Card getOneCard(){//發牌
		Random rnd = new Random();
		int j = rnd.nextInt(52);
		if(usedCard.size()==52)//如果Card發完了,則洗牌後再發一張牌
		{
			shuffle();
			nUsed++;
			usedCard.add(cards.get(j));
		}
		else
		{
			nUsed++;
			usedCard.add(cards.get(j));
		}
		return cards.get(j);
	}
}