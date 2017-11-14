import java.util.ArrayList;
import java.util.Random;

public class Deck{
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed;
	public Deck(int nDeck){
		cards=new ArrayList<Card>();//�s��Card
		usedCard=new ArrayList<Card>();//�s��o�X�L��Card
		for(int d=0;d<nDeck;d++)//����Card
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
		shuffle();//�@�}�l�~�P
	}
	public void printDeck(){
		for(int i=0;i<cards.size();i++)
		{
			
			Card card = new Card (cards.get(i).getSuit(),cards.get(i).getRank());
			//�N�C�@�icard���ƭȹ����
			card.printCard();
			//�ϥ�printCard�N����ƫ᪺card��ܦb�ù��W
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	public void shuffle(){//�~�P
		Random rnd = new Random();
		int j = rnd.nextInt(52);
		for(int i=0;i<52;i++)
		{
			Card tmp = cards.get(i);//�]�@���ܼƦs���Ӫ�Card
			cards.set(i,cards.get(j));//�N��Ӫ�Card�]���H������ArrayList��m��Card
			cards.set(j,tmp);//�N�H������ArrayList��m��Card�]����Ӫ�Card
		}
		if(!usedCard.isEmpty())//���]usedCard��nUsed
		{
			usedCard.clear();
			nUsed =0;
		}
	}
	public Card getOneCard(){//�o�P
		Random rnd = new Random();
		int j = rnd.nextInt(52);
		if(usedCard.size()==52)//�p�GCard�o���F,�h�~�P��A�o�@�i�P
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