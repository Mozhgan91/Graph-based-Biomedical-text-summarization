
public class Similarity {

	public int S1; 
	public int S2;
	public double sim;
	
	//jaccard similarity
	public void Similarity_func(int com_freqItem, int freqItem_num1, int freqItem_num2){
		
		sim = (com_freqItem / (((double)freqItem_num1 + (double)freqItem_num2) - com_freqItem) );
	}
	
	
}
